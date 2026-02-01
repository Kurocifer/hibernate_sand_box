import java.sql.*;

public class EmployeeCRUD {
    static final String DB_URL = "jdbc:mysql://localhost/tutorialspointdb?serverTimezone=UTC&useSSL=false";
    static final String USER = "hibernate_user";
    static final String PASS = "password";
    
    public static void insertEmployee(String firstName, String lastName, int salary) {
        String sql = "INSERT INTO EMPLOYEE (first_name, last_name, salary) VALUES (?, ?, ?)";
        
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, firstName);
            pstmt.setString(2, lastName);
            pstmt.setInt(3, salary);
            
            int rowsAffected = pstmt.executeUpdate();
            System.out.println(rowsAffected + " row(s) inserted.");
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void listEmployees() {
        String sql = "SELECT id, first_name, last_name, salary FROM EMPLOYEE";
        
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            System.out.println("\n--- Employee List ---");
            while (rs.next()) {
                System.out.printf("ID: %d, Name: %s %s, Salary: $%d%n",
                    rs.getInt("id"),
                    rs.getString("first_name"),
                    rs.getString("last_name"),
                    rs.getInt("salary"));
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    // UPDATE - Update employee salary
    public static void updateSalary(int id, int newSalary) {
        String sql = "UPDATE EMPLOYEE SET salary = ? WHERE id = ?";
        
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, newSalary);
            pstmt.setInt(2, id);
            
            int rowsAffected = pstmt.executeUpdate();
            System.out.println(rowsAffected + " row(s) updated.");
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    // DELETE - Delete employee
    public static void deleteEmployee(int id) {
        String sql = "DELETE FROM EMPLOYEE WHERE id = ?";
        
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, id);
            
            int rowsAffected = pstmt.executeUpdate();
            System.out.println(rowsAffected + " row(s) deleted.");
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        System.out.println("__-_-_-_-_-_- INSERT _-_-_-_-_-_-_-__");
        insertEmployee("John", "Doe", 50000);
        insertEmployee("Jane", "Smith", 60000);
        insertEmployee("Bob", "Johnson", 55000);
        
        listEmployees();
        
        System.out.println("\n__-_-_-_-_- UPDATE _-_-_-_-_-__");
        updateSalary(1, 75000);
        listEmployees();
        
        System.out.println("\n__-_-_-_-_- DELETE _-_-_-_-_-__");
        deleteEmployee(3);
        listEmployees();
    }
}
