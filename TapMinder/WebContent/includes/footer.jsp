<%-- THIS IS INCLUDED WHEN A HEADER IS INCLUDED, INGORE WARNINGS:

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> --%>

<div class="bottom-page-spacer">

</div>


<footer class="fixed-bottom-footer">

WELCOME TO TAPMINDER


<c:if test="${currentUser.usertype.accessLevel == 2}">
	<%@ include file="moderatorLowerMenu.jsp"%>
</c:if>

<c:if test="${currentUser.usertype.accessLevel == 3}">
	<%@ include file="adminLowerMenu.jsp"%>
</c:if>

</footer>


    <!-- jQuery -->
    <script src="js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>

    <!-- Plugin JavaScript -->
    <script src="js/jquery.easing.min.js"></script>
    <script src="js/jquery.fittext.js"></script>
    <script src="js/wow.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="js/creative.js"></script>

</body>
</html>
