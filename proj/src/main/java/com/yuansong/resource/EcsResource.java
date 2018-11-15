package com.yuansong.resource;

import java.util.Date;

public class EcsResource extends BaseResource {
	
	//实例ID
	private String instanceID;
	//所在地域，如华东1
	private String area;
	//公网IP
	private String internetIp;
	//私有IP
	private String intranetIp;
	//操作系统
	private String os;
	//过期日期
	private Date expirationDate;
	//远程桌面端口
	private int rdpPort;
	//操作系统登录名
	private String loginName;
	//操作系统登录密码
	private String loginPwd;
	
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getInternetIp() {
		return internetIp;
	}
	public void setInternetIp(String internetIp) {
		this.internetIp = internetIp;
	}
	public String getIntranetIp() {
		return intranetIp;
	}
	public void setIntranetIp(String intranetIp) {
		this.intranetIp = intranetIp;
	}
	public String getOs() {
		return os;
	}
	public void setOs(String os) {
		this.os = os;
	}
	public Date getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getLoginPwd() {
		return loginPwd;
	}
	public void setLoginPwd(String loginPwd) {
		this.loginPwd = loginPwd;
	}
	public String getInstanceID() {
		return instanceID;
	}
	public void setInstanceID(String instanceID) {
		this.instanceID = instanceID;
	}
	public int getRdpPort() {
		return rdpPort;
	}
	public void setRdpPort(int rdpPort) {
		this.rdpPort = rdpPort;
	}

}
