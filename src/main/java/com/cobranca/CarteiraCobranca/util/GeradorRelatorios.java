package com.cobranca.CarteiraCobranca.util;

import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.util.HashMap;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;

public class GeradorRelatorios {

	private String caminho;
	private String nomeRelatorio;

	private static final Logger logger = LoggerFactory.getLogger(GeradorRelatorios.class);

	public GeradorRelatorios(String caminho, String nomeRelatorio) {
		this.caminho = caminho;
		this.nomeRelatorio = nomeRelatorio;
	}

	public String getCaminho() {
		return caminho;
	}

	public void setCaminho(String caminho) {
		this.caminho = caminho;
	}

	public String getNomeRelatorio() {
		return nomeRelatorio;
	}

	public void setNomeRelatorio(String nomeRelatorio) {
		this.nomeRelatorio = nomeRelatorio;
	}

	public void gerandoPDF(HttpServletResponse response, Connection connection, HashMap<String, Object> parametros) {
		try {
			logger.info("Gerando relatório: " + this.nomeRelatorio);
			InputStream arquivo = this.getClass().getClassLoader().getResourceAsStream(this.caminho);
			JasperReport jasperReport = JasperCompileManager.compileReport(arquivo);
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, connection);
			logger.info("JasperPrint" + jasperPrint);

			JRPdfExporter pdfExporter = new JRPdfExporter();
			response.setContentType("application/pdf");
			response.addHeader("Content-Disposition", "inline; filename=" + this.nomeRelatorio + ";");
			OutputStream outputStream = response.getOutputStream();
			pdfExporter.setExporterInput(new SimpleExporterInput(jasperPrint));
			pdfExporter.setExporterOutput(new SimpleOutputStreamExporterOutput(outputStream));
			pdfExporter.exportReport();
			logger.info("Completed Successfully: " + this.nomeRelatorio);
		} catch (Exception e) {
			logger.error("Error: ", e.getMessage());
		}
	}

}
