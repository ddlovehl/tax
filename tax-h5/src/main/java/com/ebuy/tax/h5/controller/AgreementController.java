package com.ebuy.tax.h5.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 协议
* @author dd
* @date 2018年9月5日
 */
@Controller
public class AgreementController {
	
	private static final Logger logger = LoggerFactory.getLogger(AgreementController.class);
	
	@RequestMapping("/front/test111")
	public String test() {
		logger.info("test....");
		return "/demo/index";
	}
	
	public static void main(String[] args) {
		
	}

}
