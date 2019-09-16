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
<title>Message View</title>
</head>
<body>
	<%@ include file="../Home/header.jsp"%>
	<br />
	<br />
	<br />
	<div class="container">
		<h1>
			Conversation with <span style="color: blue;"><s:property
					value="otherUserName" /></span>
		</h1>
		<div>
			<s:iterator value="messages">
				<div
					style="border: 1px dotted red; border-radius: 5px; margin-bottom: 0.5rem;
			<s:if test="senderUser">
			background-color: lightblue;
			</s:if><s:if test="!senderUser">
			background-color: lightgray;
			</s:if>">
					<!--<div> -->
					<%--Sent By: <b><s:property value="senderName" /></b> --%>
					<!--</div> -->
					<!--<div> -->
					<%--Subject: <b><s:property value="subject" /></b> --%>
					<!--</div> -->
					<div>
						Message: <b><s:property value="message" /></b>
					</div>
					<div>
						Sent On: <b><s:property value="timestamp" /></b>
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
									<h4>Send Message</h4>
									<hr>
								</div>
							</div>
							<div class="row">
								<div class="col-md-12">
									<form action="message" method="post">
										<!--<div> -->
										<!--<b>Subject</b> -->
										<!--</div> -->
										<!--<div> -->
										<!--<input type="text" name="newSubject" -->
										<%--value="<s:property value="newSubject" />" /> --%>
										<!--</div> -->

										<div class="form-group row">
											<label for="message" class="col-4 col-form-label">Message:
												*</label>
											<div class="col-8">
												<textarea id="message" name="newMessage"
													placeholder="Enter Message" class="form-control here"
													rows="10" style="height: 100%;"><s:property
														value="newMessage" /></textarea>
											</div>
										</div>
										<input type="hidden" name="otherUserId"
											value="<s:property value="otherUserId" />" /> <input
											type="hidden" name="otherUserName"
											value="<s:property value="otherUserName" />" />

										<div class="form-group row">
											<div class="offset-4 col-8">
												<button name="submit" value="New" class="btn btn-primary">Send</button>
											</div>

										</div>
										<div class="form-group row">
											<div class="offset-4 col-8">
												<button name="submit" value="List" class="btn btn-primary">Back</button>
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
		<div style="<s:property value="pageMessageStyle" />">
			<s:property value="pageMessage" />
		</div>
	</div>
	<%@ include file="../Home/footer.jsp"%>
</body>
</html>