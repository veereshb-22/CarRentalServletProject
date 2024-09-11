<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
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
        .error-message {
            color: red;
            font-weight: normal;
        }
    </style>
    <script>
        function validateForm() {
            var startLocation = document.getElementById("startLocationf").value;
            var endLocation = document.getElementById("endLocationf").value;
            var bookingDate = document.getElementById("bookingDate").value;
            var errorMessages = [];
            
            // Clear previous errors
            document.getElementById("startLocationError").innerHTML = "";
            document.getElementById("endLocationError").innerHTML = "";
            document.getElementById("dateError").innerHTML = "";

            // Check if start and end locations are the same
            if (startLocation === endLocation) {
                document.getElementById("startLocationError").innerHTML = "Starting and ending locations should not be the same.";
            }

            // Check if date is current or future
            var today = new Date().toISOString().split('T')[0];
            if (bookingDate && bookingDate < today) {
                document.getElementById("dateError").innerHTML = "Date must be current or a future date.";
            }

            if (document.getElementById("startLocationError").innerHTML || document.getElementById("endLocationError").innerHTML || document.getElementById("dateError").innerHTML) {
                return false;
            }

            return true;
        }

        function setupValidation() {
            var startLocation = document.getElementById("startLocationf");
            var endLocation = document.getElementById("endLocationf");
            var bookingDate = document.getElementById("bookingDate");

            startLocation.addEventListener("input", validateForm);
            endLocation.addEventListener("input", validateForm);
            bookingDate.addEventListener("input", function() {
                validateForm();
                if (!this.value) {
                    document.getElementById("dateError").innerHTML = "";
                }
            });
        }

        window.onload = setupValidation;
    </script>
</head>
<body>
    <jsp:include page="../common/homeheader.jsp"></jsp:include>
    <div class="container">
        <div class="form-container">
            <h2 class="my-4 text-center" style="color: orange; text-align: center;">Select Location</h2>
            <form action="<%=request.getContextPath()%>/bookingcarservlet" method="post" onsubmit="return validateForm()">
                <div class="form-group">
                    <label for="startLocation">Starting Location</label>
                    <select id="startLocationf" name="startLocationf" class="form-control" required>
                        <c:forEach var="location" items="${startingLocations}">
                            <option value="${location}">${location}</option>
                        </c:forEach>
                        <option value="VijayNagar">Vijay Nagar</option>
                    </select>
                    <div id="startLocationError" class="error-message"></div>
                </div>
               
                <div class="form-group">
                    <label for="endLocation">Ending Location</label>
                    <select id="endLocationf" name="endLocationf" class="form-control" required>
                        <c:forEach var="location" items="${endingLocations}">
                            <option value="${location}">${location}</option>
                        </c:forEach>
                        <option value="VijayNagar">Vijay Nagar</option>
                    </select>
                    <div id="endLocationError" class="error-message"></div>
                </div>
              
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="bookingDate">Date</label>
                        <input type="date" id="bookingDate" name="bookingDate" class="form-control" required>
                        <div id="dateError" class="error-message"></div>
                    </div>
                 
                    <div class="form-group col-md-6">
                        <label for="bookingTime">Time</label>
                        <input type="time" id="bookingTime" name="bookingTime" class="form-control" required>
                    </div>
               
                </div>
                <button type="submit" class="btn btn-primary btn-block">Find Ride</button>
            </form>
        </div>
    </div>
   	<jsp:include page="../common/footer.jsp"></jsp:include>
   
</body>
</html>
