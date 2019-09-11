<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Profile Block/Unblock</title>
</head>
<body>
	<%@ include file="../Home/header.jsp"%>
	<br />
	<br />
	<br />
	
		<div class="container">
  <h2>Profile - Block/Unblock</h2>          
  <table class="table table-bordered">
    <thead>
      <tr>
        <th>First Name</th>
		<th>Last Name</th>
		<th>Email</th>
		<th>Block/Unblock</th>			
      </tr>
    </thead>
	<tbody>
	<s:iterator value="users">
	<tr>
					<td><s:property value="firstName" /></td>
					<td><s:property value="lastName" /></td>
					<td><s:property value="email" /></td>
					<td>
					<div class="form-group row">
					<div class="col-sm-4">
						<form action="profile" method="post">
							<input type="hidden" name="usersUserId"
								value="<s:property value="userID" />" /> <input type="hidden"
								name="blocked" value="<s:property value="blocked" />" />
							<s:if test="blocked">
								<button name="submit" value="Block" class="btn btn-secondary">Unblock</button>
							</s:if>
							<s:if test="!blocked">
								<button name="submit" value="Block" class="btn btn-primary">Block</button>
							</s:if>
						</form>
						</div>
						</div>
					</td>
				</tr>
			</s:iterator>
			</tbody>
			</table>
			</div>
	
	<div style="<s:property value="message" />"></div>
	<%@ include file="../Home/footer.jsp"%>
</body>
</html>