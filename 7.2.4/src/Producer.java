public class Producer extends Thread {
    private ProductData s;

    Producer(ProductData s) {
        this.s = s;
    }

    @Override
    public void run() {
        for (int i = 0; i <= 5; i++) {
            s.product(i);
            System.out.println("P[" + i + "] Product.");
        }
    }
}