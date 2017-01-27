<%--
  Created by IntelliJ IDEA.
  User: Punitha Anandan
  Date: 1/22/2017
  Time: 9:43 AM
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@include file="head.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<html>
<head>
    <title>Search Page</title>
    <script type="text/JavaScript">
        function validateForm() {
            //var searchTerm = document.forms["myForm"]["searchTerm"].value;
            //var searchType = document.forms["myForm"]["searchType"].value;
            var searchTerm = document.myForm.searchTerm.value;
            var lastNameChecked = document.myForm.searchType[1].checked;
            //alert('searchTerm:'+searchTerm);
            //alert('lastNameChecked:'+lastNameChecked);
            if ((lastNameChecked == true) && (searchTerm == "")) {
                    alert("Last Name must be filled out");
                    return false;
            }
        }
    </script>
</head>
<body>


<div class="container-fluid">
    <h2>Select the option</h2>
    <form name="myForm" action="searchUser" onsubmit="return validateForm();" method="get">

        <table border="1">

            <tr><td>Search Term</td><td><input type="text" name="searchTerm" /></td></tr>
            <tr><td>Search Type</td><td><input type="radio" name="searchType" value="All" checked>All
                <input type="radio" name="searchType" value="lastName">Last Name</td></tr>
            <tr><td>&nbsp;</td><td><input type="submit" name="" value="Search" /></td></tr>
        </table>

    </form>
</div>

</body>
</html>
