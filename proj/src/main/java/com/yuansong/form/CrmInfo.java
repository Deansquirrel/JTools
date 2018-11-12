package com.yuansong.form;

import java.util.List;

import com.yuansong.resource.EcsResource;
import com.yuansong.resource.RdsDbResource;
import com.yuansong.resource.TpProxyResource;

public class CrmInfo {
		private String crmDzServiceAddress;
		private String appid;
		private EcsResource ecs;
		private List<RdsDbResource> hxDb;
		private TpProxyResource tpProxy;
		
		public String getCrmDzServiceAddress() {
			return crmDzServiceAddress;
		}
		public void setCrmDzServiceAddress(String crmDzServiceAddress) {
			this.crmDzServiceAddress = crmDzServiceAddress;
		}
		public String getAppid() {
			return appid;
		}
		public void setAppid(String appid) {
			this.appid = appid;
		}
		public List<RdsDbResource> getHxDb() {
			return hxDb;
		}
		public void setHxDb(List<RdsDbResource> hxDb) {
			this.hxDb = hxDb;
		}
		public EcsResource getEcs() {
			return ecs;
		}
		public void setEcs(EcsResource ecs) {
			this.ecs = ecs;
		}
		public TpProxyResource getTpProxy() {
			return tpProxy;
		}
		public void setTpProxy(TpProxyResource tpProxy) {
			this.tpProxy = tpProxy;
		}
}
