<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Car Assignment</title>

<!-- Bootstrap CSS -->
<link rel="stylesheet"
    href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
    integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
    crossorigin="anonymous">

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
    integrity="sha384-q8i/X+965DzO0rT7abK3gXo0b3zcfKz6z2rB7U0k0G0F7ph1E9n3J2e4dEjXiqd1"
    crossorigin="anonymous"></script>
    
<!-- Popper.js -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
    integrity="sha384-UOa5cLxSTUleG24H6lz6xFmgGQz9GCh2uAlJUlXr0Q47FLUFSzLJz4O7rC1Is8cB"
    crossorigin="anonymous"></script>
    
<!-- Bootstrap JS -->
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
    integrity="sha384-fXdVvs8CmH2rmZpPWhBzz73k6EcmjCk8Uq2kS4J2Ak7Ab4D8W/2Sm9qjzNwslX"
    crossorigin="anonymous"></script>

<!-- Custom JavaScript -->
<script>
    function validateCarNumber(input) {
        var carNumberPattern = /^[A-Z]{2}\s\d{2}\s[A-Z]{2}\s\d{4}$/;
        var value = input.value;
        var errorMessage = '';

        if (!carNumberPattern.test(value)) {
            errorMessage = 'Please enter a valid car number plate (e.g., MH 12 AB 1234).';
        }

        document.getElementById('carNumberError').textContent = errorMessage;
    }
</script>

</head>
<body>
    <jsp:include page="../common/adminheader.jsp"></jsp:include>
    <div class="container">
        <h2 class="text-center" style="color: orange; text-align: center;">Car Assignment </h2>
        <div class="col-md-6 col-md-offset-3">
            <form action="<%=request.getContextPath()%>/addedcartodriver" method="post">
                <div class="form-group">
                    <label for="carNumber">Car Number Plate:</label>
                    <input type="text" class="form-control" id="carNumber" placeholder="Car Number Plate" name="carNumber" required oninput="validateCarNumber(this)">
                    <div id="carNumberError" style="color: red;"></div>
                </div>
                <div class="form-group">
                    <label for="carModel">Car Model:</label>
                    <input type="text" class="form-control" id="carModel" placeholder="Car Model" name="carModel" required>
                </div>
                
                <div class="form-group">
                    <label for="carType">Car Type:</label>
                    <select class="form-control" id="carType" name="carType" required>
                        <option value="">Select Car Type</option>
                        <option value="SUV">SUV</option>
                        <option value="Sedan">Sedan</option>
                        <option value="Coupe">Coupe</option>
                        <option value="MPV">MPV</option>
                    </select>
                </div>
                
                <div>
                    <button type="submit" class="btn btn-primary">ENTER</button>
                </div>

            </form>        
        </div>
    </div>
    <hr>
    <jsp:include page="../common/footer.jsp"></jsp:include>
</body>
</html>
