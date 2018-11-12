package com.yuansong.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.yuansong.common.HttpUtils;
import com.yuansong.form.InterfaceResult;
import com.yuansong.global.SystemConfig;
import com.yuansong.resource.CommonDbResource;
import com.yuansong.resource.CustomerResource;
import com.yuansong.resource.RdsDbResource;

@Service
public class ResourceService {
	
	private final Logger logger = Logger.getLogger(ResourceService.class);
	
	private Gson mGson = new Gson();
	
	private HttpUtils httpUtils = new HttpUtils();
	
	@Autowired
	private SystemConfig systemConfig;
	
	/***
	 * 获取客户资源列表
	 * @return
	 * @throws Exception
	 */
	public List<CustomerResource> getCustomerList() throws Exception{
		String result = httpUtils.httpGet(systemConfig.getUrl() + "/Resource/Customer/Get");
		InterfaceResult<List<CustomerResource>> info = mGson.fromJson(result, new TypeToken<InterfaceResult<List<CustomerResource>>>(){}.getType());
		if(info.getErrcode() != 0) {
			logger.error(info.getErrmsg());
			throw new Exception(info.getErrmsg());
		}
		return info.getData();
	}
	
	public RdsDbResource getRds(String id) throws Exception{
		String result = httpUtils.httpGet(systemConfig.getUrl() + "/Resource/Rds/" + id);
//		return this.getResource(result);
		InterfaceResult<RdsDbResource> info = mGson.fromJson(result, new TypeToken<InterfaceResult<RdsDbResource>>(){}.getType());
		if(info.getErrcode() != 0) {
			logger.error(info.getErrmsg());
			throw new Exception(info.getErrmsg());
		}
		return info.getData();
	}
	
	public CommonDbResource getDb(String id) throws Exception{
		String result = httpUtils.httpGet(systemConfig.getUrl() + "/Resource/DB/" + id);
//		return this.getResource(result);
		InterfaceResult<CommonDbResource> info = mGson.fromJson(result, new TypeToken<InterfaceResult<CommonDbResource>>(){}.getType());
		if(info.getErrcode() != 0) {
			logger.error(info.getErrmsg());
			throw new Exception(info.getErrmsg());
		}
		return info.getData();
	}
	
//	private <T> T getResource(String url) throws Exception{
//		String result = httpUtils.httpGet(url);
//		InterfaceResult<T> info = mGson.fromJson(result, new TypeToken<InterfaceResult<T>>(){}.getType());
//		if(info.getErrcode() != 0) {
//			logger.error(info.getErrmsg());
//			throw new Exception(info.getErrmsg());
//		}
//		return info.getData();
//	}
}
