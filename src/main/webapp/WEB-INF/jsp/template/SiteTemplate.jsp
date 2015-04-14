<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
	<head>
		<title><spring:message code="application.title" /></title>
		
		<link href="<c:url value="/static/css/style.css" />" rel="stylesheet" />
		<link type="image/gif" href="<c:url value="/static/images/favicon.png" />" rel="icon">
		<script type="text/javascript" src="<c:url value="/static/js/script.js" />"></script>
	</head>
	<body>
		<div class="container">
			<!-- Header -->
			<tiles:insertAttribute name="header" />
			<!-- Menu Page -->
			
			<tiles:insertAttribute name="menu" />
			
			<!-- Main Page -->
			<div class="main">
				<tiles:insertAttribute name="body" />
			</div>
			<!-- Footer Page -->
			<tiles:insertAttribute name="footer" />
		</div>
	</body>
</html>