import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class IOReadZip {
    public static void main(String[] args) {
        int cont;
        FileInputStream fin = null;
        ZipInputStream zin = null;
        ZipEntry ze = null;
        // 指定待读取的文件
        try {
            fin = new FileInputStream("F:\\IDEA_Space\\PracticeWork\\PracticeWork\\4.3.4\\redirect.zip");
            zin = new ZipInputStream(new BufferedInputStream(fin));
            while ((ze = zin.getNextEntry()) != null) {
                System.out.println("file name is : " + ze);
                while ((cont = zin.read()) != -1) {
                    System.out.write(cont);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fin.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                zin.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
