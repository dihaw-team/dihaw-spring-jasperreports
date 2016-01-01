<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">
	    <div style="margin: 70px;">

			<div class="error-title"><h3><spring:message code="error.title" /></h3></div>
			<div class="error-message"><h3>${errorCode}</h3><h3>${errorMessage}</h3></div>

		</div>
    </tiles:putAttribute>
</tiles:insertDefinition>
