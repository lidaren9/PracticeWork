public class ProducerConsumer {
    public static void main(String[] args) {
        ProductData s = new ProductData();
        new Producer(s).start();
        new Consumer(s).start();
    }
}
