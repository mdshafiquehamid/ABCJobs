<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Details Confirmation</title>
</head>

<style>
body {
	background: -webkit-linear-gradient(left, #3931af, #00c6ff);
}
</style>

<body>

<form action="registration" method="post">
    <input type="hidden" name="registerFirstName" value="<s:property value="registerFirstName"/>">
    <input type="hidden" name="registerLastName" value="<s:property value="registerLastName"/>">
    <input type="hidden" name="registerEmail" value="<s:property value="registerEmail"/>">
    <input type="hidden" name="registerPassword" value="<s:property value="registerPassword"/>">	
	<div class="form-group">
		First Name: <b><s:property value="registerFirstName"/></b>
	</div>
	<div class="form-group">
		Last Name: <b><s:property value="registerLastName"/></b>
	</div>
	<div class="form-group">
		Email: <b><s:property value="registerEmail"/></b>
	</div>
	<div class="form-group">
		<button type="submit" class="btnSubmit" name="submit" value="RegisterDetailsBack">Back</button>
	</div>
	<div class="form-group">
		<button type="submit" class="btnSubmit" name="submit" value="RegisterDetailsConfirm">Confirm</button>
	</div>
</form>
</body>
</html>