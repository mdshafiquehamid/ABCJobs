<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List Threads</title>
</head>
<body>
	<%@ include file="../Home/header.jsp"%>
	<br />
	<br />
	<br />
	
	<div class="container">
		<div class="row">
			<div class="col-md-9">
				<div class="card">
					<div class="card-body">
						<div class="row">
							<div class="col-md-12">
								<h4>Post New Thread</h4>
								<hr>
							</div>
						</div>
						<div class="row">
							<div class="col-md-12">
								<form action="thread" method="post">
								
									<div class="form-group row">
										<label for="newThreadSubject" class="col-4 col-form-label">Subject: *</label>
										<div class="col-8">
											<input id="newThreadSubject" name="newThreadSubject"
												placeholder="Subject" class="form-control here"
												type="text" value="<s:property value="newThreadSubject"/>">
										</div>
									</div>
									<div class="form-group row">
										<label for="newThreadMessage" class="col-4 col-form-label">Message: *</label>
										<div class="col-8">
											<input id="newThreadMessage" name="newThreadMessage" placeholder="Message"
												class="form-control here" type="text"
												value="<s:property value="newThreadMessage"/>">
										</div>
									</div>
									
									<div style="<s:property value="newThreadStatusStyle" />">
				                    <s:property value="newThreadStatus" />
			                        </div>

			                        
			                        <div class="form-group row">
										<div class="offset-4 col-8">
											<button name="submit" value="Create" class="btn btn-primary">Create</button>
										</div>
									</div>
			                       
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<hr />
	<div>
		<table border="1">
			<tr>
				<th>Thread Subject</th>
				<th>Thread Message</th>
				<th>Created By</th>
				<th>Created On</th>
				<th>View</th>
			</tr>
			<s:iterator value="threads">
				<tr
					style="
			<s:if test="threadCreator">
			background-color: lightblue;
			</s:if><s:if test="!threadCreator">
			background-color: lightgray;
			</s:if>">
					<td><s:property value="subject" /></td>
					<td><s:property value="message" /></td>
					<td><s:property value="userName" /></td>
					<td><s:property value="timestamp" /></td>
					<td>
						<form action="thread" method="post">
							<input type="hidden" name="threadId"
								value="<s:property value="threadId" />" /> <input type="hidden"
								name="threadSubject" value="<s:property value="subject" />" />
							<input type="hidden" name="threadMessage"
								value="<s:property value="message" />" /> <input type="hidden"
								name="threadCreatorName" value="<s:property value="userName" />" />
							<input type="hidden" name="threadCreatedOn"
								value="<s:property value="timestamp" />" />
							<button name="submit" value="View">View</button>
						</form>
					</td>
				</tr>
			</s:iterator>
		</table>
	</div>
	<div style="<s:property value="pageMessageStyle" />">
		<s:property value="pageMessage" />
	</div>
	<%@ include file="../Home/footer.jsp"%>
</body>
</html>