<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored = "false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User List</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
    <style>
        /* Custom styles */
        .container {
            margin-top: 20px;
        }
        table {
            width: 100%;
        }
        th, td {
            text-align: left;
            vertical-align: middle;
        }
    </style>
</head>
<body>
	<jsp:include page="../common/adminheader.jsp"></jsp:include>
    <div class="container">
        <h2 class="my-4" style="color: orange; text-align: center;">User List</h2>
        <table class="table table-striped table-bordered">
            <thead class="thead-dark">
                <tr>
                    <th>User ID</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Email</th>
                    <th>Wallet</th>
                    <th>Phone</th>
                    <th>Age</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="user" items="${users}">
                    <tr>
                        <td>${user.userID}</td>
                        <td>${user.userFirstName}</td>
                        <td>${user.userLastName}</td>
                        <td>${user.userEmail}</td>
                        <td>${user.userWallet}</td>
                        <td>${user.userPhone}</td>
                        <td>${user.age}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
	<jsp:include page="../common/footer.jsp"></jsp:include>

   
</body>
</html>
