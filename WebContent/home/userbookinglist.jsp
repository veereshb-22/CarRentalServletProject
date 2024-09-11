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
	<jsp:include page="../common/homeheader.jsp"></jsp:include>
    <div class="container">
        <h1 class="my-4"  style="color: orange; text-align: center;">Booking List</h1>
        <table class="table table-striped table-bordered">
            <thead class="thead-dark">
                <tr>
                       	<th>Booking ID</th>
		                <th>Driver Name</th>
		                <th>Driver Phone</th>
		                <th>Car Number</th>
		                <th>Start Point</th>
		                <th>End Point</th>
		                <th>Location Cost</th>
              
                </tr>
            </thead>
            <tbody>           
                <c:forEach var="bookingListUser" items="${bookingListUsers}">
                <tr>
                   <td>${bookingListUser.bookingId}</td>  
                   <td>${bookingListUser.driverName}</td>  
                   <td>${bookingListUser.driverPhoneNumber}</td>  
                   <td>${bookingListUser.carNumber}</td>  
                   <td>${bookingListUser.startPoint}</td>  
                   <td>${bookingListUser.endPoint}</td>  
                  <td>${bookingListUser.locationCost}</td>  
                </tr>  
                </c:forEach>
            </tbody>
        </table>
    </div>
   	<jsp:include page="../common/footer.jsp"></jsp:include>
   
</body>
</html>
