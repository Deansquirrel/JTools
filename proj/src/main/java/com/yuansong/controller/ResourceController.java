package com.yuansong.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.yuansong.global.Global;
import com.yuansong.service.ResourceService;

@Controller
@RequestMapping(value="/Resource")
public class ResourceController {
	
	private final Logger logger = Logger.getLogger(ResourceController.class);
	
	@Autowired
	private ResourceService resourceService;

	@Transactional
	@RequestMapping(value="/Customer/Add",method=RequestMethod.POST)
	public ModelAndView configAddAction(
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

}
