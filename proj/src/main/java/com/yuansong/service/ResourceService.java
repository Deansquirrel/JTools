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
import com.yuansong.resource.ExceptionlessResource;
import com.yuansong.resource.MongoDBResource;
import com.yuansong.resource.RabbitMQResource;
import com.yuansong.resource.RdsDbResource;
import com.yuansong.resource.RdsResource;
import com.yuansong.resource.RedisResource;

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
		String result = httpUtils.httpGet(systemConfig.getUrl() + "/Resource/Customer/List");
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
	
	/***
	 * 添加RDS
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public int addRds(Map<String, String> data) throws Exception {
		String result = httpUtils.httpPostJson(systemConfig.getUrl() + "/Resource/Rds/Add", mGson.toJson(data));
		
		InterfaceResult<Integer> info = mGson.fromJson(result, new TypeToken<InterfaceResult<Integer>>(){}.getType());
		if(info.getErrcode() != 0) {
			logger.error(info.getErrmsg());
			throw new Exception(info.getErrmsg());
		}
		return info.getData();
	}
		
	/***
	 * 删除RDS
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public int delRds(Map<String, String> data) throws Exception {
		logger.debug(mGson.toJson(data));
		String result = httpUtils.httpPostJson(systemConfig.getUrl() + "/Resource/Rds/Del", mGson.toJson(data));
		
		InterfaceResult<Integer> info = mGson.fromJson(result, new TypeToken<InterfaceResult<Integer>>(){}.getType());
		if(info.getErrcode() != 0) {
			logger.error(info.getErrmsg());
			throw new Exception(info.getErrmsg());
		}
		return info.getData();
	}
	
	/***
	 * 获取单个RDS信息
	 * @param id
	 * @return
	 */
	public RdsResource getRds(String id)  throws Exception {
		String result = httpUtils.httpGet(systemConfig.getUrl() + "/Resource/Rds/" + id);
		logger.debug(result);
		InterfaceResult<RdsResource> info = mGson.fromJson(result, new TypeToken<InterfaceResult<RdsResource>>(){}.getType());
		if(info.getErrcode() != 0) {
			logger.error(info.getErrmsg());
			throw new Exception(info.getErrmsg());
		}
		return info.getData();
	}
	
	/***
	 * 获取RDS资源列表
	 * @return
	 * @throws Exception
	 */
	public List<RdsResource> getRdsList() throws Exception{
		String result = httpUtils.httpGet(systemConfig.getUrl() + "/Resource/Rds/List");
		InterfaceResult<List<RdsResource>> info = mGson.fromJson(result, new TypeToken<InterfaceResult<List<RdsResource>>>(){}.getType());
		if(info.getErrcode() != 0) {
			logger.error(info.getErrmsg());
			throw new Exception(info.getErrmsg());
		}
		return info.getData();
	}
	
	/***
	 * 添加CommonDb
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public int addCommonDb(Map<String, String> data) throws Exception {
		String result = httpUtils.httpPostJson(systemConfig.getUrl() + "/Resource/CommonDb/Add", mGson.toJson(data));
		
		InterfaceResult<Integer> info = mGson.fromJson(result, new TypeToken<InterfaceResult<Integer>>(){}.getType());
		if(info.getErrcode() != 0) {
			logger.error(info.getErrmsg());
			throw new Exception(info.getErrmsg());
		}
		return info.getData();
	}
	
	/***
	 * 删除CommonDb
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public int delCommonDb(Map<String, String> data) throws Exception {
		logger.debug(mGson.toJson(data));
		String result = httpUtils.httpPostJson(systemConfig.getUrl() + "/Resource/CommonDb/Del", mGson.toJson(data));
		
		InterfaceResult<Integer> info = mGson.fromJson(result, new TypeToken<InterfaceResult<Integer>>(){}.getType());
		if(info.getErrcode() != 0) {
			logger.error(info.getErrmsg());
			throw new Exception(info.getErrmsg());
		}
		return info.getData();
	}
	
	/***
	 * 获取单个CommonDb信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public CommonDbResource getCommonDb(String id)  throws Exception {
		String result = httpUtils.httpGet(systemConfig.getUrl() + "/Resource/CommonDb/" + id);
		logger.debug(result);
		InterfaceResult<CommonDbResource> info = mGson.fromJson(result, new TypeToken<InterfaceResult<CommonDbResource>>(){}.getType());
		if(info.getErrcode() != 0) {
			logger.error(info.getErrmsg());
			throw new Exception(info.getErrmsg());
		}
		return info.getData();
	}
	
	/***
	 * 添加RdsDb
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public int addRdsDb(Map<String, String> data) throws Exception {
		String result = httpUtils.httpPostJson(systemConfig.getUrl() + "/Resource/RdsDb/Add", mGson.toJson(data));
		
		InterfaceResult<Integer> info = mGson.fromJson(result, new TypeToken<InterfaceResult<Integer>>(){}.getType());
		if(info.getErrcode() != 0) {
			logger.error(info.getErrmsg());
			throw new Exception(info.getErrmsg());
		}
		return info.getData();
	}
	
	/***
	 * 删除RdsDb
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public int delRdsDb(Map<String, String> data) throws Exception {
		logger.debug(mGson.toJson(data));
		String result = httpUtils.httpPostJson(systemConfig.getUrl() + "/Resource/RdsDb/Del", mGson.toJson(data));
		
		InterfaceResult<Integer> info = mGson.fromJson(result, new TypeToken<InterfaceResult<Integer>>(){}.getType());
		if(info.getErrcode() != 0) {
			logger.error(info.getErrmsg());
			throw new Exception(info.getErrmsg());
		}
		return info.getData();
	}
	
	/***
	 * 获取单个RdsDb信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public RdsDbResource getRdsDb(String id)  throws Exception {
		String result = httpUtils.httpGet(systemConfig.getUrl() + "/Resource/RdsDb/" + id);
		logger.debug(result);
		InterfaceResult<RdsDbResource> info = mGson.fromJson(result, new TypeToken<InterfaceResult<RdsDbResource>>(){}.getType());
		if(info.getErrcode() != 0) {
			logger.error(info.getErrmsg());
			throw new Exception(info.getErrmsg());
		}
		return info.getData();
	}
	
	/***
	 * 添加Redis
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public int addRedis(Map<String, String> data) throws Exception {
		String result = httpUtils.httpPostJson(systemConfig.getUrl() + "/Resource/Redis/Add", mGson.toJson(data));
		
		InterfaceResult<Integer> info = mGson.fromJson(result, new TypeToken<InterfaceResult<Integer>>(){}.getType());
		if(info.getErrcode() != 0) {
			logger.error(info.getErrmsg());
			throw new Exception(info.getErrmsg());
		}
		return info.getData();
	}
	
	/***
	 * 删除Redis
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public int delRedis(Map<String, String> data) throws Exception {
		logger.debug(mGson.toJson(data));
		String result = httpUtils.httpPostJson(systemConfig.getUrl() + "/Resource/Redis/Del", mGson.toJson(data));
		
		InterfaceResult<Integer> info = mGson.fromJson(result, new TypeToken<InterfaceResult<Integer>>(){}.getType());
		if(info.getErrcode() != 0) {
			logger.error(info.getErrmsg());
			throw new Exception(info.getErrmsg());
		}
		return info.getData();
	}
	
	/***
	 * 获取单个Redis信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public RedisResource getRedis(String id)  throws Exception {
		String result = httpUtils.httpGet(systemConfig.getUrl() + "/Resource/Redis/" + id);
		logger.debug(result);
		InterfaceResult<RedisResource> info = mGson.fromJson(result, new TypeToken<InterfaceResult<RedisResource>>(){}.getType());
		if(info.getErrcode() != 0) {
			logger.error(info.getErrmsg());
			throw new Exception(info.getErrmsg());
		}
		return info.getData();
	}
	
	
	/***
	 * 添加ExceptionLess
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public int addExceptionLess(Map<String, String> data) throws Exception {
		String result = httpUtils.httpPostJson(systemConfig.getUrl() + "/Resource/ExceptionLess/Add", mGson.toJson(data));
		
		InterfaceResult<Integer> info = mGson.fromJson(result, new TypeToken<InterfaceResult<Integer>>(){}.getType());
		if(info.getErrcode() != 0) {
			logger.error(info.getErrmsg());
			throw new Exception(info.getErrmsg());
		}
		return info.getData();
	}
	
	/***
	 * 删除ExceptionLess
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public int delExceptionLess(Map<String, String> data) throws Exception {
		logger.debug(mGson.toJson(data));
		String result = httpUtils.httpPostJson(systemConfig.getUrl() + "/Resource/ExceptionLess/Del", mGson.toJson(data));
		
		InterfaceResult<Integer> info = mGson.fromJson(result, new TypeToken<InterfaceResult<Integer>>(){}.getType());
		if(info.getErrcode() != 0) {
			logger.error(info.getErrmsg());
			throw new Exception(info.getErrmsg());
		}
		return info.getData();
	}
	
	/***
	 * 获取单个ExceptionLess信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public ExceptionlessResource getExceptionLess(String id)  throws Exception {
		String result = httpUtils.httpGet(systemConfig.getUrl() + "/Resource/ExceptionLess/" + id);
		logger.debug(result);
		InterfaceResult<ExceptionlessResource> info = mGson.fromJson(result, new TypeToken<InterfaceResult<ExceptionlessResource>>(){}.getType());
		if(info.getErrcode() != 0) {
			logger.error(info.getErrmsg());
			throw new Exception(info.getErrmsg());
		}
		return info.getData();
	}
	
	/***
	 * 添加MongoDB
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public int addMongoDB(Map<String, String> data) throws Exception {
		String result = httpUtils.httpPostJson(systemConfig.getUrl() + "/Resource/MongoDB/Add", mGson.toJson(data));
		
		InterfaceResult<Integer> info = mGson.fromJson(result, new TypeToken<InterfaceResult<Integer>>(){}.getType());
		if(info.getErrcode() != 0) {
			logger.error(info.getErrmsg());
			throw new Exception(info.getErrmsg());
		}
		return info.getData();
	}
	
	/***
	 * 删除MongoDB
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public int delMongoDB(Map<String, String> data) throws Exception {
		logger.debug(mGson.toJson(data));
		String result = httpUtils.httpPostJson(systemConfig.getUrl() + "/Resource/MongoDB/Del", mGson.toJson(data));
		
		InterfaceResult<Integer> info = mGson.fromJson(result, new TypeToken<InterfaceResult<Integer>>(){}.getType());
		if(info.getErrcode() != 0) {
			logger.error(info.getErrmsg());
			throw new Exception(info.getErrmsg());
		}
		return info.getData();
	}
	
	/***
	 * 获取单个MongoDB信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public MongoDBResource getMongoDB(String id)  throws Exception {
		String result = httpUtils.httpGet(systemConfig.getUrl() + "/Resource/MongoDB/" + id);
		logger.debug(result);
		InterfaceResult<MongoDBResource> info = mGson.fromJson(result, new TypeToken<InterfaceResult<MongoDBResource>>(){}.getType());
		if(info.getErrcode() != 0) {
			logger.error(info.getErrmsg());
			throw new Exception(info.getErrmsg());
		}
		return info.getData();
	}
	
	/***
	 * 添加RabbitMQ
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public int addRabbitMQ(Map<String, String> data) throws Exception {
		String result = httpUtils.httpPostJson(systemConfig.getUrl() + "/Resource/RabbitMQ/Add", mGson.toJson(data));
		
		InterfaceResult<Integer> info = mGson.fromJson(result, new TypeToken<InterfaceResult<Integer>>(){}.getType());
		if(info.getErrcode() != 0) {
			logger.error(info.getErrmsg());
			throw new Exception(info.getErrmsg());
		}
		return info.getData();
	}
	
	/***
	 * 删除RabbitMQ
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public int delRabbitMQ(Map<String, String> data) throws Exception {
		logger.debug(mGson.toJson(data));
		String result = httpUtils.httpPostJson(systemConfig.getUrl() + "/Resource/RabbitMQ/Del", mGson.toJson(data));
		
		InterfaceResult<Integer> info = mGson.fromJson(result, new TypeToken<InterfaceResult<Integer>>(){}.getType());
		if(info.getErrcode() != 0) {
			logger.error(info.getErrmsg());
			throw new Exception(info.getErrmsg());
		}
		return info.getData();
	}
	
	/***
	 * 获取单个RabbitMQ信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public RabbitMQResource getRabbitMQ(String id)  throws Exception {
		String result = httpUtils.httpGet(systemConfig.getUrl() + "/Resource/RabbitMQ/" + id);
		logger.debug(result);
		InterfaceResult<RabbitMQResource> info = mGson.fromJson(result, new TypeToken<InterfaceResult<RabbitMQResource>>(){}.getType());
		if(info.getErrcode() != 0) {
			logger.error(info.getErrmsg());
			throw new Exception(info.getErrmsg());
		}
		return info.getData();
	}
	
	
	
	
	
	
	
	

	
//	public CommonDbResource getDb(String id) throws Exception{
//		String result = httpUtils.httpGet(systemConfig.getUrl() + "/Resource/DB/" + id);
////		return this.getResource(result);
//		InterfaceResult<CommonDbResource> info = mGson.fromJson(result, new TypeToken<InterfaceResult<CommonDbResource>>(){}.getType());
//		if(info.getErrcode() != 0) {
//			logger.error(info.getErrmsg());
//			throw new Exception(info.getErrmsg());
//		}
//		return info.getData();
//	}
	
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
