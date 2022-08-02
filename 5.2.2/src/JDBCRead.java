import java.sql.*;

public class JDBCRead {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Where is your MySQL JDBC Driver?");
            e.printStackTrace();
            return;
        }
        Connection connection = null;
        Statement stmt = null;
        try {
            connection =  DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_demo", "root", "123456");
            if (connection != null) {
                stmt = connection.createStatement();
                String query = "select id, name, score from student";
                ResultSet rs = stmt.executeQuery(query);
                while (rs.next()) {
                    System.out.print("id : " + rs.getString("id") + " ");
                    System.out.print("name : " + rs.getString("name") + " ");
                    System.out.println("score : " + rs.getString("score"));
                }
            } else {
                System.out.println("failed to make connection!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
