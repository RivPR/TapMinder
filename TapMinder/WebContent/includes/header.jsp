<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">

<head>

<link rel="stylesheet" type="text/css" href="customcss/reset.css" />

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>TAPMINDER</title>

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



<link rel="stylesheet" type="text/css" href="customcss/tableReflow.css" />
<link rel="stylesheet" type="text/css" href="customcss/starRating.css" />
<link rel="stylesheet" type="text/css" href="customcss/stylesheet.css" />
</head>

<body id="page-top">

<!-- facebook script -->
<%@ include file="facebookHeaderScript.jsp"%>

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
			<c:if test="${currentUser.id > 0}">
				<a class="navbar-brand page-scroll" href="indexAlexTest.jsp">TapMinder | Welcome, ${currentUser.firstname}! </a>
			</c:if>
			<c:if test="${currentUser.id < 1}">
				<a class="navbar-brand page-scroll" href="initPage.do">TapMinder</a>
			</c:if>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
					<c:if test="${currentUser.id > 0 }">
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<form action="menu.do" method="POST">
				<ul class="nav navbar-nav navbar-right">
						<li><button type="submit" style="color:rgb(220,220,220)"class="btn btn-link nav-links"
								name="menuChoice" value="myAccount">Manage Account</button></li>
						<li><button type="submit" style="color:rgb(220,220,220)"class="btn btn-link nav-links"
								name="menuChoice" value="viewUserBeers">View Beers</button></li>
						<li><button type="submit" style="color:rgb(220,220,220)" class="btn btn-link nav-links"
								name="menuChoice" value="logout">Logout ${currentUser.firstname} ${currentUser.lastname }</button></li>
				</ul>
			</form>
		</div>
					</c:if>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid --> </nav>