public class Consumer extends Thread {
    private ProductData s;

    Consumer(ProductData s) {
        this.s = s;
    }

    @Override
    public void run() {
        int i;
        do {
            i = s.consume();
            System.out.println("P[" + i + "] Consume.");
        } while (i != 9);
    }
}
