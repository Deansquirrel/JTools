package com.yuansong.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.yuansong.common.HttpUtils;
import com.yuansong.form.CrmInfo;
import com.yuansong.form.CrmYwDzServiceWxMembership;
import com.yuansong.form.InterfaceResult;
import com.yuansong.global.SystemConfig;
import com.yuansong.resource.RdsDbResource;

@Service
public class CrmService {
	
	private Gson mGson = null;
	
	@Autowired
	private SystemConfig systemConfig;
	
	@Autowired
	private CommonService commonService;
	
	private static final String SQL_GET_ACCID_BY_TEL = ""
			+ "select accid from cfv4accstat where acccellno in (?)";
	
	private static final String SQL_GET_RCODE_BY_ACCID = ""
			+ "select rcode from cfv4accwxmprel where accid=?";
	
	public CrmService() {
		mGson = new Gson();
	}
	
	public CrmInfo getCrmInfo(String customerCode, String requiredInfo) throws Exception {
		List<String> requiredInfoList = new ArrayList<String>();
		requiredInfoList.add(requiredInfo);
		return this.getCrmInfo(customerCode, requiredInfoList);
	}
		
	public CrmInfo getCrmInfo(String customerCode, List<String> requiredInfo) throws Exception {
		String result = this.getCrmInfoStr(customerCode, requiredInfo);
		InterfaceResult<CrmInfo> crmInfo = mGson.fromJson(result, new TypeToken<InterfaceResult<CrmInfo>>(){}.getType());
		if(crmInfo.getErrcode() != 0) {
			throw new Exception(crmInfo.getErrmsg());
		}
		else {
			return crmInfo.getData();
		}
	}
	
	private String getCrmInfoStr(String customerCode, List<String> requiredInfo) throws IOException {
		HttpUtils httpUtils = new HttpUtils();
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("customerCode", customerCode);
		data.put("requiredInfo", requiredInfo);
		return httpUtils.httpPostJson(systemConfig.getUrl() + "/Crm/Info", mGson.toJson(data));
	}
	
	

	/***
	 * 根据手机号在核心库查询accid
	 * @param tel
	 * @return
	 * @throws Exception 
	 */
	public String getAccidByTel(List<RdsDbResource> dbList, String tel) throws Exception {		
		String accid = "";
		JdbcTemplate jdbcTemplate;
		for(int i=0;i<dbList.size();i++) {
			jdbcTemplate = commonService.getJdbcTemplate(dbList.get(i));
			List<String> strList = jdbcTemplate.queryForList(SQL_GET_ACCID_BY_TEL, new Object[] {tel}, String.class);
			if(strList.size() > 0) {
				accid = strList.get(0);
				break;
			}
		}
		return accid;
	}
	
	/***
	 * 根据accid在核心库查询rcode
	 * @param accid
	 * @return
	 * @throws Exception 
	 */
	public String getRCodeByAccid(List<RdsDbResource> dbList, String accid) throws Exception {
		String rcode = "";
		JdbcTemplate jdbcTemplate;
		for(int i=0;i<dbList.size();i++) {
			jdbcTemplate = commonService.getJdbcTemplate(dbList.get(i));
			List<String> strList = jdbcTemplate.queryForList(SQL_GET_RCODE_BY_ACCID, new Object[] {accid}, String.class);
			if(strList.size() > 0) {
				rcode = strList.get(0);
				break;
			}
		}
		return rcode;
	}
	
	/**
	 * 调用CrmYwDz服务，获取更新微信卡面号信息
	 * @param rCode
	 * @return
	 * @throws Exception 
	 */
	public CrmYwDzServiceWxMembership getCrmYwDzServiceUpdateWeixinMembershipno(String crmDzServiceAddress, String appid, String rCode) throws Exception {		
		HttpUtils httpUtils = new HttpUtils();
		String accInfoStr = httpUtils.httpGet(crmDzServiceAddress + "/ApiV1/CRMYwDzService/UpdateWeixinMembershipno?wxcardcode=" + rCode);
		if(accInfoStr.equals("")) {
			throw new Exception("通过定制服务获取账户信息失败。");
		}
		CrmYwDzServiceWxMembership accInfo = mGson.fromJson(accInfoStr, CrmYwDzServiceWxMembership.class);
		if(accInfo.getDescription() != null && !accInfo.getDescription().equals("")) {
			throw new Exception("通过定制服务获取账户信息时遇到错误。[" + accInfo.getDescription() + "]");
		}
		
		return accInfo;
	}
}
