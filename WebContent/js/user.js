
function validateUsername() {
    var username = document.getElementById("username").value;
    var usernamePattern = /^[a-zA-Z0-9._%+-]+@(gmail\.com|hotmail\.com)$/;
    var usernameError = document.getElementById("usernameError");

    if (!usernamePattern.test(username)) {
        usernameError.innerHTML = "Username must end with @gmail.com or @hotmail.com.";
    } else {
        usernameError.innerHTML = "";
    }
}

function validatePassword() {
    var password = document.getElementById("password").value;
    var passwordError = document.getElementById("passwordError");

    if (password.length < 6) {
        passwordError.innerHTML = "Password must be at least 6 characters long.";
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
vaildateForm();