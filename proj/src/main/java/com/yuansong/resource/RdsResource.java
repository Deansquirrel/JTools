package com.yuansong.resource;

import java.util.Date;

public class RdsResource extends BaseResource {
	
	//实例ID
	private String instanceID;
	//所在地域，如华东1
	private String area;
	//数据库类型
	private String dbType;
	//外网地址
	private String internetIp;
	//外网端口
	private int internetPort;
	//内网地址
	private String intranetIp;
	//内网端口
	private int intranetPort;
	//过期日期
	private Date expirationDate;
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getDbType() {
		return dbType;
	}
	public void setDbType(String dbType) {
		this.dbType = dbType;
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
	public Date getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}
	public String getInstanceID() {
		return instanceID;
	}
	public void setInstanceID(String instanceID) {
		this.instanceID = instanceID;
	}
	public int getInternetPort() {
		return internetPort;
	}
	public void setInternetPort(int internetPort) {
		this.internetPort = internetPort;
	}
	public int getIntranetPort() {
		return intranetPort;
	}
	public void setIntranetPort(int intranetPort) {
		this.intranetPort = intranetPort;
	}

}
