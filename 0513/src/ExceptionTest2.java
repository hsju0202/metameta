public class ExceptionTest2 {

    public static void func() throws Exception {
        String str = null;
        try {
            System.out.println(str.toString());
        }
        catch (NullPointerException e) {
            System.out.println("func");
        }
    }

    public static void main(String[] args) {
        try {
            func();
        } catch (Exception e) {
            System.out.println("main");
        }
    }
}
