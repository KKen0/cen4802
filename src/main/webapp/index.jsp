<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <title>Purchase Calculator</title>
</head>

<body>

<h1>Purchase Calculator - Docker Container Version</h1>

<p>This updated version is running inside a Docker container.</p>

<p>Enter the price of an item and the quantity you would like to purchase.</p>

<form action="calculate" method="post">

    <label for="price">Item Price:</label>
    <input
            type="number"
            id="price"
            name="price"
            step="0.01"
            min="0"
            required>

    <br><br>

    <label for="quantity">Quantity:</label>
    <input
            type="number"
            id="quantity"
            name="quantity"
            min="1"
            required>

    <br><br>

    <label for="discount">Discount Percentage:</label>
    <input
            type="number"
            id="discount"
            name="discount"
            min="0"
            max="100"
            step="0.01"
            value="0"
            required>
    <button type="submit">Calculate Total</button>

</form>

</body>
</html>