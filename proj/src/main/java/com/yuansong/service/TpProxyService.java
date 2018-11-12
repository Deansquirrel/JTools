package com.yuansong.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.yuansong.common.ConversionTool;
import com.yuansong.form.TpProxyAuthorizationInfo;
import com.yuansong.resource.CommonDbResource;
import com.yuansong.resource.RdsDbResource;
import com.yuansong.resource.TpProxyResource;

@Service
public class TpProxyService {
	
	private final Logger logger = Logger.getLogger(TpProxyService.class);
	
	private static final String SQL_GET_AUTHORIZATIONINFO = ""
			+ "SELECT [authorizer_appid]\r\n" + 
			"      ,[authorizer_access_token]\r\n" + 
			"      ,[authorizer_refresh_token]\r\n" + 
			"      ,[expires_Time]\r\n" + 
			"      ,[UpdateTime]\r\n" + 
			"  FROM [Authorization_info]\r\n" + 
			"WHERE authorizer_appid = ?";
	
	@Autowired
	private CommonService commonService;
	
	@Autowired
	private ResourceService resourceService;

	public TpProxyAuthorizationInfo getAuthorizationInfo(TpProxyResource tpProxyResource, String appid) throws Exception {
		
		JdbcTemplate jdbcTemplate = null;
		switch (tpProxyResource.getCrmDataCenterDbType()) {
			case 0:
				CommonDbResource commonDbResource =  null;
				try {
					commonDbResource =  resourceService.getDb(tpProxyResource.getCrmDataCenterDbId());					
				}catch(Exception ex) {
					logger.debug(ex.getMessage());
					ex.printStackTrace();
					throw new Exception("获取数据库信息时发生错误。["+ ex.getMessage() + "]");
				}
				jdbcTemplate = commonService.getJdbcTemplate(commonDbResource);
				break;
			case 1:
				RdsDbResource rdsDbResource = null;
				try {
					rdsDbResource = resourceService.getRds("F775F94B-2A21-4755-AF31-864859880786");
				}catch(Exception ex) {
					logger.debug(ex.getMessage());
					ex.printStackTrace();
					throw new Exception("获取数据库信息时发生错误。["+ ex.getMessage() + "]");
				}
				jdbcTemplate = commonService.getJdbcTemplate(rdsDbResource);
				break;
			default:
				throw new Exception("未定义的数据库类型。["+ String.valueOf(tpProxyResource.getCrmDataCenterDbType()) + "]");
		}
		if(jdbcTemplate == null) {
			throw new Exception("获取数据库连接对象时发生错误。");
		}
		
		List<TpProxyAuthorizationInfo> list = 	jdbcTemplate.query(SQL_GET_AUTHORIZATIONINFO, new Object[] {appid}, new RowMapper<TpProxyAuthorizationInfo>() {
			@Override
			public TpProxyAuthorizationInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
				TpProxyAuthorizationInfo obj = new TpProxyAuthorizationInfo();
				obj.setAuthorizerAppid(rs.getString("authorizer_appid"));
				obj.setAuthorizerAccessToken(rs.getString("authorizer_access_token"));
				obj.setAuthorizerRefreshToken(rs.getString("authorizer_refresh_token"));
				obj.setExpiresTime(ConversionTool.convertSqlDateToUtilDate(rs.getDate("expires_Time")));
				obj.setUpdateTime(ConversionTool.convertSqlDateToUtilDate(rs.getDate("UpdateTime")));
				return obj;
			}});				
		if(list.size() > 0) {
			return list.get(0);
		}
		else {
			return null;	
		}	
	}
}
