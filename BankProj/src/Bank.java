import acc.Account;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class Bank {

    Scanner sc = new Scanner(System.in);
    HashMap<String, Account> accs = new HashMap<>();

    public void makeAccount() {
        System.out.println("[계좌개설]");

        System.out.print("계좌번호: ");
        String id = sc.nextLine();

        System.out.print("이름: ");
        String name = sc.nextLine();

        System.out.print("입금액: ");
        int money = Integer.parseInt(sc.nextLine());

        accs.put(id, new Account(id, name, money));
    }

    public void deposit() {
        System.out.println("[입금]");

        System.out.print("계좌번호: ");
        String id = sc.nextLine();

        System.out.print("입금액: ");
        int money = Integer.parseInt(sc.nextLine());

        if (!accs.containsKey(id))
            System.out.println("계좌번호가 틀립니다.");
        else
            accs.get(id).deposit(money);
    }

    public void withdraw() {
        System.out.println("[출금]");

        System.out.print("계좌번호: ");
        String id = sc.nextLine();

        System.out.print("출금액: ");
        int money = Integer.parseInt(sc.nextLine());

        if (!accs.containsKey(id))
            System.out.println("계좌번호가 틀립니다.");
        else
            accs.get(id).withdraw(money);
    }

    public void accountInfo() {
        System.out.println("[계좌조회]");

        System.out.print("계좌번호: ");
        String id = sc.nextLine();

        if (!accs.containsKey(id))
            System.out.println("계좌번호가 틀립니다.");
        else
            System.out.println(accs.get(id));
    }

    public void allAccountInfo() {
        System.out.println("[전체계좌조회]");
        for (Account acc : accs.values()) {
            System.out.println(acc);
        }
    }

    public int selMenu() {
        System.out.println("[메타은행]");
        System.out.println("0.종료");
        System.out.println("1.계좌개설");
        System.out.println("2.입금");
        System.out.println("3.출금");
        System.out.println("4.계좌조회");
        System.out.println("5.전체계좌조회");
        System.out.print("선택>>");
        int sel = Integer.parseInt(sc.nextLine());
        return sel;
    }

    public void saveAccount_b() {
        FileOutputStream fos = null;
        DataOutputStream dos = null;
        try {
            fos = new FileOutputStream("accs.bin");
            dos = new DataOutputStream(fos);
            dos.writeInt(accs.size());
            for (Account acc : accs.values()) {
                dos.writeUTF(acc.getId());
                dos.writeUTF(acc.getName());
                dos.writeInt(acc.getBalance());
            }
        } catch (IOException e) {

        } finally {
            try {
                if (dos != null) dos.close();
            } catch (IOException e) {}
        }
    }

    public void loadAccount_b() {
        FileInputStream fis = null;
        DataInputStream dis = null;
        try {
            fis = new FileInputStream("accs.bin");
            dis = new DataInputStream(fis);
            int cnt = dis.readInt();
            for (int i=0; i<cnt; i++) {
                String id = dis.readUTF();
                String name = dis.readUTF();
                int balance = dis.readInt();
                accs.put(id, new Account(id, name, balance));
            }
        } catch (IOException e) {

        } finally {
            try {
                if (dis != null) dis.close();
            } catch (IOException e) {}
        }
    }

    public void saveAccount_t() {
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            fw = new FileWriter("accs.txt");
            bw = new BufferedWriter(fw);
            for (Account acc : accs.values()) {
                String accstr = "";
                accstr += acc.getId() + "#";
                accstr += acc.getName() + "#";
                accstr += acc.getBalance();
                bw.write(accstr);
                bw.newLine();
            }
        } catch (IOException e) {

        } finally {
            try {
                if (bw != null) bw.close();
            } catch (IOException e) {}
        }
    }

    public void loadAccount_t() {
        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader("accs.txt");
            br = new BufferedReader(fr);
            String accstr = null;
            while ((accstr = br.readLine()) != null) {
                String[] accCol = accstr.split("#");
                accs.put(accCol[0], new Account(accCol[0], accCol[1], Integer.parseInt(accCol[2])));
            }
        } catch (IOException e) {

        } finally {
            try {
                if (br != null) br.close();
            } catch (IOException e) {}
        }
    }

    public void saveAccount_o() {
        FileOutputStream fow = null;
        ObjectOutputStream oos = null;
        try {
            fow = new FileOutputStream("accs.ser");
            oos = new ObjectOutputStream(fow);
            oos.writeInt(accs.size());
            for (Account acc : accs.values()) {
                oos.writeObject(acc);
            }
        } catch (IOException e) {

        } finally {
            try {
                if (oos != null) oos.close();
            } catch (IOException e) {}
        }
    }

    public void loadAccount_o() {
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream("accs.ser");
            ois = new ObjectInputStream(fis);
            int cnt = ois.readInt();
            for (int i=0; i<cnt; i++) {
                Account acc = (Account)ois.readObject();
                accs.put(acc.getId(), acc);
            }
        } catch (ClassNotFoundException e) {

        } catch (IOException e) {

        } finally {
            try {
                if (ois != null) ois.close();
            } catch (IOException e) {}
        }
    }

    public static void main(String[] args) {
        Bank bank = new Bank();
        bank.loadAccount_o();

        while (true) {
            try {
                int sel = bank.selMenu();

                if (sel == 0) {
                    bank.saveAccount_o();
                    break;
                }

                switch (sel) {
                    case 1:
                        bank.makeAccount();
                        break;
                    case 2:
                        bank.deposit();
                        break;
                    case 3:
                        bank.withdraw();
                        break;
                    case 4:
                        bank.accountInfo();
                        break;
                    case 5:
                        bank.allAccountInfo();
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("입력 형식이 올바르지 않습니다.");
            }
        }
    }
}
