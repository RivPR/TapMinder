<%@include file="includes/header.jsp"%>


<c:if test="${currentUser.id > 0}">

${currentUser.id}
${currentUser.firstname}
${currentUser.email}
${currentUser.password}
<%-- ${currentUser.usertype.name} --%>

${currentUser.usertype.typeName}

</c:if>

<%@include file="includes/footer.jsp"%>
