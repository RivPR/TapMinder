<%@include file="/includes/header.jsp"%>

<header>
	<div class="header-content">
	<div class="header-content-inner">

	<span class="center-text"><h2>USER INFO</h2></span>
	<div class="user-information">
			<div class="col-sm-0 col-md-5 col-lg-5">
				<img class="xs-pic" src="${currentUser.picture}" />
	<div class="col-sm-12 col-md-4 col-lg-8">
	<form action="editProfile.do">
	<table>
		<tr>
			<td>First* </td>
			<td><input type="text" name="firstname" value="${currentUser.firstname}"/></td>
		</tr>
		<tr>
			<td>Last* </td>
			<td><input type="text" name="lastname" value="${currentUser.lastname}" /></td>
		</tr>
		<tr>
			<td>Picture URL&nbsp; </td>
			<td><input type="text" name="picture" value="${currentUser.picture}" /></td>
		</tr>
	</table>
	</form>
	<table>
		<tr>
			<td colspan="1">
			<form action="updateCurrentUser.do">
			<input type="hidden" name="userId" value="${currentUser.id}">
			<button class="btn btn-add" type="submit">
			 UPDATE	ACCOUNT</button>
			</form>
			</td>
			
			<td colspan="1">
			<form action="deleteCurrentUser.do">
			<input type="hidden" name="userId" value="${currentUser.id}">
			<button class="btn btn-warning" type="submit"
			 onclick="if (confirm('Are you sure you want to delete your account?')) commentDelete(1); return false">
			 DELETE	ACCOUNT</button>
			</form>
			</td>
			
		</tr>
		
	</table>		



				</div>
			</div>
		</div>
	</div>
	</div>
</header>
<%@include file="/includes/footer.jsp"%>