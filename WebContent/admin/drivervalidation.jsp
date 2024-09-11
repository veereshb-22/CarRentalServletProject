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
        <h2 class="my-4" style="color: orange; text-align: center;">Manage Driver</h2>
        <table class="table table-striped table-bordered">
            <thead class="thead-dark">
                <tr>
                    <th>Driver ID</th>
                    <th> Name</th>
                    <th>License Number</th>
                    <th>Email</th>
                    <th>Phone Number</th>
                    <th>Validation</th>
                    <th>Action</th>                 
                </tr>
            </thead>
            <tbody>
                <c:forEach var="drivers" items="${drivers}">
                    <tr>
                        <td>${drivers.driverID}</td>
                        <td>${drivers.driverName}</td>
                        <td>${drivers.driverLicense}</td>
                        <td>${drivers.driverEmail}</td>
                        <td>${drivers.driverPhone}</td>
                        <td>${drivers.driverValidation}</td>  
                       	<td>
						   	 <button style="background-color: green; color: white; border: none; padding: 5px 10px; border-radius: 5px;">
						        <a href="addcartodriver?id=<c:out value='${drivers.driverID}' />" style="color: black; text-decoration: none;">ASSIGN CAR</a>
						    </button>
						    &nbsp;&nbsp;
						    <button style="background-color: red; color: white; border: none; padding: 5px 10px; border-radius: 5px;">
						        <a href="deactivatedriver?id=<c:out value='${drivers.driverID}' />" style="color: black; text-decoration: none;">DEACTIVATE</a>
						    </button>
						</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>   
   	<jsp:include page="../common/footer.jsp"></jsp:include>
   
</body>
</html>
