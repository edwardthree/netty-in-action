package netty.core;

public enum CommandTypeEnum {

	REQUEST_TYPE(1,"请求"),
	RESPONST_TYPE(2,"响应"),
	HEAT_BEAT(3,"心跳");
	
	int value ;
	String description;
	private CommandTypeEnum(int value,String description){
		this.value  = value;
		this.description = description;
	}

	public byte getValue() {
		return (byte)value;
	}

	public void setValue(byte value) {
		this.value = value;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
