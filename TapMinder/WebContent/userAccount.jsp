<%@include file="/includes/header.jsp"%>


<header>
	<div class="header-content">
		<div class="header-content-inner">

				<span class="center-text"><h2>USER INFO</h2></span>
			<div class="user-information">
			<div class="col-sm-0 col-md-5"> 
			<img class="med-beer beer-result" src="${currentUser.picture}" />
			<h5>Status:</h5>
			${currentUser.status}
			</div>
			<div class="col-sm-12 col-md-4">
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
					<td colspan="2"><form action="deleteCurrentUser.do">
					<input type="hidden" name="userId" value="${currentUser.id}">
					<button class="btn btn-warning" type="submit"
						onclick="if (confirm('Are you sure you want to delete your account?')) commentDelete(1); return false">DELETE
						ACCOUNT</button>
				</form></td>
					</tr>

				</table>


				

</div>
			</div>
		</div>
	</div>
</header>
<%@include file="/includes/footer.jsp"%>
