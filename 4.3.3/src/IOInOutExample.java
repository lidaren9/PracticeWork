import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IOInOutExample {
    public static void main(String[] args) {
        // 从System.in中读取内容，并放入缓存br
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String read = null;
        System.out.print("input is : ");
        try {
            read = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("output is : " + read);
    }
}
