import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NIOBufferDemo {
    public static void main(String[] args) {
        int bufferSize = 1024;
        try {
            FileChannel src = new FileInputStream("4.4.3\\source.txt").getChannel();
            FileChannel dest = new FileOutputStream("4.4.3\\dest.txt").getChannel();
            // 通过allocate()方法给ByteBuffer分配空间
            ByteBuffer buffer = ByteBuffer.allocate(bufferSize);
            // 从循环中逐行读取
            while (src.read(buffer) != -1) {
                // 切换读取模式
                buffer.flip();
                // 写
                dest.write(buffer);
                // 清空缓存
                buffer.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
