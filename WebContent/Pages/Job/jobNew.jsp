<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Job New</title>
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
								<h4>Post New Job</h4>
								<hr>
							</div>
						</div>
						<div class="row">
							<div class="col-md-12">
								<form action="job" method="post">
								
									<div class="form-group row">
										<label for="title" class="col-4 col-form-label">Title: *</label>
										<div class="col-8">
											<input id="title" name="title"
												placeholder="Title" class="form-control here"
												type="text" value="<s:property value="title"/>">
										</div>
									</div>

									<div class="form-group row">
										<label for="companyName" class="col-4 col-form-label">Company Name: *</label>
										<div class="col-8">
											<input id="companyName" name="companyName" placeholder="Company Name"
												class="form-control here" type="text"
												value="<s:property value="companyName"/>">
										</div>
									</div>

									<div class="form-group row">
										<label for="salary" class="col-4 col-form-label">Salary: *</label>
										<div class="col-8">
											<input id="salary" name="salary" placeholder="Salary"
												class="form-control here" type="text"
												value="<s:property value="salary"/>">
										</div>
									</div>

									<div class="form-group row">
										<label for="description" class="col-4 col-form-label">Description: *</label>
										<div class="col-8">
											<input id="description" name="description" placeholder="Description"
												class="form-control here" type="text"
												value="<s:property value="description"/>">
										</div>
									</div>
			
			                        <div style="<s:property value="messageStyle" />">
				                        <s:property value="message" />
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
	
	<%@ include file="../Home/footer.jsp"%>
</body>
</html>