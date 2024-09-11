
<header>
	<nav class="navbar navbar-expand-md navbar-dark"
		style="background-color: grey">
		<div>
			 <a class="navbar-brand" href="#" ><img
                    src="https://th.bing.com/th/id/OIP.D1-9CUxhvfJs84LhtllV2QAAAA?rs=1&pid=ImgDetMain" 
                    alt="" 
                    width="30"
                    height="30"></a>
			<a href="#" class="navbar-brand" style="color: orange; font-weight: bold;"><b>Welcome  <%= session.getAttribute("username") %></b></a>
		</div>

		<ul class="navbar-nav navbar-collapse justify-content-end">
			<li><a href="<%= request.getContextPath() %>/bookinguserservlet"class="nav-link" style="color: orange; font-weight: bold;">Booking</a></li> 
			<li><a href="<%= request.getContextPath() %>/userbookedlist" class="nav-link" style="color: orange; font-weight: bold;">Booking Transaction</a></li>
			<li><a href="<%= request.getContextPath() %>/usertransactionservlet" class="nav-link" style="color: orange; font-weight: bold;">Transaction</a></li>
			<li><a href="<%= request.getContextPath() %>/walletrecharge"class="nav-link" style="color: orange; font-weight: bold;">Profile</a></li>
			<li><a href="<%= request.getContextPath() %>/logoutservlet" class="nav-link"style="color: orange; font-weight: bold;">Logout</a></li>
		</ul>
	</nav>
</header>