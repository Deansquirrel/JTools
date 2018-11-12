package com.yuansong.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerExceptionResolverComposite;

import com.yuansong.global.Global;

public class ExceptionHandler extends HandlerExceptionResolverComposite {
	
	private final Logger logger = Logger.getLogger(ExceptionHandler.class);
	
	public ModelAndView resolveException(HttpServletRequest request,   
            HttpServletResponse response, Object handler, Exception ex) {
		
		StringWriter sw = new StringWriter();   
        PrintWriter pw = new PrintWriter(sw, true);   
        ex.printStackTrace(pw);   
        pw.flush();   
        sw.flush();
        
        logger.error(ex.getMessage());
        logger.error(sw.toString());
        ex.printStackTrace();
        
        return Global.getResponseData(-1, ex.getMessage());
        
//        Map<String, Object> data = new HashMap<String, Object>();
//        data.put("errcode", -1);
//        data.put("errmsg", ex.getMessage());
//        
//        Map<String, Object> model = new HashMap<String, Object>();
//		model.put("info", mGson.toJson(data));
//		
//        return new ModelAndView("responsePage",model);   
    }

}
