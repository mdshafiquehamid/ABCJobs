<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Confirmation</title>
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

border {
  border-style: 3px solid;
  border-color: teal;
  font-family: Arial, Helvetica, sans-serif;

}
a:link, a:visited  {
  background-color: #00BFFF;
  color: white;
  padding: 15px 25px;
  text-decoration: none;
  display: inline-block;
  margin-left: 740px;
}
a:hover, a:active {
  background-color: #1E90FF;
}
p {
text-align: center;
}
</style>
</head>
<body background="Images/Background.jpg">

<img src="Images/Logo.png" alt="Logo" style="width:128px;height:128px;">

<h1>Registration is Successful!</h1>
<br>
<br>
	
<div class="border">
<p>Thank you <b><span style="color:purple"><s:property value="registerFirstName"/></span> <span style="color:purple"><s:property value="registerLastName"/></span></b> for registering with ABC Jobs Pte Ltd!</p> 
<p>A confirmation email has been sent to your email address at <b><span style="color:purple"><s:property value="registerEmail"/></span></b></p>
<p>We would like to give you a warm welcome to our community portal and hope you have a fulfilling experience in using our portal.
Once again thank you for choosing us!</p>
</div>
<br>
<br>
<a href="Pages/Registration/registrationHome.jsp">Login</a>

</body>
</html>