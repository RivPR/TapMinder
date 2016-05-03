<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>



<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="description" content="">
<meta name="author" content="">

<title>TapMinder</title>

<!-- Bootstrap Core CSS -->
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">

<!-- Custom Fonts -->
<link
	href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800'
	rel='stylesheet' type='text/css'>
<link
	href='http://fonts.googleapis.com/css?family=Merriweather:400,300,300italic,400italic,700,700italic,900,900italic'
	rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="font-awesome/css/font-awesome.min.css"
	type="text/css">

<!-- Plugin CSS -->
<link rel="stylesheet" href="css/animate.min.css" type="text/css">

<!-- Custom CSS -->
<link rel="stylesheet" href="css/creative.css" type="text/css">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>


<body id="page-top">

	<nav id="mainNav" class="navbar navbar-default navbar-fixed-top">
	<div class="container-fluid">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand page-scroll" href="initPage.do">Home</a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav navbar-right">
				<li><a class="page-scroll" href="#about">About</a></li>
				<li><a class="page-scroll" href="#services">Services</a></li>
				<li><a class="page-scroll" href="#portfolio">Portfolio</a></li>
				<li><a class="page-scroll" href="#contact">Contact</a></li>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid --> </nav>

	<header>

	<div class="header-content">
		<div class="header-content-inner">

			<form action="menu.do" method="POST">
				<!-- 		if logged in, show loggout instead (destroy session or something) -->
				<button style="color: black;" type="submit" name="menuChoice"
					value="login">Login</button>
				<button style="color: black;" type="submit" name="menuChoice"
					value="findBeers">Find Beers</button>
				<button style="color: black;" type="submit" name="menuChoice"
					value="findBreweries">Find Breweries</button>

				<button style="color: black;" type="submit" name="menuChoice"
					value="viewUserBeers">View User Beers</button>

				<button style="color: black;" type="submit" name="menuChoice"
					value="myAccount">View User Account</button>
				<!-- moderators and up only -->
				<button style="color: black;" type="submit" name="menuChoice"
					value="modifyBreweries">edit brews</button>
				<!-- admin and up only -->
				<button style="color: black;" type="submit" name="menuChoice"
					value="modifyUsers">edit users</button>
				<button style="color: black;" type="submit" name="menuChoice"
					value="addBreweries">add brewrss</button>
			</form>

		</div>
	</div>
	</header>
<body>

	<form action="menu.do" method="POST">

		<section class="no-padding" id="portfolio">
		<div class="container-fluid">
			<div class="row no-gutter">

				<div class="col-lg-4 col-sm-6">
					<!--  <a href="#" class="portfolio-box"> -->
					<!--    <a href="#" class="portfolio-box" name="menuChoice" onclick="$(findBeers).closest('menu.do').submit()">Submit</a> -->
					<a href="#" class="porfolio-box"> <input type="image"
						name="menuChoice" value="findBeers" class="img-responsive"
						src="img/portfolio/1.jpg" alt="" /> <!--  <img src="img/portfolio/1.jpg" class="img-responsive" alt="">  -->
						<!--                         <input class="portfolio-box" type="image" name="menuChoice" src="img/portfolio/1.jpg" class="img-responsive" alt="" border="0" value="findBeers" alt="Submit" />
 -->
						<div class="portfolio-box-caption">
							<div class="portfolio-box-caption-content">
								<!--  <div class="project-category text-faded">
                                    Category
                                </div> -->
								<div align="center" class="project-name">Find Brews</div>
							</div>
						</div>
					</a>
				</div>

				<div class="col-lg-4 col-sm-6">
					<!--  <a href="#" class="portfolio-box"> -->
					<!--    <a href="#" class="portfolio-box" name="menuChoice" onclick="$(findBeers).closest('menu.do').submit()">Submit</a> -->
					<a href="#" class="porfolio-box"> <input type="image"
						name="menuChoice" value="findBreweries" class="img-responsive"
						src="img/portfolio/2.jpg" alt="" /> <!--  <img src="img/portfolio/1.jpg" class="img-responsive" alt="">  -->
						<!--                         <input class="portfolio-box" type="image" name="menuChoice" src="img/portfolio/1.jpg" class="img-responsive" alt="" border="0" value="findBeers" alt="Submit" />
 -->
						<div class="portfolio-box-caption">
							<div class="portfolio-box-caption-content">
								<!--  <div class="project-category text-faded">
                                    Category
                                </div> -->
								<div align="center" class="project-name">Find Breweries</div>
							</div>
						</div>
					</a>
				</div>

				<div class="col-lg-4 col-sm-6">
					<!--  <a href="#" class="portfolio-box"> -->
					<!--    <a href="#" class="portfolio-box" name="menuChoice" onclick="$(findBeers).closest('menu.do').submit()">Submit</a> -->
					<a href="#" class="porfolio-box"> <input type="image"
						name="menuChoice" value="viewUserBeers" class="img-responsive"
						src="img/portfolio/3.jpg" alt="" /> <!--  <img src="img/portfolio/1.jpg" class="img-responsive" alt="">  -->
						<!--                         <input class="portfolio-box" type="image" name="menuChoice" src="img/portfolio/1.jpg" class="img-responsive" alt="" border="0" value="findBeers" alt="Submit" />
 -->
						<div class="portfolio-box-caption">
							<div class="portfolio-box-caption-content">
								<!--  <div class="project-category text-faded">
                                    Category
                                </div> -->
								<div align="center" class="project-name">View Your Brews</div>
							</div>
						</div>
					</a>
				</div>


				<div class="col-lg-4 col-sm-6">
					<a href="#" class="portfolio-box"> <img
						src="img/portfolio/4.jpg" class="img-responsive" alt="">
						<div class="portfolio-box-caption">
							<div class="portfolio-box-caption-content">
								<!--  <div class="project-category text-faded">
                                    Category
                                </div> -->
								<div class="project-name">View Your Account</div>
							</div>
						</div>
					</a>
				</div>
				<div class="col-lg-4 col-sm-6">
					<a href="#" class="portfolio-box"> <img
						src="img/portfolio/5.jpg" class="img-responsive" alt="">
						<div class="portfolio-box-caption">
							<div class="portfolio-box-caption-content">
								<!-- <div class="project-category text-faded">
                                    Category
                                </div> -->
								<div class="project-name">Edit Beer</div>
							</div>
						</div>
					</a>
				</div>
				<div class="col-lg-4 col-sm-6">
					<a href="#" class="portfolio-box"> <img
						src="img/portfolio/6.jpg" class="img-responsive" alt="">
						<div class="portfolio-box-caption">
							<div class="portfolio-box-caption-content">
								<!-- <div class="project-category text-faded">
                                    Category
                                </div> -->
								<div class="project-name">Edit Moderators</div>
							</div>
						</div>
					</a>
				</div>
			</div>
		</div>
		</section>
	</form>

	<aside class="bg-dark">
	<div class="container text-center">
		<div class="call-to-action">
			<h2>Connect with us on Facebook!</h2>
			<a href="#" class="btn btn-default btn-xl wow tada">Yes!</a>
		</div>
	</div>
	</aside>

	<section id="contact">
	<div class="container">
		<div class="row">
			<div class="col-lg-8 col-lg-offset-2 text-center">
				<h2 class="section-heading">Let's Get In Touch!</h2>
				<hr class="primary">
				<p>Ready to start your next project with us? That's great! Give
					us a call or send us an email and we will get back to you as soon
					as possible!</p>
			</div>
			<div class="col-lg-4 col-lg-offset-2 text-center">
				<i class="fa fa-phone fa-3x wow bounceIn"></i>
				<p>123-456-6789</p>
			</div>
			<div class="col-lg-4 text-center">
				<i class="fa fa-envelope-o fa-3x wow bounceIn" data-wow-delay=".1s"></i>
				<p>
					<a href="mailto:your-email@your-domain.com">feedback@TapMinder.com</a>
				</p>
			</div>
		</div>
	</div>
	</section>
<body>

	<form action="menu.do" method="POST">

		<!-- 		if logged in, show loggout instead (destory session or something) -->
		<button type="submit" name="menuChoice" value="login">Login</button>
		<button type="submit" name="menuChoice" value="findBeers">Find
			Beers</button>
		<button type="submit" name="menuChoice" value="findBreweries">Find
			Breweries</button>
		<button type="submit" name="menuChoice" value="viewUserBeers">View
			User Beers</button>
		<button type="submit" name="menuChoice" value="myAccount">View
			User Account</button>
		<!-- moderators and up only -->
		<button type="submit" name="menuChoice" value="modifyBreweries">edit
			brews</button>
		<!-- admin and up only -->
		<button type="submit" name="menuChoice" value="modifyUsers">edit
			moderators</button>

		<button type="submit" name="menuChoice" value="logout">logout</button>


	</form>


	<c:if test="${currentUser.id > 0}"> 
	${currentUser.firstname}
	${currentUser.email}
	${currentUser.lastname}
	${currentUser.password}
	${currentUser.firstname}
	${currentUser.firstname}
</c:if>

</body>
</html>
