<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Booking List</title>
    <!-- Bootstrap CSS for styling -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <style>
        /* Custom styles */
        .btn-book {
            background-color: orange; /* Orange background color */
            color: white; /* White text color */
            border: none; /* Remove default border */
            border-radius: 5px; /* Rounded corners */
            padding: 10px 15px; /* Padding for size */
            font-size: 16px; /* Font size */
            text-align: center; /* Center text */
            text-decoration: none; /* Remove underline */
        }

        .btn-book:hover {
            background-color: darkorange; /* Darker orange on hover */
            color: white; /* Maintain white text color */
        }
    </style>
</head>
<body>
    <jsp:include page="../common/homeheader.jsp"></jsp:include>
    <div class="container">
        <h2 class="my-4 text-center" style="color: orange;">Available Cars for Booking</h2>
        
        <table class="table table-bordered table-striped">
            <thead>
                <tr>
                    <th>Car Model</th>
                    <th>Car Number</th>
                    <th>Driver Name</th>
                    <th>Driver Phone Number</th>
                    <th>Cost</th>
                    <th>Action</th>    
                </tr>
            </thead>
            <tbody>
                <!-- Iterate over the list of CarDriverInfo objects -->
                <c:forEach var="carDriver" items="${availableCars}">
                    <tr>
                        <td>${carDriver.carModel}</td>
                        <td>${carDriver.carNumber}</td>
                        <td>${carDriver.driverName}</td>
                        <td>${carDriver.driverPhoneNumber}</td>
                        <td>${carDriver.rideCost}</td>
                        <td>
                            <!-- Use the custom button class -->
                            <a href="bookingcartransactionservlet?carNum=<c:out value='${carDriver.carNumber}'/>" class="btn btn-book">BOOK</a>
                        </td>                         
                    </tr>
                </c:forEach>
                
                <!-- Optional: Add a message if no cars are available -->
                <c:if test="${empty availableCars}">
                    <tr>
                        <td colspan="6" class="text-center">No cars available for the selected date and time.</td>
                    </tr>
                </c:if>
            </tbody>
        </table>        
    </div>
   	<jsp:include page="../common/footer.jsp"></jsp:include>
   
</body>
</html>
