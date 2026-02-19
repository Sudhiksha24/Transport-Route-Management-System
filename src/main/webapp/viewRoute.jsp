<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>View Route</title>
</head>
<body>

<h2>View Route</h2>

<form action="MainServlet" method="post">

    <input type="hidden" name="operation" value="viewRecord"/>

    Route Code: <input type="text" name="routeCode"/><br><br>

    Route Name: <input type="text" name="routeName"/><br><br>

    <input type="submit" value="View Route"/>

</form>

</body>
</html>
