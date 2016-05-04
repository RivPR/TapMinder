<%@include file="/includes/header.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Profile Page</title>
</head>


<body>

<div class="container">
<div>
<h2>USER INFO</h2>
<table class="table table-inverse">
<thead>
	<tr>
		<th>First Name</th>
		<th>Last Name</th>
		<th>Email</th>
		<th>Account Type</th>
		<th># of Beers Rated</th>
	</tr>
</thead>
<tbody>
 	<tr>
 		<th>${currentUser.firstname}</th>
 		<th>${currentUser.lastname}</th>
		<th>${currentUser.email}</th>
    	<th>${currentUser.usertype.typeName}</th>
		<th>${currentUser.ratings.size()}</th>
	</tr>
</table>
	
<form action="deleteCurrentUser.do">
	<input type="hidden" name="userId" value="${currentUser.id}">
	<button class="btn btn-delete btn-xl page-scroll" type="submit">DELETE ACCOUNT</button>
</form>


</div> <!-- PROFILE CARD -->

</div> <!-- /CONTAINER -->




</body>



</html>