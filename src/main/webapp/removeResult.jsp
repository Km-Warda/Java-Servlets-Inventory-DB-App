<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Item Deletion Result</title>
</head>
<body>
    <h1>Delete Item Result</h1>
    <%
        boolean status = (Boolean) request.getAttribute("removalStatus");
        int id = (Integer) request.getAttribute("removedId");
    %>
    <p>
        <%= status ? "Item with ID " + id + " was successfully removed." :
                     "Failed to remove item with ID " + id + ". It may not exist." %>
    </p>
    <a href="index.jsp">Back to Dashboard</a>
</body>
</html>
