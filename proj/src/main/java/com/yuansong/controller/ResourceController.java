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
import com.yuansong.resource.CommonDbResource;
import com.yuansong.resource.CustomerResource;
import com.yuansong.resource.EcsResource;
import com.yuansong.resource.ExceptionlessResource;
import com.yuansong.resource.MongoDBResource;
import com.yuansong.resource.RabbitMQResource;
import com.yuansong.resource.RdsDbResource;
import com.yuansong.resource.RdsResource;
import com.yuansong.resource.RedisResource;
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
			if(rdpPort.trim().equals("")) {
				rdpPort = "3389";
			}
			else {
				int port = Integer.valueOf(rdpPort);
				rdpPort = String.valueOf(port);
			}
			
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
	
	@Transactional
	@RequestMapping(value="/Rds/Add",method=RequestMethod.POST)
	public ModelAndView rdsAddAction(
			@RequestParam("rdsAddName") String name,
			@RequestParam("rdsAddDescription") String description,
			@RequestParam("rdsAddInstanceID") String instanceID,
			@RequestParam("rdsAddArea") String area,
			@RequestParam("rdsAddDbType") String dbType,
			@RequestParam("rdsAddInternetIp") String internetIp,
			@RequestParam("rdsAddInternetPort") String internetPort,
			@RequestParam("rdsAddIntranetIp") String intranetIp,
			@RequestParam("rdsAddIntranetPort") String intranetPort,
			@RequestParam("rdsAddExpirationDate") String expirationDate,
			Map<String, Object> model) {
		
		try {
			Date d = DateTool.getDateFromStr(expirationDate, "yyyy-MM-dd");
			expirationDate = DateTool.getDateStr(d, "yyyy-MM-dd");
			if(internetPort.trim().equals("")) {
				internetPort = "3433";
			}
			else {
				int port = Integer.valueOf(internetPort);
				internetPort = String.valueOf(port);
			}
			if(intranetPort.trim().equals("")) {
				intranetPort = "3433";
			}
			else {
				int port = Integer.valueOf(intranetPort);
				intranetPort = String.valueOf(port);
			}
			
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
		data.put("dbType", dbType);
		data.put("internetIp", internetIp);
		data.put("internetPort", internetPort);
		data.put("intranetIp", intranetIp);
		data.put("intranetPort", intranetPort);
		data.put("expirationDate", expirationDate);
		
		try {
			resourceService.addRds(data);
		}catch(Exception ex) {
			ex.printStackTrace();
			logger.error(ex.getMessage());
			return Global.getResponseData(-1, ex.getMessage());			
		}
		
		return Global.getResponseData(0, "");
	}
	
	@Transactional
	@RequestMapping(value="/Rds/Del",method=RequestMethod.POST)
	public ModelAndView rdsDel(@RequestParam("delId") String id,
			Map<String, Object> model) {
		
		Map<String, String> data = new HashMap<String, String>();
		data.put("id", id);
		
		try {
			resourceService.delRds(data);
		}catch(Exception ex) {
			ex.printStackTrace();
			logger.error(ex.getMessage());
			return Global.getResponseData(-1, ex.getMessage());			
		}
		
		return Global.getResponseData(0, "");
	}
	
	@Transactional
	@RequestMapping(value="/Rds/{id}",method=RequestMethod.GET)
	public ModelAndView rdsDetail(@PathVariable String id, Map<String, Object> model) {
		
		RdsResource resource = null;
		try{
			resource = resourceService.getRds(id);
			model.put("info", mGson.toJson(resource));
		}catch(Exception ex) {
			ex.printStackTrace();
			logger.error(ex.getMessage());
			model.put("info", ex.getMessage());			
		}
		return new ModelAndView("responsePage", model);
	}
	
	@Transactional
	@RequestMapping(value="/CommonDb/Add",method=RequestMethod.POST)
	public ModelAndView commonDbAddAction(
			@RequestParam("commonDbAddName") String name,
			@RequestParam("commonDbAddDescription") String description,
			@RequestParam("commonDbAddDbName") String dbName,
			@RequestParam("commonDbAddDbUser") String dbUser,
			@RequestParam("commonDbAddDbPwd") String dbPwd,
			@RequestParam("commonDbAddAddress") String address,
			@RequestParam("commonDbAddPort") String port,
			Map<String, Object> model) {
				
		try {
			if(port.trim().equals("")) {
				port = "1433";
			}
			else {
				int iport = Integer.valueOf(port);
				port = String.valueOf(iport);
			}
		}catch(Exception ex) {
			ex.printStackTrace();
			logger.error(ex.getMessage());
			return Global.getResponseData(-1, ex.getMessage());	
		}
		
		Map<String, String> data = new HashMap<String, String>();
		data.put("name", name);
		data.put("description", description);
		data.put("dbName", dbName);
		data.put("dbUser", dbUser);
		data.put("dbPwd", dbPwd);
		data.put("address", address);
		data.put("port", port);
		
		try {
			resourceService.addCommonDb(data);
		}catch(Exception ex) {
			ex.printStackTrace();
			logger.error(ex.getMessage());
			return Global.getResponseData(-1, ex.getMessage());			
		}
		
		return Global.getResponseData(0, "");
	}
	
	@Transactional
	@RequestMapping(value="/CommonDb/Del",method=RequestMethod.POST)
	public ModelAndView commonDbDel(@RequestParam("delId") String id,
			Map<String, Object> model) {
		
		Map<String, String> data = new HashMap<String, String>();
		data.put("id", id);
		
		try {
			resourceService.delCommonDb(data);
		}catch(Exception ex) {
			ex.printStackTrace();
			logger.error(ex.getMessage());
			return Global.getResponseData(-1, ex.getMessage());			
		}
		
		return Global.getResponseData(0, "");
	}
	
	@Transactional
	@RequestMapping(value="/CommonDb/{id}",method=RequestMethod.GET)
	public ModelAndView commonDbDetail(@PathVariable String id, Map<String, Object> model) {
		
		CommonDbResource resource = null;
		try{
			resource = resourceService.getCommonDb(id);
			model.put("info", mGson.toJson(resource));
		}catch(Exception ex) {
			ex.printStackTrace();
			logger.error(ex.getMessage());
			model.put("info", ex.getMessage());			
		}
		return new ModelAndView("responsePage", model);
	}

	@Transactional
	@RequestMapping(value="/RdsDb/Add",method=RequestMethod.POST)
	public ModelAndView rdsDbAddAction(
			@RequestParam("rdsDbAddName") String name,
			@RequestParam("rdsDbAddDescription") String description,
			@RequestParam("rdsDbAddDbName") String dbName,
			@RequestParam("rdsDbAddDbUser") String dbUser,
			@RequestParam("rdsDbAddDbPwd") String dbPwd,
			@RequestParam("rdsDbAddDbRds") String rdsId,
			Map<String, Object> model) {
		
		Map<String, String> data = new HashMap<String, String>();
		data.put("name", name);
		data.put("description", description);
		data.put("dbName", dbName);
		data.put("dbUser", dbUser);
		data.put("dbPwd", dbPwd);
		data.put("rdsId", rdsId);
		
		try {
			resourceService.addRdsDb(data);
		}catch(Exception ex) {
			ex.printStackTrace();
			logger.error(ex.getMessage());
			return Global.getResponseData(-1, ex.getMessage());			
		}
		
		return Global.getResponseData(0, "");
	}
	
	@Transactional
	@RequestMapping(value="/RdsDb/Del",method=RequestMethod.POST)
	public ModelAndView rdsDbDel(@RequestParam("delId") String id,
			Map<String, Object> model) {
		
		Map<String, String> data = new HashMap<String, String>();
		data.put("id", id);
		
		try {
			resourceService.delRdsDb(data);
		}catch(Exception ex) {
			ex.printStackTrace();
			logger.error(ex.getMessage());
			return Global.getResponseData(-1, ex.getMessage());			
		}
		
		return Global.getResponseData(0, "");
	}
	
	@Transactional
	@RequestMapping(value="/RdsDb/{id}",method=RequestMethod.GET)
	public ModelAndView rdsDbDetail(@PathVariable String id, Map<String, Object> model) {
		
		RdsDbResource resource = null;
		try{
			resource = resourceService.getRdsDb(id);
			model.put("info", mGson.toJson(resource));
		}catch(Exception ex) {
			ex.printStackTrace();
			logger.error(ex.getMessage());
			model.put("info", ex.getMessage());			
		}
		return new ModelAndView("responsePage", model);
	}

	@Transactional
	@RequestMapping(value="/Redis/Add",method=RequestMethod.POST)
	public ModelAndView redisAddAction(
			@RequestParam("redisAddName") String name,
			@RequestParam("redisAddDescription") String description,
			@RequestParam("redisAddInstanceID") String instanceID,
			@RequestParam("redisAddArea") String area,
			@RequestParam("redisAddHost") String host,
			@RequestParam("redisAddPort") String port,
			@RequestParam("redisAddPwd") String pwd,
			Map<String, Object> model) {
		
		Map<String, String> data = new HashMap<String, String>();
		data.put("name", name);
		data.put("description", description);
		data.put("instanceID", instanceID);
		data.put("area", area);
		data.put("host", host);
		data.put("port", port);
		data.put("pwd", pwd);
		
		try {
			resourceService.addRedis(data);
		}catch(Exception ex) {
			ex.printStackTrace();
			logger.error(ex.getMessage());
			return Global.getResponseData(-1, ex.getMessage());			
		}
		
		return Global.getResponseData(0, "");
	}
	
	@Transactional
	@RequestMapping(value="/Redis/Del",method=RequestMethod.POST)
	public ModelAndView redisDel(@RequestParam("delId") String id,
			Map<String, Object> model) {
		
		Map<String, String> data = new HashMap<String, String>();
		data.put("id", id);
		
		try {
			resourceService.delRedis(data);
		}catch(Exception ex) {
			ex.printStackTrace();
			logger.error(ex.getMessage());
			return Global.getResponseData(-1, ex.getMessage());			
		}
		
		return Global.getResponseData(0, "");
	}
	
	@Transactional
	@RequestMapping(value="/Redis/{id}",method=RequestMethod.GET)
	public ModelAndView redisDetail(@PathVariable String id, Map<String, Object> model) {
		
		RedisResource resource = null;
		try{
			resource = resourceService.getRedis(id);
			model.put("info", mGson.toJson(resource));
		}catch(Exception ex) {
			ex.printStackTrace();
			logger.error(ex.getMessage());
			model.put("info", ex.getMessage());			
		}
		return new ModelAndView("responsePage", model);
	}

	@Transactional
	@RequestMapping(value="/ExceptionLess/Add",method=RequestMethod.POST)
	public ModelAndView exceptionLessAddAction(
			@RequestParam("exceptionlessAddName") String name,
			@RequestParam("exceptionlessAddDescription") String description,
			@RequestParam("exceptionlessAddUrl") String url,
			@RequestParam("exceptionlessAddLoginName") String loginName,
			@RequestParam("exceptionlessAddLoginPwd") String loginPwd,
			Map<String, Object> model) {
				
		Map<String, String> data = new HashMap<String, String>();
		data.put("name", name);
		data.put("description", description);
		data.put("url", url);
		data.put("loginName", loginName);
		data.put("loginPwd", loginPwd);
		
		try {
			resourceService.addExceptionLess(data);
		}catch(Exception ex) {
			ex.printStackTrace();
			logger.error(ex.getMessage());
			return Global.getResponseData(-1, ex.getMessage());			
		}
		
		return Global.getResponseData(0, "");
	}
	
	@Transactional
	@RequestMapping(value="/ExceptionLess/Del",method=RequestMethod.POST)
	public ModelAndView exceptionLessDel(@RequestParam("delId") String id,
			Map<String, Object> model) {
		
		Map<String, String> data = new HashMap<String, String>();
		data.put("id", id);
		
		try {
			resourceService.delExceptionLess(data);
		}catch(Exception ex) {
			ex.printStackTrace();
			logger.error(ex.getMessage());
			return Global.getResponseData(-1, ex.getMessage());			
		}
		
		return Global.getResponseData(0, "");
	}
	
	@Transactional
	@RequestMapping(value="/ExceptionLess/{id}",method=RequestMethod.GET)
	public ModelAndView exceptionLessDetail(@PathVariable String id, Map<String, Object> model) {
		
		ExceptionlessResource resource = null;
		try{
			resource = resourceService.getExceptionLess(id);
			model.put("info", mGson.toJson(resource));
		}catch(Exception ex) {
			ex.printStackTrace();
			logger.error(ex.getMessage());
			model.put("info", ex.getMessage());			
		}
		return new ModelAndView("responsePage", model);
	}

	@Transactional
	@RequestMapping(value="/MongoDB/Add",method=RequestMethod.POST)
	public ModelAndView mongodbAddAction(
			@RequestParam("mongodbAddName") String name,
			@RequestParam("mongodbAddDescription") String description,
			@RequestParam("mongodbAddInternetIp") String internetIp,
			@RequestParam("mongodbAddIntranetIp") String intranetIp,
			@RequestParam("mongodbAddPort") String port,
			@RequestParam("mongodbAddLoginName") String loginName,
			@RequestParam("mongodbAddLoginPwd") String loginPwd,
			Map<String, Object> model) {
		
		
		try {
			if(port.trim().equals("")) {
				port = "27017";
			}
			else {
				int iport = Integer.valueOf(port);
				port = String.valueOf(iport);
			}
		}catch(Exception ex) {
			ex.printStackTrace();
			logger.error(ex.getMessage());
			return Global.getResponseData(-1, ex.getMessage());	
		}
				
		Map<String, String> data = new HashMap<String, String>();
		data.put("name", name);
		data.put("description", description);
		data.put("internetIp", internetIp);
		data.put("intranetIp", intranetIp);
		data.put("port", port);
		data.put("loginName", loginName);
		data.put("loginPwd", loginPwd);
		
		try {
			resourceService.addMongoDB(data);
		}catch(Exception ex) {
			ex.printStackTrace();
			logger.error(ex.getMessage());
			return Global.getResponseData(-1, ex.getMessage());			
		}
		
		return Global.getResponseData(0, "");
	}
	
	@Transactional
	@RequestMapping(value="/MongoDB/Del",method=RequestMethod.POST)
	public ModelAndView mongoDBDel(@RequestParam("delId") String id,
			Map<String, Object> model) {
		
		Map<String, String> data = new HashMap<String, String>();
		data.put("id", id);
		
		try {
			resourceService.delMongoDB(data);
		}catch(Exception ex) {
			ex.printStackTrace();
			logger.error(ex.getMessage());
			return Global.getResponseData(-1, ex.getMessage());			
		}
		
		return Global.getResponseData(0, "");
	}
	
	@Transactional
	@RequestMapping(value="/MongoDB/{id}",method=RequestMethod.GET)
	public ModelAndView mongoDBDetail(@PathVariable String id, Map<String, Object> model) {
		
		MongoDBResource resource = null;
		try{
			resource = resourceService.getMongoDB(id);
			model.put("info", mGson.toJson(resource));
		}catch(Exception ex) {
			ex.printStackTrace();
			logger.error(ex.getMessage());
			model.put("info", ex.getMessage());			
		}
		return new ModelAndView("responsePage", model);
	}

	@Transactional
	@RequestMapping(value="/RabbitMQ/Add",method=RequestMethod.POST)
	public ModelAndView rabbitmqAddAction(
			@RequestParam("rabbitmqAddName") String name,
			@RequestParam("rabbitmqAddDescription") String description,
			@RequestParam("rabbitmqAddInternetIp") String internetIp,
			@RequestParam("rabbitmqAddIntranetIp") String intranetIp,
			@RequestParam("rabbitmqAddPort") String port,
			@RequestParam("rabbitmqAddLoginName") String loginName,
			@RequestParam("rabbitmqAddLoginPwd") String loginPwd,
			Map<String, Object> model) {
		
		
		try {
			if(port.trim().equals("")) {
				port = "5672";
			}
			else {
				int iport = Integer.valueOf(port);
				port = String.valueOf(iport);
			}
		}catch(Exception ex) {
			ex.printStackTrace();
			logger.error(ex.getMessage());
			return Global.getResponseData(-1, ex.getMessage());	
		}
				
		Map<String, String> data = new HashMap<String, String>();
		data.put("name", name);
		data.put("description", description);
		data.put("internetIp", internetIp);
		data.put("intranetIp", intranetIp);
		data.put("port", port);
		data.put("loginName", loginName);
		data.put("loginPwd", loginPwd);
		
		try {
			resourceService.addRabbitMQ(data);
		}catch(Exception ex) {
			ex.printStackTrace();
			logger.error(ex.getMessage());
			return Global.getResponseData(-1, ex.getMessage());			
		}
		
		return Global.getResponseData(0, "");
	}
	
	@Transactional
	@RequestMapping(value="/RabbitMQ/Del",method=RequestMethod.POST)
	public ModelAndView rabbitmqDel(@RequestParam("delId") String id,
			Map<String, Object> model) {
		
		Map<String, String> data = new HashMap<String, String>();
		data.put("id", id);
		
		try {
			resourceService.delRabbitMQ(data);
		}catch(Exception ex) {
			ex.printStackTrace();
			logger.error(ex.getMessage());
			return Global.getResponseData(-1, ex.getMessage());			
		}
		
		return Global.getResponseData(0, "");
	}
	
	@Transactional
	@RequestMapping(value="/RabbitMQ/{id}",method=RequestMethod.GET)
	public ModelAndView rabbitmqDetail(@PathVariable String id, Map<String, Object> model) {
		
		RabbitMQResource resource = null;
		try{
			resource = resourceService.getRabbitMQ(id);
			model.put("info", mGson.toJson(resource));
		}catch(Exception ex) {
			ex.printStackTrace();
			logger.error(ex.getMessage());
			model.put("info", ex.getMessage());			
		}
		return new ModelAndView("responsePage", model);
	}

}
