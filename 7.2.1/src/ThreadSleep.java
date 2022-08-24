public class ThreadSleep extends Thread {
    @Override
    public void run() {
        Long curTime = System.currentTimeMillis();
        // sleep 方法会抛出InterruptedException异常
        try {
            sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("ts线程阻塞的时间 " + (System.currentTimeMillis() - curTime) + "毫秒");
    }

    public static void main(String[] args) {
        ThreadSleep ts = new ThreadSleep();
        ts.start();
        Long curTime = System.currentTimeMillis();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("主线程阻塞的时间 " + (System.currentTimeMillis() - curTime) + "毫秒");
    }
}
