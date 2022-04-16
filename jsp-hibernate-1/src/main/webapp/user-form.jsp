<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/WEB-INF/mytags.tld" prefix="m" %>
<html>
<head>
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
    <title></title></head>
<jsp:include page="/header.jsp" />
Current Date and Time is: <m:date/>
<body>
<br>
<form action="insert" method="post">
    <h3>Add New Employee</h3>
    <label>User Name</label> <label>
    <input type="text" class="form-control" name="name" required="required">
</label>
    <br>
    <label>Employee Salary</label> <label>
    <input type="text" class="form-control" name="salary">
</label>
    <br>
    <label>Employee Department</label> <label>
    <input type="text" class="form-control" name="department">
</label>
    <br>
    <label>Employee Address</label> <label>
    <input type="text" class="form-control" name="address">
</label>
    <br>
    <label>Employee Phone</label> <label>
    <input type="text" class="form-control" name="phone">
</label>
    <br>
    <button type="submit" class="btn btn-success">Save</button>
</form>
</body>
<div class="fixed-bottom">
    <jsp:include page="/footer.jsp" />
</div>
</html>