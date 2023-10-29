<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: FIRST-ACER-Desktop
  Date: 10/29/2023
  Time: 2:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>My Cart</h1>
<p>Total Price: ${requestScope.total}</p>
    <c:forEach items="${sessionScope.selectedCart}" var="product">
        <form action="SelectedCart" method="POST">
                <h3>${product.title}</h3>
                <span>${product.price}</span>
                <input type="hidden" name="productId" value="${product.id}">
                <input type="submit" value="remove">
        </form>
    </c:forEach>
<a href="ProductController">Back to Product Catalog</a>
</body>
</html>
