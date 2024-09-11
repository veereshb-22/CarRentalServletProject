<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Payment Successful</title>
    <style>
        /* Basic reset */
        body {
            margin: 0;
            padding: 0;
            font-family: Arial, sans-serif;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            background-color: #f4f4f4;
        }
        .container {
            display: grid;
            place-items: center;
            text-align: center;
            gap: 20px; /* Space between elements */
        }
        .message {
            font-size: 24px;
            font-weight: bold;
            color: #4CAF50;
        }
        .tick img {
            max-width: 100px; /* Adjust size as needed */
            height: auto;
        }
        .button-container {
            display: flex;
            justify-content: center;
        }
        .button {
            background-color: #4CAF50; /* Green background */
            color: white; /* White text */
            border: none;
            padding: 10px 20px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
            margin: 10px 0;
            border-radius: 5px; /* Rounded corners */
            cursor: pointer;
            transition: background-color 0.3s ease;
        }
        .button:hover {
            background-color: #45a049; /* Darker green on hover */
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="message">Payment Successful</div>
        <div class="tick">
            <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTm_rFiKLD7kMeP6uMeCVK8aeLjXN5JixG_VkKFHHrcJw1ttqS5n8EU2iKAuw&s" alt="Success Tick">
        </div>
        <div class="button-container">
            <a href="<%= request.getContextPath() %>/bookinguserservlet"class="nav-link">RETURN</a>
        </div>
    </div>
</body>
</html>
