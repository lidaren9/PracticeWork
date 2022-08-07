import java.io.*;
import java.sql.*;
import java.util.Properties;

public class JDBCByConfig {
    public static void main(String[] args) {
        String fileName;
        if (args != null && args.length == 1) {
            fileName = args[0] + ".properties";
        } else {
            fileName = "qa.properties";
        }
        String driver = null;
        String url = null;
        String username = null;
        String pwd = null;
        Properties prop = new Properties();
        InputStream in = null;
        try {
            System.out.println(fileName);
            // 读配置和文件
            in = new BufferedInputStream(new FileInputStream("5.3.1/src/prop/" + fileName));
            prop.load(in);
            // 读JDBC连接参数
            driver = prop.getProperty("mysql.Driver");
            url = prop.getProperty("mysql.url");
            username = prop.getProperty("mysql.username");
            pwd = prop.getProperty("mysql.pwd");
        } catch (IOException e) {
            e.printStackTrace();
            return;
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                prop.clear();
            }
        }
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = DriverManager.getConnection(url, username, pwd);
            ps = connection.prepareStatement("select id, name, score from student");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                System.out.print("id : " + rs.getString("id")  + " ");
                System.out.print("name : " + rs.getString("name") + " ");
                System.out.println("Score : " + rs.getInt("score"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                ps.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
