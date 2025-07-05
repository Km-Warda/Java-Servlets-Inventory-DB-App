<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Item Update Result</title>
</head>
<body>
    <h1>Item Update Result</h1>
    <%
        boolean status = (Boolean) request.getAttribute("updatedItem");
        int id = (Integer) request.getAttribute("updatedItemID");
    %>
    <p>
        <%= status ? "Item with ID " + id + " was successfully updated." :
                     "Failed to update item with ID " + id + ". It may not exist." %>
    </p>
    <a href="index.jsp">Back to Dashboard</a>
</body>
</html>