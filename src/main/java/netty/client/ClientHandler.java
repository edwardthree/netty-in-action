package netty.client;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import netty.core.Command;
import netty.core.bean.ProtocolMsg;

public class ClientHandler  extends SimpleChannelInboundHandler<ProtocolMsg>{

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		System.out.println("clientActive");
//		Command.authLogin(ctx.channel(), "mmm1", "1234", (short)1);
	}
	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {
		System.out.println("�ͻ��˶Ͽ�");
	}
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
			throws Exception {
		System.out.println("�ͻ����쳣");
	}
	@Override
	protected void channelRead0(
			ChannelHandlerContext ctx, ProtocolMsg msg)
			throws Exception {
		System.out.println("�ͻ��˽��գ�"+msg.getBody());
		
	}
	@Override
	public void userEventTriggered(ChannelHandlerContext ctx, Object evt)
	    throws Exception{
	    System.out.println("�����¼�");
	    if (evt instanceof IdleStateEvent) {
	        IdleStateEvent e = (IdleStateEvent) evt;
	        if (e.state() == IdleState.READER_IDLE) {
	            System.out.println("READER_IDLE ����ʱ");
	        } else if (e.state() == IdleState.WRITER_IDLE) {
	            System.out.println("WRITER_IDLE д��ʱ");
	        }
	        else if (e.state().equals(IdleState.ALL_IDLE)) {
				System.out.println("ALL_IDLE");
				// ��������
				ctx.channel().write("pisssssssng\n");
			}
	    }
	}
}
