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
        <h2 class="my-4" style="color: orange; text-align: center;">Car List</h2>
        <table class="table table-striped table-bordered">
            <thead class="thead-dark">
                <tr>
                    <th>Car ID</th>
                    <th>Driver ID</th>
                    <th>Car Number</th>
                    <th>Car Model</th>
                    <th>Car Type</th>                     
                </tr>
            </thead>
            <tbody>
              
                <c:forEach var="car" items="${cars}">
                    <tr>
                        <td>${car.cardID}</td>
                        <td>${car.carDriverID} </td>
                        <td>${car.carNumber}</td>
                        <td>${car.carModel}</td>         
                        <td>${car.carType}</td>                                  
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
	<jsp:include page="../common/footer.jsp"></jsp:include>

</body>
</html>