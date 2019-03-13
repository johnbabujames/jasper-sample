package com.jaspersample.jaspersample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jaspersample.jaspersample.service.ReportingService;

@RestController
@RequestMapping("/api")
public class ReportingController {
	
	@Autowired
	private ReportingService reportingService;
	
	@GetMapping("/jasper-report")
	public String printReport() {
		reportingService.generateReport();
		return "Report Generated";
	}
}
