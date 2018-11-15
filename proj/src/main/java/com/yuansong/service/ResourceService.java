package com.yuansong.service;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.yuansong.common.HttpUtils;
import com.yuansong.form.InterfaceResult;
import com.yuansong.global.SystemConfig;
import com.yuansong.resource.BaseResource;
import com.yuansong.resource.CommonDbResource;
import com.yuansong.resource.CustomerResource;
import com.yuansong.resource.EcsResource;
import com.yuansong.resource.RdsDbResource;

@Service
public class ResourceService {
	
	private final Logger logger = Logger.getLogger(ResourceService.class);
	
	private Gson mGson = new Gson();
	
	private HttpUtils httpUtils = new HttpUtils();
	
	@Autowired
	private SystemConfig systemConfig;
	
	/***
	 * 获取资源信息摘要列表
	 * @return
	 * @throws Exception
	 */
	public Map<String, List<BaseResource>> getBaseResourceList() throws Exception{
		String result = httpUtils.httpGet(systemConfig.getUrl() + "/Resource/List");
		InterfaceResult<Map<String, List<BaseResource>>> info = mGson.fromJson(result, new TypeToken<InterfaceResult<Map<String, List<BaseResource>>>>(){}.getType());
		if(info.getErrcode() != 0) {
			logger.error(info.getErrmsg());
			throw new Exception(info.getErrmsg());
		}
		return info.getData();
	}
	
	/***
	 * 添加用户
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public int addCustomer(Map<String, String> data) throws Exception {
		String result = httpUtils.httpPostJson(systemConfig.getUrl() + "/Resource/Customer/Add", mGson.toJson(data));
		
		InterfaceResult<Integer> info = mGson.fromJson(result, new TypeToken<InterfaceResult<Integer>>(){}.getType());
		if(info.getErrcode() != 0) {
			logger.error(info.getErrmsg());
			throw new Exception(info.getErrmsg());
		}
		return info.getData();
	}
	
	/***
	 * 删除用户
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public int delCustomer(Map<String, String> data) throws Exception {
		logger.debug(mGson.toJson(data));
		String result = httpUtils.httpPostJson(systemConfig.getUrl() + "/Resource/Customer/Del", mGson.toJson(data));
		
		InterfaceResult<Integer> info = mGson.fromJson(result, new TypeToken<InterfaceResult<Integer>>(){}.getType());
		if(info.getErrcode() != 0) {
			logger.error(info.getErrmsg());
			throw new Exception(info.getErrmsg());
		}
		return info.getData();
	}
	
	/***
	 * 获取单个用户信息
	 * @param id
	 * @return
	 */
	public CustomerResource getCustomer(String id)  throws Exception {
		String result = httpUtils.httpGet(systemConfig.getUrl() + "/Resource/Customer/" + id);
		logger.debug(result);
		InterfaceResult<CustomerResource> info = mGson.fromJson(result, new TypeToken<InterfaceResult<CustomerResource>>(){}.getType());
		if(info.getErrcode() != 0) {
			logger.error(info.getErrmsg());
			throw new Exception(info.getErrmsg());
		}
		return info.getData();
	}
	
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
	
	/***
	 * 添加ECS
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public int addEcs(Map<String, String> data) throws Exception {
		String result = httpUtils.httpPostJson(systemConfig.getUrl() + "/Resource/Ecs/Add", mGson.toJson(data));
		
		InterfaceResult<Integer> info = mGson.fromJson(result, new TypeToken<InterfaceResult<Integer>>(){}.getType());
		if(info.getErrcode() != 0) {
			logger.error(info.getErrmsg());
			throw new Exception(info.getErrmsg());
		}
		return info.getData();
	}
	
	/***
	 * 删除ECS
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public int delEcs(Map<String, String> data) throws Exception {
		logger.debug(mGson.toJson(data));
		String result = httpUtils.httpPostJson(systemConfig.getUrl() + "/Resource/Ecs/Del", mGson.toJson(data));
		
		InterfaceResult<Integer> info = mGson.fromJson(result, new TypeToken<InterfaceResult<Integer>>(){}.getType());
		if(info.getErrcode() != 0) {
			logger.error(info.getErrmsg());
			throw new Exception(info.getErrmsg());
		}
		return info.getData();
	}
	
	/***
	 * 获取单个Ecs信息
	 * @param id
	 * @return
	 */
	public EcsResource getEcs(String id)  throws Exception {
		String result = httpUtils.httpGet(systemConfig.getUrl() + "/Resource/Ecs/" + id);
		logger.debug(result);
		InterfaceResult<EcsResource> info = mGson.fromJson(result, new TypeToken<InterfaceResult<EcsResource>>(){}.getType());
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
