package com.yuansong.global;

import org.springframework.stereotype.Component;

@Component
public class SystemConfig {
	
	private String url;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
