package netty.core;

import netty.core.bean.ProtocolHeader;
import netty.core.bean.ProtocolMsg;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

public class ProtocolEncoder extends MessageToByteEncoder<ProtocolMsg> {

	@Override
	protected void encode(ChannelHandlerContext paramChannelHandlerContext,
			ProtocolMsg in, ByteBuf out) throws Exception {
		System.out.println("encode");
			ProtocolHeader header = in.getHeader();
			out.writeByte(header.getFlag()|header.getError());
			out.writeByte(header.getType());
			out.writeShort(header.getCommand());
			out.writeShort(header.getSeq());
			if(in.getBody().length() > 0){
				out.writeShort(in.getBody().length());
			}else{
				out.writeShort(0);
			}
			out.writeBytes(in.getBody().getBytes());
			System.out.println("±àÂë"+in.getBody());
	}
}
