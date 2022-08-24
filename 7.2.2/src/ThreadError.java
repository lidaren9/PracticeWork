public class ThreadError {
    public static void main(String[] args) {
        SynObject o = new SynObject();
        Thread t1 = new SynThreadAdd(o);
        Thread t2 = new SynThreadMinus(o);
        t1.start();
        t2.start();
    }
}
