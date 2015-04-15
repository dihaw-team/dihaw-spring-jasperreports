package com.dihaw.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.FastDateFormat;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/showPdfPage")
public class WelcomeController {

	private static final Logger logger = Logger.getLogger(WelcomeController.class);

	/**
	 * This is first function will be execute when we launch our application
	 * @return
	 */
	@RequestMapping(value = "/getPdf", method = RequestMethod.GET)
	public ModelAndView getWelcome() {

		//logs debug message
		if(logger.isDebugEnabled()){
			logger.debug("getWelcome is executed!");
		}
		
		//logs exception
		//logger.error("This is Error message", new Exception("Testing"));
		
		ModelAndView model = new ModelAndView("view/welcome");
		model.addObject("msg", "Hello Spring MVC + Jasper Report Example ");
		return model;

	}
	
	
	/**
	 * This function is called when we need to download our PDF
	 * @param modelAndView
	 * @param response
	 * @throws JRException
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	
	@RequestMapping(value="/pdf", method = RequestMethod.GET)
	public void pdf(ModelAndView modelAndView,HttpServletResponse response) throws JRException, IOException, ClassNotFoundException{
	    logger.info("--------------generate PDF report----------");
	    
	    Map<String,Object> params = new HashMap<String,Object>();
	    params.put("p_message","https://github.com/dihaw-team/dihaw-jasperreports");
	    
	    /*Wahid Presentation*/
	    params.put("p_PathPicWahid","/pic/wahidPic.png");
	    params.put("p_namew","Wahid GAZZAH");
	    params.put("p_countryw","Tunisia Sousse");
	    params.put("p_mailw","wahid.gazzah@gmail.com");
	    
	    /*Amine Presentation*/
	    params.put("p_PathPicAmine","/pic/aminePic.jpg");
	    params.put("p_namea","Muhamed Amine BERGUIGA");
	    params.put("p_countrya","Tunisia Sousse");
	    params.put("p_maila","m.a.berguiga@gmail.com");	    
	    
	 	/*Config output stream*/
	    InputStream reportStream = this.getClass().getResourceAsStream("/ourTeam.jasper");  
	    JasperReport jasperReport = (JasperReport) JRLoader.loadObject(reportStream);
	    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, new JREmptyDataSource());
	    response.setContentType("application/x-pdf");
	    response.setHeader("Content-disposition", "inline; filename="+generateDocName());
	    final OutputStream outStream = response.getOutputStream();
	    JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
	}	

	
	
	/**
	 * This function is used to genearate name each time we download PDF file.
	 * @return
	 */
	public String generateDocName() {
		
		String fileName = StringUtils.EMPTY;
		String prefixFile="PDF";
		FastDateFormat format = FastDateFormat.getInstance("_dd_MM_yyyy_hh_mm_ss");

		
        String currentDateAndTime = format.format(new Date());
        String fileExtension=".pdf";
        fileName = prefixFile+currentDateAndTime+fileExtension;
		
		return fileName;
		
	}
}