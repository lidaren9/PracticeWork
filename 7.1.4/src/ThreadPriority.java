public class ThreadPriority implements Runnable{
    // 线程编号
    int number;

    public ThreadPriority(int number) {
        this.number = number;
        System.out.println("Creat Thread [" + number + "]");
    }

    // run方法，当调用线程的start方法时会调用该方法
    @Override
    public void run() {
        for (int i = 0; i <= 3; i++) {
            System.out.println("Thread number [" + number + "]:" + i);
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new ThreadPriority(1));
        t1.setPriority(1);

        Thread t2 = new Thread(new ThreadPriority(2));
        t2.setPriority(8);

        t1.start();
        t2.start();
    }
}
