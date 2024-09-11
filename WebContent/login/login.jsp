<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link rel="stylesheet"
    href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
    integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
    crossorigin="anonymous">
<script>
    function validateUsername() {
        var username = document.getElementById("username").value;
        var emailPattern = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
        var usernameError = document.getElementById("usernameError");

        if (!emailPattern.test(username)) {
            usernameError.innerHTML = "Please enter a valid email address.";
        } else {
            usernameError.innerHTML = "";
        }
    }

    function validatePassword() {
        var password = document.getElementById("password").value;
        var passwordError = document.getElementById("passwordError");
        var passwordPattern = /^(?=.*[!@#$%^&*()_+{}\[\]:;"'<>,.?~`]).{6,}$/; // At least 6 characters long and contains at least one special character

        if (password.length < 6) {
            passwordError.innerHTML = "Password must be at least 6 characters long.";
        } else if (!passwordPattern.test(password)) {
            passwordError.innerHTML = "Password must contain at least one special character.";
        } else {
            passwordError.innerHTML = "";
        }
    }

    function validateForm() {
        validateUsername();
        validatePassword();
        var usernameError = document.getElementById("usernameError").innerHTML;
        var passwordError = document.getElementById("passwordError").innerHTML;

        if (usernameError || passwordError) {
            return false;
        }
        return true;
    }

    window.onload = function() {
        var globalErrorDiv = document.getElementById("globalError");
        // Retrieve and display the error message
        var errorMessage = '<%= session.getAttribute("errorMessage") != null ? session.getAttribute("errorMessage") : "" %>';
        
        if (errorMessage && errorMessage.trim() !== "") {
            globalErrorDiv.innerHTML = errorMessage;
            // Remove the error message from session after displaying it
            <%
                session.removeAttribute("errorMessage");
            %>
        } else {
            globalErrorDiv.innerHTML = ""; // Clear error message if not present or empty
        }
    }
</script>
</head>
<body>

    <jsp:include page="../common/generalheader.jsp"></jsp:include>

    <!-- Main Content -->
    <div class="d-flex justify-content-center align-items-center" style="min-height: 100vh; background-color: #f8f9fa;">
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-md-6">
                    <div class="card p-4 shadow-sm">
                        <h2 class="text-center mb-4">Sign In</h2>
                        <div id="globalError" style="color: red; text-align: center;"></div>
                        <form action="<%=request.getContextPath()%>/login" method="post" id="user" onsubmit="return validateForm()">
                            <div class="form-group">
                                <label for="username">User Email:</label>
                                <input type="email" class="form-control" id="username" placeholder="User Email" name="useremail" required oninput="validateUsername()">
                                <div id="usernameError" style="color: red; font-weight: normal;"></div>
                            </div>
                            <div class="form-group">
                                <label for="password">Password:</label>
                                <input type="password" class="form-control" id="password" placeholder="Password" name="password" required oninput="validatePassword()">
                                <div id="passwordError" style="color: red; font-weight: normal;"></div>
                            </div>
                            <button type="submit" class="btn btn-primary w-100">Login</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
	<jsp:include page="../common/footer.jsp"></jsp:include>
	
    <!-- Include Bootstrap JS and dependencies -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK3aRz8t5nEj7/8U1L/eMO6U6p6xM+3/E6ltFuW5dV5WbB" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UOaM5B5Bz7lv0A0g9yKAtAKP6a6fyOg80x3b3SYt4epPZpuLkFJwX89hp/5Vt9zD" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-s4F2yW1Fq8A3X5U9T8l3RaE6M4I6X8pF90xF6STfU+2T3FfZZ9E5Li0Y2b9S4yJ0" crossorigin="anonymous"></script>
    
</body>
</html>
    