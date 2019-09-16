<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<title>Thread View</title>
</head>
<body>
	<%@ include file="../Home/header.jsp"%>
	<br />
	<br />
	<br />
	<div class="container">
		<h2>Thread Details</h2>
		<table class="table table-bordered">
			<tbody>
				<tr>
					<th>Subject</th>
					<td><s:property value="threadSubject" /></td>
				</tr>
				<tr>
					<th>Message</th>
					<td><s:property value="threadMessage" /></td>
				</tr>
				<tr>
					<th>Created By</th>
					<td><s:property value="threadCreatorName" /></td>
				</tr>
				<tr>
					<th>Created On</th>
					<td><s:property value="threadCreatedOn" /></td>
				</tr>
			</tbody>
		</table>
	</div>


	<hr />
	<div class="container">
		<div>
			<s:iterator value="threadReplies">
				<div
					style="border: 1px dotted red; border-radius: 5px; margin-bottom: 0.5rem;
			<s:if test="replyCreator">
			background-color: lightblue;
			</s:if><s:if test="!replyCreator">
			background-color: lightgray;
			</s:if>">
					<div>
						Reply: <b><s:property value="replyContent" /></b>
					</div>
					<div>
						Replied By: <b><s:property value="userName" /></b>
					</div>
					<div>
						Replied On: <b><s:property value="timestamp" /></b>
					</div>
				</div>
			</s:iterator>
		</div>

		<div>
			<div class="row">
				<div class="col-md-9">
					<div class="card">
						<div class="card-body">
							<div class="row">
								<div class="col-md-12">
									<h4>Reply to Thread</h4>
									<hr>
								</div>
							</div>
							<div class="row">
								<div class="col-md-12">
									<form action="thread" method="post">
										<div class="form-group row">
											<label for="message" class="col-4 col-form-label">Reply:
												*</label>
											<div class="col-8">
												<textarea id="threadReplyMessage" name="threadReplyMessage"
													placeholder="Enter Reply" class="form-control here"
													rows="10" style="height: 100%;"><s:property
														value="threadReplyMessage" /></textarea>
											</div>
										</div>

										<input type="hidden" name="threadId"
											value="<s:property value="threadId" />" /> <input
											type="hidden" name="threadSubject"
											value="<s:property value="threadSubject" />" /> <input
											type="hidden" name="threadMessage"
											value="<s:property value="threadMessage" />" /> <input
											type="hidden" name="threadCreatorName"
											value="<s:property value="threadCreatorName" />" /> <input
											type="hidden" name="threadCreatedOn"
											value="<s:property value="threadCreatedOn" />" />
										<div class="form-group row">
											<div class="offset-4 col-8">
												<button name="submit" value="Reply" class="btn btn-primary">Reply</button>
											</div>
										</div>
									</form>
									<div style="<s:property value="pageMessageStyle" />">
										<s:property value="pageMessage" />
									</div>
									<form action="thread" method="post">
										<button name="submit" value="List" class="btn btn-primary">Back</button>
									</form>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%@ include file="../Home/footer.jsp"%>
</body>
</html>