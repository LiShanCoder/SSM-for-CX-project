package com.company.project.vo;

public class JsonMsg {

	private boolean isSuccess;
	private String errMsg;

	public JsonMsg(boolean isSuccess, String errMsg) {
		this.isSuccess = isSuccess;
		this.errMsg = errMsg;
	}

	public boolean isSuccess() {
		return isSuccess;
	}

	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	@Override
	public String toString() {
		return "JsonMsg [isSuccess=" + isSuccess + ", errMsg=" + errMsg + "]";
	}

}
