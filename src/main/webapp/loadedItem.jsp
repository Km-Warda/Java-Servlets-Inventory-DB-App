<%@page import="com.item.model.Item"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Item Details</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<%
    Item item = (Item) request.getAttribute("item");
    if (item != null) {
%>
    <h2>Item Found:</h2>
    <ul>
        <li>ID: <%= item.getId() %></li>
        <li>Name: <%= item.getName() %></li>
        <li>Price: <%= item.getPrice() %></li>
        <li>Total Number: <%= item.getTotalNumber() %></li>
    </ul>
<%
    } else {
%>
    <h2>No item found with that ID.</h2>
<%
    }
%>

<a href="index.jsp">← Back to Dashboard</a>
</body>
</html>
