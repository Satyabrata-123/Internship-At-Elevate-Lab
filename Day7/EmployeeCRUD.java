package Day7;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class EmployeeCRUD {

    private static final String URL = "jdbc:mysql://localhost:3306/ElevateInternship";
    private static final String USER = "root";
    private static final String PASSWORD = "Satya@123";

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    private static void addEmployee(String name, double salary) {
        String insertSql = "INSERT INTO Employee(name, salary) VALUES (?, ?)";
        try (
            Connection con = getConnection();
            PreparedStatement st = con.prepareStatement(insertSql)
        ) {
            st.setString(1, name);
            st.setDouble(2, salary);
            System.out.println(st.executeUpdate() + " Employee added.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void viewEmployees() {
        String viewSql = "SELECT * FROM Employee";
        try (
            Connection con = getConnection();
            PreparedStatement st = con.prepareStatement(viewSql);
            ResultSet rs = st.executeQuery()
        ) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") +
                                   "\tName: " + rs.getString("name") +
                                   "\tSalary: " + rs.getDouble("salary"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void updateEmployee(int id, String newName, double newSalary) {
        String updateSql = "UPDATE Employee SET name = ?, salary = ? WHERE id = ?";
        try (
            Connection con = getConnection();
            PreparedStatement st = con.prepareStatement(updateSql)
        ) {
            st.setString(1, newName);
            st.setDouble(2, newSalary);
            st.setInt(3, id);
            System.out.println(st.executeUpdate() + " Employee updated.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void deleteEmployee(int id) {
        String deleteSql = "DELETE FROM Employee WHERE id = ?";
        try (
            Connection con = getConnection();
            PreparedStatement st = con.prepareStatement(deleteSql)
        ) {
            st.setInt(1, id);
            System.out.println(st.executeUpdate() + " Employee(s) deleted.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Optional: Explicit driver loading (only if classpath issues)
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found!");
            return;
        }

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n==== Employee Management ====");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    sc.nextLine(); // consume newline
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter salary: ");
                    double salary = sc.nextDouble();
                    addEmployee(name, salary);
                    break;

                case 2:
                    viewEmployees();
                    break;

                case 3:
                    System.out.print("Enter ID to update: ");
                    int updateId = sc.nextInt();
                    sc.nextLine(); // consume newline
                    System.out.print("Enter new name: ");
                    String newName = sc.nextLine();
                    System.out.print("Enter new salary: ");
                    double newSalary = sc.nextDouble();
                    updateEmployee(updateId, newName, newSalary);
                    break;

                case 4:
                    System.out.print("Enter ID to delete: ");
                    int deleteId = sc.nextInt();
                    deleteEmployee(deleteId);
                    break;

                case 5:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
