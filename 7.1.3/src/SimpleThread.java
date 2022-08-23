public class SimpleThread extends Thread {
    int index;
    public SimpleThread(int index) {
        this.index = index;
        System.out.println("创造了Thread[" + index + "]");
    }
    @Override
    public void run() {
        for (int j = 0; j <= 3; j++) {
            System.out.println("Thread [" + index + "]:running time " + j);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i <= 3; i++) {
            Thread t = new SimpleThread(i + 1);
            t.start();
        }
    }
}
