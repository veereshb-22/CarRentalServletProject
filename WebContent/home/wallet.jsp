<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Wallet Recharge</title>
<link rel="stylesheet"
    href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
    integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
    crossorigin="ansonymous">
    <script>
	function showAlert() {
    alert('Recharge Successful!');
	}
	</script>
</head>
<body>

	<jsp:include page="../common/homeheader.jsp"></jsp:include>
    <div class="container col-md-8 col-md-offset-3" style="overflow: auto">
    	<br>
        <h2 style="color: orange; text-align: center;"><b>Profile</b></h2>
        <br>
        <form action="<%=request.getContextPath()%>/walletrecharge" method="post" id="user" onsubmit="showAlert()" >
        
        	 <div class="form-group">
                <label> User Email:<%= session.getAttribute("username") %></label> 
            </div>
            
             <div class="form-group">
                <label> Current Amount  <%= session.getAttribute("userwallet") %></label> 
            </div>
         
        
            <div class="form-group">
                <label for="uname">Recharge Wallet</label> 
                <input type="number" class="form-control" id="user_wallet" 
                placeholder="Recharge Amount" name="user_wallet" >  
            </div>
         

            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
    </div>
    <jsp:include page="../common/footer.jsp"></jsp:include>

</body>
</html>