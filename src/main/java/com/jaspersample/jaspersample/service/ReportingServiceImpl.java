package com.jaspersample.jaspersample.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

@Service
public class ReportingServiceImpl implements ReportingService{
	
	@Autowired
	private DataSource datasource;

	@Override
	public void generateReport() {
		try {
			Connection conn = datasource.getConnection();
			
			// Compile jrxml file.
		       JasperReport jasperReport = JasperCompileManager
		               .compileReport("C:\\Users\\babus\\JaspersoftWorkspace\\MyReports\\MyFirstReport.jrxml");
		 
		       // Parameters for report
		       Map<String, Object> parameters = new HashMap<String, Object>();
		       
		       JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, conn);
		       
		       JasperExportManager.exportReportToPdfFile(jasperPrint,
		               "C:\\Users\\babus\\JaspersoftWorkspace\\MyReports\\MyFirstReport.pdf");
		        
		       System.out.println("Done!");
			
		} catch (SQLException | JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
