<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Item Adding Result</title>
</head>
<body>
    <h1>Item Adding Result</h1>
    <%
        boolean status = (Boolean) request.getAttribute("addedItem");
    %>
    <p>
        <%= status ? "Item Created successfully" :
                     "Failed to add item" %>
    </p>
    <a href="index.jsp">Back to Dashboard</a>
</body>
</html>