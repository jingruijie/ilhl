package com.jrj.evt.exception;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jrj.evt.domain.ReturnVO;
import com.jrj.evt.util.ReturnCode;

@RestController
public class RequestExceptionHandler implements ErrorController{

	@Override
	public String getErrorPath() {
		return "/error";
	}

	@RequestMapping("/error")
    public ReturnVO errorPage(){
        return new ReturnVO(ReturnCode.UrlError);
    }
}
