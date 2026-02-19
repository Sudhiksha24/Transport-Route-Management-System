<%@ page import="com.wipro.route.bean.RouteBean" %>
<%
    RouteBean bean = (RouteBean) request.getAttribute("bean");
    String message = (String) request.getAttribute("message");
%>

<!DOCTYPE html>
<html>
<head>
    <title>Display Route</title>
</head>
<body>

<h2>Route Details</h2>

<%
    if (bean != null) {
%>

Route ID: <%= bean.getRouteId() %> <br><br>
Route Code: <%= bean.getRouteCode() %> <br><br>
Route Name: <%= bean.getRouteName() %> <br><br>
Start Location: <%= bean.getStartLoc() %> <br><br>
End Location: <%= bean.getEndLoc() %> <br><br>
Distance (Km): <%= bean.getDistanceKm() %> <br><br>
Remarks: <%= bean.getRemarks() %> <br><br>

<%
    } else {
%>

<%= message %>

<%
    }
%>

<br><br>
<a href="menu.html">Back to Menu</a>

</body>
</html>
