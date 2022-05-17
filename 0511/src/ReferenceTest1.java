class Number {
    int n;
}

public class ReferenceTest1 {
    public static void func(int d) {
        System.out.println(d);
        d++;
    }

    public static void main(String[] args) {
        Number number = new Number();
        number.n = 10;
        func(number.n);
        System.out.println(number.n);
    }
}
