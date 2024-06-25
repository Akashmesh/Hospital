import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/AddNewDoctorServlet")
@MultipartConfig
public class AddNewDoctorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            // Establishing database connection
            String url = "jdbc:mysql://localhost:3306/hospital2";
            String user = "root";
            String pass = "";

            // Load the MySQL driver
            Class.forName("com.mysql.jdbc.Driver");

            // Establish the connection
            connection = DriverManager.getConnection(url, user, pass);

            // Getting form data
            String name = request.getParameter("name");
            String regno = request.getParameter("regno");
            String education = request.getParameter("education");
            String experienceString = request.getParameter("experience");
            int experience = (experienceString != null && !experienceString.isEmpty()) ? Integer.parseInt(experienceString) : 0;
            String visit1 = request.getParameter("visit1");
            String visit2 = request.getParameter("visit2");
            String visit3 = request.getParameter("visit3");
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            // Handling file upload
            Part filePart = request.getPart("photo");
            String fileName = filePart.getSubmittedFileName();
            String uploadDir = getServletContext().getRealPath("") + File.separator + "uploads"; // Specify your upload directory here

            // Create the upload directory if it doesn't exist
            File directory = new File(uploadDir);
            if (!directory.exists()) {
                directory.mkdir();
            }

            // Save file to server
            String savePath = uploadDir + File.separator + fileName;
            File saveFile = new File(savePath);
            try (InputStream input = filePart.getInputStream(); OutputStream output = new FileOutputStream(saveFile)) {
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = input.read(buffer)) != -1) {
                    output.write(buffer, 0, bytesRead);
                }
            }

            // Inserting data into the database
            String filePath = "uploads/" + fileName;
            String query = "INSERT INTO doctor (name,regno, education, experience,visit1,visit2,visit3, User, Password, photo_path) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?,?)";
            statement = connection.prepareStatement(query);
            statement.setString(1, name);
            statement.setString(2, regno);
            statement.setString(3, education);
            statement.setInt(4, experience);
            statement.setString(5, visit1);
            statement.setString(6, visit2);
            statement.setString(7, visit3);
            statement.setString(8, username);
            statement.setString(9, password);
            statement.setString(10, filePath);

            int rowsInserted = statement.executeUpdate();

            if (rowsInserted > 0) {
                // Redirect to another page with success message in URL parameter
                response.sendRedirect("addNewDoctor.jsp?message=New doctor added successfully!");
            } else {
                // Redirect to another page with error message in URL parameter
                response.sendRedirect("addNewDoctor.jsp?message=Failed to add new doctor.");
            }            
        
         
            
        } catch (ClassNotFoundException | SQLException | IOException e) {
//            response.getWriter().println("Error: " + e.getMessage());
              response.sendRedirect("addNewDoctor.jsp?message=" + e.getMessage());
        } finally {
            // Closing resources
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                response.getWriter().println("Error: " + e.getMessage());
            }
        }
    }
}