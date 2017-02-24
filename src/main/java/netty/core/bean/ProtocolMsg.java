package netty.core.bean;

public class ProtocolMsg {
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

}
