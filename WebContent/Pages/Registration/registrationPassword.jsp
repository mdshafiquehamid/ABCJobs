<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Reset Password</title>
</head>
<body>

	<form action="registration" method="post">
		<input type="hidden" name="resetEmail"
			value="<s:property value="resetEmail"/>">
		<div class="form-group">
			Email: <b><s:property value="resetEmail" /></b>
		</div>
		<div class="form-group">
			Password: <input type="password" name="resetPassword"
				value="<s:property value="resetPassword"/>">
		</div>
		<div style="<s:property value="resetStyle"/>">
			<p>
				<s:property value="resetMessage" />
			</p>
		</div>
		<div class="form-group">
			<button type="submit" class="btnSubmit" name="submit"
				value="ResetPasswordConfirm">Reset</button>
		</div>
	</form>
</body>
</html>