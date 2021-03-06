<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/WEB-INF/mytags.tld" prefix="m" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
    <title>JSP - Hello World - Acentuação </title>
    <jsp:include page="/header.jsp" />
</head>
<body>
Current Date and Time is: <m:date/>
<h1><%= "Manage Employee - Acentuação" %>
</h1>
<br/>
<a href="${pageContext.request.contextPath}/user-form.jsp" class="btn btn-success">Insert</a>
<a href="${pageContext.request.contextPath}/delete" class="btn btn-success">Delete</a>
<a href="${pageContext.request.contextPath}/list" class="btn btn-success">List Employees</a>
<a href="${pageContext.request.contextPath}/find-emp.jsp" class="btn btn-success">Update Employee Info</a>
<div id="esquerdo">
    <%@include file="/WEB-INF/jspf/menu.jspf"%>
</div>
</body>
<div class="fixed-bottom">
    <jsp:include page="/footer.jsp" />
</div>
</html>