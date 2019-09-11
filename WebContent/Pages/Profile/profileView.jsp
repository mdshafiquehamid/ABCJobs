<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Profile</title>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

</head>
<body>
	<%@ include file="../Home/header.jsp"%>
	<br />
	<br />
	<br />
	<div class="container emp-profile">
		<div class="row">

			<div class="col-md-6">
				<div class="profile-head">
					<h2>Profile</h2>

					<ul class="nav nav-tabs" id="myTab" role="tablist">
						<li class="nav-item"><a class="nav-link active" id="home-tab"
							data-toggle="tab" href="#home" role="tab" aria-controls="home"
							aria-selected="true">Basic-Info</a></li>
						<li class="nav-item"><a class="nav-link" id="profile-tab"
							data-toggle="tab" href="#profile" role="tab"
							aria-controls="profile" aria-selected="false">Experience</a></li>
					</ul>
				</div>
			</div>
			<div class="col-md-2">
				<div style="display: none;">
					<form action="profile" method="post">
						<button name="submit" value="Home">Return Home</button>
					</form>
				</div>
				<div class="form-group row">
					<div class="offset-4 col-8">
					<form action="profile" method="post">
						<button name="submit" value="Edit" class="btn btn-primary">Edit Profile</button>
					</form>
					</div>
				</div>
			</div>
		</div>
		<div class="row">

			<div class="col-md-8">
				<div class="tab-content profile-tab" id="myTabContent">
					<div class="tab-pane fade show active" id="home" role="tabpanel"
						aria-labelledby="home-tab">
						<div class="row">
							<div class="col-md-6">
								<label>First Name</label>
							</div>
							<div class="col-md-6">
								<p>
									<s:property value="firstName" />
								</p>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<label>Last Name</label>
							</div>
							<div class="col-md-6">
								<p>
									<s:property value="lastName" />
								</p>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<label>Email</label>
							</div>
							<div class="col-md-6">
								<p>
									<s:property value="email" />
								</p>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<label>Mobile</label>
							</div>
							<div class="col-md-6">
								<p>
									<s:property value="mobile" />
								</p>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<label>Block No</label>
							</div>
							<div class="col-md-6">
								<p>
									<s:property value="blockNo" />
								</p>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<label>Street</label>
							</div>
							<div class="col-md-6">
								<p>
									<s:property value="street" />
								</p>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<label>Unit No</label>
							</div>
							<div class="col-md-6">
								<p>
									<s:property value="unitNo" />
								</p>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<label>Postal Code</label>
							</div>
							<div class="col-md-6">
								<p>
									<s:property value="postalCode" />
								</p>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<label>City</label>
							</div>
							<div class="col-md-6">
								<p>
									<s:property value="city" />
								</p>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<label>Country</label>
							</div>
							<div class="col-md-6">
								<p>
									<s:property value="country" />
								</p>
							</div>
						</div>
					</div>
					<div class="tab-pane fade" id="profile" role="tabpanel"
						aria-labelledby="profile-tab">
						<div class="row">
							<div class="col-md-6">
								<label>Education</label>
							</div>
							<div class="col-md-6">
								<p>
									<s:property value="education" />
								</p>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<label>Company Name</label>
							</div>
							<div class="col-md-6">
								<p>
									<s:property value="companyName" />
								</p>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<label>Work Experience</label>
							</div>
							<div class="col-md-6">
								<p>
									<s:property value="workExperience" />
								</p>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<label>Skills</label>
							</div>
							<div class="col-md-6">
								<p>
									<s:property value="skills" />
								</p>
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
