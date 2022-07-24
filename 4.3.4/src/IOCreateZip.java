import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class IOCreateZip {
    public static void main(String[] args) {
        // 设置压缩后的文件名
        String zipFile = "F:\\IDEA_Space\\PracticeWork\\PracticeWork\\4.3.4\\redirect.zip";
        // 指定待压缩的文件
        String file = "F:\\IDEA_Space\\PracticeWork\\PracticeWork\\4.3.4\\redirect.txt";
        int zipRes = -1;
        FileOutputStream fout = null;
        ZipOutputStream zout = null;
        BufferedOutputStream bout = null;
        FileInputStream fisOne = null;
        BufferedInputStream bisOne = null;
        try {
            fout = new FileOutputStream(zipFile);
            zout = new ZipOutputStream(fout);
            bout = new BufferedOutputStream(zout);
            fisOne = new FileInputStream(file);
            bisOne = new BufferedInputStream(fisOne);
            zout.putNextEntry(new ZipEntry("redirect.txt"));
            // 逐行读取文件，把读取的文件添加到压缩流
            while ((zipRes = bisOne.read()) != -1) {
                bout.write(zipRes);
            }
            // 强制输出
            bout.flush();
            System.out.println("start wait");
            Thread.sleep(5000);
            System.out.println("wait end");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bisOne != null) {
                    bisOne.close();
                }
                if (fout != null) {
                    fout.close();
                }
                if (zout != null) {
                    zout.close();
                }
                if (fisOne != null) {
                    fisOne.close();
                }
                if (bout != null) {
                    bout.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
