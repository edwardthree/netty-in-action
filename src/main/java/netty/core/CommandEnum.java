package netty.core;

public enum CommandEnum {
	AUTH_LOGIN(1,"auth.login","客户端请求登录","服务器响应登录");
	
	
	int value;
	String symbol;
	String requestDescription;
	String responseDescription;
	
	private CommandEnum(int value,String symbol,String requestDescription,String responseDescription){
		this.value = value;
		this.symbol = symbol;
		this.requestDescription = requestDescription;
		this.responseDescription = responseDescription;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getRequestDescription() {
		return requestDescription;
	}

	public void setRequestDescription(String requestDescription) {
		this.requestDescription = requestDescription;
	}

	public String getResponseDescription() {
		return responseDescription;
	}

	public void setResponseDescription(String responseDescription) {
		this.responseDescription = responseDescription;
	}

}
