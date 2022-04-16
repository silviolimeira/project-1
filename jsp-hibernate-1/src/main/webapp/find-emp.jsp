<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
    <title></title></head>
<jsp:include page="/header.jsp" />
<body>
<br>
<c:if test="${delete != null}">
<form action="doDelete" method="post">
    </c:if>
    <c:if test="${delete == null}">
    <form action="findEmp" method="post">
        </c:if>
    <label>Enter the Employee ID</label> <label>
    <input type="text" class="form-control" name="empId" required="required">
</label>
    <br>
    <button type="submit" class="btn btn-success">Save</button>
</form>
</body>
<div class="fixed-bottom">
    <jsp:include page="/footer.jsp" />
</div>
</html>