<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Profile Search</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>
	<%@ include file="../Home/header.jsp"%>
	<br />
	<br />
	<br />

	<div class="container">
    <h2>Search Results</h2>          
    	<table class="table table-bordered">
    	  <thead>
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Company Name</th>
				<th>City</th>
				<th>Country</th>
				<th>Message</th>
			</tr>
		   </thead>
		   <tbody>
			<s:iterator value="users">
				<tr>
					<td><s:property value="firstName" /></td>
					<td><s:property value="lastName" /></td>
					<td><s:property value="companyName" /></td>
					<td><s:property value="city" /></td>
					<td><s:property value="country" /></td>
					<td>
					<div class="form-group row">
					<div class="col-sm-4">
						<form action="message" method="post">
							<input type="hidden" name="otherUserId"
								value="<s:property value="userID" />" /> <input type="hidden"
								name="otherUserName"
								value="<s:property value="firstName" /> <s:property value="lastName" />" />
							<button name="submit" value="View" class="btn btn-primary">Message</button>
						</form>
						</div>
						</div>
					</td>
				</tr>
			</s:iterator>
			</tbody>
		</table>
	</div>
	<p>
		<b><s:property value="message" /></b>
	</p>
	<%@ include file="../Home/footer.jsp"%>
</body>
</html>