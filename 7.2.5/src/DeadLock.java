class T extends Thread {
    // 得到另外一个线程
    T t;

    @Override
    public void run() {
        sync();
    }

    public synchronized void sync() {
        try {
            sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t.anoSyc();
    }

    public synchronized void anoSyc() {

    }
}

public class DeadLock extends Thread {
    public static void main(String[] args) {
        T t1 = new T();
        T t2 = new T();
        t1.t = t2;
        t2.t = t1;
        t1.start();
        t2.start();
        System.out.println("main finished");
    }
}
