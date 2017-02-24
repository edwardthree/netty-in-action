package netty.client;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import netty.core.Command;
import netty.core.bean.ProtocolMsg;

public class ClientHandler  extends SimpleChannelInboundHandler<ProtocolMsg>{

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		System.out.println("clientActive");
		Command.authLogin(ctx.channel(), "mmm1", "1234", (short)1);
	}
	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {
		System.out.println("客户端断开");
	}
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
			throws Exception {
		System.out.println("客户端异常");
	}
	@Override
	protected void channelRead0(
			ChannelHandlerContext ctx, ProtocolMsg msg)
			throws Exception {
		System.out.println("客户端接收："+msg.getBody());
		
	}

}
