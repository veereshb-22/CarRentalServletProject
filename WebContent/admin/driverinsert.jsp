<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Driver Registration</title>

<link rel="stylesheet"
    href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
    integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
    crossorigin="anonymous">

<script>
    function validateForm() {
        var emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
        var phonePattern = /^[789][0-9]{9}$/;
        var namePattern = /^.{3,}$/;
        var licensePattern = /^[A-Z]{2}[0-9]{13}$/;

        var email = document.getElementById("useremail").value;
        var phoneNumber = document.getElementById("phonenumber").value;
        var name = document.getElementById("username").value;
        var license = document.getElementById("license").value;

        var emailValid = emailPattern.test(email);
        var phoneValid = phonePattern.test(phoneNumber);
        var nameValid = namePattern.test(name);
        var licenseValid = licensePattern.test(license);

        document.getElementById("emailError").innerHTML = email.length > 0 && !emailValid ? 'Please enter a valid email address.' : '';
        document.getElementById("phoneError").innerHTML = phoneNumber.length > 0 && !phoneValid ? 'Phone number must start with 9, 8, or 7 and be exactly 10 digits.' : '';
        document.getElementById("nameError").innerHTML = name.length > 0 && !nameValid ? 'Name must contain at least 3 characters.' : '';
        document.getElementById("licenseError").innerHTML = license.length > 0 && !licenseValid ? 'License number must be 15 characters long, starting with 2 letters followed by 13 digits.' : '';

        var isFormValid = emailValid && phoneValid && nameValid && licenseValid;
        document.getElementById("submitButton").disabled = !isFormValid;

        return isFormValid;
    }

    function validateInput(input) {
        validateForm(); // Call validateForm to update validation messages and button state
    }

    window.onload = function() {
        validateForm(); // Initialize the submit button state on page load
    }
</script>
</head>
<body>
    <jsp:include page="../common/adminheader.jsp"></jsp:include>
    <div class="container">
        <h2 class="text-center" style="color: orange; text-align: center;">Driver Registration</h2>
        <div class="col-md-8 col-lg-6 mx-auto">
            
            <!-- Display notification message if set -->
            <c:if test="${not empty NOTIFICATION}">
                <div class="alert alert-info text-center">
                    ${NOTIFICATION}
                </div>
            </c:if>

            <form action="<%=request.getContextPath()%>/driverinsertservlet" method="post" onsubmit="return validateForm()">
                <div class="form-group">
                    <label for="username">Name:</label>
                    <input type="text" class="form-control" id="username" placeholder="Name" name="username" required oninput="validateInput(this)">
                    <div id="nameError" style="color: red;"></div>
                </div>

                <div class="form-group">
                    <label for="useremail">Email:</label>
                    <input type="email" class="form-control" id="useremail" placeholder="Email" name="useremail" required oninput="validateInput(this)">
                    <div id="emailError" style="color: red;"></div>
                </div>

                <div class="form-group">
                    <label for="phonenumber">Phone Number:</label>
                    <input type="text" class="form-control" id="phonenumber" placeholder="Phone Number" name="phonenumber" required oninput="validateInput(this)">
                    <div id="phoneError" style="color: red;"></div>
                </div>

                <div class="form-group">
                    <label for="license">License Number:</label>
                    <input type="text" class="form-control" id="license" placeholder="License Number" name="license" required oninput="validateInput(this)">
                    <div id="licenseError" style="color: red;"></div>
                </div>

                <div class="text-center">
                    <button type="submit" class="btn btn-primary" id="submitButton" disabled>Allocate</button>
                </div>
            </form>
        </div>
    </div>
    <hr>
    <jsp:include page="../common/footer.jsp"></jsp:include>
</body>
</html>
