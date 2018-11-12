package com.yuansong.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Service;

import com.yuansong.resource.CommonDbResource;
import com.yuansong.resource.RdsDbResource;

@Service
public class CommonService {
	
	public List<JdbcTemplate> getJdbcTemplateList(List<RdsDbResource> dbList){
		List<JdbcTemplate> list = new ArrayList<JdbcTemplate>();
		for(RdsDbResource dbConfig : dbList) {
			list.add(this.getJdbcTemplate(dbConfig));
		}
		return list;
	}
	
	
	public JdbcTemplate getJdbcTemplate(RdsDbResource dbConfig) {
		DriverManagerDataSource dataSource = new DriverManagerDataSource ();
		dataSource.setDriverClassName("net.sourceforge.jtds.jdbc.Driver");
		dataSource.setUrl("jdbc:jtds:sqlserver://" + dbConfig.getRdsResource().getInternetIp()+ ":" + String.valueOf(dbConfig.getRdsResource().getInternetPort()) +";DatabaseName=" + dbConfig.getDbName());
		dataSource.setUsername(dbConfig.getDbUser());
		dataSource.setPassword(dbConfig.getDbPwd());
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setQueryTimeout(30);
		jdbcTemplate.setDataSource(dataSource);
		return jdbcTemplate;
	}
	
	public JdbcTemplate getJdbcTemplate(CommonDbResource dbConfig) {
		DriverManagerDataSource dataSource = new DriverManagerDataSource ();
		dataSource.setDriverClassName("net.sourceforge.jtds.jdbc.Driver");
		dataSource.setUrl("jdbc:jtds:sqlserver://" + dbConfig.getAddress() + ":" + String.valueOf(dbConfig.getPort()) +";DatabaseName=" + dbConfig.getDbName());
		dataSource.setUsername(dbConfig.getDbUser());
		dataSource.setPassword(dbConfig.getDbPwd());
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setQueryTimeout(30);
		jdbcTemplate.setDataSource(dataSource);
		return jdbcTemplate;
	}
	
	
	

}
