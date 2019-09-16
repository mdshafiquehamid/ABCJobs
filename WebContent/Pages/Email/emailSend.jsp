<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Email</title>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css"
	type="text/css" rel="stylesheet">
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
								<h4>Send Email</h4>
								<hr>
							</div>
						</div>
						<div class="row">
							<div class="col-md-12">
								<form action="email" method="post">
									<div class="form-group row">
										<label for="sendTo" class="col-4 col-form-label">Send
											To: *<br />(<i>use </i><b>;</b><i> to separate email
												addresses</i>)
										</label>
										<div class="col-8">
											<input id="sendTo" name="to"
												placeholder="Enter Recipient Email"
												class="form-control here" type="text"
												value="<s:property value="to"/>">
										</div>
									</div>

									<div class="form-group row">
										<label for="subject" class="col-4 col-form-label">Subject:
											*</label>
										<div class="col-8">
											<input id="subject" name="subject"
												placeholder="Enter Subject" class="form-control here"
												type="text" value="<s:property value="subject"/>">
										</div>
									</div>

									<div class="form-group row">
										<label for="message" class="col-4 col-form-label">Message:
											*</label>
										<div class="col-8">
											<textarea id="message" name="message"
												placeholder="Enter Message" class="form-control here"
												rows="10" style="height: 100%;"><s:property
													value="message" /></textarea>
										</div>
									</div>

									<div style="<s:property value="statusMessageStyle" />">
										<p class="email-message">
											<s:property value="statusMessage" />
										</p>
									</div>

									<div class="form-group row">
										<div class="offset-4 col-8">
											<button name="submit" value="Bulk" class="btn btn-primary">Send</button>
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
	<%@ include file="../Home/footer.jsp"%>
</body>
</html>