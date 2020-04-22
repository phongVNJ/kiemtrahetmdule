<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 4/22/2020
  Time: 4:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>LIST</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">

</head>
<body>
<header>
    <nav class="navbar navbar-expand-md navbar-dark"
         style="background-color: tomato">
        <div>
            <a href="https://www.google.com" class="navbar-brand">Item Management App</a>
        </div>
        <ul class="navbar-nav">
            <li><a href="<%=request.getContextPath()%>/list"
                   class="nav-link">List</a></li>
        </ul>
    </nav>
</header>
<br>
<div class="row">
    <!--<div class="alert alert-sucess" *ngIf='message'>{{message}}</div>-->
    <div class="container">
        <h3 class="text-center">List</h3>
        <hr>
        <div class="container text-left">
            <a href="%=request.getContextPath()%>/new" class="btn btn-success">Add New item</a>
        </div>
        <br>
        <table class="table table-bordered">
            <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>price</th>
                <th>Color</th>
                <th>Quantity</th>
                <th>Descrition</th>
                <th>Category</th>
            </tr>
            </thead>
            <tbody>
            <!--for(Todo todo: todos){ -->
            <c:forEach var="item" items="${listItem}">
                <tr>
                    <td><c:out value="${item.id}" /></td>
                    <td><c:out value="${item.name}" /></td>
                    <td><c:out value="${item.price}" /></td>
                    <td><c:out value="${item.color}" /></td>
                    <td><c:out value="${item.quatity}" /></td>
                    <td><c:out value="${item.mota}" /></td>
                    <td><c:out value="${item.category}" /></td>
                    <td><a href="edit?id=<c:out value='${item.id}'/>">Edit</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="delete?id=<c:out value='${item.id}' />">Deleted</a></td>
                </tr>
            </c:forEach>
            <!--} -->
            </tbody>
        </table>
    </div>
</div>



</body>
</html>
