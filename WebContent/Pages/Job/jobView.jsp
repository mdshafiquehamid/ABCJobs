<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<title>Job View</title>
</head>
<body>
	<%@ include file="../Home/header.jsp"%>
	<br />
	<br />
	<br />

<div class="container">
<h2>Job Details</h2>
<table class="table table-bordered">
    <tbody>
        <tr>
          <th>Title</th>
            <td><s:property value="title" /></td>
        </tr>
        <tr>
          <th>Company Name</th>
            <td><s:property value="companyName" /></td>
        </tr>
        <tr>
          <th>Salary</th>
            <td><s:property value="salary" /></td>
        </tr>
      <tr>
          <th>Description</th>
          	<td><s:property value="description" /></td>
        </tr>
    </tbody>
</table>
</div>
	
	<hr />
	
		<div class="container">
  <h2>List of Users who Applied</h2>          
  <table class="table table-bordered">
    <thead>
      <tr>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Email</th>
      </tr>
    </thead>
    <tbody>
	<s:iterator value="users">
      <tr>
        <td><s:property value="firstName" /></td>
        <td><s:property value="lastName" /></td>
        <td><s:property value="email" /></td>
      </tr>
	  </s:iterator>
    </tbody>
  </table>
  	<div style="<s:property value="messageStyle" />">
		<s:property value="message" />
	</div>
	
	<div class="form-group row">
	  <div class="offset col-8">
	    <form action="job" method="post">
		  <button name="submit" value="List" class="btn btn-primary">Back</button>
		</form>
	  </div>
	</div>
</div>	
	  	
	<%@ include file="../Home/footer.jsp"%>
</body>
</html>