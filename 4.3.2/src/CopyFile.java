import java.io.*;

public class CopyFile {
    public static void main(String[] args) {
        fileCopy("F:\\IDEA_Space\\PracticeWork\\PracticeWork\\4.3.2\\src\\IBMCustom\\IBM.csv", "F:\\IDEA_Space\\PracticeWork\\PracticeWork\\4.3.2\\src\\history\\IBM.csv");
    }

    static void fileCopy(String src, String des) {
        InputStream input = null;
        OutputStream output = null;
        try {
            input = new FileInputStream(src);
            output = new FileOutputStream(des);
            int length = input.available();
            byte[] buffer = new byte[length];
            input.read(buffer);
            output.write(buffer);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (output != null) {
                try {
                    output.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
