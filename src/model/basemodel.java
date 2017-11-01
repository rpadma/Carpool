package model;

public class basemodel {

	String message;
	int code;
	String ipaddress;

	
	public basemodel() {
		super();
	}


	
	public String getIpaddress() {
		return ipaddress;
	}



	public void setIpaddress(String ipaddress) {
		this.ipaddress = ipaddress;
	}



	public int getCode() {
		return code;
	}


	public void setCode(int code) {
		this.code = code;
	}


	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
