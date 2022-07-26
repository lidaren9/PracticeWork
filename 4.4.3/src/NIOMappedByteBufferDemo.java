import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class NIOMappedByteBufferDemo {
    public static void main(String[] args) throws IOException {
        // 10M
        int length = 1024 * 1024 * 10;
        MappedByteBuffer out = new RandomAccessFile("4.4.3/bigFile.txt", "rw").getChannel().map(FileChannel.MapMode.READ_WRITE, 0, length);
        // 写文件
        for (int i = 0; i < length; i++) {
            out.put((byte) 'a');
        }
        // 只读取其中前10位
        for (int i = 0; i < 10; i++) {
            System.out.println((char) out.get(i));
        }
    }
}
