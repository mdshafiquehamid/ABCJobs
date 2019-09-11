<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Confirmation</title>
</head>
<body>

<h1>Registration is Successful</h1>

<p>Thank you <span style="color:purple"><s:property value="registerFirstName"/></span> <span style="color:purple"><s:property value="registerLastName"/></span> for registering with ABC Jobs Pte Ltd!</p> 
<p>A confirmation email has been sent to your email address at <span style="color:blue"><s:property value="registerEmail"/></span></p> 
<p>We would like to give you a warm welcome to our community portal and hope you have a fulfilling experience in using our portal.
Once again thank you for choosing us!</p>

<a href="Pages/Registration/registrationHome.jsp">Return to login</a>

</body>
</html>