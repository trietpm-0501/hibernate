
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class JDBC {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/test";
        String user = "root";
        String password = "";

        try {
            // Use the correct driver class name
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connection is Successful: " + url);

            String query = "SELECT * FROM customers";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String phone = rs.getString("phone");

                // In ra các giá trị để kiểm tra
                System.out.println("ID: " + id + ", Name: " + name + ", Phone: "
                        + phone);
            }
            // Đóng các đối tượng ResultSet và Statement
            rs.close();
            statement.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
