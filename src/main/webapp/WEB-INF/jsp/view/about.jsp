<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %> 

<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">
		<div class="about">
			<div class="about-title">
				<h3>About this project</h3>
			</div>
			<p>	
				This project developed By <a href="http://blog.dihaw.com" target="_blank">Wahid Gazzah</a>. 
			</p>
			
			<div class="about-title">
				<h3>Technology used</h3>
			</div>
			<ul>
				<li><strong>Maven</strong></li>
				<li><strong>Spring MVC</strong></li>
				<li><strong>Jasper Reports</strong>: The jasper's files will be created on <br>the C:\dihaw\dihaw-spring-jasperreports\jasperreports folder 
													(see the pom.xml file, jasperreports-maven-plugin: Configuration plugin)
				<li><strong>Tiles</strong>: in order to create the template (header, body, menu, footer)</li>
				<li><strong>logback</strong>: The log will be setted on the C:\dihaw\dihaw-spring-jasperreports\logs\SystemOut.log file (see the logback.xml file)</li>
			</ul>

			</br></br> 
		</div>
    </tiles:putAttribute>
</tiles:insertDefinition>