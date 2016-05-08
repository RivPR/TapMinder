<%@include file="/includes/header.jsp"%>


<header>
	<div class="header-content">
		<div class="header-content-inner">

				<span class="center-text"><h2>USER INFO</h2></span>
			<div class="col-sm-0 col-md-2 col-lg-2 filler"></div>
			<div class="user-information">
			
			<div class="row">
			
			<div class="col-sm-12 col-md-5 col-lg-6"> 
			<img class="lg-pic" src="${currentUser.picture}" />
			</div>
			
			</div> <!-- row -->
			
			<div class="row">
			<div class="col-sm-12 col-lg-6 status">
			<h5>Status:</h5>
			<h3 class="status">${currentUser.status}</h3>
			
			<form action="updateStatus.do">
			<button class="btn btn-add" type="submit">Update status</button>
			</form>
			</div>
			

			<div class="col-sm-12 col-md-4 col-lg-6">
				<table>
					<tr>
						<td>Firstname:</td>
						<td>${currentUser.firstname}</td>
					</tr>
					<tr>
						<td>Lastname:</td>
						<td>${currentUser.lastname}</td>
					</tr>
					<tr>
						<td>Email:</td>
						<td>${currentUser.email}</td>
					</tr>
					<tr>
						<td>Account Type:&nbsp;&nbsp;&nbsp;</td>
						<td>${currentUser.usertype.typeName}</td>
					</tr>
					<tr>
						<td>Beers Rated:</td>
						<td>${currentUser.ratings.size()}</td>
					</tr>
					
					<tr>
					<td colspan="2">
					<form action="takeToUpdateProfile.do">
					<button class="btn btn-add" type="submit">Edit Profile</button>
					</form>
					</td>
					</tr>


				</table>
			</div>
			</div> <!-- row -->
			
			
			
			
			</div>
		</div>
	</div>
	
</header>
<%@include file="/includes/footer.jsp"%>
