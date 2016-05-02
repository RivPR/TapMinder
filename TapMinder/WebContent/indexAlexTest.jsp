<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>



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
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Merriweather:400,300,300italic,400italic,700,700italic,900,900italic' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="font-awesome/css/font-awesome.min.css" type="text/css">

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
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand page-scroll" href="initPage.do">Home</a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                    <li>
                        <a class="page-scroll" href="#about">About</a>
                    </li>
                    <li>
                        <a class="page-scroll" href="#services">Services</a>
                    </li>
                    <li>
                        <a class="page-scroll" href="#portfolio">Portfolio</a>
                    </li>
                    <li>
                        <a class="page-scroll" href="#contact">Contact</a>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container-fluid -->
    </nav>

	<header>

	<div class="header-content">
		<div class="header-content-inner">

			<form action="menu.do" method="POST">
				<!-- 		if logged in, show loggout instead (destroy session or something) -->
				<button style="color:black;" type="submit" name="menuChoice" value="login">Login</button>
				<button style="color:black;" type="submit" name="menuChoice" value="findBeers">Find
					Beers</button>
				<button style="color:black;" type="submit" name="menuChoice" value="findBreweries">Find
					Breweries</button>

				<button style="color:black;" type="submit" name="menuChoice" value="viewUserBeers">View
					User Beers</button>
					
				<button style="color:black;" type="submit" name="menuChoice" value="myAccount">View
					User Account</button>
				<!-- moderators and up only -->
				<button style="color:black;" type="submit" name="menuChoice" value="modifyBreweries">edit
					brews</button>
				<!-- admin and up only -->
				<button style="color:black;" type="submit" name="menuChoice" value="modifyUsers">edit
					moderators</button>
					
			
					
			</form>

		</div>
	</div>
	</header><body>

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
