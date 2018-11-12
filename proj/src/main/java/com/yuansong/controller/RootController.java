package com.yuansong.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.yuansong.global.Global;
import com.yuansong.global.SystemConfig;

@Controller
@RequestMapping(value="/")
public class RootController {

	private final Logger logger = Logger.getLogger(RootController.class);
	
	@Autowired
	private SystemConfig systemConfig;
	
//	private Gson mGson = new Gson();
	
	@RequestMapping(value="/")
	public ModelAndView defaultPage(Map<String, Object> model){
		logger.debug("跳转到 Current");
		return new ModelAndView("redirect:/FunctionMenu");
	} 
	
	@RequestMapping(value="/PageNotFound")
	public ModelAndView pageNotFound(Map<String, Object> model){
		logger.debug("RootController PageNotFound");

		return Global.getResponseData(404, "page not found");
	}
	
	@RequestMapping(value="/version")
	public ModelAndView getVersion(Map<String, Object> model){
		
		Map<String, String> rData = new HashMap<String, String>();
		rData.put("version", Global.getVersion());
		
		return Global.getResponseData(0, "", rData);
	}
	
	@RequestMapping(value="/FunctionMenu")
	public ModelAndView functionMenu(Map<String, Object> model){
		logger.debug("RootController functionMenu");
		return new ModelAndView("functionMenuPage",model);
	}
	
	@RequestMapping(value="/DataMaintain")
	public ModelAndView dataMaintain(Map<String, Object> model){
		logger.debug("RootController dataMaintain");
		return new ModelAndView("dataMaintainPage",model);
	}
	
	@RequestMapping(value="/test")
	public ModelAndView test(Map<String, Object> model){
		logger.debug("RootController test");
		
		return Global.getResponseData(0, "",systemConfig.getUrl());
		
//		Map<String, Object> data = new HashMap<String, Object>();
//        data.put("errcode", 0);
//        data.put("errmsg", "");
//        data.put("data", testService.test());
//		
//		model.put("info",mGson.toJson(data));
////        model.put("info", testService.test());
	}
	
//	@RequestMapping(value="/testPage")
//	public ModelAndView testPage(Map<String, Object> model){
//		logger.info("RootController testPage");
//		model.put("info", "testPage");
//
//		return new ModelAndView("testPage",model);
//	}
//	
//	@RequestMapping(value="/testPageOne")
//	public ModelAndView testPageOne(Map<String, Object> model){
//		logger.info("RootController testPageOne");
//		model.put("info", "testPageOne");
//
//		return new ModelAndView("testPage",model);
//	}
//	
//	@RequestMapping(value="/testErrorPage")
//	public ModelAndView testErrorPage(Map<String, Object> model){
//		logger.info("RootController testErrorPage");
//		model.put("info", "testPageOne");
//
//		throw new RuntimeException("sfesf");
////		return new ModelAndView("testPage",model);
//	}
	
}
