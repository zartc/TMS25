<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>

<head>
	<title><fmt:message key="welcome.title" /></title>
	<link rel="stylesheet" type="text/css" href="<c:url value="/css/knacss-unminified.css" />">
</head>

<body bgcolor="white">

	<c:if test="${empty applicationScope['org.apache.struts.action.MESSAGE']}">
		<font color="red">ERROR: Application resources not loaded --
			check servlet container logs for error messages.</font>
	</c:if>
	
	<h1>
		<font color="YellowGreen">
			<fmt:message key="welcome.message">
				<fmt:param>wadis-edr</fmt:param>
			</fmt:message>
		</font>
	</h1>

	<img src="<c:url value="/img/visuel-agentconnect.png" />" />

	<p>
		<fmt:message key="utf-8.message"/>
	</p>
</body>
</html>
