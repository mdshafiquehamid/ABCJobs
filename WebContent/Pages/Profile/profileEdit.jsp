<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Profile Edit</title>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css" type="text/css" rel="stylesheet">

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
								<h4>Edit Profile</h4>
								<hr>
							</div>
						</div>
						<div class="row">
							<div class="col-md-12">
								<form action="profile" method="post">
									<div class="form-group row">
										<label for="firstName" class="col-4 col-form-label">First
											Name: *</label>
										<div class="col-8">
											<input id="firstName" name="firstName"
												placeholder="First Name" class="form-control here"
												type="text" value="<s:property value="firstName"/>">
										</div>
									</div>

									<div class="form-group row">
										<label for="lastName" class="col-4 col-form-label">Last
											Name : *</label>
										<div class="col-8">
											<input id="lastName" name="lastName" placeholder="Last Name"
												class="form-control here" type="text"
												value="<s:property value="lastName"/>">
										</div>
									</div>

									<div class="form-group row">
										<label for="email" class="col-4 col-form-label">Email:
											*</label>
										<div class="col-8">
											<input id="email" name="email" placeholder="Email"
												class="form-control here" type="text"
												value="<s:property value="email"/>">
										</div>
									</div>

									<div class="form-group row">
										<label for="password" class="col-4 col-form-label">Password:
											*</label>
										<div class="col-8">
											<input id="password" name="password" placeholder="Password"
												class="form-control here" type="password"
												value="<s:property value="password"/>">
										</div>
									</div>

									<div class="form-group row">
										<label for="mobile" class="col-4 col-form-label">Mobile:</label>
										<div class="col-8">
											<input id="mobile" name="mobile" placeholder="Mobile"
												class="form-control here" type="text"
												value="<s:property value="mobile"/>">
										</div>
									</div>

									<div class="form-group row">
										<label for="blockNo" class="col-4 col-form-label">Block
											No:</label>
										<div class="col-8">
											<input id="blockNo" name="blockNo" placeholder="Block No"
												class="form-control here" type="text"
												value="<s:property value="blockNo"/>">
										</div>
									</div>

									<div class="form-group row">
										<label for="street" class="col-4 col-form-label">Street:</label>
										<div class="col-8">
											<input id="street" name="street" placeholder="Street"
												class="form-control here" type="text"
												value="<s:property value="street"/>">
										</div>
									</div>

									<div class="form-group row">
										<label for="unitNo" class="col-4 col-form-label">Unit
											No:</label>
										<div class="col-8">
											<input id="unitNo" name="unitNo" placeholder="Unit No"
												class="form-control here" type="text"
												value="<s:property value="unitNo"/>">
										</div>
									</div>

									<div class="form-group row">
										<label for="postalCode" class="col-4 col-form-label">Postal
											Code:</label>
										<div class="col-8">
											<input id="postalCode" name="postalCode"
												placeholder="Postal Code" class="form-control here"
												type="text" value="<s:property value="postalCode"/>">
										</div>
									</div>

									<div class="form-group row">
										<label for="city" class="col-4 col-form-label">City:</label>
										<div class="col-8">
											<input id="city" name="city" placeholder="City"
												class="form-control here" type="text"
												value="<s:property value="city"/>">
										</div>
									</div>

									<div class="form-group row">
										<label for="country" class="col-4 col-form-label">Country:</label>
										<div class="col-8">
											<input id="country" name="country" placeholder="Country"
												class="form-control here" type="text"
												value="<s:property value="country"/>">
										</div>
									</div>

									<div class="form-group row">
										<label for="education" class="col-4 col-form-label">Education:</label>
										<div class="col-8">
											<input id="education" name="education"
												placeholder="Education" class="form-control here"
												type="text" value="<s:property value="education"/>">
										</div>
									</div>

									<div class="form-group row">
										<label for="companyName" class="col-4 col-form-label">Company
											Name:</label>
										<div class="col-8">
											<input id="companyName" name="companyName"
												placeholder="Company Name" class="form-control here"
												type="text" value="<s:property value="companyName"/>">
										</div>
									</div>

									<div class="form-group row">
										<label for="workExperience" class="col-4 col-form-label">Work
											Experience:</label>
										<div class="col-8">
											<input id="workExperience" name="workExperience"
												placeholder="Work Experience" class="form-control here"
												type="text" value="<s:property value="workExperience"/>">
										</div>
									</div>

									<div class="form-group row">
										<label for="skills" class="col-4 col-form-label">Skills:</label>
										<div class="col-8">
											<input id="skills" name="skills" placeholder="Skills"
												class="form-control here" type="text"
												value="<s:property value="skills"/>">
										</div>
									</div>

									<input name="updateData" type="hidden"
										value="<s:property value="updateData"/>" />

									<p style="color: red">
										<s:property value="message" />
									</p>

									<div class="form-group row">
										<div class="offset-4 col-8">
											<button name="submit" value="Update" class="btn btn-primary">Update</button>
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