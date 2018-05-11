<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%@page import="model.News" ;%>
<%@page import="java.util.*" ;%>


<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB"
	crossorigin="anonymous">

<title>Car Management</title>
</head>
<body>
<%ArrayList<News> listNews = (ArrayList<News>) request.getAttribute("LIST_VIEW");%>
<%=listNews.size()%>
	<header>
		<div class="container">
			<nav class="navbar navbar-expand-lg navbar-light bg-light">

				<div class="collapse navbar-collapse" id="navbarNavDropdown">
					<ul class="navbar-nav">
						<li class="nav-item active"><a class="nav-link" href="#">Home
								<span class="sr-only">(current)</span>
						</a></li>
						<li class="nav-item"><form action="home" method="post"
									style="margin-top: 10px">
									<button class=" dropdown-item btn btn-link">Test
										</button>
								</form>

						</li>
						<li class="nav-item"><a class="nav-link" href="#">Pricing</a>
						</li>
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="#"
							id="navbarDropdownMenuLink" data-toggle="dropdown"
							aria-haspopup="true" aria-expanded="false"> Car Management </a>
							<div class="dropdown-menu"
								aria-labelledby="navbarDropdownMenuLink">
								<form action="listOfCar" method="post" style="margin-top: 10px">
									<button class=" dropdown-item btn btn-link">Show All
										cars</button>
								</form>

								<form action="index.jsp" method="post" style="margin-top: 10px">
									<button class=" dropdown-item btn btn-link">Add new
										car</button>
								</form>

								<form action="buyInsurance" method="post"
									style="margin-top: 10px">
									<button class=" dropdown-item btn btn-link">Buy
										Insurance for cars insurance</button>
								</form>

							</div></li>
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="#"
							id="navbarDropdownMenuLink" data-toggle="dropdown"
							aria-haspopup="true" aria-expanded="false"> Insurance
								Management </a>
							<div class="dropdown-menu"
								aria-labelledby="navbarDropdownMenuLink">

								<form action="listOfInsurance" method="post"
									style="margin-top: 10px">
									<button class=" dropdown-item btn btn-link">Show all
										insurance</button>
								</form>
								<form action="insurance.jsp" method="get"
									style="margin-top: 10px">
									<button class=" dropdown-item btn btn-link">Add new
										insurance</button>
								</form>
							</div></li>
					</ul>
				</div>
			</nav>
		</div>
	</header>
	<!-- /header -->

	<div class="news-content">
		<div class="container">
			<div class="row">
				<div class="col-xl-8">
					
						<ul class="list-unstyled">

							<li class="media"><img class="mr-3" src=".../64x64"
								alt="Generic placeholder image">
								<div class="media-body">




									<h5 class="mt-0 mb-1"></h5>
									Cras sit amet nibh libero, in gravida nulla. Nulla vel metus
									scelerisque ante sollicitudin. Cras purus odio, vestibulum in
									vulputate at, tempus viverra turpis. Fusce condimentum nunc ac
									nisi vulputate fringilla. Donec lacinia congue felis in
									faucibus.
								</div></li>
							<li class="media my-4"><img class="mr-3" src=".../64x64"
								alt="Generic placeholder image">
								<div class="media-body">
									<h5 class="mt-0 mb-1">List-based media object</h5>
									Cras sit amet nibh libero, in gravida nulla. Nulla vel metus
									scelerisque ante sollicitudin. Cras purus odio, vestibulum in
									vulputate at, tempus viverra turpis. Fusce condimentum nunc ac
									nisi vulputate fringilla. Donec lacinia congue felis in
									faucibus.
								</div></li>
							<li class="media"><img class="mr-3" src=".../64x64"
								alt="Generic placeholder image">
								<div class="media-body">
									<h5 class="mt-0 mb-1">List-based media object</h5>
									Cras sit amet nibh libero, in gravida nulla. Nulla vel metus
									scelerisque ante sollicitudin. Cras purus odio, vestibulum in
									vulputate at, tempus viverra turpis. Fusce condimentum nunc ac
									nisi vulputate fringilla. Donec lacinia congue felis in
									faucibus.
								</div></li>
						</ul>
				
				</div>
				<div class="col-xl-4">
					<h3>Hot News</h3>
					<ul>
						<li>5 Loại xe hot nhất hiện nay</li>
						<li>5 Loại xe hot nhất hiện nay</li>
						<li>5 Loại xe hot nhất hiện nay</li>
						<li>5 Loại xe hot nhất hiện nay</li>
						<li>5 Loại xe hot nhất hiện nay</li>

					</ul>
				</div>
			</div>
		</div>

	</div>
	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
		integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"
		integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T"
		crossorigin="anonymous"></script>
</body>
</html>