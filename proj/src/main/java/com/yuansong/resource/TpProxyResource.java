package com.yuansong.resource;

public class TpProxyResource extends BaseResource {
	
	private String url;
	private int port;
	
	private String crmDataCenterDbId;
	private int crmDataCenterDbType;
	private String tpO2OProxyConfigDbId;
	private int tpO2OProxyConfigDbType;
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public String getCrmDataCenterDbId() {
		return crmDataCenterDbId;
	}
	public void setCrmDataCenterDbId(String crmDataCenterDbId) {
		this.crmDataCenterDbId = crmDataCenterDbId;
	}
	public String getTpO2OProxyConfigDbId() {
		return tpO2OProxyConfigDbId;
	}
	public void setTpO2OProxyConfigDbId(String tpO2OProxyConfigDbId) {
		this.tpO2OProxyConfigDbId = tpO2OProxyConfigDbId;
	}
	public int getCrmDataCenterDbType() {
		return crmDataCenterDbType;
	}
	public void setCrmDataCenterDbType(int crmDataCenterDbType) {
		this.crmDataCenterDbType = crmDataCenterDbType;
	}
	public int getTpO2OProxyConfigDbType() {
		return tpO2OProxyConfigDbType;
	}
	public void setTpO2OProxyConfigDbType(int tpO2OProxyConfigDbType) {
		this.tpO2OProxyConfigDbType = tpO2OProxyConfigDbType;
	}

}
