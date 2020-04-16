package com.jrj.evt.exception;

import java.util.Properties;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.jrj.evt.domain.ReturnVO;
import com.jrj.evt.util.Common;
import com.jrj.evt.util.ReadPropertiesUtil;
import com.jrj.evt.util.ReturnCode;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{
	private static Properties properties = ReadPropertiesUtil.getProperties(System.getProperty("user.dir") + Common.RESPONSE_PROP_URL);

    /**
     * 重写handleExceptionInternal，自定义处理过程
     **/
    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
        //这里将异常直接传给handlerException()方法进行处理，返回值为OK保证友好的返回，而不是出现500错误码。
        return new ResponseEntity<>(handlerException(ex), HttpStatus.OK);
    }

    /**
     * 异常捕获
     * @param e 捕获的异常
     * @return 封装的返回对象
     **/
    @ExceptionHandler(Exception.class)
    public ReturnVO handlerException(Throwable e) {
        ReturnVO returnVO = new ReturnVO();
        String errorName = e.getClass().getName();
        errorName = errorName.substring(errorName.lastIndexOf(".") + 1);
        
        //如果没有定义异常，而是直接抛出一个运行时异常，需要进入以下分支
        if (e.getClass() == RuntimeException.class) {
            returnVO.setMessage(properties.getProperty(ReturnCode.RuntimeException.msg()) +": "+ e.getMessage());
            returnVO.setCode(properties.getProperty(ReturnCode.RuntimeException.val()));
        } else {
            returnVO.setMessage(properties.getProperty(ReturnCode.valueOf(errorName).msg()));
            returnVO.setCode(properties.getProperty(ReturnCode.valueOf(errorName).val()));
        }
        return returnVO;
    }
}
