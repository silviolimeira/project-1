<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
    </head>
<jsp:include page="/header.jsp" />
<body>
<br>
<form action="editEmp" method="post">
    <h3>Edit Employee</h3>
    <label>Employee Id</label>
    <label>
        <input type="text"
               value="<c:out value='${user.id}' />" class="form-control"
               name="empId" required="required" readonly="readonly">
        </label>
    <br>

    <label>Employee Name</label>
    <label>
    <input type="text"
           value="<c:out value='${user.name}' />" class="form-control"
           name="name" required="required">
</label>
    <br>
    <label>Employee Salary</label> <label>
    <input type="text"
           value="<c:out value='${user.salary}' />" class="form-control"
           name="salary">
</label>
    <br>
    <label>Employee Department</label> <label>
    <input type="text"
           value="<c:out value='${user.department}' />" class="form-control"
           name="department">
</label>
    <br>
    <label>Employee Address</label> <label>
    <input type="text"
           value="<c:out value='${user.address}' />" class="form-control"
           name="address">
</label>
    <br>
    <label>Employee Phone</label> <label>
    <input type="text"
           value="<c:out value='${user.phoneNo}' />" class="form-control"
           name="phone">
</label>
    <br>
    <button type="submit" class="btn btn-success">Save</button>
</form>
</body>
<div class="fixed-bottom">
    <jsp:include page="/footer.jsp" />
</div>
</html>