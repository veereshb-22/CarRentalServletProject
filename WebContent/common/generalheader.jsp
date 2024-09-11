
<header>
	<nav class="navbar navbar-expand-md navbar-dark"
		style="background-color: grey">
		<div>
			 <a class="navbar-brand" href="#">
			 <img src="https://th.bing.com/th/id/OIP.D1-9CUxhvfJs84LhtllV2QAAAA?rs=1&pid=ImgDetMain" alt="" width="30" height="30"></a>
			<a href="#" class="navbar-brand" style="color: orange; font-weight: bold;"><b>CRS</b></a>
		</div>

		<ul class="navbar-nav navbar-collapse justify-content-end">
			<li><a href="<%= request.getContextPath() %>/general/generalhome.jsp" class="nav-link" style="color: orange; font-weight: bold;">Home</a></li>
			<li><a href="<%= request.getContextPath() %>/general/generalcontact.jsp" class="nav-link" style="color: orange; font-weight: bold;">Contact</a></li>
			<li><a href="<%= request.getContextPath() %>/general/generalabout.jsp" class="nav-link" style="color: orange; font-weight: bold;">About</a></li>
			<li><a href="<%= request.getContextPath() %>/login" class="nav-link" style="color: orange; font-weight: bold;">Sign In</a></li>
			<li><a href="<%= request.getContextPath() %>/register" class="nav-link" style="color: orange; font-weight: bold;">Sign Up</a></li>
		</ul>
	</nav>
</header>