import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by ccatana on 5/16/2014.
 */
public class DeleteServlet extends HttpServlet {
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException
    {
        java.sql.Statement stmt = null;

        String departament =request.getParameter("deleteDepartament");
        System.out.println("Departamentul este:" + departament);

        response.setContentType("text/html");

        // Actual logic goes here.
        PrintWriter out = response.getWriter();
       /* out.println("<h1>" + name + "</h1>");
        out.println("<body>" + departament + "</body>");*/
        out.println("Si acum conectarea:</br>");

        Connection connection = getConnection();

        String sql = "delete from departament where Denumire_Departament = '"+departament+"';";

        try {
            stmt = connection.createStatement();
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        out.println("S-a efectuat si Stergerea!!");
    }


    public Connection getConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Where is your MySQL JDBC Driver?");
            e.printStackTrace();
            return null;
        }

        System.out.println("MySQL JDBC Driver Registered!");
        Connection connection = null;


        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/endava", "root", "catamaster11");

        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            return null;
        }

        if (connection != null) {
            System.out.println("You made it, take control your database now!");
        } else {
            System.out.println("Failed to make connection!");
        }
        return connection;
    }
}
