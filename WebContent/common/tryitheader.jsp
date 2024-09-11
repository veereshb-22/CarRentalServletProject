<header>
    <nav class="navbar navbar-expand-md navbar-dark" style="background-color: grey">
        <div>
            <a class="navbar-brand" href="#"><img
                src="https://th.bing.com/th/id/OIP.D1-9CUxhvfJs84LhtllV2QAAAA?rs=1&pid=ImgDetMain"
                alt="Logo"
                width="30"
                height="30"></a>
            <a href="#" class="navbar-brand"><b>Admin Page</b></a>
        </div>

        <div class="collapse navbar-collapse">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                    <a href="<%= request.getContextPath() %>/driverdisplayservlet" class="nav-link">Driver</a>
                </li>
                <li class="nav-item">
                    <a href="<%= request.getContextPath() %>/userdisplayall" class="nav-link">User</a>
                </li>
                
                <!-- Dropdown Menu -->
                <li class="nav-item dropdown">
                   
                </li>
            </ul>
             <div class="dropdown">
                <button class="dropbtn" onclick="toggleDropdown()">Dropdown</button>
                <div class="dropdown-content">
                    <a href="#">Link 1</a>
                    <a href="#">Link 2</a>
                    <a href="#">Link 3</a>
                </div>
            </div>
        </div>
    </nav>
</header>
<style>
  .dropdown {
            position: relative;
            display: inline-block;
        }

        .dropdown-content {
            display: none;
            position: absolute;
            background-color: #f9f9f9;
            min-width: 160px;
            box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
            z-index: 1;
        }

        .dropdown-content a {
            color: black;
            padding: 12px 16px;
            text-decoration: none;
            display: block;
        }

        .dropdown-content a:hover {background-color: #f1f1f1}

        .dropdown.show .dropdown-content {
            display: block;
        }
    
</style>
               