package com.yuansong.worker;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.yuansong.form.CrmYwDzServiceWxMembership;
import com.yuansong.service.CrmService;
import com.yuansong.service.WxService;

@Component
public class UpdateWxCardNo2 {
	
	private final Logger logger = Logger.getLogger(UpdateWxCardNo2.class);
		
	@Autowired
	private CrmService crmService;
	
	@Autowired
	private WxService wxService;
	
	private Gson mGson = null;
	
	public UpdateWxCardNo2() {
		mGson = new Gson();
	}
	
	public String update(String rcode) throws Exception {
		logger.debug(rcode);
		String accessToken = "15_Rf_q_sI_WAgkNvQbLpBWcCccUh8XZKVtqYXJHRKfCv_BbKaA0UZEv9Mg-nDFJHsCS69VgPMP7wQicGnmgUm0GfjmyX7wmu0rAG0YVC9xlo7-VeTNS-4lKiio8abBE-09acY6i6bbOZmpb1OfVGHbAHDDOP";
		logger.debug(accessToken);
		
		CrmYwDzServiceWxMembership accInfo = crmService.getCrmYwDzServiceUpdateWeixinMembershipno("http://116.62.23.123:10022","wx9f81eddbbadfe23a", rcode);
		
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
		result.put("rcode", rcode);
		result.put("提交微信数据", data);
		result.put("微信返回结果", wxResult);
		return mGson.toJson(result);
	}

}
