package netty.core.bean;

public class FlagBean {
	byte urgent;
	byte compress;
	byte compelte;
	
	public FlagBean(byte urgent,byte compress,byte complete){
		this.urgent = urgent;
		this.compress = compress;
		this.compelte = complete;
	}
	
	public byte getFlagBean (){
		return  (byte) (this.urgent|this.compress|this.compelte);
	}
	public byte getUrgent() {
		return urgent;
	}
	public void setUrgent(byte urgent) {
		this.urgent = urgent;
	}
	public byte getCompress() {
		return compress;
	}
	public void setCompress(byte compress) {
		this.compress = compress;
	}
	public byte getCompelte() {
		return compelte;
	}
	public void setCompelte(byte compelte) {
		this.compelte = compelte;
	}
	
}
