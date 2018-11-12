package com.yuansong.service;

import java.io.IOException;

import org.springframework.stereotype.Service;

import com.yuansong.common.HttpUtils;

@Service
public class WxService {
//	https://api.weixin.qq.com/card/membercard/activate?access_token=TOKEN
	private static final String URL_CARD_MEMBERCARD_ACTIVE = "https://api.weixin.qq.com/card/membercard/activate";
	
	/***
	 * 调用微信接口，更新微信卡面号
	 * @param json
	 * @return
	 * @throws IOException 
	 */
	public String cardMembercardActive(String token, String json) throws IOException {
		HttpUtils httpUtils = new HttpUtils();
		return httpUtils.httpPostJson(URL_CARD_MEMBERCARD_ACTIVE + "?access_token=" + token, json);
	}

}
