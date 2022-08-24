public class SyncBlock implements Runnable{
    @Override
    public void run() {
        synchronized (this) {
            for (int i = 0; i < 3; i++) {
                System.out.println(Thread.currentThread().getName() + ",count:" + i);
            }
        }
    }

    public static void main(String[] args) {
        SyncBlock sb = new SyncBlock();
        Thread t1 = new Thread(sb, "A");
        Thread t2 = new Thread(sb, "B");
        t1.start();
        t2.start();
    }
}
