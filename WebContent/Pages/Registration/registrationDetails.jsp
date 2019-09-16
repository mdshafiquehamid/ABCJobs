<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Details</title>
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
    <input type="hidden" name="registerFirstName" value="<s:property value="registerFirstName"/>">
    <input type="hidden" name="registerLastName" value="<s:property value="registerLastName"/>">
    <input type="hidden" name="registerEmail" value="<s:property value="registerEmail"/>">
    <input type="hidden" name="registerPassword" value="<s:property value="registerPassword"/>">

<div class="content">
	<div class="container">
	<h2>Confirm Details</h2>
	<table class="table table-bordered table-light">
    	<tbody>
          <tr>
              <th>First Name</th>
              <td><s:property value="registerFirstName" /></td>
          </tr>
           <tr>
              <th>Last Name</th>
              <td><s:property value="registerLastName" /></td>
          </tr>
           <tr>
              <th>Email</th>
              <td><s:property value="registerEmail" /></td>
          </tr>
         </tbody>
	 </table>
	 </div>
	    
		<button type="submit" name="submit" value="RegisterDetailsBack" class="btn btn-primary">Back</button>
		
		<button type="submit" name="submit" value="RegisterDetailsConfirm" class="btn btn-primary">Confirm</button>
		  
      </div>

</form>
</body>
</html>