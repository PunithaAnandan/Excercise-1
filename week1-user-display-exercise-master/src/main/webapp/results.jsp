<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="head.jsp"%>

<html xmlns="http://www.w3.org/1999/xhtml">

<%--@include file="taglib.jsp"%>
<c:set var="title" value="Search Results" />
<%@include file="head.jsp"%>

<script type="text/javascript" class="init">
    $(document).ready( function () {
        $('#userTable').DataTable();
    } );
</script>--%>


<body>

<%--TODO Pretty up the results!--%>
<div class="container-fluid">
    <h2>Search Results: </h2>
    <table border="1" align="left" width="500" cellspacing="50">
        <tr><th align="center" bgcolor="#8a2be2">User Id</th><th align="center" bgcolor="#8a2be2">First Name</th>
            <th align="center" bgcolor="#8a2be2">Last Name</th><th align="center" bgcolor="#8a2be2">Date of Birth</th>
            <th align="center" bgcolor="#8a2be2">Age</th></tr>
    <c:forEach items="${users}" var="user">

        <tr>
            <td align="center">${user.userid}</td>
            <td align="center">${user.firstName}</td>
            <td align="center">${user.lastName}</td>
            <td align="center">${user.dateOfBirth}</td>
            <td align="center">${user.getAge()}</td>
        </tr>
    </c:forEach>
    </table>

</div>
<a href="search.jsp">Back to the search Page</a>

</body>
</html>
