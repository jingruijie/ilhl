package com.jrj.evt.controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jrj.evt.common.CommonResult;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 连接测试操作类
 * 
 * @author jingruijie
 *
 */
@Api(value = "Ping API")
@RestController
public class PingController extends BaseController{
	private static final String PAGE_PING = "/pages/ping";
	/*
	 * @RequestMapping(value = "/findAll") public Object findAll() { throw new
	 * RuntimeException("ddd"); }
	 */
	@ApiOperation(value = "Ping")
	@RequestMapping(value = "/ping")
	public CommonResult<Object> ping(ModelMap map) {
		return new CommonResult<Object>().ofSuccess();
	}
}
