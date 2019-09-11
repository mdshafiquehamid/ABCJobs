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
<title>Job List</title>
</head>
<body>
	<%@ include file="../Home/header.jsp"%>
	<br />
	<br />
	<br />
	
<div class="container">
  <h2>Jobs</h2>          
  <table class="table table-bordered">
    <thead>
      <tr>
        <th>Title</th>
				<th>Company Name</th>
				<th>Description</th>
				<th>Salary</th>
				<th>Listed By</th>
				<th>Total Applicants</th>
				<th><s:if test="userAdmin">
					View
				</s:if> <s:if test="!userAdmin">
					Apply
				</s:if></th>
      </tr>
    </thead>
    
	<tbody>
	<s:iterator value="jobs">
				<tr>
					<td><s:property value="title" /></td>
					<td><s:property value="companyName" /></td>
					<td><s:property value="description" /></td>
					<td><s:property value="salary" /></td>
					<td><s:property value="listedBy" /></td>
					<td><s:property value="applicantCount" /></td>
					<td>
					<div class="form-group row">
					<div class="col-sm-4">
						<form action="job" method="post">
							<input type="hidden" name="jobId"
								value="<s:property value="jobId" />" /> <input type="hidden"
								name="title" value="<s:property value="title" />" /> <input
								type="hidden" name="companyName"
								value="<s:property value="companyName" />" /> <input
								type="hidden" name="salary"
								value="<s:property value="salary" />" /> <input type="hidden"
								name="description" value="<s:property value="description" />" />
							<s:if test="userAdmin">
								<button name="submit" value="View" class="btn btn-primary">View</button>
							</s:if>
							<s:if test="!userAdmin">
								<s:if test="!hasApplied">
									<button name="submit" value="Apply" class="btn btn-primary">Apply</button>
								</s:if>
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
			<div style="<s:property value="messageStyle" />">
		<s:property value="message" />
	</div>
	


	<%@ include file="../Home/footer.jsp"%>
</body>
</html>