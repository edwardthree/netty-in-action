package netty.client;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.ssl.SslContext;
import netty.core.ProtocolDecoder;
import netty.core.ProtocolEncoder;

public class ClientChannelInitializer extends ChannelInitializer<SocketChannel> {
	  private final SslContext sslCtx;

	    public ClientChannelInitializer(SslContext sslCtx) {
	        this.sslCtx = sslCtx;
	    }

		@Override
		protected void initChannel(SocketChannel ch) throws Exception {
			  ChannelPipeline pipeline = ch.pipeline();
//			In this example, we use a bogus certificate in the server side
	        // and accept any invalid certificates in the client side.
	        // You will need something more complicated to identify both
	        // and server in the real world.
	        pipeline.addLast(sslCtx.newHandler(ch.alloc(), ClientMainStart.HOST, ClientMainStart.PORT));

	        // On top of the SSL handler, add the text line codec.
	        pipeline.addLast(new ProtocolDecoder());
	        pipeline.addLast(new ProtocolEncoder());

	        // and then business logic.
	        pipeline.addLast(new ClientHandler());
		}
}
