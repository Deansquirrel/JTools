package com.yuansong.resource;

public class RedisResource extends BaseResource {
	
	//实例ID
	private String instanceID;
	//所在地域，如华东1
	private String area;
	//连接地址
	private String host;
	//端口
	private int port;
	//连接密码
	private String pwd;
	
	public String getInstanceID() {
		return instanceID;
	}
	public void setInstanceID(String instanceID) {
		this.instanceID = instanceID;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

}
