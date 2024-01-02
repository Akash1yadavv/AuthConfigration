/**
 * 
 */
package com.hospital.service;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.dto.admin.panel.AdminPanelStatistics;
import com.hospital.dto.admin.panel.UserStatisticsData;
import com.hospital.service.interfaces.AdminPanel;
import com.hospital.service.interfaces.UserService;

/**
 * @author ankit
 */
@Service
public class AdminPanelImpl implements AdminPanel{

	@Autowired UserService userService;
	@Override
	public AdminPanelStatistics getAdminPanelStatistics( Instant sincInstant, Instant tillInstant) {
		Long noRegisteredUsers = userService.countByCreatedOnLessThanAndCreatedOnGreaterThan(sincInstant, tillInstant);
		AdminPanelStatistics adminPanelStatistics = new AdminPanelStatistics();
		
		UserStatisticsData userStatisticsData = new UserStatisticsData();
		adminPanelStatistics.setUserStatisticsData(userStatisticsData);
		userStatisticsData.setNoRegisteredUsers(noRegisteredUsers);
		
		
		return adminPanelStatistics;
	}
	
}
