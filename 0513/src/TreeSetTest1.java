import java.util.Comparator;
import java.util.TreeSet;

public class TreeSetTest1 {

    public static void main(String[] args) {
        TreeSet<Person> ts = new TreeSet<>();

        ts.add(new Person(30, "홍길동"));
        ts.add(new Person(20, "고길동"));
        ts.add(new Person(10, "박길동"));

        for (Person p : ts) {
            System.out.println(p);
        }

        TreeSet<Person> tsn = new TreeSet<>((o1, o2) -> o1.getName().compareTo(o2.getName()));

        tsn.add(new Person(30, "홍길동"));
        tsn.add(new Person(20, "고길동"));
        tsn.add(new Person(10, "박길동"));

        for (Person person : tsn) {
            System.out.println(person);
        }
    }
}
