import java.io.*;

public class IORedirectInput {
    public static void main(String[] args) {
        BufferedInputStream bin = null;
        DataInputStream ds = null;
        try {
            String tmp;
            // 将文件里的内容读到bin内存缓冲区
            bin = new BufferedInputStream(new FileInputStream("4.3.3/src/redirect.txt"));
            // 设置重定向
            System.setIn(bin);
            // 从重定向的输入中读取内容，并逐行输出
            ds = new DataInputStream(System.in);
            while ((tmp = ds.readLine()) != null) {
                System.out.println(tmp);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("文件没找到");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭IO对象
            try {
                if (bin != null) {
                    bin.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (ds != null) {
                    ds.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
