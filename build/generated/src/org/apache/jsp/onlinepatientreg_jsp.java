package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
import java.io.PrintWriter;
import java.util.*;
import java.sql.*;
import java.sql.DriverManager;
import java.util.Random;

public final class onlinepatientreg_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


    // Generate Random Password Method
    private String generateRandomPassword() {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder sb = new StringBuilder();
        java.util.Random rnd = new java.util.Random();
        while (sb.length() < 10) {
            int index = (int) (rnd.nextFloat() * chars.length());
            sb.append(chars.charAt(index));
        }
        String password = sb.toString();
        return password;
    }

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");

//  Integer reclogin = (Integer) session.getAttribute("reclogin");
    int id;
    if (request.getParameter("id") == null || request.getParameter("id").isEmpty()) {
        String rloginStatus = "No"; // Default value is "No"

        //        rloginStatus = "Yes"; // Set rloginStatus to "Yes" if id is provided
        //    int id = Integer.parseInt(request.getParameter("id"));

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Online Patient Reg</title>\n");
      out.write("        <style>\n");
      out.write("\n");
      out.write("            body{\n");
      out.write("                margin: 0;\n");
      out.write("                padding: 0;\n");
      out.write("                background-image: url('img/doctorlogin.jpg');\n");
      out.write("                background-size: cover;\n");
      out.write("                background-position: center;\n");
      out.write("                background-repeat: no-repeat;\n");
      out.write("                /*                    height: 100vh;*/\n");
      out.write("\n");
      out.write("                font-family: sans-serif;\n");
      out.write("\n");
      out.write("            }\n");
      out.write("                    \n");
      out.write("            .navbar {\n");
      out.write("                background-color: white;\n");
      out.write("                display: flex;\n");
      out.write("                flex-direction: row;\n");
      out.write("                justify-content: space-between;\n");
      out.write("                align-items: center; /* Center vertically */\n");
      out.write("                height: 70px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            #navimg {\n");
      out.write("                height: 70px;\n");
      out.write("                width: 90px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .navbar a {\n");
      out.write("                color: black;\n");
      out.write("                text-align: center;\n");
      out.write("                padding: 14px 20px;\n");
      out.write("                text-decoration: none;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .navitem a:hover {\n");
      out.write("                background-color: #5a2f90;\n");
      out.write("                color: white;\n");
      out.write("                border-radius: 30px;\n");
      out.write("                box-shadow: 0 2px 4px rgba(0, 0, 0, 0.4);\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .navitem {\n");
      out.write("                margin-left: auto;\n");
      out.write("                padding: 15px;\n");
      out.write("                /* position: relative;*/\n");
      out.write("                z-index: 2;\n");
      out.write("            }\n");
      out.write("            .dropdown {\n");
      out.write("                position: relative;\n");
      out.write("                display: inline-block;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .dropdown-content {\n");
      out.write("                display: none;\n");
      out.write("                position: fixed; /* Change to fixed */\n");
      out.write("                background-color: #f9f9f9;\n");
      out.write("                min-width: 160px;\n");
      out.write("                box-shadow: 0 2px 4px rgba(0, 0, 0, 0.2);\n");
      out.write("                z-index: 2;\n");
      out.write("                margin-top: 15px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .dropdown-content a {\n");
      out.write("                color: black;\n");
      out.write("                padding: 12px 16px;\n");
      out.write("                text-decoration: none;\n");
      out.write("                display: block;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .dropdown-content a:hover {\n");
      out.write("                background-color: #5a2f90;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .dropdown:hover .dropdown-content {\n");
      out.write("                display: block;\n");
      out.write("            }\n");
      out.write("            input[type=\"number\"] {\n");
      out.write("                -moz-appearance: textfield; /* Firefox */\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            input[type=\"number\"]::-webkit-inner-spin-button,\n");
      out.write("            input[type=\"number\"]::-webkit-outer-spin-button { /* WebKit */\n");
      out.write("                -webkit-appearance: none;\n");
      out.write("                margin: 0; /* Removes the default margin */\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .container {\n");
      out.write("                width: 40%;\n");
      out.write("                margin: 5px auto;\n");
      out.write("\n");
      out.write("                padding: 20px;\n");
      out.write("                border-radius: 8px;\n");
      out.write("                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);\n");
      out.write("                background: none;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            h1 {\n");
      out.write("                text-align: center;\n");
      out.write("                color: #333;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            table {\n");
      out.write("                width: 80%;\n");
      out.write("                border-collapse: collapse;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            table td {\n");
      out.write("                padding: 10px;\n");
      out.write("                border-bottom: 1px solid #ccc;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            table td:first-child {\n");
      out.write("                width: 30%;\n");
      out.write("                font-weight: bold;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            input[type=\"text\"],\n");
      out.write("            input[type=\"number\"],\n");
      out.write("            textarea {\n");
      out.write("                width: calc(100% - 20px);\n");
      out.write("                padding: 8px;\n");
      out.write("                border: 1px solid #ccc;\n");
      out.write("                border-radius: 5px;\n");
      out.write("                box-sizing: border-box;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            input[type=\"submit\"] {\n");
      out.write("                width: 50%;\n");
      out.write("                padding: 10px;\n");
      out.write("                background-color: #5a2f90;\n");
      out.write("                color: white;\n");
      out.write("                border: none;\n");
      out.write("                border-radius: 5px;\n");
      out.write("                cursor: pointer;\n");
      out.write("                font-size: 16px;\n");
      out.write("                margin-top: 10px;\n");
      out.write("                margin-left:30%;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            input[type=\"submit\"]:hover {\n");
      out.write("                box-shadow: 0 2px 4px rgba(0, 0, 0, 0.9);\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .radio-group {\n");
      out.write("                display: flex;\n");
      out.write("                align-items: center;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .radio-group input[type=\"radio\"] {\n");
      out.write("                margin-right: 5px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .subscript {\n");
      out.write("                vertical-align: super;\n");
      out.write("                font-size: 80%;\n");
      out.write("            }\n");
      out.write("            footer {\n");
      out.write("                background-color: #5a2f90;\n");
      out.write("                color: white;\n");
      out.write("                text-align: center;\n");
      out.write("                padding: 10px;\n");
      out.write("                margin-bottom: -18px;\n");
      out.write("                clear: both;  /*Added to clear float */\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            footer p {\n");
      out.write("                color: white;\n");
      out.write("            }\n");
      out.write("            select {\n");
      out.write("                width: calc(100% - 20px);\n");
      out.write("                padding: 8px;\n");
      out.write("                border: 1px solid #ccc;\n");
      out.write("                border-radius: 5px;\n");
      out.write("                box-sizing: border-box;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .tab {\n");
      out.write("                display: none;\n");
      out.write("            }\n");
      out.write("            .tab.active {\n");
      out.write("                display: block;\n");
      out.write("            }\n");
      out.write("            .tab-content {\n");
      out.write("                padding: 20px;\n");
      out.write("                padding-top:10px !important;\n");
      out.write("\n");
      out.write("                border: 1px solid #ccc;\n");
      out.write("                border-top: none;\n");
      out.write("                text-align: center;\n");
      out.write("                align-items: center;\n");
      out.write("\n");
      out.write("            }\n");
      out.write("            .tabs {\n");
      out.write("                overflow: hidden;\n");
      out.write("                border: 1px solid #ccc;\n");
      out.write("                background-color: #f1f1f1;\n");
      out.write("            }\n");
      out.write("            .tab-link {\n");
      out.write("                float: left;\n");
      out.write("                border-right: 1px solid #ccc;\n");
      out.write("                background-color: inherit;\n");
      out.write("                padding: 10px 20px;\n");
      out.write("                text-decoration: none;\n");
      out.write("                color: black;\n");
      out.write("            }\n");
      out.write("            .tab-link:last-child {\n");
      out.write("                border-right: none;\n");
      out.write("            }\n");
      out.write("            .tab-link:hover {\n");
      out.write("                background-color: #ddd;\n");
      out.write("            }\n");
      out.write("            .tab-link.active {\n");
      out.write("                background-color: white;\n");
      out.write("                border-bottom: 1px solid white;\n");
      out.write("            }\n");
      out.write("            ul {\n");
      out.write("                list-style: none;\n");
      out.write("                padding: 0;\n");
      out.write("            }\n");
      out.write("            ul li {\n");
      out.write("                margin-bottom: 10px;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("        <!-- Your head content goes here -->\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("        <div class=\"navbar\" style=\"display:flex; flex-direction: row; justify-content: space-between;\">\n");
      out.write("            <div> <a href=\"index.html\"><img id=\"navimg\" src=\"img/newlogo.png\"></a></div>\n");
      out.write("            <div class=\"navitem\"> <a href=\"index.html\">Home</a>\n");
      out.write("                <div class=\"dropdown\">\n");
      out.write("                    <a href=\"#about\" id=\"login-drop\">Login</a>\n");
      out.write("                    <div class=\"dropdown-content\">\n");
      out.write("                        <a href=\"administrator.html\">Administrator Login</a>\n");
      out.write("                        <a href=\"adminlogin.html\">Admin Login</a>\n");
      out.write("                        <a href=\"receptionistlogin.html\">Receptionist's Login</a>\n");
      out.write("                        <a href=\"doctorlogin.html\">Doctor's Login</a>\n");
      out.write("                        <a href=\"patientlogin.jsp\">Patient's Login</a>\n");
      out.write("                        <!-- Add more login options as needed -->\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <a href=\"Aboutus.html\">About Us</a>\n");
      out.write("                <a href=\"viewDoctor.jsp\">Doctors</a>\n");
      out.write("                <a href=\"onlinepatientreg.jsp\">Book Apointment Online</a>\n");
      out.write("                <a href=\"contact.html\">Contact Us</a>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <h1>Online Patient Registration</h1>\n");
      out.write("            <form name=\"PatientReg\" action=\"\" method=\"POST\" onsubmit=\"getCurrentDate(); return validation()\">\n");
      out.write("                <table>\n");
      out.write("                    <tbody>\n");
      out.write("                        <tr>\n");
      out.write("                            <td>Patient Name:</td>\n");
      out.write("                            <td><input type=\"text\" name=\"pname\" required/></td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td>Doctor:</td>\n");
      out.write("                            <td><select name=\"doctor\" onchange=\"updateFees()\">\n");
      out.write("\n");
      out.write("                                    <option>Available Doctor</option>\n");
      out.write("                                    ");
                                        try {
                                            Class.forName("com.mysql.jdbc.Driver");

                                            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital2", "root", "");
                                            String sql1 = "select * from doctor where status='active'";
                                            Statement st1 = con.createStatement();
                                            ResultSet rs1 = st1.executeQuery(sql1);
                                            while (rs1.next()) {
                                                out.print(rs1.getString("name"));
                                    
      out.write("\n");
      out.write("                                    <option value='");
      out.print(rs1.getString("name"));
      out.write("'>\n");
      out.write("                                        ");
 out.print(rs1.getString("name") + " (" + rs1.getString("education") + ")"); 
      out.write("\n");
      out.write("                                    </option>\n");
      out.write("                                    ");

                                            }
                                        } catch (Exception e) {
                                            out.print(e);

                                        }
                                    
      out.write("\n");
      out.write("                                </select></td>\n");
      out.write("                        </tr>\n");
      out.write("\n");
      out.write("                        <tr>\n");
      out.write("\n");
      out.write("                            <!-- Gender field -->\n");
      out.write("                        <tr>\n");
      out.write("                            <td>Gender:</td>\n");
      out.write("                            <td class=\"radio-group\">\n");
      out.write("                                <input type=\"radio\" name=\"gender\" value=\"Male\" />Male \n");
      out.write("                                <input type=\"radio\" name=\"gender\" value=\"Female\" />Female\n");
      out.write("                            </td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td>Mobile No:</td>\n");
      out.write("                            <td><input type=\"number\" name=\"mobile\" id=\"mobile\" /></td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td>Email Id:</td>\n");
      out.write("                            <td><input type=\"text\" name=\"email\" required/></td>\n");
      out.write("                        </tr>\n");
      out.write("\n");
      out.write("                        <tr>\n");
      out.write("                            <td>Age:</td>\n");
      out.write("                            <td><input type=\"number\" name=\"age\" required /></td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td>Weight:</td>\n");
      out.write("                            <td><input type=\"number\" name=\"weight\" required /></td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td>Address:</td>\n");
      out.write("                            <td><textarea rows=\"5\" name=\"address\" required></textarea></td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td>Hospital Visit:</td>\n");
      out.write("                            <td>\n");
      out.write("                                <input type=\"radio\" name=\"visit\" value=\"1st\" id=\"visit1\" checked />1st\n");
      out.write("                                <input type=\"radio\" name=\"visit\" value=\"2nd\" id=\"visit2\" />2nd\n");
      out.write("                                <input type=\"radio\" name=\"visit\" value=\"3rd\" id=\"visit3\" />3rd\n");
      out.write("                            </td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("\n");
      out.write("                        <tr> <td><input type=\"hidden\" name=\"registrationDate\" id=\"registrationDate\" onsubmit=\"getCurrentDate()\"> </td></tr>\n");
      out.write("\n");
      out.write("\n");
      out.write("                        <tr>\n");
      out.write("                            <td colspan=\"2\"><input type=\"submit\" value=\"Submit\" /></td>\n");
      out.write("                        </tr>\n");
      out.write("                    </tbody>\n");
      out.write("                </table>\n");
      out.write("                <input type=\"hidden\" name=\"fees\" id=\"fees\" value=\"\"/>\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");

    if ("POST".equalsIgnoreCase(request.getMethod())) {
        try {
            String mobile = request.getParameter("mobile");
            String email = request.getParameter("email");
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital2", "root", "");
            String userPassword = null;
            // Check if the user already exists in patientlogin table
            String sqlCheckUser = "SELECT * FROM patientlogin WHERE User = ?";
            PreparedStatement pstmtCheckUser = con.prepareStatement(sqlCheckUser);
            pstmtCheckUser.setString(1, mobile);
            ResultSet rsCheckUser = pstmtCheckUser.executeQuery();

            String n = request.getParameter("pname");
            String doc = request.getParameter("doctor");
            String g = request.getParameter("gender");
            String m = mobile;
            String a = request.getParameter("age");
            String w = request.getParameter("weight");
            String ad = request.getParameter("address");
            String h = request.getParameter("visit");
            String date = request.getParameter("registrationDate");
            String f = (String)request.getParameter("fees").trim();
            String s = "Online";

            if (!rsCheckUser.next()) {
                // User does not exist, proceed with insertion
                userPassword = generateRandomPassword();
                // Insert patient data into patientreg table
                String sqlInsertPatientReg = "INSERT INTO patientreg (Name, Doctor, Gender, MobileNo, Email, Age, Weight, Address, Visit, Date, Fees, Status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement pstmtInsertPatientReg = con.prepareStatement(sqlInsertPatientReg);
                pstmtInsertPatientReg.setString(1, n);
                pstmtInsertPatientReg.setString(2, doc);
                pstmtInsertPatientReg.setString(3, g);
                pstmtInsertPatientReg.setString(4, m);
                pstmtInsertPatientReg.setString(5, email);
                pstmtInsertPatientReg.setString(6, a);
                pstmtInsertPatientReg.setString(7, w);
                pstmtInsertPatientReg.setString(8, ad);
                pstmtInsertPatientReg.setString(9, h);
                pstmtInsertPatientReg.setString(10, date);
                pstmtInsertPatientReg.setString(11, f);
                pstmtInsertPatientReg.setString(12, s);
                pstmtInsertPatientReg.executeUpdate();
                pstmtInsertPatientReg.close();

                // Insert patient data into patientlogin table
                String sqlInsertPatientLogin = "INSERT INTO patientlogin (User, Password) VALUES (?, ?)";
                PreparedStatement pstmtInsertPatientLogin = con.prepareStatement(sqlInsertPatientLogin);
                pstmtInsertPatientLogin.setString(1, mobile);
                pstmtInsertPatientLogin.setString(2, userPassword);
                pstmtInsertPatientLogin.executeUpdate();
                pstmtInsertPatientLogin.close();

            } else {
                // User already exists, proceed with insertion without sending user and password

                // Insert patient data into patientreg table
                String sqlInsertPatientReg = "INSERT INTO patientreg (Name, Doctor, Gender, MobileNo, Email, Age, Weight, Address, Visit,status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)";
                PreparedStatement pstmtInsertPatientReg = con.prepareStatement(sqlInsertPatientReg);
                pstmtInsertPatientReg.setString(1, n);
                pstmtInsertPatientReg.setString(2, doc);
                pstmtInsertPatientReg.setString(3, g);
                pstmtInsertPatientReg.setString(4, m);
                pstmtInsertPatientReg.setString(5, email);
                pstmtInsertPatientReg.setString(6, a);
                pstmtInsertPatientReg.setString(7, w);
                pstmtInsertPatientReg.setString(8, ad);
                pstmtInsertPatientReg.setString(9, h);
                pstmtInsertPatientReg.setString(10, date);
                pstmtInsertPatientReg.setString(11, s);
                pstmtInsertPatientReg.executeUpdate();
                pstmtInsertPatientReg.close();
            }

            final String username = "jkhospitalx@gmail.com";
            final String password = "cbayswcezziyoyzy"; // Consider using a more secure way to store credentials

            // SMTP server properties
            Properties props = new Properties();
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", "smtp.gmail.com"); // SMTP server address
            props.put("mail.smtp.port", "587"); // Port for SMTP server

            // Set connection timeout and socket timeout
            props.put("mail.smtp.connectiontimeout", "5000"); // 5 seconds
            props.put("mail.smtp.timeout", "5000"); // 5 seconds

            // Get the Session object
            Session msgsession = Session.getInstance(props, new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            });

            try {
                // Create a default MimeMessage object
                Message message = new MimeMessage(msgsession);

                // Set From: header field
                message.setFrom(new InternetAddress(username));

                // Set To: header field
                message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));

                // Set Subject: header field
                message.setSubject("Appointment Receipt");

                // Set email content
                String emailContent = "Name : " + n + "\n";
                emailContent += "Doctor Name : " + doc + "\n";
                emailContent += "Gender : " + g + "\n";
                emailContent += "Mobile No : " + m + "\n";
                emailContent += "Email Id : " + email + "\n";
                emailContent += "Age : " + a + "\n";
                emailContent += "Weight : " + w + "\n";
                emailContent += "Visit : " + h + "\n";
                emailContent += "Doctor fees to be paid at hospital: " + f + "\n";
                if (userPassword != null) {
                    // Include password if it's not null
                    emailContent += "Your Login Id is your mobile number. \nPassword : " + userPassword + "\n";
                }
                message.setText(emailContent);

                // Send message
                Transport.send(message);
                out.print("<center><h4>Patient Registered Successfully!</h4></center>");
            } catch (MessagingException e) {
                // Print any errors
                out.println("Error sending email: " + e.getMessage());
            }
            rsCheckUser.close();
            pstmtCheckUser.close();
            con.close();
        } catch (Exception e) {
            out.print(e);
        }
    }

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<script>\n");
      out.write("    function validation() {\n");
      out.write("        var m = document.PatientReg.mobile.value;\n");
      out.write("        if (isNaN(m)) {\n");
      out.write("            alert(\"Mobile Number should be numeric\");\n");
      out.write("            return false;\n");
      out.write("        } else if (m.length !== 10) {\n");
      out.write("            alert(\"Mobile Number should be 10 digit\");\n");
      out.write("            return false;\n");
      out.write("        } else {\n");
      out.write("            return true;\n");
      out.write("        }\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    var radioButtons = document.querySelectorAll('input[name=\"visit\"]');\n");
      out.write("    radioButtons.forEach(function (radioButton) {\n");
      out.write("\n");
      out.write("        radioButton.addEventListener('click', updateFees);\n");
      out.write("    });\n");
      out.write("\n");
      out.write("    // Initial update of fees on page load\n");
      out.write("//        updateFees();\n");
      out.write("\n");
      out.write("    function updateFees() {\n");
      out.write("        console.log(\"Fees update function called\");\n");
      out.write("        var feesInput = document.getElementById('fees');\n");
      out.write("        var visit1 = document.getElementById('visit1');\n");
      out.write("        var visit2 = document.getElementById('visit2');\n");
      out.write("        var visit3 = document.getElementById('visit3');\n");
      out.write("\n");
      out.write("        var doctorName = document.querySelector('select[name=\"doctor\"]').value; // Get selected doctor name\n");
      out.write("\n");
      out.write("        var visitType;\n");
      out.write("        if (visit1.checked) {\n");
      out.write("            visitType = \"visit1\";\n");
      out.write("        } else if (visit2.checked) {\n");
      out.write("            visitType = \"visit2\";\n");
      out.write("        } else if (visit3.checked) {\n");
      out.write("            visitType = \"visit3\";\n");
      out.write("        }\n");
      out.write("//feesInput.value=1;\n");
      out.write("        // Ajax call to fetch fees from the database based on doctor name and visit type\n");
      out.write("        var xhr = new XMLHttpRequest();\n");
      out.write("        xhr.onreadystatechange = function () {\n");
      out.write("            if (xhr.readyState === 4 && xhr.status === 200) {\n");
      out.write("                feesInput.value = xhr.responseText; // Update fees input field with fetched value\n");
      out.write("//                console.log(xhr.responseText);\n");
      out.write("            }\n");
      out.write("        };\n");
      out.write("        xhr.open(\"GET\", \"fetchFees.jsp?doctor=\" + doctorName + \"&visitType=\" + visitType, true);\n");
      out.write("        xhr.send();\n");
      out.write("    }\n");
      out.write("\n");
      out.write("\n");
      out.write("</script>\n");
      out.write("</body>\n");
      out.write("    </html>\n");

} else {
    id = Integer.parseInt(request.getParameter("id"));

    String url = "jdbc:mysql://localhost:3306/hospital2";
    String us = "root";
    String pas = "admin";

    try {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, "root", "");
        String query = "SELECT * FROM patientreg where id=?";
        PreparedStatement ps = con.prepareStatement(query);
//        String doctorName = (String) session.getAttribute("doctor_name");

        ps.setInt(1, id);

        // Execute the query
        ResultSet rs = ps.executeQuery();

        // If the query returns a row, the user is authenticated
        if (rs.next()) {

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<!--\n");
      out.write("To change this license header, choose License Headers in Project Properties.\n");
      out.write("To change this template file, choose Tools | Templates\n");
      out.write("and open the template in the editor.\n");
      out.write("-->\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Online Patient Reg</title>\n");
      out.write("        <style>\n");
      out.write("\n");
      out.write("            body{\n");
      out.write("                margin: 0;\n");
      out.write("                padding: 0;\n");
      out.write("                background-image: url('img/doctorlogin.jpg');\n");
      out.write("                background-size: cover;\n");
      out.write("                background-position: center;\n");
      out.write("                background-repeat: no-repeat;\n");
      out.write("                /*                    height: 100vh;*/\n");
      out.write("\n");
      out.write("                font-family: sans-serif;\n");
      out.write("\n");
      out.write("            }\n");
      out.write("                    \n");
      out.write("            .navbar {\n");
      out.write("                background-color: white;\n");
      out.write("                display: flex;\n");
      out.write("                flex-direction: row;\n");
      out.write("                justify-content: space-between;\n");
      out.write("                align-items: center; /* Center vertically */\n");
      out.write("                height: 70px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            #navimg {\n");
      out.write("                height: 70px;\n");
      out.write("                width: 90px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .navbar a {\n");
      out.write("                color: black;\n");
      out.write("                text-align: center;\n");
      out.write("                padding: 14px 20px;\n");
      out.write("                text-decoration: none;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .navitem a:hover {\n");
      out.write("                background-color: #5a2f90;\n");
      out.write("                color: white;\n");
      out.write("                border-radius: 30px;\n");
      out.write("                box-shadow: 0 2px 4px rgba(0, 0, 0, 0.4);\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .navitem {\n");
      out.write("                margin-left: auto;\n");
      out.write("                padding: 15px;\n");
      out.write("                /* position: relative;*/\n");
      out.write("                z-index: 2;\n");
      out.write("            }\n");
      out.write("            .dropdown {\n");
      out.write("                position: relative;\n");
      out.write("                display: inline-block;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .dropdown-content {\n");
      out.write("                display: none;\n");
      out.write("                position: fixed; /* Change to fixed */\n");
      out.write("                background-color: #f9f9f9;\n");
      out.write("                min-width: 160px;\n");
      out.write("                box-shadow: 0 2px 4px rgba(0, 0, 0, 0.2);\n");
      out.write("                z-index: 2;\n");
      out.write("                margin-top: 15px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .dropdown-content a {\n");
      out.write("                color: black;\n");
      out.write("                padding: 12px 16px;\n");
      out.write("                text-decoration: none;\n");
      out.write("                display: block;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .dropdown-content a:hover {\n");
      out.write("                background-color: #5a2f90;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .dropdown:hover .dropdown-content {\n");
      out.write("                display: block;\n");
      out.write("            }\n");
      out.write("            input[type=\"number\"] {\n");
      out.write("                -moz-appearance: textfield; /* Firefox */\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            input[type=\"number\"]::-webkit-inner-spin-button,\n");
      out.write("            input[type=\"number\"]::-webkit-outer-spin-button { /* WebKit */\n");
      out.write("                -webkit-appearance: none;\n");
      out.write("                margin: 0; /* Removes the default margin */\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .container {\n");
      out.write("                width: 40%;\n");
      out.write("                margin: 50px auto;\n");
      out.write("\n");
      out.write("                padding: 20px;\n");
      out.write("                border-radius: 8px;\n");
      out.write("                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);\n");
      out.write("                background: none;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            h1 {\n");
      out.write("                text-align: center;\n");
      out.write("                color: #333;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            table {\n");
      out.write("                width: 80%;\n");
      out.write("                border-collapse: collapse;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            table td {\n");
      out.write("                padding: 10px;\n");
      out.write("                border-bottom: 1px solid #ccc;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            table td:first-child {\n");
      out.write("                width: 30%;\n");
      out.write("                font-weight: bold;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            input[type=\"text\"],\n");
      out.write("            input[type=\"number\"],\n");
      out.write("            textarea {\n");
      out.write("                width: calc(100% - 20px);\n");
      out.write("                padding: 8px;\n");
      out.write("                border: 1px solid #ccc;\n");
      out.write("                border-radius: 5px;\n");
      out.write("                box-sizing: border-box;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            input[type=\"submit\"] {\n");
      out.write("                width: 50%;\n");
      out.write("                padding: 10px;\n");
      out.write("                background-color: #5a2f90;\n");
      out.write("                color: white;\n");
      out.write("                border: none;\n");
      out.write("                border-radius: 5px;\n");
      out.write("                cursor: pointer;\n");
      out.write("                font-size: 16px;\n");
      out.write("                margin-top: 10px;\n");
      out.write("                margin-left:30%;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            input[type=\"submit\"]:hover {\n");
      out.write("                box-shadow: 0 2px 4px rgba(0, 0, 0, 0.9);\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .radio-group {\n");
      out.write("                display: flex;\n");
      out.write("                align-items: center;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .radio-group input[type=\"radio\"] {\n");
      out.write("                margin-right: 5px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .subscript {\n");
      out.write("                vertical-align: super;\n");
      out.write("                font-size: 80%;\n");
      out.write("            }\n");
      out.write("            footer {\n");
      out.write("                background-color: #5a2f90;\n");
      out.write("                color: white;\n");
      out.write("                text-align: center;\n");
      out.write("                padding: 10px;\n");
      out.write("                margin-bottom: -18px;\n");
      out.write("                clear: both;  /*Added to clear float */\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            footer p {\n");
      out.write("                color: white;\n");
      out.write("            }\n");
      out.write("            select {\n");
      out.write("                width: calc(100% - 20px);\n");
      out.write("                padding: 8px;\n");
      out.write("                border: 1px solid #ccc;\n");
      out.write("                border-radius: 5px;\n");
      out.write("                box-sizing: border-box;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .tab {\n");
      out.write("                display: none;\n");
      out.write("            }\n");
      out.write("            .tab.active {\n");
      out.write("                display: block;\n");
      out.write("            }\n");
      out.write("            .tab-content {\n");
      out.write("                padding: 20px;\n");
      out.write("                padding-top:10px !important;\n");
      out.write("\n");
      out.write("                border: 1px solid #ccc;\n");
      out.write("                border-top: none;\n");
      out.write("                text-align: center;\n");
      out.write("                align-items: center;\n");
      out.write("\n");
      out.write("            }\n");
      out.write("            .tabs {\n");
      out.write("                overflow: hidden;\n");
      out.write("                border: 1px solid #ccc;\n");
      out.write("                background-color: #f1f1f1;\n");
      out.write("            }\n");
      out.write("            .tab-link {\n");
      out.write("                float: left;\n");
      out.write("                border-right: 1px solid #ccc;\n");
      out.write("                background-color: inherit;\n");
      out.write("                padding: 10px 20px;\n");
      out.write("                text-decoration: none;\n");
      out.write("                color: black;\n");
      out.write("            }\n");
      out.write("            .tab-link:last-child {\n");
      out.write("                border-right: none;\n");
      out.write("            }\n");
      out.write("            .tab-link:hover {\n");
      out.write("                background-color: #ddd;\n");
      out.write("            }\n");
      out.write("            .tab-link.active {\n");
      out.write("                background-color: white;\n");
      out.write("                border-bottom: 1px solid white;\n");
      out.write("            }\n");
      out.write("            ul {\n");
      out.write("                list-style: none;\n");
      out.write("                padding: 0;\n");
      out.write("            }\n");
      out.write("            ul li {\n");
      out.write("                margin-bottom: 10px;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("\n");
      out.write("        <div class=\"navbar\" style=\"display:flex; flex-direction: row; justify-content: space-between;\">\n");
      out.write("            <div> <a href=\"index.html\"><img id=\"navimg\" src=\"img/newlogo.png\"></a></div>\n");
      out.write("            <div class=\"navitem\"> <a href=\"index.html\">Home</a>\n");
      out.write("                <div class=\"dropdown\">\n");
      out.write("                    <a href=\"#about\" id=\"login-drop\">Login</a>\n");
      out.write("                    <div class=\"dropdown-content\">\n");
      out.write("                        <a href=\"adminlogin.html\">Admin Login</a>\n");
      out.write("                        <a href=\"receptionistlogin.html\">Receptionist's Login</a>\n");
      out.write("                        <a href=\"doctorlogin.jsp\">Doctor's Login</a>\n");
      out.write("                        <a href=\"patientlogin.jsp\">Patient's Login</a>\n");
      out.write("                        <!-- Add more login options as needed -->\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <a href=\"Aboutus.html\">About Us</a>\n");
      out.write("                <a href=\"viewDoctor.jsp\">Doctors</a>\n");
      out.write("                <a href=\"onlinepatientreg.jsp\">Book Apointment Online</a>\n");
      out.write("                <a href=\"contact.html\">Contact Us</a>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("    <center>\n");
      out.write("\n");
      out.write("        <div class=\"container\">\n");
      out.write("  <div style=\"display:flex; justify-content: flex-end; width: 85%; flex-direction: row; \">\n");
      out.write("                <a href=\"receptionist-dashboard.jsp\" name=\"print\" style=\"text-decoration: none; color: #007bff; font-weight: bold; border: 1px solid #007bff; padding: 8px 16px; border-radius: 4px; background-color: #f8f9fa;\">Go Back To Dashboard</a>\n");
      out.write("                \n");
      out.write("            </div>\n");
      out.write("            <h1> Online Patient Registration </h1>\n");
      out.write("            <form name=\"PatientReg\" action=\"\"  method=\"POST\" onsubmit=\"return validation()\">\n");
      out.write("\n");
      out.write("                <table>\n");
      out.write("                    <tbody>\n");
      out.write("                        <tr>\n");
      out.write("                            <td>Patient Name:</td>\n");
      out.write("                            <td><input type=\"text\" name=\"pname\" value='");
      out.print(rs.getString("Name"));
      out.write("' required/></td>\n");
      out.write("                        </tr>\n");
      out.write("                      \n");
      out.write("\n");
      out.write("                        <tr>\n");
      out.write("                            <td>Doctor:</td>\n");
      out.write("                            <td><select name=\"doctor\">\n");
      out.write("\n");
      out.write("                                    <option>select Doctor</option>\n");
      out.write("                                    ");

                                        try {
                                            Class.forName("com.mysql.jdbc.Driver");

                                            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital2", "root", "");
                                            String sql1 = "select * from doctor where status='active'";
                                            Statement st1 = con.createStatement();
                                            ResultSet rs1 = st1.executeQuery(sql1);
                                            while (rs1.next()) {
                                                out.print(rs1.getString("name"));
                                    
      out.write("\n");
      out.write("                            <option value='");
      out.print(rs1.getString("name"));
      out.write('\'');
      out.write(' ');
 if (rs1.getString("name").equals(rs.getString("Doctor"))) {
    out.print("selected");
}
      out.write(">\n");
      out.write("    ");
 out.print(rs1.getString("name") + " (" + rs1.getString("education") + ")"); 
      out.write("\n");
      out.write("</option>\n");
      out.write("\n");
      out.write("                                    ");

                                            }
                                        } catch (Exception e) {
                                            out.print(e);

                                        }
                                    
      out.write("\n");
      out.write("                                </select></td>\n");
      out.write("                        </tr>\n");
      out.write("                       \n");
      out.write("                        <tr>\n");
      out.write("                            <td>Gender:</td>\n");
      out.write("                            <td class=\"radio-group\">\n");
      out.write("                                <input type=\"radio\" name=\"gender\" value=\"Male\" ");
      out.print( rs.getString("Gender").equals("Male") ? "checked" : "");
      out.write(" />Male \n");
      out.write("\n");
      out.write("                                <input type=\"radio\" name=\"gender\" value=\"Female\" ");
      out.print( rs.getString("Gender").equals("Female") ? "checked" : "");
      out.write(" />Female\n");
      out.write("                            </td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td>Mobile No:</td>\n");
      out.write("                            <td><input type=\"number\" name=\"mobile\" id=\"mobile\" value='");
      out.print(rs.getString("MobileNo"));
      out.write("' /></td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td>Email Id:</td>\n");
      out.write("                            <td><input type=\"text\" name=\"email\" value='");
      out.print(rs.getString("Email"));
      out.write("' required/></td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td>Age:</td>\n");
      out.write("                            <td><input type=\"number\" name=\"age\" value='");
      out.print(rs.getString("Age"));
      out.write("' required /></td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td>Weight:</td>\n");
      out.write("                            <td><input type=\"number\" name=\"weight\" value='");
      out.print(rs.getString("Weight"));
      out.write("' required /></td>\n");
      out.write("                        </tr>\n");
      out.write("\n");
      out.write("                        <tr>\n");
      out.write("                            <td>Address:</td>\n");
      out.write("                            <td><textarea rows=\"5\" name=\"address\"  required>");
      out.print(rs.getString("Address"));
      out.write("</textarea></td>\n");
      out.write("                        </tr>\n");
      out.write("                        \n");
      out.write("                        <tr>\n");
      out.write("                            <td>Hospital Visit:</td>\n");
      out.write("                            <td>\n");
      out.write("                                <input type=\"radio\" name=\"visit\" value=\"1st\" id=\"visit1\" ");
if (rs.getString("Visit").equals("1st")) {out.print("checked");}
      out.write(" />1st\n");
      out.write("                                <input type=\"radio\" name=\"visit\" value=\"2nd\" id=\"visit2\" ");
if (rs.getString("Visit").equals("2nd")) {out.print("checked");}
      out.write("/>2nd\n");
      out.write("                                <input type=\"radio\" name=\"visit\" value=\"3rd\" id=\"visit3\" ");
if (rs.getString("Visit").equals("3rd")) {out.print("checked");}
      out.write("/>3rd\n");
      out.write("                            </td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td>Hospital Fees:</td>\n");
      out.write("                            <td><input type=\"text\" name=\"fees\"  id=\"fees\" value=\"");
      out.print(rs.getString("Fees"));
      out.write("\"></td>\n");
      out.write("                        </tr>\n");
      out.write("                      \n");
      out.write("\n");
      out.write("                        <tr>\n");
      out.write("\n");
      out.write("                            <td colspan=\"2\"><input type=\"submit\" value=\"Submit\" /></td>\n");
      out.write("                        </tr>\n");
      out.write("                    </tbody>\n");
      out.write("                </table>\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("    </center>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("    ");

                    if ("POST".equalsIgnoreCase(request.getMethod())) {
                        try {
                            String mobile = request.getParameter("mobile");
                            String email = request.getParameter("email");
                            Class.forName("com.mysql.jdbc.Driver");
//                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", "");
                            String userPassword = null;
                            // Check if the user already exists in patientlogin table
                            String sqlCheckUser = "SELECT * FROM patientlogin WHERE User = ?";
                            PreparedStatement pstmtCheckUser = con.prepareStatement(sqlCheckUser);
                            pstmtCheckUser.setString(1, mobile);
                            ResultSet rsCheckUser = pstmtCheckUser.executeQuery();

                            
                            String n = request.getParameter("pname");
                String doc = request.getParameter("doctor");
                String g = request.getParameter("gender");
                String m = mobile;
                String a = request.getParameter("age");
                String w = request.getParameter("weight");
                String ad = request.getParameter("address");
                String h = request.getParameter("visit");
                String f = request.getParameter("fees");
                String s = "Offline";
                         

                            if (rsCheckUser.next()) {
                                // User does not exist, proceed with insertion
                                userPassword = generateRandomPassword();
                                // Insert patient data into patientreg table
                                String sqlUpdatePatientReg = "UPDATE patientreg SET Name=?, Doctor=?, Gender=?, Email=?, Age=?, Weight=?, Address=?, Visit=?, Fees=?,status=? WHERE MobileNo=?";
                                PreparedStatement pstmtUpdatePatientReg = con.prepareStatement(sqlUpdatePatientReg);
                                pstmtUpdatePatientReg.setString(1, n);
                                pstmtUpdatePatientReg.setString(2, doc);
                                pstmtUpdatePatientReg.setString(3, g);
                                pstmtUpdatePatientReg.setString(4, email);
                                pstmtUpdatePatientReg.setString(5, a);
                                pstmtUpdatePatientReg.setString(6, w);
                                pstmtUpdatePatientReg.setString(7, ad);
                                pstmtUpdatePatientReg.setString(8, h);
                                pstmtUpdatePatientReg.setString(9, f);
                                pstmtUpdatePatientReg.setString(10, s);
                                pstmtUpdatePatientReg.setString(11, m); // MobileNo used in WHERE clause
                                pstmtUpdatePatientReg.executeUpdate();
                                pstmtUpdatePatientReg.close();

//                                // Insert patient data into patientlogin table
//                                String sqlInsertPatientLogin = "INSERT INTO patientlogin (User, Password) VALUES (?, ?)";
//                                PreparedStatement pstmtInsertPatientLogin = con.prepareStatement(sqlInsertPatientLogin);
//                                pstmtInsertPatientLogin.setString(1, mobile);
//                                pstmtInsertPatientLogin.setString(2, userPassword);
//                                pstmtInsertPatientLogin.executeUpdate();
//                                pstmtInsertPatientLogin.close();

                            } 
//                            else {
//                                // User already exists, proceed with insertion without sending user and password
//
//                                // Insert patient data into patientreg table
//                                String sqlInsertonlinepatientreg = "INSERT INTO onlinepatientreg (Name, Doctor, Gender, MobileNo, Email, Age,Weight, Address) VALUES (?, ?, ?, ?, ?, ?, ?,?)";
//                                PreparedStatement pstmtInsertonlinepatientreg = con.prepareStatement(sqlInsertonlinepatientreg);
//                                pstmtInsertonlinepatientreg.setString(1, n);
//                                pstmtInsertonlinepatientreg.setString(2, doc);
//                                pstmtInsertonlinepatientreg.setString(3, g);
//                                pstmtInsertonlinepatientreg.setString(4, m);
//                                pstmtInsertonlinepatientreg.setString(5, email);
//                                pstmtInsertonlinepatientreg.setString(6, a);
//                                pstmtInsertonlinepatientreg.setString(7, w);
//
//                                pstmtInsertonlinepatientreg.setString(8, ad);
//
//                                pstmtInsertonlinepatientreg.executeUpdate();
//                                pstmtInsertonlinepatientreg.close();
//                            }

                            final String username = "jkhospitalx@gmail.com";
                            final String password = "cbayswcezziyoyzy"; // Consider using a more secure way to store credentials

                            // SMTP server properties
                            Properties props = new Properties();
                            props.put("mail.smtp.auth", "true");
                            props.put("mail.smtp.starttls.enable", "true");
                            props.put("mail.smtp.host", "smtp.gmail.com"); // SMTP server address
                            props.put("mail.smtp.port", "587"); // Port for SMTP server

                            // Set connection timeout and socket timeout
                            props.put("mail.smtp.connectiontimeout", "5000"); // 5 seconds
                            props.put("mail.smtp.timeout", "5000"); // 5 seconds

                            // Get the Session object
                            Session msgsession = Session.getInstance(props, new javax.mail.Authenticator() {
                                protected PasswordAuthentication getPasswordAuthentication() {
                                    return new PasswordAuthentication(username, password);
                                }
                            });

                            try {
                                // Create a default MimeMessage object
                                Message message = new MimeMessage(msgsession);

                                // Set From: header field
                                message.setFrom(new InternetAddress(username));

                                // Set To: header field
                                message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));

                                // Set Subject: header field
                                message.setSubject("Appointment Receipt");

                                // Set email content
                                String emailContent = "Name : " + n + "\n";
                                emailContent += "Doctor Name : " + doc + "\n";
                                emailContent += "Gender : " + g + "\n";
                                emailContent += "Mobile No : " + m + "\n";
                                emailContent += "Email Id : " + email + "\n";
                                emailContent += "Age : " + a + "\n";
                                emailContent += "Weight : " + w + "\n";
                                emailContent += "Payment Status : " + "Paid - ₹"+f + " \n";

                                if (userPassword != null) {
                                    // Include password if it's not null
                                    emailContent += "Your Login Id is your mobile number. \nPassword : " + userPassword + "\n";
                                }
                                message.setText(emailContent);

                                // Send message
                                Transport.send(message);
                                out.print("<center><h4>Patient Registered Successfully!</h4></center>");
                            } catch (MessagingException e) {
                                // Print any errors
                                out.println("Error sending email: " + e.getMessage());
                            }
                            rsCheckUser.close();
                            pstmtCheckUser.close();
                            con.close();
                        } catch (Exception e) {
                            out.print(e);
                        }
                    }
                }
            } catch (Exception e) {
                out.print(e);
            }
        }
    
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("    <!-- Footer -->\n");
      out.write("    <footer>\n");
      out.write("        <p>© 2024 JK Multispecialist Hospital Amravati. All Rights Reserved.</p>\n");
      out.write("    </footer>\n");
      out.write("\n");
      out.write("    <script>\n");
      out.write("        function validation() {\n");
      out.write("            var m = document.PatientReg.mobile.value;\n");
      out.write("            if (isNaN(m)) {\n");
      out.write("                alert(\"Mobile Number should be numeric\");\n");
      out.write("                return false;\n");
      out.write("            } else if (m.length !== 10) {\n");
      out.write("                alert(\"Mobile Number should be 10 digit\");\n");
      out.write("                return false;\n");
      out.write("            } else {\n");
      out.write("                return true;\n");
      out.write("            }\n");
      out.write("        }\n");
      out.write("\n");
      out.write("  var radioButtons = document.querySelectorAll('input[name=\"visit\"]');\n");
      out.write("    radioButtons.forEach(function (radioButton) {\n");
      out.write("\n");
      out.write("        radioButton.addEventListener('click', updateFees);\n");
      out.write("    });\n");
      out.write("\n");
      out.write("    // Initial update of fees on page load\n");
      out.write("//        updateFees();\n");
      out.write("\n");
      out.write("    function updateFees() {\n");
      out.write("        console.log(\"Fees update function called\");\n");
      out.write("        var feesInput = document.getElementById('fees');\n");
      out.write("        var visit1 = document.getElementById('visit1');\n");
      out.write("        var visit2 = document.getElementById('visit2');\n");
      out.write("        var visit3 = document.getElementById('visit3');\n");
      out.write("\n");
      out.write("        var doctorName = document.querySelector('select[name=\"doctor\"]').value; // Get selected doctor name\n");
      out.write("\n");
      out.write("        var visitType;\n");
      out.write("        if (visit1.checked) {\n");
      out.write("            visitType = \"visit1\";\n");
      out.write("        } else if (visit2.checked) {\n");
      out.write("            visitType = \"visit2\";\n");
      out.write("        } else if (visit3.checked) {\n");
      out.write("            visitType = \"visit3\";\n");
      out.write("        }\n");
      out.write("//feesInput.value=1;\n");
      out.write("        // Ajax call to fetch fees from the database based on doctor name and visit type\n");
      out.write("        var xhr = new XMLHttpRequest();\n");
      out.write("        xhr.onreadystatechange = function () {\n");
      out.write("            if (xhr.readyState === 4 && xhr.status === 200) {\n");
      out.write("                feesInput.value = xhr.responseText; // Update fees input field with fetched value\n");
      out.write("//                console.log(xhr.responseText);\n");
      out.write("            }\n");
      out.write("        };\n");
      out.write("        xhr.open(\"GET\", \"fetchFees.jsp?doctor=\" + doctorName + \"&visitType=\" + visitType, true);\n");
      out.write("        xhr.send();\n");
      out.write("    }\n");
      out.write("\n");
      out.write(" function getCurrentDate() {\n");
      out.write("    var today = new Date();\n");
      out.write("    var year = today.getFullYear();\n");
      out.write("    var month = String(today.getMonth() + 1).padStart(2, '0'); // Adding leading zero if needed\n");
      out.write("    var day = String(today.getDate()).padStart(2, '0'); // Adding leading zero if needed\n");
      out.write("    var formattedDate = year + '-' + month + '-' + day;\n");
      out.write("\n");
      out.write("    // Set the value of the registrationDate field\n");
      out.write("    document.getElementById('registrationDate').value = formattedDate;\n");
      out.write("}\n");
      out.write("\n");
      out.write("    </script>\n");
      out.write("</body>\n");
      out.write("    </html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
