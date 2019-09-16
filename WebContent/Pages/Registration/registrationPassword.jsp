<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Password</title>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<style>
img {
  display: block;
  margin-left: auto;
  margin-right: auto;
}

.content {
  max-width: 500px;
  margin: auto;
  padding: 10px;
}

h2 {
  text-align: center;
  font-family: "Arial Black", Gadget, sans-serif;
}
</style>
</head>
<body background="Images/Background.jpg">

<img src="Images/Logo.png" alt="Logo" style="width:128px;height:128px;">

	<form action="registration" method="post">
		<input type="hidden" name="resetEmail"
			value="<s:property value="resetEmail"/>">
			
		<div class="content">
	    <div class="container">
	    <h2>Reset Password</h2>
	    <br>
	    <br>
	    <table class="table table-bordered table-light">
    	<tbody>
          <tr>
          	<th>Email</th>
          	<td><s:property value="resetEmail" /></td>
          </tr>
          <tr>
          	<th>Password</th>
          	<td><input type="password" name="resetPassword"
				value="<s:property value="resetPassword"/>"></td>
          </tr>
          </tbody>
          </table>
         </div>

		<div style="<s:property value="resetStyle"/>">
			<p><s:property value="resetMessage" /></p>
		</div>
		
			<button type="submit" class="btnSubmit" name="submit"
			value="ResetPasswordConfirm" class="btn btn-primary">Reset</button>

         </div>
	</form>
</body>
</html>