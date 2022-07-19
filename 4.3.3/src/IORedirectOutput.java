import java.io.*;

//输出的重定向
public class IORedirectOutput {
    public static void main(String[] args) {
        FileOutputStream fout = null;
        BufferedOutputStream bout = null;
        PrintStream ps = null;
        try {
            fout = new FileOutputStream("F:\\IDEA_Space\\PracticeWork\\PracticeWork\\4.3.3\\src\\redirect.txt");
            bout = new BufferedOutputStream(fout);
            ps = new PrintStream(bout);
            System.setOut(ps);
            System.out.println("sdjfasljdflasjdgasgasdg收到反馈数据格式苦涩哦我空间给");
            ps.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            ps.close();
            try {
                bout.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fout.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
