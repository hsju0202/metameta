package acc;

import java.io.Serializable;

public class Account implements Serializable {
    String id;
    String name;
    int balance;

    public Account() {}

    public Account(String id, String name, int money) {
        this.id = id;
        this.name = name;
        this.balance = money;
    }

    public void deposit(int money){
        balance += money;
    }

    public void withdraw(int money){
        if (balance >= money) {
            balance -= money;
        }
    }

    @Override
    public String toString() {
        return "계좌번호: " + id +
                ", 이름: " + name +
                ", 잔액: " + balance;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
