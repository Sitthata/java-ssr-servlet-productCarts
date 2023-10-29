<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: FIRST-ACER-Desktop
  Date: 10/29/2023
  Time: 1:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Product Cart</h2>

<h1>Total Product: ${requestScope.cartList.size()}</h1>
<form method="POST" action="ProductController">
    <c:forEach items="${requestScope.cartList}" var="product" varStatus="vs">
        <div>
            <input type="checkbox" value="${product.id}" id="${vs.index}" name="selectedId">
            <label for="${vs.index}">${product.title}</label>
            <h3>${product.price}</h3>
        </div>
    </c:forEach>
    <input type="submit" value="Add to Cart">
    <c:if test="${not empty requestScope.message}">
        <p>${requestScope.message}</p>
    </c:if>
</form>

</body>
</html>
