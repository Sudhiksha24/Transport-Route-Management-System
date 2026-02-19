<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add Route</title>
</head>
<body>

<h2>Add Route</h2>

<form action="MainServlet" method="post">

    <input type="hidden" name="operation" value="newRecord"/>

    Route Code: <input type="text" name="routeCode"/><br><br>

    Route Name: <input type="text" name="routeName"/><br><br>

    Start Location: <input type="text" name="startLoc"/><br><br>

    End Location: <input type="text" name="endLoc"/><br><br>

    Distance (Km): <input type="text" name="distanceKm"/><br><br>

    Remarks: <input type="text" name="remarks"/><br><br>

    <input type="submit" value="Add Route"/>

</form>

</body>
</html>
