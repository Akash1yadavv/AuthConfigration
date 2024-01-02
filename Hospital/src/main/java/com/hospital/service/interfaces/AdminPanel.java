package com.hospital.service.interfaces;

import java.time.Instant;

import com.hospital.dto.admin.panel.AdminPanelStatistics;

public interface AdminPanel {


	AdminPanelStatistics getAdminPanelStatistics(Instant sincInstant, Instant tillInstant);
	
}
