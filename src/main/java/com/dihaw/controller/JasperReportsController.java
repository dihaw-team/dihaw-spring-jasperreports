package com.dihaw.controller;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.FastDateFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dihaw.dto.BonReceptionDTO;
import com.dihaw.service.JasperReportsService;

/**
 * JasperReports controller.
 * 
 * @author Wahid Gazzah
 * @since 0.0.1
 */
@Controller
@RequestMapping("/report")
public class JasperReportsController {

	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	private static String JASPER_VIEW = "view/jasper";
	private static String EXTENSION_PDF = ".pdf";
	
	@Autowired
	JasperReportsService jasperReportsService;

	/**
	 * This is first function will be execute when we launch our application
	 * @return
	 */
	@RequestMapping()
	public String showJasperView() {

		logger.debug("showJasperView is executed!");
		
		return JASPER_VIEW;

	}
	
	/**
	 * This function is called when we need to generate a PDF report
	 * @param {@link HttpServletResponse} response
	 * @return void
	 */
    @RequestMapping( value = "/servletPdf", method = RequestMethod.GET)
    public void servletPdfReport(HttpServletResponse response) throws JRException, IOException {

        logger.debug("--------------generate PDF report");

        Map<String,Object> modelMap = new HashMap<String,Object>();

        BonReceptionDTO bonReceptionResult = jasperReportsService.bonReception();
	    ArrayList <BonReceptionDTO> listBonReceptionValue = new ArrayList <BonReceptionDTO>();
	    listBonReceptionValue.add(bonReceptionResult);
	    
	    modelMap.put("p_PathLogo", "/report/logo.png");
	    
	    modelMap.put("SUBREPORT_TRAITEMENT_PATH", "C://dihaw/dihaw-spring-jasperreports/jasperreports/bon_reception_traitement_sub_report.jasper");
	    
        JRDataSource jRdataSource = new JRBeanCollectionDataSource(listBonReceptionValue);
        
        String printFileName = JasperFillManager.fillReportToFile("C://dihaw/dihaw-spring-jasperreports/jasperreports/bon_reception_report.jasper",modelMap, jRdataSource);
        JasperExportManager.exportReportToPdfFile(printFileName,"C://dihaw/dihaw-spring-jasperreports/jasperreports/bonReception.pdf");
        
        byte[] pdfReport= chargerFichier("C://dihaw/dihaw-spring-jasperreports/jasperreports/bonReception.pdf");
        
        response.setContentType("application/x-pdf");
        response.setHeader("Content-disposition", "inline; filename=" + generateDocName(EXTENSION_PDF));
        final OutputStream outputStream = response.getOutputStream();
        outputStream.write(pdfReport);
        
        outputStream.close();

    }
	
	/**
	 * This function is called when we need to generate a PDF report
	 * @param modelAndView
	 * @param response
	 */
    @RequestMapping(value = "/pdf", method = RequestMethod.GET)
    public ModelAndView generatePdfReport(){

        logger.debug("--------------generate PDF report");
        

        Map<String,Object> modelMap = new HashMap<String,Object>();

        BonReceptionDTO bonReceptionResult = jasperReportsService.bonReception();
	    ArrayList <BonReceptionDTO> listBonReceptionValue = new ArrayList <BonReceptionDTO>();
	    listBonReceptionValue.add(bonReceptionResult);
	    
	    modelMap.put("p_PathLogo", "/report/logo.png");
	    
	    modelMap.put("SUBREPORT_TRAITEMENT_PATH", "C://dihaw/dihaw-spring-jasperreports/jasperreports/bon_reception_traitement_sub_report.jasper");
	    
        JRDataSource jRdataSource = new JRBeanCollectionDataSource(listBonReceptionValue);

        modelMap.put("pdfBeanData", jRdataSource);

        ModelAndView mav = new ModelAndView("jasperPdfBonReception", modelMap);

        return mav;

    }
	
    @RequestMapping(value = "/csv", method = RequestMethod.GET )
    public ModelAndView generateCsvReport(){

        logger.debug("--------------generate CSV report");

        Map<String,Object> modelMap = new HashMap<String,Object>();

        BonReceptionDTO bonReceptionResult = jasperReportsService.bonReception();
	    ArrayList <BonReceptionDTO> listBonReceptionValue = new ArrayList <BonReceptionDTO>();
	    listBonReceptionValue.add(bonReceptionResult);
	    
	    modelMap.put("SUBREPORT_TRAITEMENT_PATH", "C://dihaw/dihaw-spring-jasperreports/jasperreports/bon_reception_traitement_sub_csv.jasper");

        JRDataSource JRdataSource = new JRBeanCollectionDataSource(listBonReceptionValue);

        modelMap.put("csvBeanData", JRdataSource);

        ModelAndView mav = new ModelAndView("jasperCsvBonReception", modelMap);

        return mav;

    }
    
    @RequestMapping(value = "/xls", method = RequestMethod.GET )
    public ModelAndView generateXlsReport(){

        logger.debug("--------------generate XLS report");

        Map<String,Object> modelMap = new HashMap<String,Object>();

        BonReceptionDTO bonReceptionResult = jasperReportsService.bonReception();
	    ArrayList <BonReceptionDTO> listBonReceptionValue = new ArrayList <BonReceptionDTO>();
	    listBonReceptionValue.add(bonReceptionResult);
	    
	    modelMap.put("SUBREPORT_TRAITEMENT_PATH", "C://dihaw/dihaw-spring-jasperreports/jasperreports/bon_reception_traitement_sub_csv.jasper");

        JRDataSource JRdataSource = new JRBeanCollectionDataSource(listBonReceptionValue);

        modelMap.put("xlsBeanData", JRdataSource);

        ModelAndView mav = new ModelAndView("jasperXlsBonReception", modelMap);

        return mav;

    }
	
    @RequestMapping( value = "/html", method = RequestMethod.GET)
    public ModelAndView generateHtmlReport(){

        logger.debug("--------------generate HTML report----------");

        Map<String,Object> parameterMap = new HashMap<String,Object>();

        BonReceptionDTO bonReceptionResult = jasperReportsService.bonReception();
	    ArrayList <BonReceptionDTO> listBonReceptionValue = new ArrayList <BonReceptionDTO>();
	    listBonReceptionValue.add(bonReceptionResult);

        JRDataSource JRdataSource = new JRBeanCollectionDataSource(listBonReceptionValue);

        parameterMap.put("htmlBeanData", JRdataSource);

        ModelAndView mav = new ModelAndView("jasperHtmlBonReception", parameterMap);

        return mav;

    }
	
    /**
     * Lecture du fichier en InputStream
  	 * @param stream
  	 * @return
  	 * @throws IOException
  	 */
  	public static byte[] readInputStream(InputStream stream) throws IOException
  	  {
  	      byte[] buffer = new byte[8192];
  	      ByteArrayOutputStream baos = new ByteArrayOutputStream();
  	
  	      int bytesRead;
  	      while ((bytesRead = stream.read(buffer)) != -1)
  	      {
  	          baos.write(buffer, 0, bytesRead);
  	      }
  	      return baos.toByteArray();
  	  }

    /**
     * Chargement du fichier
  	 * @param sourcePath
  	 * @return
  	 * @throws IOException
  	*/
  	public static byte[] chargerFichier(String sourcePath) throws IOException
  	  {
  	      InputStream inputStream = null;
  	      try 
  	      {
  	          inputStream = new FileInputStream(sourcePath);
  	          return readInputStream(inputStream);
  	      } 
  	      finally
  	      {
  	          if (inputStream != null)
  	          {
  	              inputStream.close();
  	          }
  	      }
  	  }

    
    /**
     * This function is used to genearate a name, each time we download a FILE.
     * 
     * @return 
     */
    public String generateDocName(String fileExtension) {

      String fileName = StringUtils.EMPTY;
      String prefixFile = "FILE";
      FastDateFormat format = FastDateFormat.getInstance("_dd_MM_yyyy_hh_mm_ss");

      String currentDateAndTime = format.format(new Date());
      fileName = prefixFile + currentDateAndTime + fileExtension;

      return fileName;
    }
	
	/**
	 * This function is used to genearate name each time we download the pdf file.
	 * @return
	 */
	public String generateName() {
		
		String fileName = StringUtils.EMPTY;
		String prefixFile="bonReception";
		FastDateFormat format = FastDateFormat.getInstance("_dd_MM_yyyy_hh_mm_ss");
		
        String currentDateAndTime = format.format(new Date());
        String fileExtension=".pdf";
        fileName = prefixFile+currentDateAndTime+fileExtension;
		
		return fileName;
		
	}
	
}