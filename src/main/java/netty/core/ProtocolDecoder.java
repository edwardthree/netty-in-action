package netty.core;

import java.nio.charset.Charset;
import java.util.List;

import netty.core.bean.ProtocolHeader;
import netty.core.bean.ProtocolMsg;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.util.CharsetUtil;

public class ProtocolDecoder extends ByteToMessageDecoder{

	@Override
	protected void decode(ChannelHandlerContext paramChannelHandlerContext,
			ByteBuf in, List<Object> out) throws Exception {
		System.out.println("decode");
		 if (in.readableBytes()<8) { 
			 System.out.println("decode1");
	            return; //小于头部8字节不做处理  
	        }  
		    ProtocolHeader header = new ProtocolHeader();
		    ProtocolMsg msg = new  ProtocolMsg();
		    byte flagType = in.readByte();
		    header.setFlag((byte) (flagType&0x0f));
		    header.setError((byte) (flagType&0xf0));
		    header.setType(in.readByte());
		    header.setCommand(in.readShort());
		    header.setSeq(in.readShort());
		    header.setLength(in.readShort());
		    in.markReaderIndex();  
		    if(in.readableBytes()<header.getLength()){
		    	in.resetReaderIndex();
		    	return;
		    }
		    byte[] msgs = new byte[header.getLength()];
		    in.readBytes(msgs);
		    msg.setHeader(header);
		    msg.setBody(new String(msgs,CharsetUtil.UTF_8));
	        out.add(msg);   
	}
}
