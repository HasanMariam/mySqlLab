package org.closure;
import java.sql.*;

public class App 
{

    static final String DB_URL = "jdbc:mysql://localhost:3306/sakila";
    static final String USER = "root";
    static final String PASS = "root";
    static final String QUERY = "SELECT actor_id, first_name, last_name FROM sakila.actor";
    static String QUERY2 = "SELECT ? , ? FROM sakila.actor ";

    public static void main( String[] args )
    {
     try {
         int x = 1;
         Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
         PreparedStatement perStmt = conn.prepareStatement(QUERY2);
         perStmt.setString(1,"actor_id");
         perStmt.setInt(2,2);
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(QUERY);
         while (rs.next()) {
             // Retrieve by column name
             System.out.print("actor_id:"+rs.getInt("actor_id") +"  ");
             System.out.print("first_name:"+rs.getString("first_name")+"  ");
             System.out.print("last_name:"+rs.getString("last_name")+"  ");
             System.out.println(" ");
         }
         ResultSet  executeQ2 = perStmt.executeQuery();
         rs.next();
         System.out.println(executeQ2.getString(1));
         }
     catch (SQLException e) {
         e.printStackTrace();
              // Extract data from result set
           }

    // Open a connection




}



}
