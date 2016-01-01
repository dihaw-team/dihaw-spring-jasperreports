<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<c:url value="/report/pdf" var="downloadPdf"/>
<c:url value="/report/servletPdf" var="downloadServletPdf"/>
<c:url value="/report/xls" var="downloadExcel"/>
<c:url value="/report/csv" var="downloadCsv"/>

<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">
	    <div style="padding:60px 10px 0;">
			<div class="title">
				<h3>Spring MVC + Jasper Report integration example</h3>
				<br/>
			</div>
				<p style="vertical-align:top;">
					The JasperReports Library is the world's most popular open source reporting engine. 
					It is entirely written in Java and it is able to use data coming from any kind of data 
					source and produce pixel-perfect documents that can be viewed, printed or exported in 
					a variety of document formats including HTML, PDF, Excel, OpenOffice and Word.
					<br/>
					<a href="http://community.jaspersoft.com/project/jasperreports-library" target="_blank">Link</a>
				</p>
				
				<br/><br/><br/>
				<div class="title">
					<a href="${downloadPdf}" class="btn"target="_blank"><spring:message code="download.pdf" /></a><br/><br/>
					<a href="${downloadServletPdf}" class="btn"target="_blank"><spring:message code="download.pdf" /> Servlet</a><br/><br/>
					<a href="${downloadExcel}" class="btn"target="_blank"><spring:message code="download.excel" /></a><br/><br/>
				</div>
		</div>
    </tiles:putAttribute>
</tiles:insertDefinition>



