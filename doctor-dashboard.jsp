<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Doctor Dashboard</title>
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Noto+Sans:ital,wght@0,100..900;1,100..900&display=swap" rel="stylesheet">

        <!-- Add any CSS styles here if needed -->
        <style>
            body {
                margin: 0;
                padding: 0;
                background:url("img/adminlogin.jpg");
                background-size: cover;
                background-attachment: fixed;
                font-family:  sans-serif;
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

            .navbar a { 
                color: black;
                text-align: center;
                padding: 14px 20px;
                text-decoration: none;
                text-shadow: 1.5px 1px 2px rgba(255, 255, 255, 1);

            }

            .navitem a:hover {
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
                height: 100vh !important;
                width: 60%;
                margin: 50px auto;
                box-shadow: rgb(38, 57, 77) 0px 20px 30px -10px;
            }
            .heading {
                font-size: 35px;
                font-weight: 600;
                margin-top: 1rem;
                text-align: center;
                letter-spacing: 1px;

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
                margin-top: -10px;
                padding-top: 7px;
                text-align: center;
                color: white;
                background-color: #5a2f90;
                height: 55px;
                position: absolute;
                bottom: -225px;
                width: 100%;
                font-family: "Inter",sans-serif;
            }
            .dropdown {
                position: relative;
                display: inline-block;
            }

            .dropdown-content {
                display: none;
                position: fixed; /* Change to fixed */
                background-color: #f9f9f9;
                min-width: 160px;
                boxshadow: 0 2px 4px rgba(0, 0, 0, 0.2);
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
            table {
                width: 80%;
                border-collapse: collapse;
                margin: 0 auto;
                background-color: white;
            }
            th, td {
                padding: 8px;
                padding-right:0px !important;
                border-bottom: 1px solid #ddd;
                text-align: left;
            }
            th {
                background-color: #f2f2f2;
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
                        <a href="adminlogin.html">Admin Login</a>
                        <a href="receptionistlogin.html">Receptionist's Login</a>
                        <a href="doctorlogin.html">Doctor's Login</a>
                        <a href="patientlogin.html">Patient's Login</a>
                        <!-- Add more login options as needed -->
                    </div>
                </div>
                <a href="Aboutus.html">About Us</a>
                <a href="viewDoctor.jsp">Doctors</a>
                <a href="onlinepatientreg.jsp">Book Apointment Online</a>
                <a href="contact.html">Contact Us</a>
            </div>
        </div>
        <div class="container">
            <center>
                <h2>Doctor Dashboard</h2>
            </center>
            <%-- Establish database connection --%>
            <%@ page import="java.sql.*" %>
            <%
                String url = "jdbc:mysql://localhost:3306/hospital2";
                String username = "root";
                String password = "";

                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection(url, username, password);
                    Statement stmt = con.createStatement();
                    String doctorName = (String)session.getAttribute("doctor_name");
                    // Get current date
                    java.util.Date currentDate = new java.util.Date();
                    java.sql.Date sqlCurrentDate = new java.sql.Date(currentDate.getTime());

                    ResultSet rs = stmt.executeQuery("SELECT * FROM patientreg WHERE Doctor='" + doctorName + "' AND status='Offline' AND Date='" + sqlCurrentDate + "'");
            %>

            <%-- Display fetched data in a table --%>
            <table>
                <thead>
                    <tr>
                        <th>Appointment No</th>
                        <th>Name</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <%  
                    int i = 1;
                    while (rs.next()) {
                    %>
                    <tr>
                        <td><%= i++ %></td>
                        <td><%= rs.getString("Name") %></td>
                        <td><a href='doctor.jsp?patient_id=<%= rs.getString("MobileNo") %>' style="text-decoration:none; background-color: greenyellow; border: 1px solid black; border-radius:10px; padding: 5px;">Give Prescription</td>       
                    </tr>
                    <% 
                    } 
                    %>
                </tbody>
            </table>
        </div>
        <footer>
            <p>© 2024 JK Multispecialist Hospital Amravati. All Rights Reserved.</p>
        </footer>
        <%
                // Close database connection
                rs.close();
                stmt.close();
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        %>
    </body>
</html>

