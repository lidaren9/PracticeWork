import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;



public class JDBCC3P0Demo {
    public static void main(String[] args) {
        // 初始化连接池对象
        ComboPooledDataSource ds;
        ds = new ComboPooledDataSource();
        try {
            // 设置连接池的驱动
            ds.setDriverClass("com.mysql.jdbc.Driver");
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        // 设置连接数据库的URL
        ds.setJdbcUrl("jdbc:mysql://localhost:3306/jdbc_demo");
        ds.setUser("root");
        ds.setPassword("123456");
        ds.setMaxPoolSize(10);
        ds.setMinPoolSize(2);
        ds.setInitialPoolSize(10);
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            // 通过ds这个连接池对象获得连接
            conn = ds.getConnection();
            String sql = "SELECT * FROM student";
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println("Name is : " + rs.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                ps.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
