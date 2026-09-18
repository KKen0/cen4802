<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <title>Purchase Calculator</title>
</head>

<body>

<h1>Purchase Calculator - Continuous Integration Version</h1>

<p>This version is built and tested automatically with GitHub Actions.</p>

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

    <button type="submit">Calculate Total</button>

</form>

</body>
</html>