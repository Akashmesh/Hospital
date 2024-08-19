<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*,java.sql.*"%>


<%
    boolean check = false;
    // Check if the user is already logged in
//                if (session.getAttribute("isLoggedIn") != null && session.getAttribute("isLoggedIn").toString().equals("Yes")) {
//                    // If the user is already logged in, redirect to the admin dashboard
//                   
//
//                } else {
    // If not logged in, proceed with the login process
    try {
        String user = request.getParameter("username");
        String pass = request.getParameter("password");

        // Only proceed with database operations if both username and password are provided
        if (user != null && pass != null) {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital2", "root", "");

            String sql = "SELECT * FROM adminlogin WHERE User = ? AND Password = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, user);
            st.setString(2, pass);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                check = true;
                // If login is successful, set isLoggedIn attribute to "Yes" and redirect to admin dashboard
                session.setAttribute("isLoggedIn", "Yes");
            } else {
                // Credentials are incorrect, redirect back to adminlogin.html
                response.sendRedirect("adminlogin.html?login=failed");
            }
            con.close();
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
//                    }
    String loginstatus = (String) session.getAttribute("isLoggedIn");

    if (loginstatus == "Yes") {
%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Noto+Sans:ital,wght@0,100..900;1,100..900&display=swap" rel="stylesheet">

        <title>Admin Panel</title>
        <style>
            * {
                margin: 0;
                padding: 0;
                box-sizing: border-box;
            }
            body {
                margin: 0;
                padding: 0;
                height: 100vh;
                background:url("img/adminlogin.jpg");
                background-size: cover;
                background-attachment: fixed;
                font-family: "Noto Sans", sans-serif;
            }
            .navbar {
                overflow: hidden;
                display: flex;
                justify-content: space-between; 
                align-items: center; 
                box-shadow: rgba(0, 0, 0, 0.15) 1.95px 1.95px 2.6px;
                height: 75px;
            }

            #navimg {
                height: 70px;
                width: 90px;
            }

            .link-btns{
                display: flex;
                flex-direction: row;
                justify-content: space-around;
                align-items: center;
                margin-top: 20px;
                width: 30%;
            }

            .link-btn{
                border : 1px solid black;
                border-radius: 15px;
                background-color: greenyellow;
                padding: 15px;
                text-decoration: none;
            }
            .navbar a { 
                color: black;
                text-align: center;
                padding: 14px 20px;
                text-decoration: none;
                text-shadow: 1.5px 1px 2px rgba(255, 255, 255, 1);

            }

            .navbar a:hover {
                background-color: #5a2f90;
                color: white;
                border-radius: 30px;
                box-shadow: 0 2px 4px rgba(0, 0, 0, 0.4); 
                text-shadow: none;

            }
            .navitem {
                margin-left: auto;
                padding: 10px;
            }
            .container {
                display: flex;
                flex-direction: column;
                border: 2px solid black;
                border-style: outset;
                border-radius: 20px;
                /*                height: 350px;*/
                width: 30%;
                margin: 100px auto;
                box-shadow: rgb(38, 57, 77) 0px 20px 30px -10px;
            }
            .heading {
                font-size: 35px;
                font-weight: 600;
                margin-top: 1rem;
                text-align: center;
                letter-spacing: 1px;
                padding: 20px;
                text-shadow: 2px 2px 2px rgba(0,0,0,0.6);

            }
            .box {
                margin-top: 2rem;
            }
            .inputbox {
                border-bottom: 2px solid #000000;
                margin: 10px 75px 25px 40px;
            }
            .inputbox label {
                font-size: 20px;
                font-weight: 500;
                display:block;
                text-align: left;
                letter-spacing: 1.5px;

            }
            .inputbox input{
                font-size: 20px;
                outline: none;
                border: none;
                background: transparent;
                margin-top: 10px;
                width: 100%;
                letter-spacing: 1.5px;
                font-weight: 600;
            }
            .btn {
                color: black;
                background: transparent;
                margin-left: 35%;
                border: 2px solid black;
                width: 30%;
                height: 35px;
                border-radius: 30px;
                font-size: 1rem;
                letter-spacing: 2px;

            }
            .btn:hover {
                background-color: black;
                letter-spacing: 4px;
                color: #ffffff;
            }
            .btn:active {
                transform: scale(0.8);
            } 
            footer {
                padding: 10px;
                text-align: center;
                color: white;
                background-color: #5a2f90;
                font-family: "Inter", sans-serif;
                width: 100%;
                position: fixed;
                bottom: 0;
                /* Push footer to the bottom */
            }
            .dropdown {
                position: relative;
                display: inline-block;
            }

            .dropdown-content {
                display: none;
                position: fixed; 
                background-color: #f9f9f9;
                min-width: 160px;
                box-shadow: 0 2px 4px rgba(0, 0, 0, 0.2);
                z-index: 2;
                margin-top: 15px;
            }

            .dropdown-content a {
                color: black;
                padding: 12px 16px;
                text-decoration: none;
                display: block;
            }

            .dropdown-content a:hover {
                background-color: #5a2f90;
            }

            .dropdown:hover .dropdown-content {
                display: block;
            }
            body {
                font-family: Arial, sans-serif;
            }
            .tab {
                display: none;
            }
            .tab.active {
                display: block;
            }
            .tab-content {
                padding: 20px;
                padding-top:10px !important;

                border: 1px solid #ccc;
                border-top: none;
                text-align: center;
                align-items: center;

            }
            .tabs {
                overflow: hidden;
                border: 1px solid #ccc;
                background-color: #f1f1f1;
            }
            .tab-link {
                float: left;
                border-right: 1px solid #ccc;
                background-color: inherit;
                padding: 10px 20px;
                text-decoration: none;
                color: black;
            }
            .tab-link:last-child {
                border-right: none;
            }
            .tab-link:hover {
                background-color: #ddd;
            }
            .tab-link.active {
                background-color: white;
                border-bottom: 1px solid white;
            }
            ul {
                list-style: none;
                padding: 0;
            }
            ul li {
                margin-bottom: 10px;
            }
        </style>
    </head>
    <body>
        <!-- Navbar -->
        <div class="navbar">
            <a href="index.html"><img id="navimg" src="img/newlogo.png"></a>
            <div class="navitem">
                <a href="index.html">Home</a>
                <div class="dropdown">
                    <a href="#about" id="login-drop">Login</a>
                    <div class="dropdown-content">
                        <a href="administrator.html">Administrator Login</a>
                        <a href="adminlogin.html">Admin Login</a>
                        <a href="receptionistlogin.html">Receptionist's Login</a>
                        <a href="doctorlogin.html">Doctor's Login</a>
                        <a href="patientlogin.html">Patient's Login</a>
                        <!-- Add more login options as needed -->
                    </div>
                </div>
                <a href="Aboutus.html">About Us</a>
                <a href="viewDoctor.jsp">Doctors</a>
                <a href="contact.html">Contact Us</a>
            </div>
        </div>

        <div style="display:flex; flex-direction: column;">

            <div class="heading">Admin Dashboard</div>

            <div class="tabs">
                <a href="#" class="tab-link active" onclick="openTab(event, 'doctors')">Doctors</a>
                <a href="#" class="tab-link" onclick="openTab(event, 'receptionists')">Receptionists</a>
                <a href="#" class="tab-link" onclick="openTab(event, 'patients')">Patients</a>

            </div>

            <div id="doctors" class="tab active">
                <div class="tab-content">
                    <h1>Doctors</h1>
                    <div style="width:100%; align-items: center; justify-content: center; text-align:center; display:flex;">

                        <ul class="link-btns">
                            <li><a href="addNewDoctor.jsp" class="link-btn">Add New Doctor</a></li>
                            <li><a href="adminviewdoctor.jsp" class="link-btn">View Doctor</a></li>
                        </ul>
                    </div>

                </div>
            </div>

            <div id="receptionists" class="tab">
                <div class="tab-content">
                    <h1>Receptionist</h1>
                    <div style="width:100%; align-items: center; justify-content: center; text-align:center; display:flex;">

                        <ul class="link-btns">
                            <li><a href="addNewReceptionist.jsp" class="link-btn">Add New Receptionist</a></li>
                            <li><a href="viewReceptionist.jsp" class="link-btn">View Receptionist</a></li>
                        </ul>
                    </div>
                </div>
            </div>

            <div id="patients" class="tab">
                <div class="tab-content">
                    <h1>Patients</h1>
                    <div style="width:100%; align-items: center; justify-content: center; text-align:center; display:flex;">

                        <ul class="link-btns">

                            <li><a href="viewPatient.jsp" class="link-btn">View Patient</a></li>
                        </ul>

                    </div>
                </div>
            </div>
        </div>

        <footer>
            <p>© 2024 JK Multispecialist Hospital Amravati. All Rights Reserved.</p>
        </footer>


        <script>

            function openTab(evt, tabName) {

                var tabcontent = document.getElementsByClassName("tab");
                for (var i = 0; i < tabcontent.length; i++) {
                    tabcontent[i].style.display = "none";
                }

                // Get all elements with class "tab-link" and remove the "active" class
                var tablinks = document.getElementsByClassName("tab-link");
                for (var i = 0; i < tablinks.length; i++) {
                    tablinks[i].classList.remove("active");
                }

                // Show the selected tab content and mark its link as active
                document.getElementById(tabName).style.display = "block";
                evt.currentTarget.classList.add("active");
            }

        </script>


    </body>
</html>
<%
    } else {
        response.sendRedirect("adminlogin.html");
    }
%>