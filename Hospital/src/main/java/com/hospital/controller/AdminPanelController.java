package com.hospital.controller;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.dto.admin.panel.AdminPanelStatistics;
import com.hospital.service.interfaces.AdminPanel;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping(value = "/admin-panel")
@SecurityRequirement(name = "bearer-key")
@Log4j2
@PreAuthorize("hasAuthority('ROLE_ADMIN')")
public class AdminPanelController {
	
	@Autowired AdminPanel adminPanel;
	
	@GetMapping(value = "/statistics")
	public AdminPanelStatistics getAdminPanelStatistics(@RequestParam Instant sinceInstant, @RequestParam Instant tillInstant) {
		log.debug("since "+ sinceInstant+" till "+tillInstant);
		return adminPanel.getAdminPanelStatistics(tillInstant, sinceInstant);
	}

}
