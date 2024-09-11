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
        <h2 class="my-4" style="color: orange; text-align: center;">Transaction List</h2>
        <table class="table table-striped table-bordered">
            <thead class="thead-dark">
                <tr>
                    <th>Transaction ID</th>
                    <th>User ID</th>
                    <th>Booking ID</th>
                    <th>Transaction Time</th>
                    <th>Status</th>
                    <th>Amount </th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="transaction" items="${transactions}">
                    <tr>
                        <td>${transaction.transactionID}</td>  
                        <td>${transaction.transactionUserID}</td>
                        <td>${transaction.tranactionBookingID}</td>      
                        <td>${transaction.transactionTime}</td>                              
                        <td>${transaction.tranactionStatus}</td>                              
                        <td>${transaction.transactionAmount}</td>                                                                              
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
     <jsp:include page="../common/footer.jsp"></jsp:include> 
</body>
</html>