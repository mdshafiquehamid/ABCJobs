<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Reset Password Confirmation</title>
</head>
<body>

<h1>Reset Password is Successful</h1>

<p>An email has been sent to <span style="color:blue"><s:property value="resEmail"/></span>. Please follow the instructions given to reset your password.</p>

<a href="loginRegister.jsp">Return to login</a>

</body>
</html>