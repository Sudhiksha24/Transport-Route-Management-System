<%@ page import="java.util.*, com.wipro.route.bean.RouteBean" %>
<%
    List<RouteBean> list = (List<RouteBean>) request.getAttribute("list");
    String message = (String) request.getAttribute("message");
%>

<!DOCTYPE html>
<html>
<head>
    <title>All Routes</title>
</head>
<body>

<h2>All Routes</h2>

<%
    if (list != null && !list.isEmpty()) {
%>

<table border="1">
<tr>
    <th>Route ID</th>
    <th>Route Code</th>
    <th>Route Name</th>
    <th>Start</th>
    <th>End</th>
    <th>Distance</th>
    <th>Remarks</th>
</tr>

<%
    for (RouteBean bean : list) {
%>

<tr>
    <td><%= bean.getRouteId() %></td>
    <td><%= bean.getRouteCode() %></td>
    <td><%= bean.getRouteName() %></td>
    <td><%= bean.getStartLoc() %></td>
    <td><%= bean.getEndLoc() %></td>
    <td><%= bean.getDistanceKm() %></td>
    <td><%= bean.getRemarks() %></td>
</tr>

<%
    }
%>

</table>

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
