import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCTrans {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection connection = null;
        PreparedStatement ps;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_demo", "root", "123456");
            // 开启非自动提交模式
            connection.setAutoCommit(false);
            String sql = "insert into student (id, name, score) values (?, ?, ?)";
            ps = connection.prepareStatement(sql);
            ps.setString(1, "1");
            ps.setString(2, "Peter");
            ps.setInt(3, 95);
            ps.addBatch();
            ps.setString(1, "2");
            ps.setString(2, "Mike");
            ps.setInt(3, 90);
            ps.addBatch();
            // 执行批处理，但有了事务，这句话执行后不会立即提交
            ps.executeBatch();
            // 在commit时插入两条数据
            connection.commit();
        } catch (SQLException e) {
            // 一旦出现异常，则在catch中进行回滚
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
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
