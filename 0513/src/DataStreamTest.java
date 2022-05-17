import java.io.*;

public class DataStreamTest {

    public static void main(String[] args) {

//        int age = 20;
//        String name = "hong";
//        double weight = 76.3;
//
//        FileOutputStream fos = null;
//        DataOutputStream dos = null;
//
//        try {
//            fos = new FileOutputStream("info.dat");
//            dos = new DataOutputStream(fos);
//            dos.writeInt(age);
//            dos.writeUTF(name);
//            dos.writeDouble(weight);
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                if (dos != null) dos.close();
//            } catch (IOException e) {}
//        }

        FileInputStream fis = null;
        DataInputStream dis = null;

        try {
            fis = new FileInputStream("info.dat");
            dis = new DataInputStream(fis);
            int age = dis.readInt();
            String name = dis.readUTF();
            double weight = dis.readDouble();
            System.out.println(age);
            System.out.println(name);
            System.out.println(weight);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (dis != null) dis.close();
            } catch (IOException e) {}
        }
    }
}
