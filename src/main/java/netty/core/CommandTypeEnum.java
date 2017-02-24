package netty.core;

public enum CommandTypeEnum {

	REQUEST_TYPE(1,"ÇëÇó"),
	RESPONST_TYPE(2,"ÏìÓ¦"),
	HEAT_BEAT(3,"ÐÄÌø");
	
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
