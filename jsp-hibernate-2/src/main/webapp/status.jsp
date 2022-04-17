<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
    <title>Status</title>
    <jsp:include page="/header.jsp" />
</head>
<body>
<c:if test = "${status == true}"><h1 style="color:Green;">Status = Pass!</h1></c:if>
    <c:if test = "${status == false}"><h1 style="color:Red;">Status = Fail!</h1></c:if>

<br>
<a href="${pageContext.request.contextPath}/home" class="btn btn-success" >Home Page</a>
</body>
<div class="fixed-bottom">
    <jsp:include page="/footer.jsp" />
</div>
</html>