public class SynThreadMinus extends Thread{
    SynObject o;

    public SynThreadMinus(SynObject o) {
        this.o = o;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            o.minus();
        }
    }
}
