package com.yuansong.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.yuansong.global.Global;
import com.yuansong.resource.CustomerResource;
import com.yuansong.service.ResourceService;
import com.yuansong.worker.UpdateWxCardNo;

@Controller
@RequestMapping(value="/Tools")
public class ToolsController {
	
	private final Logger logger = Logger.getLogger(ToolsController.class);
	
	@Autowired
	private ResourceService resourceService;
	
	@Autowired
	private UpdateWxCardNo updateWxCardNoWorker;
	
	@RequestMapping(value="/UpdateWxCardNo",method=RequestMethod.GET)
	public ModelAndView updateWxCardNoGet(Map<String, Object> model){
		logger.debug("ToolsController updateWxCardNoGet");
		
		List<CustomerResource> customerResources = null;
		try {
			customerResources = resourceService.getCustomerList();
		} catch (Exception ex) {
			logger.debug("获取客户列表时发生错误。[" + ex.getMessage() + "]");
			ex.printStackTrace();
			throw new RuntimeException("获取客户列表时发生错误。[" + ex.getMessage() + "]");
		}
		
		Map<String, String> customerList = new HashMap<String, String>();
		if(customerList != null) {
			for(CustomerResource customer : customerResources) {
				customerList.put(customer.getCode(), customer.getShowName());
			}			
		}
		model.put("customerList", customerList);
		return new ModelAndView("updateWxCardNo",model);
	}
	
	@RequestMapping(value="/UpdateWxCardNo",method=RequestMethod.POST)
	public ModelAndView updateWxCardNoPost(Map<String, Object> model,
			@RequestParam("tel") String tel,
			@RequestParam("customer") String customer){
		logger.debug("ToolsController updateWxCardNoPost");
		tel = tel.trim();
		String customerCode = customer.trim();
		if(tel.equals("") || customerCode.equals("")) {
			return Global.getResponseData(-1, " 客户或手机号不能为空");
		}
		
		String strResult;
		try {
			strResult = updateWxCardNoWorker.update(customerCode, tel);
		} catch (Exception e) {
			e.printStackTrace();
			return Global.getResponseData(-1, e.getMessage());
		}		
		return Global.getResponseData(0, "", strResult);
	}
}
