<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Rai Car Rental System</title>
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
            background-color: rgba(0, 0, 0, 0.7); /* Semi-transparent background for better contrast */
            border-radius: 10px; /* Optional: rounded corners */
            max-width: 600px; /* Limit the width of the content */
            width: 90%; /* Responsive width */
            box-sizing: border-box; /* Include padding in width calculation */
        }

        p {
            margin-bottom: 15px; /* Spacing between paragraphs */
        }
    </style>
</head>
<body>
    <jsp:include page="../common/generalheader.jsp"></jsp:include>

    <div class="container content">
        <h2>Rai Car Rental System</h2>
        <div>
        <p>In 2024, Rai revolutionized the car rental industry with the launch of his innovative car rental system. Rai's vision was to create a service that transcended traditional rental models by incorporating advanced technology and a user-centric approach.
        The Rai Car Rental System is distinguished by its seamless integration of cutting-edge features designed to enhance the customer experience. Utilizing an intuitive mobile app and a user-friendly website, customers can effortlessly browse available vehicles, select their preferences, and complete transactions with just a few taps.
        The platform offers a diverse fleet of vehicles ranging from eco-friendly hybrids to luxurious SUVs, catering to various needs and preferences.</p>
       
       	</div>
    </div>

    <jsp:include page="../common/footer.jsp"></jsp:include>

</body>
</html>
