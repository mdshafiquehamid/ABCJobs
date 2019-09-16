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
</head>
<title>Header</title>
</head>
<body>

	<nav class="navbar fixed-top navbar-expand-md navbar-dark bg-dark">
		<a class="navbar-brand" href="#">ABC Jobs</a>

		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarsExample04" aria-controls="navbarsExample04"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarsExample04">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active">
					<form action="profile" method="post">
						<button style="background: none; border: none;" class="nav-link"
							name="submit" value="Home">Home</button>
					</form>
				</li>

				<li class="nav-item active">
					<form action="profile" method="post">
						<button style="background: none; border: none;" class="nav-link"
							name="submit" value="View">Profile</button>
					</form>
				</li>

				<li class="nav-item active">
					<form action="job" method="post">
						<button style="background: none; border: none;" class="nav-link"
							name="submit" value="New">Post Job</button>
					</form>
				</li>

				<li class="nav-item active">
					<form action="job" method="post">
						<button style="background: none; border: none;" class="nav-link"
							name="submit" value="List">Job</button>
					</form>
				</li>

				<li class="nav-item active">
					<form action="message" method="post">
						<button style="background: none; border: none;" class="nav-link"
							name="submit" value="List">Message</button>
					</form>
				</li>

				<li class="nav-item active">
					<form action="thread" method="post">
						<button style="background: none; border: none;" class="nav-link"
							name="submit" value="List">Thread</button>
					</form>
				</li>

				<s:if test="userAdmin">
					<li class="nav-item active">
						<form action="profile" method="post">
							<button style="background: none; border: none;" class="nav-link"
								name="submit" value="List">Users</button>
						</form>
					</li>

					<li class="nav-item active">
						<form action="email" method="post">
							<button style="background: none; border: none;" class="nav-link"
								name="submit" value="Send">Email</button>
						</form>
					</li>
				</s:if>

				<li class="nav-item active">
					<form action="registration" method="post">
						<button style="background: none; border: none;" class="nav-link"
							name="submit" value="Logout">Logout</button>
					</form>
				</li>
			</ul>

			<form class="form-inline my-2 my-md-0" action="profile" method="post">
				<input class="form-control mr-sm-2" type="text" placeholder="Search"
					aria-label="Search" name="search"
					value="<s:property value="search" />">
				<button class="btn btn-outline-success my-2 my-sm-0" name="submit"
					value="Search">Search</button>
			</form>
		</div>
	</nav>

</body>
</html>