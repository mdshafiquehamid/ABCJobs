<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Home</title>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link rel="stylesheet" href="Pages/Registration/registrationHomeStyle.css">

<style>
img {
  display: block;
  margin-left: auto;
  margin-right: auto;
}

h1 {
  text-align: center;
  font-family: "Arial Black", Gadget, sans-serif;
}
</style>

</head>
<body background="Images/Background.jpg">

    <img src="Images/Logo.png" alt="Logo" style="width:128px;height:128px;">

	<h1>Welcome to ABC Jobs Community Portal</h1>

	<div class="container login-container">
		<div class="row">
			<div class="col-md-6 login-form">
				<h3>Login</h3>
				<form action="registration" method="post">
					<div class="form-group">
						<input type="text" class="form-control" placeholder="Your Email *"
							name="loginEmail" value="<s:property value="loginEmail"/>">
					</div>
					<div class="form-group">
						<input type="password" class="form-control"
							placeholder="Your Password *" name="loginPassword">
					</div>
					<div style="<s:property value="loginStyle"/>">
						<p>
							<s:property value="loginMessage" />
						</p>
					</div>
					<div class="form-group">
						<button type="submit" class="btnSubmit" name="submit"
							value="Login">Login</button>
					</div>
				</form>
				<h3>Forget Password</h3>
				<form action="registration" method="post">
					<div class="form-group">
						<input type="text" class="form-control" placeholder="Your Email *"
							name="forgotEmail" value="<s:property value="forgotEmail"/>">
					</div>
					<div style="<s:property value="forgotStyle"/>">
						<p>
							<s:property value="forgotMessage" />
						</p>
					</div>
					<div class="form-group">
						<button type="submit" class="btnSubmit" name="submit"
							value="ForgotPassword">Send</button>
					</div>
				</form>
			</div>
			<div class="col-md-6 register-form">
				<h3>Register</h3>
				<form action="registration" method="post">
					<div class="form-group">
						<input type="text" class="form-control" placeholder="First Name *"
							name="registerFirstName"
							value="<s:property value="registerFirstName"/>">
					</div>
					<div class="form-group">
						<input type="text" class="form-control" placeholder="Last Name *"
							name="registerLastName"
							value="<s:property value="registerLastName"/>">
					</div>
					<div class="form-group">
						<input type="text" class="form-control" placeholder="Email *"
							name="registerEmail" value="<s:property value="registerEmail"/>">
					</div>
					<div class="form-group">
						<input type="password" class="form-control"
							placeholder="Password *" name="registerPassword">
					</div>
					<div style="<s:property value="registerStyle"/>">
						<p>
							<s:property value="registerMessage" />
						</p>
					</div>
					<div class="form-group">
						<button type="submit" class="btnSubmit" name="submit"
							value="Register">Register</button>
					</div>
				</form>
			</div>
		</div>
	</div>

</body>
</html>