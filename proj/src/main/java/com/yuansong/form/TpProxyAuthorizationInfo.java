package com.yuansong.form;

import java.util.Date;

public class TpProxyAuthorizationInfo {
	private String authorizerAppid;
	private String authorizerAccessToken;
	private String authorizerRefreshToken;
	private Date expiresTime;
	private Date updateTime;
	public String getAuthorizerAppid() {
		return authorizerAppid;
	}
	public void setAuthorizerAppid(String authorizerAppid) {
		this.authorizerAppid = authorizerAppid;
	}
	public String getAuthorizerAccessToken() {
		return authorizerAccessToken;
	}
	public void setAuthorizerAccessToken(String authorizerAccessToken) {
		this.authorizerAccessToken = authorizerAccessToken;
	}
	public String getAuthorizerRefreshToken() {
		return authorizerRefreshToken;
	}
	public void setAuthorizerRefreshToken(String authorizerRefreshToken) {
		this.authorizerRefreshToken = authorizerRefreshToken;
	}
	public Date getExpiresTime() {
		return expiresTime;
	}
	public void setExpiresTime(Date expiresTime) {
		this.expiresTime = expiresTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
}
