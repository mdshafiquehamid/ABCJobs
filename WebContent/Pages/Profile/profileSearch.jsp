<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Profile</title>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.7.2/css/all.css">

<link rel="stylesheet" href="searchProfileStyle.css">
</head>
<body>
	<%@ include file="../Home/header.jsp"%>
	<br />
	<br />
	<br />

	<div>
		<table border="1">
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Company Name</th>
				<th>City</th>
				<th>Country</th>
				<th>Message</th>
			</tr>
			<s:iterator value="users">
				<tr>
					<td><s:property value="firstName" /></td>
					<td><s:property value="lastName" /></td>
					<td><s:property value="companyName" /></td>
					<td><s:property value="city" /></td>
					<td><s:property value="country" /></td>
					<td>
						<form action="message" method="post">
							<input type="hidden" name="otherUserId"
								value="<s:property value="userID" />" /> <input type="hidden"
								name="otherUserName"
								value="<s:property value="firstName" /> <s:property value="lastName" />" />
							<button name="submit" value="View">Message</button>
						</form>
					</td>
				</tr>
			</s:iterator>
		</table>
	</div>
	<p>
		<b><s:property value="message" /></b>
	</p>
	<%@ include file="../Home/footer.jsp"%>
</body>
</html>