<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Registration</title>

<link rel="stylesheet"
    href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
    integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
    crossorigin="anonymous">

<script>
    function validateField(fieldId, pattern, minLength, errorMessage) {
        var field = document.getElementById(fieldId);
        var value = field.value;
        var errorDiv = document.getElementById(fieldId + 'Error');
        if (value.length === 0) {
            errorDiv.innerHTML = "";
            return false;
        }
        if (value.length < minLength) {
            errorDiv.innerHTML = errorMessage;
            return false;
        }
        if (pattern && !pattern.test(value)) {
            errorDiv.innerHTML = errorMessage;
            return false;
        }
        errorDiv.innerHTML = "";
        return true;
    }

    function validateForm() {
        var isValid = true;

        // Validate each field
        isValid &= validateField('userfname', null, 3, "First Name must be at least 3 characters long.");
        isValid &= validateField('userlname', null, 1, "Last Name is required.");
        isValid &= validateField('useremail', /^[^\s@]+@[^\s@]+\.[^\s@]+$/, 1, "Please enter a valid email address.");
        isValid &= validateField('password', null, 1, "Password is required.");
        isValid &= validateField('phonenumber', /^[789][0-9]{9}$/, 10, "Phone number must be exactly 10 digits, starting with 7, 8, or 9.");
        isValid &= validateField('wallet', /^[0-9]+$/, 1, "Wallet must be a numeric value.");
        isValid &= validateField('age', /^[0-9]+$/, 1, "Age must be a numeric value.");

        // Additional age validation
        var age = parseInt(document.getElementById('age').value);
        if (age <= 14) {
            document.getElementById('ageError').innerHTML = "Age must be greater than 14.";
            isValid = false;
        } else {
            document.getElementById('ageError').innerHTML = "";
        }

        // Display or hide submit button based on form validity
        document.getElementById('submitButton').disabled = !isValid;

        return isValid;
    }

    function setupValidation() {
        var fields = ['userfname', 'userlname', 'useremail', 'password', 'phonenumber', 'wallet', 'age'];
        fields.forEach(function(fieldId) {
            document.getElementById(fieldId).addEventListener('input', function() {
                validateField(fieldId, null, 1, "");
                validateForm();
            });
        });
    }

    window.onload = setupValidation;
</script>
</head>
<body>
    <jsp:include page="../common/generalheader.jsp"></jsp:include>
    <div class="container d-flex justify-content-center align-items-center" style="min-height: 100vh;">
        <div class="col-md-8 col-lg-6">
            <!-- Display registration message if set -->
            <c:if test="${not empty NOTIFICATION}">
                <div class="alert alert-info">
                    ${NOTIFICATION}
                </div>
            </c:if>

            <h2 class="text-center"  style="color: orange; text-align: center;">Sign Up</h2>
            <form action="<%=request.getContextPath()%>/register" method="post" onsubmit="return validateForm()">
                <div class="form-group">
                    <label for="userfname">First Name:</label>
                    <input type="text" class="form-control" id="userfname" placeholder="First Name" name="userfname">
                    <div id="userfnameError" style="color: red;"></div>
                </div>

                <div class="form-group">
                    <label for="userlname">Last Name:</label>
                    <input type="text" class="form-control" id="userlname" placeholder="Last Name" name="userlname">
                    <div id="userlnameError" style="color: red;"></div>
                </div>

                <div class="form-group">
                    <label for="useremail">Email:</label>
                    <input type="email" class="form-control" id="useremail" placeholder="Email" name="useremail">
                    <div id="useremailError" style="color: red;"></div>
                </div>

                <div class="form-group">
                    <label for="password">Password:</label>
                    <input type="password" class="form-control" id="password" placeholder="Password" name="password">
                    <div id="passwordError" style="color: red;"></div>
                </div>

                <div class="form-group">
                    <label for="phonenumber">Phone Number:</label>
                    <input type="text" class="form-control" id="phonenumber" placeholder="Phone Number" name="phonenumber">
                    <div id="phonenumberError" style="color: red;"></div>
                </div>

                <div class="form-group">
                    <label for="wallet">Wallet:</label>
                    <input type="number" class="form-control" id="wallet" placeholder="Wallet" name="wallet">
                    <div id="walletError" style="color: red;"></div>
                </div>

                <div class="form-group">
                    <label for="age">Age:</label>
                    <input type="number" class="form-control" id="age" placeholder="Age" name="age">
                    <div id="ageError" style="color: red;"></div>
                </div>

                <div id="errorMessages" style="color: red; font-weight: bold;"></div>

                <div class="text-center">
                    <button type="submit" class="btn btn-primary" id="submitButton" disabled>Sign Up</button>
                </div>
                <br>
            </form>
        </div>
    </div>
    <br>
    <jsp:include page="../common/footer.jsp"></jsp:include>
</body>
</html>
