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
				This project developed By <a href="https://github.com/Berg-it" target="_blank">Amin Berguiga</a>. 
				The source code is available in <a href="https://github.com/dihaw-team/dihaw-spring-jasperreports" target="_blank">Github</a>.
			</p>
			
			<div class="about-title">
				<h3>Technology used</h3>
			</div>
			<ul>
				<li><strong>Maven</strong></li>
				<li><strong>Spring MVC</strong></li>
				<li><strong>Tiles</strong>: in order to create the template (header, body, menu, footer)</li>
				<li><strong>logback</strong>: <a href="http://logback.qos.ch/" target="_blank">Logback</a> is intended as a successor to the popular log4j project, <a href="http://logback.qos.ch/reasonsToSwitch.html" target="_blank">picking up where log4j leaves off</a></li>
			</ul>

			</br></br> 

			<div class="about-title">
				<h3>Import the Git project using STS IDE</h3>
			</div>
			<ul>
				<li>Go to the File menu and choose Import.</li>
				<li>Surf in the Import menu to Git and select Projects from Git.</li>
				<li>Choose URI at this point...</li>
				<li>After import, click the right mouse button on your project, Configure -> Convert to Maven Project.</li>
				<li>To run the project, use "clean compile install" cmd.</li>
				<li>Go to http://localhost:port/dihaw-spring-jasperreports/</li>
				<li>The <strong>log</strong> will be created on the <em>C:/dihaw/logs/dihaw-spring-jasperreports/SystemOut.log</em> file (see the <strong>logback.xml</strong> file)</li>
			</ul>
			</br></br>  
		</div>
    </tiles:putAttribute>
</tiles:insertDefinition>