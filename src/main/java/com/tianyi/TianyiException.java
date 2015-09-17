package com.tianyi;

public class TianyiException extends Exception{

	private static final long serialVersionUID = -7352154318416160235L;
	
	public TianyiException(Throwable e, String errorMsg) {
		super(errorMsg, e);
	}

	public TianyiException(String errorCode, String errorMsg) {
		super("调用天翼能力失败 errorCode [" + errorCode + "]  errorMsg [" + errorMsg
				+ "]");
		this.setErrorCode(errorCode);
		this.setErrorMsg(errorMsg);
	}
	
	private String errorCode;
	
	private String errorMsg;

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
}
