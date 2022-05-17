import java.util.HashSet;

public class HashSetTest {

    public static void main(String[] args) {
        HashSet hs = new HashSet();
        hs.add(10);
        hs.add(20);
        hs.add(30);

        for (Object h : hs) {
            System.out.println(h);
        }

        HashSet<Person> hsp = new HashSet<>();
        hsp.add(new Person(10, "홍길동"));
        hsp.add(new Person(20, "김길동"));
        hsp.add(new Person(10, "박길동"));
        hsp.add(new Person(10, "홍길동"));

        for (Person person : hsp) {
            System.out.println(person);
        }
    }
}
