package com.ebuy.tax.h5.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 协议
* @author dd
* @date 2018年9月5日
 */
@Controller
@RequestMapping("/h5")
public class PageController {
	
	private static final Logger logger = LoggerFactory.getLogger(PageController.class);
	
	@GetMapping("/bill")
	public String bill() {
		logger.info("bill page");
		return "page/bill";
	}
	
	@GetMapping("/bookkeeping")
	public String bookkeeping() {
		logger.info("bookkeeping page");
		return "page/bookkeeping";
	}
	
	@GetMapping("/cash")
	public String cash() {
		logger.info("cash page");
		return "page/cash";
	}
	
	@GetMapping("/companychange")
	public String companychange() {
		logger.info("companychange page");
		return "page/companychange";
	}
	
	@GetMapping("/netprofit")
	public String netprofit() {
		logger.info("netprofit page");
		return "page/netprofit";
	}
	
	@GetMapping("/newsdetails")
	public String newsdetails() {
		logger.info("newsdetails page");
		return "page/newsdetails";
	}
	
	@GetMapping("/paytaxes")
	public String paytaxes() {
		logger.info("paytaxes page");
		return "page/paytaxes";
	}
	
	@GetMapping("/regcompany")
	public String regcompany() {
		logger.info("regcompany page");
		return "page/regcompany";
	}
	
	@GetMapping("/tax")
	public String tax() {
		logger.info("tax page");
		return "page/tax";
	}
}
