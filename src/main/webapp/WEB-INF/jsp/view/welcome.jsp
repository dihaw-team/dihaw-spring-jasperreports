<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>




<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">
	    <div style="padding:60px 10px 0;">
			<div class="title">
				<h3>Spring MVC + Jasper Report integration example</h3>
				<br>
				<p style="vertical-align:top;">
					The JasperReports Library is the world's most popular open source reporting engine. 
					It is entirely written in Java and it is able to use data coming from any kind of data 
					source and produce pixel-perfect documents that can be viewed, printed or exported in 
					a variety of document formats including HTML, PDF, Excel, OpenOffice and Word.
				</p>
				<br/><br/><br/>
				<c:url value="/showPdfPage/pdf" var="downloadPdf"/>
				<a href="${downloadPdf}" target="_blank">Download PDF</a>
			</div>
		</div>
    </tiles:putAttribute>
</tiles:insertDefinition>



