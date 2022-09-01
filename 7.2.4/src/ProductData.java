public class ProductData {
    // 表示被哪个生产者线程生产的编号
    private int number;
    // 标志位，true表示已经消费
    private boolean flag = true;

    public synchronized void product(int number) {
        if (!flag) {
            try {
                // 未消费，等待
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.number = number;
        // 标志已经生产
        flag = false;
        // 通知消费者已经生产，可以消费
        notify();
    }

    public synchronized int consume() {
        if (flag) {
            try {
                // 未生产等待
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // 标志已经消费
        flag = true;
        // 通知需要生产
        notify();
        return this.number;
    }
}
