package com.jrj.evt.domain;

import java.util.Properties;

import com.jrj.evt.util.Common;
import com.jrj.evt.util.ReadPropertiesUtil;
import com.jrj.evt.util.ReturnCode;

/**
 * 定义统一的restful接口返回类型
 * @author jingruijie
 *
 */
public class ReturnVO {
	private static final Properties properties = ReadPropertiesUtil.getProperties(System.getProperty("user.dir") + Common.RESPONSE_PROP_URL);

    /**
     * 返回代码
     */
    private String code;

    /**
     * 返回信息
     */
    private String message;

    /**
     * 返回数据
     */
    private Object data;


    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 默认构造，返回操作正确的返回代码和信息
     */
    public ReturnVO() {
        this.setCode(properties.getProperty(ReturnCode.SUCCESS.val()));
        this.setMessage(properties.getProperty(ReturnCode.SUCCESS.msg()));
    }

    /**
     * 构造一个返回特定代码的ReturnVO对象
     * @param code
     */
    public ReturnVO(ReturnCode code) {
        this.setCode(properties.getProperty(code.val()));
        this.setMessage(properties.getProperty(code.msg()));
    }

    /**
     * 默认值返回，默认返回正确的code和message
     * @param data
     */
    public ReturnVO(Object data) {
        this.setCode(properties.getProperty(ReturnCode.SUCCESS.val()));
        this.setMessage(properties.getProperty(ReturnCode.SUCCESS.msg()));
        this.setData(data);
    }

    /**
     * 构造返回代码，以及自定义的错误信息
     * @param code
     * @param message
     */
    public ReturnVO(ReturnCode code, String message) {
        this.setCode(properties.getProperty(code.val()));
        this.setMessage(message);
    }

    /**
     * 构造自定义的code，message，以及data
     * @param code
     * @param message
     * @param data
     */
    public ReturnVO(ReturnCode code, String message, Object data) {
        this.setCode(code.val());
        this.setMessage(message);
        this.setData(data);
    }

    @Override
    public String toString() {
        return "ReturnVO{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
