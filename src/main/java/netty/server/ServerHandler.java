package netty.server;

import netty.core.Command;
import netty.core.bean.ProtocolMsg;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class ServerHandler extends SimpleChannelInboundHandler<ProtocolMsg>{

	@Override
	protected void channelRead0(
			ChannelHandlerContext paramChannelHandlerContext, ProtocolMsg msg)
			throws Exception {
		System.out.println("服务器端收到消息"+msg.getBody());
		Command.authLogin(paramChannelHandlerContext.channel(),"qqq", "1234",(short)2);
	}
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		System.out.println("serverActive");
		Command.authLogin(ctx.channel(),"qqq", "1234",(short)2);
	}
	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {
		System.out.println("服务器端断开");
	}
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
			throws Exception {
		System.out.println("服务器端异常");
	}
	
	

}
