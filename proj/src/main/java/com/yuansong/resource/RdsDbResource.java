package com.yuansong.resource;

public class RdsDbResource extends DbResource {
	
	private String rdsId;
	
	//所在RDS
	private RdsResource rdsResource;

	public RdsResource getRdsResource() {
		return rdsResource;
	}

	public void setRdsResource(RdsResource rdsResource) {
		this.rdsResource = rdsResource;
	}

	public String getRdsId() {
		return rdsId;
	}

	public void setRdsId(String rdsId) {
		this.rdsId = rdsId;
	}

}
