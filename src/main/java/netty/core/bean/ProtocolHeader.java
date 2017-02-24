package netty.core.bean;

import java.io.Serializable;

public class ProtocolHeader implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5436980356990929624L;
	private byte flagBean;
	private byte error;
	private byte type;
	private short command;
	private short seq;
	private short length;
	
	public byte getFlag() {
		return flagBean;
	}
	public void setFlag(byte flagBean) {
		this.flagBean = flagBean;
	}
	public byte getError() {
		return error;
	}
	public void setError(byte error) {
		this.error = error;
	}
	public byte getType() {
		return type;
	}
	public void setType(byte type) {
		this.type = type;
	}
	public short getCommand() {
		return command;
	}
	public void setCommand(short command) {
		this.command = command;
	}
	public short getSeq() {
		return seq;
	}
	public void setSeq(short seq) {
		this.seq = seq;
	}
	public short getLength() {
		return length;
	}
	public void setLength(short length) {
		this.length = length;
	}
	
}
