package com.yuansong.resource;

public class CustomerResource extends BaseResource {
	
	//客户编码
	private String code;
	//显示名称
	private String showName;
	//简称
	private String simpleName;
	//拼音简称
	private String pinyinName;
	
	//Z5 or Z9
	private String misType;
	//通道码
	private String tongdCode;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getShowName() {
		return showName;
	}
	public void setShowName(String showName) {
		this.showName = showName;
	}
	public String getSimpleName() {
		return simpleName;
	}
	public void setSimpleName(String simpleName) {
		this.simpleName = simpleName;
	}
	public String getTongdCode() {
		return tongdCode;
	}
	public void setTongdCode(String tongdCode) {
		this.tongdCode = tongdCode;
	}
	public String getMisType() {
		return misType;
	}
	public void setMisType(String misType) {
		this.misType = misType;
	}
	public String getPinyinName() {
		return pinyinName;
	}
	public void setPinyinName(String pinyinName) {
		this.pinyinName = pinyinName;
	}

}
