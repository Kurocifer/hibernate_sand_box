import java.sql.*;

public class JDBCExample {
    static final String DB_URL = "jdbc:mysql://localhost/tutorialspointdb?serverTimezone=UTC&useSSL=false";
    static final String USER = "hibernate_user";
    static final String PASS = "password";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql = "SELECT id, first_name, last_name, salary FROM EMPLOYEE";
            ResultSet rs = stmt.executeQuery(sql);
            
            while(rs.next()) {
                int id = rs.getInt("id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                int salary = rs.getInt("salary");
                
                System.out.print("ID: " + id);
                System.out.print(", First: " + firstName);
                System.out.print(", Last: " + lastName);
                System.out.println(", Salary: " + salary);
            }
            
            rs.close();
            stmt.close();
            conn.close();
            
        } catch(SQLException se) {
            se.printStackTrace();
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(stmt != null) stmt.close();
            } catch(SQLException se) {}
            try {
                if(conn != null) conn.close();
            } catch(SQLException se) {
                se.printStackTrace();
            }
        }
        
        System.out.println("Done!");
    }
}
