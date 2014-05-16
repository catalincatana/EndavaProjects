/**
 * Created by ccatana on 5/15/2014.
 */
import java.beans.Statement;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

// Extend HttpServlet class
public class MyServlet extends HttpServlet {

    private String message;

    public void init() throws ServletException
    {
        // Do required initialization
        message = "Hello World";
    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException
    {
        // Set response content type
        response.setContentType("text/html");

        // Actual logic goes here.
        PrintWriter out = response.getWriter();
        out.println("<h1>" + message + "</h1>");
    }

    public void doPost(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException
    {
        java.sql.Statement stmt = null;
        String name =request.getParameter("cod");
        String departament =request.getParameter("departament");

        response.setContentType("text/html");

        // Actual logic goes here.
        PrintWriter out = response.getWriter();
       /* out.println("<h1>" + name + "</h1>");
        out.println("<body>" + departament + "</body>");*/
        out.println("Si acum conectarea:</br>");

        Connection connection = getConnection();

        String sql = "insert into departament (Cod_Departament, Denumire_Departament) values  ("+Integer.parseInt(name)+",'"+departament+"');";

        try {
            stmt = connection.createStatement();
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        out.println("S-a efectuat si inserarea!!");
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

    public void destroy()
    {
        // do nothing.
    }
}