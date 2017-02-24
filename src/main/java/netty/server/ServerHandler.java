package netty.server;

import netty.core.Command;
import netty.core.bean.ProtocolMsg;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;

public class ServerHandler extends SimpleChannelInboundHandler<ProtocolMsg>{

	@Override
	protected void channelRead0(
			ChannelHandlerContext paramChannelHandlerContext, ProtocolMsg msg)
			throws Exception {
		System.out.println("���������յ���Ϣ"+msg.getBody());
		
	}
	@Override
	public void channelActive(ChannelHandlerContext paramChannelHandlerContext) throws Exception {
		System.out.println("serverActive");
		Command.authLogin(paramChannelHandlerContext.channel(),"qqqq", "1234",(short)2);
	}
	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {
		System.out.println("�������˶Ͽ�");
	}
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
			throws Exception {
		System.out.println("���������쳣");
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
	            Command.authLogin(ctx.channel(),"qqqq", "1234",(short)2);

	        }  else if (e.state().equals(IdleState.ALL_IDLE)) {
				System.out.println("ALL_IDLE");
				// ��������
				Command.authLogin(ctx.channel(),"qqqq", "1234",(short)2);
			}
	        else {
	            System.out.println("������ʱ");
	        }
	    }
	}

}
