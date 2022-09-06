class Account {
    int balance;

    Account() {
        balance = 0;
    }

    public synchronized void login() {

    }

    public synchronized void logout() {

    }

    public synchronized void add() {
        balance += 800;
        System.out.println("After add balance is : " + balance);
    }

    public synchronized void minus() {
        balance -= 800;
        System.out.println("After minus balance is : " + balance);
    }
}

class AddThread extends Thread {
    // 用于输出加钱人
    String person;

    // 价钱的账户
    Account acc;

    public AddThread(String person, Account acc) {
        this.person = person;
        this.acc = acc;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println(person + " add money, " + i + "cnt");
            acc.login();
            System.out.println(person + " login");
            try {
                sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            acc.add();
            System.out.println(person + " logout");
            acc.logout();
        }
    }
}

class MinusThread extends Thread {
    Account acc;

    String person;

    public MinusThread(Account acc, String person) {
        this.acc = acc;
        this.person = person;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println(person + " minus money, " + i + "cnt");
            System.out.println(person + " login");
            acc.login();
            try {
                sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            acc.minus();
            System.out.println(person + " logout");
            acc.logout();
        }
    }
}

public class SyncLimit {
    public static void main(String[] args) {
        Account acc = new Account();
        Thread add = new AddThread("Tom", acc);
        Thread minus = new MinusThread( acc, "Peter");
        add.start();
        minus.start();
    }
}
