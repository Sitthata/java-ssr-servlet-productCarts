<%--
  Created by IntelliJ IDEA.
  User: FIRST-ACER-Desktop
  Date: 10/29/2023
  Time: 5:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body style="background-color: ${requestScope.theme}">
<a href="hello-servlet">Hello Servlet</a>
<form action="ThemeSelector" method="GET">
    <label for="theme">Select a theme</label>
    <select name="theme" id="theme">
        <option value="white">light</option>
        <option value="black">dark</option>
        <option value="blue">blue</option>
    </select>
    <input type="submit" value="Set Theme">
</form>
</body>
</html>
