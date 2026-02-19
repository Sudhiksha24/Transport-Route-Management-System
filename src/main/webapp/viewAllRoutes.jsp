<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>View All Routes</title>
</head>
<body>

<h2>View All Routes</h2>

<form action="MainServlet" method="post">

    <input type="hidden" name="operation" value="viewAllRecords"/>

    <input type="submit" value="View All Routes"/>

</form>

</body>
</html>
