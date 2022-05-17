class Account {
    String id;
    String name;
    int balance;

    public Account() {}

    public Account(String id, String name, int balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    public String info() {
        return "계좌번호: " + id + ", 이름: " + name + ", 잔액: " + balance;
    }

    public void deposit(int amount) {
        balance += amount;
    }

    public void withdraw(int amount) {
        balance -= amount;
    }
}

public class ClassTest2 {
    public static void main(String[] args) {
        Account acc1 = new Account();
        acc1.id = "10001";
        acc1.name = "홍길동";
        acc1.balance = 100000;

        System.out.println(acc1.info());
        acc1.deposit(10000);
        System.out.println(acc1.info());
        acc1.withdraw(5000);
        System.out.println(acc1.info());

        Account acc2 = new Account("10002", "고길동", 200000);
    }
}
