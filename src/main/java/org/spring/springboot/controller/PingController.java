package org.spring.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 连接测试操作类
 * 
 * @author jingruijie
 *
 */
@Controller
public class PingController extends BaseController{
	private static final String PAGE_PING = "/pages/ping";
	/*
	 * @RequestMapping(value = "/findAll") public Object findAll() { throw new
	 * RuntimeException("ddd"); }
	 */

	@RequestMapping(value = "/ping")
	public String ping(ModelMap map) {
		return PAGE_PING;
	}
}
