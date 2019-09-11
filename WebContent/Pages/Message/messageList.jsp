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
<title>List Messages</title>
</head>
<body>
	<%@ include file="../Home/header.jsp"%>
	<br />
	<br />
	<br />
	<div class="container">
    <h2>Messages</h2>          
    <table class="table table-bordered">
    <thead>
			<tr>
				<th>Name</th>
				<!--<th>Last Subject</th> -->
				<th>Last Message</th>
				<th>Timestamp</th>
				<th>View</th>
			</tr>
	</thead>
	<tbody>
			<s:iterator value="messages">
				<tr>
					<td><s:if test="senderUser">
							<s:property value="recipientName" />
						</s:if> <s:if test="!senderUser">
							<s:property value="senderName" />
						</s:if></td>
					<%--<td><s:property value="subject" /></td> --%>
					<td><s:property value="message" /></td>
					<td><s:property value="timestamp" /></td>
					<td>
					<div class="form-group row">
					<div class="col-sm-4">
						<form action="message" method="post">
							<s:if test="senderUser">
								<input type="hidden" name="otherUserId"
									value="<s:property value="recipientUserID" />" />
								<input type="hidden" name="otherUserName"
									value="<s:property value="recipientName" />" />
							</s:if>
							<s:if test="!senderUser">
								<input type="hidden" name="otherUserId"
									value="<s:property value="senderUserID" />" />
								<input type="hidden" name="otherUserName"
									value="<s:property value="senderName" />" />
							</s:if>
							<button name="submit" value="View" class="btn btn-primary">View</button>
						</form>
						</div>
						</div>
					</td>
				</tr>
			</s:iterator>
		</tbody>
	</table>
</div>

	<div style="<s:property value="pageMessageStyle" />">
		<s:property value="pageMessage" />
	</div>
	<%@ include file="../Home/footer.jsp"%>
</body>
</html>