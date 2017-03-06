package netty.core.bean;

import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public class ProtocolMsg implements Serializable{
	public static final Integer MAX_DATALENGTH = 65535;
	 /**
	 * 
	 */
	private static final long serialVersionUID = -7118165037112491504L;
	private ProtocolHeader header;
	 private String ip;
	 private String body;
	 private byte[] byteBody;
	 
	public ProtocolHeader getHeader() {
		return header;
	}
	public void setHeader(ProtocolHeader header) {
		this.header = header;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public byte[] getByteBody() {
		return byteBody;
	}
	public void setByteBody(byte[] byteBody) {
		this.byteBody = byteBody;
	}

	public List<ProtocolMsg> splitMsg(ProtocolMsg msg){
		List<ProtocolMsg> msgs = new ArrayList<ProtocolMsg>();
		
		byte[] body = msg.getBody().getBytes();
		ByteBuffer buffer = ByteBuffer.wrap(body);
		int length = body.length;
		for(int i =0;i<(length/MAX_DATALENGTH)+1;i++){
			ProtocolHeader header = new ProtocolHeader();
			header.setCommand(msg.getHeader().getCommand());
			header.setError(msg.getHeader().getError());
			
			header.setType(msg.getHeader().getType());
			header.setSeq(msg.getHeader().getSeq());
			int splitLenth = 0;
			if(i*MAX_DATALENGTH>length){
				FlagBean flag = new FlagBean((byte)1,(byte)4, (byte)8);
				header.setFlag(flag.getFlagBean());
				splitLenth = length % MAX_DATALENGTH;
			}else{
				FlagBean flag = new FlagBean((byte)1,(byte)4,(byte)0);
				header.setFlag(flag.getFlagBean());
				splitLenth = MAX_DATALENGTH;
			}
			
			byte[] splitBody = new byte[splitLenth];
			buffer.get(splitBody);
			ProtocolMsg m = new ProtocolMsg();
			msgs.add(m);
		}
		
		
		
		return msgs;
	}
}
