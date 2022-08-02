import java.sql.*;

public class JDBCWriter {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("找不到数据库驱动");
            e.printStackTrace();
            return;
        }
        Connection connection = null;
        Statement statement = null;
        PreparedStatement ps = null;
        int affectRows = 0;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_demo", "root", "123456");
            if (connection != null) {
                statement = connection.createStatement();
                String insSql = "insert into student (id, name, score) values ('008', 'Tom', '88')";
                affectRows = statement.executeUpdate(insSql);
                String updateSql = "update student set score = 100 where id = '008'";
                ps = connection.prepareStatement(updateSql);
                affectRows = ps.executeUpdate();
                String delSql = "delete from student where id = '008'";
                ps = connection.prepareStatement(delSql);
                affectRows = ps.executeUpdate();
            } else {
                System.out.println("数据库连接失败");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
                ps.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
