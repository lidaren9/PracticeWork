import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCBatch {
    public static void main(String[] args) {
        // 装载MySQL的驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection connection = null;
        PreparedStatement pstmt;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_demo", "root", "123456");
            String query = "insert into student (id, name, score) values (?, ?, ?)";
            pstmt = connection.prepareStatement(query);
            // 插入第一条数据
            pstmt.setString(1, "1");
            pstmt.setString(2, "Peter");
            pstmt.setInt(3, 95);
            // 插入第二条数据
            pstmt.addBatch();
            pstmt.setString(1, "2");
            pstmt.setString(2, "Mike");
            pstmt.setInt(3, 90);
            pstmt.addBatch();
            pstmt.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}