<!DOCTYPE html>
<html>
<head>
    <title>Item Dashboard</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css">
</head>
<body>
    <h1>Inventory Manager</h1>

    <form action="itemController" method="get">
        <input type="hidden" name="action" value="list-items">
        <input type="submit" value="List Items">
    </form>
    
 <h2>View an Item</h2>
    
    </form>
    
    <form action="itemController" method="get">
    <input type="hidden" name="action" value="load-item">
    <label for="id">Enter Item ID to view:</label>
        <input type="number" name="id" placeholder="Enter item ID" required>
        <input type="submit" value="Load Item">
            </form>
<h2>Add new Item</h2>
<form action="itemController" method="get">
    <input type="hidden" name="action" value="add-item" />


    <label>Name:</label>
    <input type="text" name="name" required><br>

    <label>Price:</label>
    <input type="number" name="price" required><br>

    <label>Total Number:</label>
    <input type="number" name="total_number" required><br>

    <input type="submit" value="Add new Item" />
</form>
<h2>Update an Item</h2>
<form action="itemController" method="get">
    <input type="hidden" name="action" value="update-item" />

    <label>ID:</label>
    <input type="number" name="id" required><br>

    <label>Name:</label>
    <input type="text" name="name" required><br>

    <label>Price:</label>
    <input type="number" name="price" required><br>

    <label>Total Number:</label>
    <input type="number" name="total_number" required><br>

    <input type="submit" value="Update Item" />
</form>

<h2>Remove an Item</h2>

    <form action="itemController" method="get">
    <input type="hidden" name="action" value="remove-item">
    <label for="id">Enter Item ID to Remove:</label>
    <input type="number" name="id" required>
    <input type="submit" value="Remove Item">
</form>



</body>
</html>
