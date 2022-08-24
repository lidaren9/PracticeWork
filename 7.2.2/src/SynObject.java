public class SynObject {
    int i;
    int j;
    public synchronized void add() {
        i++;
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        j++;
        System.out.println("Operator : + Data: i = " + i + ", j = " + j);
    }
    public synchronized void minus() {
        i--;
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        j--;
        System.out.println("Operator : - Data: i = " + i + ", j = " + j);
    }
}
