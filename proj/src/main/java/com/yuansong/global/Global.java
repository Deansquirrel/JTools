package com.yuansong.global;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

public class Global {
	
	private static String version = "1.0.0.0 Build00000000";
	
	private static Gson mGson = new Gson();
	
	public static String getVersion() {
		return version;
	}
	
	public static ModelAndView getResponseData(int errCode, String errMsg){
		return Global.getResponseData(errCode, errMsg, null);
	}
	
	public static ModelAndView getResponseData(int errCode, String errMsg, Object rData){
		
		Map<String, Object> data = new HashMap<String, Object>();
        data.put("errcode", errCode);
        data.put("errmsg", errMsg);
        if(rData != null) {
        	data.put("data", rData);        	
        }
        
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("info", mGson.toJson(data));
        
        return new ModelAndView("responsePage",model);
	}
	
}
