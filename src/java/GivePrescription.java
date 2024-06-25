import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import javax.servlet.annotation.WebServlet;
import java.util.logging.Logger;

@WebServlet("/Give")
public class GivePrescription extends HttpServlet {

    // Initialize logger
    private static final Logger LOGGER = Logger.getLogger(GivePrescription.class.getName());

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        int prescriptionId = 0;
        String patientName = request.getParameter("pname");
        int age = Integer.parseInt(request.getParameter("age"));
        int weight = Integer.parseInt(request.getParameter("weight"));
        String medData = request.getParameter("medicineData");
        String medicine = request.getParameter("medicine");
        int numberOfDays = Integer.parseInt(request.getParameter("noofday"));
        String visitDate = request.getParameter("visitdate");
        String prescription = request.getParameter("prescription");
        String patientId = request.getParameter("patient_id");
        String doctorName = (String)request.getSession().getAttribute("doctor_name");
        
        Connection con = null;
        PreparedStatement pstmt = null;
        
        try {
            // JDBC connection
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/hospital2";
            String username = "root";
            String password = "";
            con = DriverManager.getConnection(url, username, password);
            con.setAutoCommit(false); // Start transaction
            
            // SQL query for inserting data into prescription table
            String sqlPrescription = "INSERT INTO prescription (patient_name, age, weight, visit_date, prescription, patient_id, doctor_name) VALUES (?, ?, ?, ?, ?, ?, ?)";
            pstmt = con.prepareStatement(sqlPrescription, Statement.RETURN_GENERATED_KEYS);
            
            // Set parameters for prescription table
            pstmt.setString(1, patientName);
            pstmt.setInt(2, age);
            pstmt.setInt(3, weight);
            pstmt.setString(4, visitDate);
            pstmt.setString(5, prescription);
            pstmt.setString(6, patientId);
            pstmt.setString(7, doctorName);
            
            // Execute the query for prescription table
            int rowsAffectedPrescription = pstmt.executeUpdate();
            
            if (rowsAffectedPrescription > 0) {
                ResultSet generatedKeys = pstmt.getGeneratedKeys();
                
                if (generatedKeys.next()) {
                    prescriptionId = generatedKeys.getInt(1);
                }

//                // Insert meal timings into meal_timing table
//                if (medData != null) {
//                    String sqlMealTiming = "INSERT INTO meal_timing (prescription_id, meal_timing, medicine, dose, no_of_days, timing) VALUES (?, ?, ?, ?, ?, ?)";
//                    pstmt = con.prepareStatement(sqlMealTiming);
//                    for (int i = 0; i < medData.length; i++) {
//                        String[] medDetails = medData[i].split(",");
//                        if (medDetails.length >= 5) {
//                            // Log medicine details for debugging
//                            LOGGER.info("Medicine: " + medDetails[0] + ", Dose: " + medDetails[1] + ", No of Days: " + medDetails[2] + ", Timing: " + medDetails[3] + ", Meal Timing: " + medDetails[4]);
//                            
//                            pstmt.setInt(1, prescriptionId);
//                            pstmt.setString(2, medDetails[4]); // meal_timing
//                            pstmt.setString(3, medDetails[0]);
//                            pstmt.setInt(4, Integer.parseInt(medDetails[1])); // dose
//                            pstmt.setInt(5, Integer.parseInt(medDetails[2]));
//                            pstmt.setString(6, medDetails[3]); // timing
//                            pstmt.addBatch(); 
//                        } else {
//                            LOGGER.warning("Invalid medicine data format: " + medData[i]);
//                        }
//                    }
//                    pstmt.executeBatch();
//                }
// Split the medData string into rows
String[] medRows = medData.split(";");
//for (String medRow : medRows) {
//    // Split each row into individual column values
//    String[] medDetails = medRow.split(",");
//    if (medDetails.length >= 5) {
//        // Log medicine details for debugging
//        LOGGER.info("Medicine: " + medDetails[0] + ", Dose: " + medDetails[1] + ", No of Days: " + medDetails[2] + ", Timing: " + medDetails[3] + ", Meal Timing: " + medDetails[4]);
//        
//        // Prepare and execute the batch insertion statement
//        pstmt.setInt(1, prescriptionId);
//        pstmt.setString(2, medDetails[4].replace('#',',')); // meal_timing
//        pstmt.setString(3, medDetails[0]);
//        pstmt.setInt(4, Integer.parseInt(medDetails[1])); // dose
//        pstmt.setInt(5, Integer.parseInt(medDetails[2]));
//        pstmt.setString(6, medDetails[3]); // timing
//        pstmt.addBatch(); 
//    } else {
//        LOGGER.warning("Invalid medicine data format: " + medRow);
//    }
//}

for (String medRow : medRows) {
    String sqlMealTiming = "INSERT INTO meal_timing (prescription_id, meal_timing, medicine, dose, no_of_days, timing) VALUES (?, ?, ?, ?, ?, ?)";
    pstmt = con.prepareStatement(sqlMealTiming);
    // Split each row into individual column values
    String[] medDetails = medRow.split(",");
    if (medDetails.length >= 5) {
        // Log medicine details for debugging
        LOGGER.info("Medicine: " + medDetails[0] + ", Dose: " + medDetails[1] + ", No of Days: " + medDetails[2] + ", Timing: " + medDetails[3] + ", Meal Timing: " + medDetails[4]);
        
        // Prepare and execute the batch insertion statement
        pstmt.setInt(1, prescriptionId);
        pstmt.setString(2, medDetails[4].replace('#',',')); // meal_timing
        pstmt.setString(3, medDetails[0]);
        pstmt.setInt(4, Integer.parseInt(medDetails[1])); // dose
        pstmt.setInt(5, Integer.parseInt(medDetails[2]));
        pstmt.setString(6, medDetails[3]); // timing
        pstmt.addBatch(); 
    } else {
        LOGGER.warning("Invalid medicine data format: " + medRow);
    }
    pstmt.executeBatch(); // Execute the batch insertion
}



                con.commit(); // Commit transaction
                
                response.sendRedirect("generate_report.jsp?prescription_id="+prescriptionId);
            } else {
                response.sendRedirect("generate_report.jsp?message=Something went wrong");
            }
        } catch (ClassNotFoundException | SQLException e) {
            try {
                if (con != null) {
                    con.rollback(); // Rollback transaction if exception occurs
                }
            } catch (SQLException ex) {
                LOGGER.severe("Error rolling back transaction: " + ex.getMessage());
            }
            LOGGER.severe("Error executing SQL: " + e.getMessage());
            out.println("<h2>Error: " + e.getMessage() + "</h2>");
        } finally {
            // Close JDBC resources
            try {
                if (pstmt != null) pstmt.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                LOGGER.severe("Error closing JDBC resources: " + e.getMessage());
                out.println("<h2>Error: " + e.getMessage() + "</h2>");
            }
        }
    }
}
 