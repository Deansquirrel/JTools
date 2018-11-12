package com.yuansong.worker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.yuansong.form.CrmInfo;
import com.yuansong.form.CrmYwDzServiceWxMembership;
import com.yuansong.form.TpProxyAuthorizationInfo;
import com.yuansong.service.CrmService;
import com.yuansong.service.TpProxyService;
import com.yuansong.service.WxService;

@Component
public class UpdateWxCardNo {
	
	private final Logger logger = Logger.getLogger(UpdateWxCardNo.class);
		
	@Autowired
	private CrmService crmService;
	
	@Autowired
	private WxService wxService;
	
	@Autowired
	private TpProxyService tpProxyService;
	
	private Gson mGson = null;
	
	public UpdateWxCardNo() {
		mGson = new Gson();
	}
	
	public String update(String customerCode, String tel) throws Exception {
		
		logger.debug("UpdateWxCardNo - update : " + customerCode + "   " + tel);
		
		List<String> requiredList = new ArrayList<String>();
		requiredList.add("hxDb");
		requiredList.add("crmDzServiceAddress");
		requiredList.add("appid");
		requiredList.add("tpProxy");
		
		CrmInfo crmInfoData =null;
		try {
			crmInfoData = crmService.getCrmInfo(customerCode, requiredList);			
		}catch(Exception ex) {
			throw new Exception("获取Crm信息时发生错误。[" + ex.getMessage() + "]");
		}
		
		if(crmInfoData.getHxDb() == null || crmInfoData.getHxDb().size() < 1) {
			throw new Exception("获取核心库列表失败。");
		}
		if(crmInfoData.getCrmDzServiceAddress() == null || crmInfoData.getCrmDzServiceAddress().equals("")) {
			throw new Exception("获取CrmDz服务地址失败。");
		}
		if(crmInfoData.getAppid() == null || crmInfoData.getAppid().equals("")) {
			throw new Exception("获取appid失败。");
		}
		if(crmInfoData.getTpProxy() == null) {
			throw new Exception("获取tpProxy信息失败。");
		}
		
		logger.debug(crmInfoData.getCrmDzServiceAddress());
		logger.debug(crmInfoData.getAppid());
		
		String accid = crmService.getAccidByTel(crmInfoData.getHxDb(), tel);
		if(accid.equals("")) {
			throw new Exception("未获取到accid");
		}
		logger.debug(accid);
		
		String rcode = crmService.getRCodeByAccid(crmInfoData.getHxDb(), accid);
		if(rcode.equals("")) {
			throw new Exception("未获取到rcode");
		}
		logger.debug(rcode);
		
		TpProxyAuthorizationInfo tpProxyAuthorizationInfo = tpProxyService.getAuthorizationInfo(crmInfoData.getTpProxy(), crmInfoData.getAppid());
		String accessToken = tpProxyAuthorizationInfo.getAuthorizerAccessToken();
		logger.debug(accessToken);
		
		CrmYwDzServiceWxMembership accInfo = crmService.getCrmYwDzServiceUpdateWeixinMembershipno(crmInfoData.getCrmDzServiceAddress(),crmInfoData.getAppid(), rcode);
		
		Map<String, String> accInfoData = new HashMap<String, String>();
		accInfoData.put("membership_number", accInfo.getWxcardno());
		accInfoData.put("code", accInfo.getUcode());
		accInfoData.put("card_id", accInfo.getUcardid());
		accInfoData.put("init_custom_field_value1", accInfo.getAccdismc());
		
		String data = mGson.toJson(accInfoData);
		logger.debug(data);
		
		String wxResult = "";
		try {
			wxResult = wxService.cardMembercardActive(accessToken, data); 
		}catch(Exception ex){
			logger.debug(ex.getMessage());
			ex.printStackTrace();
			throw new Exception("调用微信接口是发生错误。[" + ex.getMessage() + "]");
		}
		logger.debug(wxResult);
		
		Map<String, String> result = new HashMap<String,String>();
		result.put("客户编码", customerCode);
		result.put("手机号", tel);
		result.put("Accid", accid);
		result.put("rcode", rcode);
		result.put("提交微信数据", data);
		result.put("微信返回结果", wxResult);
		return mGson.toJson(result);
	}

}
