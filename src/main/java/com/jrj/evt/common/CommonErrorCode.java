package com.jrj.evt.common;

public enum CommonErrorCode {
	UNKNOWN_ERROR("-1","未知错误"),
    SUCCESS("10000","成功");
	
	private CommonErrorCode(String code, String message) {
		this.code = code;
		this.message = message;
	}
	private String code;
	private String message;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
