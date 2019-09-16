<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
  <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>

<link rel="stylesheet" type="text/css" href="Pages/Home/home.css">
</head>
<body>
	<%@ include file="../Home/header.jsp"%>
	<br />
	<br />
	<br />
	<%--<h1>
		<s:property value="userName" />
	</h1>
	  
	<h2>
		<s:if test="userAdmin">
			User has admin rights
		</s:if>
		<s:if test="!userAdmin">
			User does not have admin rights
		</s:if>
	</h2>--%>
	
	<div class="jumbotron">
		<div class="container">
			<h1 class="display-3">
				Hello friend,
				<s:property value="userName" />
				!
			</h1>
			<h1>Welcome to ABC Jobs Community Portal!</h1>
			<h2>About Us</h2>
			<p>We are an upcoming community portal, whereby our main goal is
				to connect all the software programmers in one place. With more than
				50,000 users in more than 50 countries, you are in the right place
				in finding your community.</p>
		</div>
	</div>

	<hr class="featurette-divider">

	<div class="row featurette">
		<div class="col-md-7 order-md-2">
			<h2 class="featurette-heading">
				Jobs. <span class="text-muted">Get hired.</span>
			</h2>
			<p class="lead">Find the right job or internship for you. Post
				your job and find the right candidate for your company.</p>
		</div>
		<div class="col-md-5 order-md-1">
			<img class="featurette-image img-fluid mx-auto"
				src="Images/Job.jpg" alt="job image">
		</div>
	</div>

	<hr class="featurette-divider">

	<div class="row featurette">
		<div class="col-md-7 order-md-2">
			<h2 class="featurette-heading">
				Search Profile. <span class="text-muted">Looking for someone?</span>
			</h2>
			<p class="lead">Find your colleagues, classmates or friends.</p>
		</div>
		<div class="col-md-5 order-md-1">
			<img class="featurette-image img-fluid mx-auto"
				src="Images/Search.jpeg" alt="search profile image">
		</div>
	</div>

	<hr class="featurette-divider">

	<div class="row featurette">
		<div class="col-md-7 order-md-2">
			<h2 class="featurette-heading">
				Message & Thread. <span class="text-muted">Get connected.</span>
			</h2>
			<p class="lead">Message someone you know or someone whom you
				would like to get to know. Join threads and contribute back to the
				community.</p>
		</div>
		<div class="col-md-5 order-md-1">
			<img class="featurette-image img-fluid mx-auto"
				src="Images/Message.jpg" alt="message & thread image">
		</div>
	</div>

	<hr class="featurette-divider">
	<%@ include file="../Home/footer.jsp"%>
</body>
</html>