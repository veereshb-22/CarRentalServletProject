<header>
	<nav class="navbar navbar-expand-md navbar-dark"
		style="background-color: grey">
		<div>
			 <a class="navbar-brand" href="#"><img
                    src=
"https://th.bing.com/th/id/OIP.D1-9CUxhvfJs84LhtllV2QAAAA?rs=1&pid=ImgDetMain" 
                    alt="" 
                    width="30"
                    height="30"></a>
			<a href="#" class="navbar-brand" style="color: orange; font-weight: bold;"><b>Welcome  <%= session.getAttribute("admin") %></b></a>
		</div>

		<ul class="navbar-nav navbar-collapse justify-content-end">
			<li><a href="<%= request.getContextPath() %>/userdisplayall" class="nav-link" style="color: orange; font-weight: bold;">User</a></li>
			<li><a href="<%= request.getContextPath() %>/driverdisplayservlet" class="nav-link" style="color: orange; font-weight: bold;">Driver</a></li>
			<li><a href="<%= request.getContextPath() %>/bookingdisplayservlet" class="nav-link" style="color: orange; font-weight: bold;">Booking</a></li>
			<li><a href="<%= request.getContextPath() %>/activedriverservlet" class="nav-link" style="color: orange; font-weight: bold;">Manage Driver</a></li>
			<li><a href="<%= request.getContextPath() %>/cardisplayadminservlet" class="nav-link" style="color: orange; font-weight: bold;">Car</a></li>			
			<li><a href="<%= request.getContextPath() %>/admin/driverinsert.jsp" class="nav-link" style="color: orange; font-weight: bold;">Add Driver</a></li>
			<li><a href="<%= request.getContextPath() %>/transactiondisplayservlet" class="nav-link" style="color: orange; font-weight: bold;">Transaction</a></li>	
			<li><a href="<%= request.getContextPath() %>/logoutservlet" class="nav-link" style="color: orange; font-weight: bold;">Logout</a></li>	
					
		</ul>
			
	</nav>
</header>