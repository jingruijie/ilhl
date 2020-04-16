package com.jrj.evt.common;

import java.io.Serializable;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

public class CommonResult<T> implements Serializable {
	/**
	 * 是否请求成功
	 */
	private Boolean success;
	/**
	 * 事件戳
	 */
	private Long ts = System.currentTimeMillis();
	/**
	 * 数据
	 */
	private T data;
	/**
	 * 错误码
	 */
	private String errCode;
	/**
	 * 错误信息
	 */
	private String msg;

	public static CommonResult ofSuccess() {
		CommonResult result = new CommonResult();
		result.success = true;
		return result;
	}

	public static CommonResult ofSuccess(Object data) {
		CommonResult result = new CommonResult();
		result.success = true;
		result.setData(data);
		return result;
	}

	public static CommonResult ofFail(String code, String msg) {
		CommonResult result = new CommonResult();
		result.success = false;
		result.errCode = code;
		result.msg = msg;
		return result;
	}

	public static CommonResult ofFail(String code, String msg, Object data) {
		CommonResult result = new CommonResult();
		result.success = false;
		result.errCode = code;
		result.msg = msg;
		result.setData(data);
		return result;
	}

	public static CommonResult ofFail(CommonErrorCode resultEnum) {
		CommonResult result = new CommonResult();
		result.success = false;
		result.errCode = resultEnum.getCode();
		result.msg = resultEnum.getMessage();
		return result;
	}

	/**
	 * 获取 json
	 */
	public String buildResultJson() {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("succ", this.success);
		jsonObject.put("code", this.errCode);
		jsonObject.put("ts", this.ts);
		jsonObject.put("msg", this.msg);
		jsonObject.put("data", this.data);
		return JSON.toJSONString(jsonObject, SerializerFeature.DisableCircularReferenceDetect);
	}

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public Long getTs() {
		return ts;
	}

	public void setTs(Long ts) {
		this.ts = ts;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getErrCode() {
		return errCode;
	}

	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
