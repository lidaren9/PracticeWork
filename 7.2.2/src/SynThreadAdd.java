public class SynThreadAdd extends Thread{
    SynObject o;

    public SynThreadAdd(SynObject o) {
        this.o = o;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            o.add();
        }
    }
}
