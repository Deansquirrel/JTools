package com.yuansong.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.yuansong.common.DateTool;
import com.yuansong.global.Global;
import com.yuansong.resource.CustomerResource;
import com.yuansong.resource.EcsResource;
import com.yuansong.service.ResourceService;

@Controller
@RequestMapping(value="/Resource")
public class ResourceController {
	
	private final Logger logger = Logger.getLogger(ResourceController.class);
	
	private Gson mGson = new Gson();
	
	@Autowired
	private ResourceService resourceService;

	@Transactional
	@RequestMapping(value="/Customer/Add",method=RequestMethod.POST)
	public ModelAndView customerAddAction(
			@RequestParam("customerAddCode") String code,
			@RequestParam("customerAddName") String name,
			@RequestParam("customerAddDescription") String description,
			@RequestParam("customerAddShowname") String showName,
			@RequestParam("customerAddSimplename") String simpleName,
			@RequestParam("customerAddPinyinname") String pinyinName,
			@RequestParam("customerAddMistype") String misType,
			@RequestParam("customerAddTongdcode") String tongdCode,
			Map<String, Object> model) {
				
		Map<String, String> data = new HashMap<String, String>();
		data.put("code", code);
		data.put("name", name);
		data.put("description", description);
		data.put("showname", showName);
		data.put("simplename", simpleName);
		data.put("pinyinname", pinyinName);
		data.put("mistype", misType);
		data.put("tongdcode", tongdCode);
		
		try {
			resourceService.addCustomer(data);
		}catch(Exception ex) {
			ex.printStackTrace();
			logger.error(ex.getMessage());
			return Global.getResponseData(-1, ex.getMessage());			
		}
		
		return Global.getResponseData(0, "");
	}
	
	@Transactional
	@RequestMapping(value="/Customer/Del",method=RequestMethod.POST)
	public ModelAndView customerDel(@RequestParam("delId") String id,
			Map<String, Object> model) {
		
		Map<String, String> data = new HashMap<String, String>();
		data.put("id", id);
		
		try {
			resourceService.delCustomer(data);
		}catch(Exception ex) {
			ex.printStackTrace();
			logger.error(ex.getMessage());
			return Global.getResponseData(-1, ex.getMessage());			
		}
		
		return Global.getResponseData(0, "");
	}
	
	@Transactional
	@RequestMapping(value="/Customer/{id}",method=RequestMethod.GET)
	public ModelAndView customerDetail(@PathVariable String id, Map<String, Object> model) {
		
		CustomerResource resource = null;
		try{
			resource = resourceService.getCustomer(id);
			model.put("info", mGson.toJson(resource));
		}catch(Exception ex) {
			ex.printStackTrace();
			logger.error(ex.getMessage());
			model.put("info", ex.getMessage());			
		}
		return new ModelAndView("responsePage", model);
	}
	
	@Transactional
	@RequestMapping(value="/Ecs/Add",method=RequestMethod.POST)
	public ModelAndView ecsAddAction(
			@RequestParam("ecsAddName") String name,
			@RequestParam("ecsAddDescription") String description,
			@RequestParam("ecsAddInstanceID") String instanceID,
			@RequestParam("ecsAddArea") String area,
			@RequestParam("ecsAddInternetIp") String internetIp,
			@RequestParam("ecsAddIntranetIp") String intranetIp,
			@RequestParam("ecsAddOs") String os,
			@RequestParam("ecsAddExpirationDate") String expirationDate,
			@RequestParam("ecsAddRDPPort") String rdpPort,
			@RequestParam("ecsAddLoginName") String loginName,
			@RequestParam("ecsAddLoginPwd") String loginPwd,
			Map<String, Object> model) {
		
		
		
		try {
			Date d = DateTool.getDateFromStr(expirationDate, "yyyy-MM-dd");
			expirationDate = DateTool.getDateStr(d, "yyyy-MM-dd");
			int port = Integer.valueOf(rdpPort);
			rdpPort = String.valueOf(port);
		}catch(Exception ex) {
			ex.printStackTrace();
			logger.error(ex.getMessage());
			return Global.getResponseData(-1, ex.getMessage());	
		}
				
		Map<String, String> data = new HashMap<String, String>();		
		data.put("name", name);
		data.put("description", description);
		data.put("instanceID", instanceID);
		data.put("area", area);
		data.put("internetIp", internetIp);
		data.put("intranetIp", intranetIp);
		data.put("os", os);
		data.put("expirationDate", expirationDate);
		data.put("rdpPort", rdpPort);
		data.put("loginName", loginName);
		data.put("loginPwd", loginPwd);
		
		try {
			resourceService.addEcs(data);
		}catch(Exception ex) {
			ex.printStackTrace();
			logger.error(ex.getMessage());
			return Global.getResponseData(-1, ex.getMessage());			
		}
		
		return Global.getResponseData(0, "");
	}
	
	@Transactional
	@RequestMapping(value="/Ecs/Del",method=RequestMethod.POST)
	public ModelAndView ecsDel(@RequestParam("delId") String id,
			Map<String, Object> model) {
		
		Map<String, String> data = new HashMap<String, String>();
		data.put("id", id);
		
		try {
			resourceService.delEcs(data);
		}catch(Exception ex) {
			ex.printStackTrace();
			logger.error(ex.getMessage());
			return Global.getResponseData(-1, ex.getMessage());			
		}
		
		return Global.getResponseData(0, "");
	}
	
	@Transactional
	@RequestMapping(value="/Ecs/{id}",method=RequestMethod.GET)
	public ModelAndView ecsDetail(@PathVariable String id, Map<String, Object> model) {
		
		EcsResource resource = null;
		try{
			resource = resourceService.getEcs(id);
			model.put("info", mGson.toJson(resource));
		}catch(Exception ex) {
			ex.printStackTrace();
			logger.error(ex.getMessage());
			model.put("info", ex.getMessage());			
		}
		return new ModelAndView("responsePage", model);
	}
	

}
