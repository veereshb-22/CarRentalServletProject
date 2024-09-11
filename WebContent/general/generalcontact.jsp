
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous"> 
<style>
    body {
        margin: 0;
        padding: 0;
        height: 100vh;
        /* Background image */
        background: url('https://www.shutterstock.com/image-photo/white-business-car-moving-on-600nw-1011178438.jpg') no-repeat center center fixed;
        background-size: cover; /* Adjust the background image size */
    }

    .content {
        position: absolute; /* Absolute position to center it */
        top: 50%; /* Center vertically */
        left: 50%; /* Center horizontally */
        transform: translate(-50%, -50%); /* Offset to exactly center */
        text-align: center;
        color: white; /* Change text color to ensure readability */
        padding: 20px;
        background-color: rgba(0, 0, 0, 0.5); /* Semi-transparent background for better contrast */
        border-radius: 10px; /* Optional: rounded corners */
    }
</style>	
</head>
<body>
	<jsp:include page="../common/generalheader.jsp"></jsp:include>

    <div class="container content">
        <!-- Centered h5 and h2 with background image -->
        <h2>Contact US</h2>
        <h5></h5> EMAIL: carrentalzoom@gmail.com</h5>
        <h5>  Office Phone : 08153 -254995 </h5>
    </div>

    <jsp:include page="../common/footer.jsp"></jsp:include>

	
</body>
</html>