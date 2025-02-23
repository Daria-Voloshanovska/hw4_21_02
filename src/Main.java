/* Дано два списка с Person необходимо получить Set с персонами которые присутствуют и в том и в другом списке
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        List<Person> list1 = new ArrayList<>();
        list1.add(new Person("Olga", 34));
        list1.add(new Person("Jack", 26));
        list1.add(new Person("Mark", 19));
        list1.add(new Person("Sandra", 22));

        List<Person> list2 = new ArrayList<>();
        list2.add(new Person("Jack", 26));
        list2.add(new Person("Sandra", 22));
        list2.add(new Person("John", 62));
        list2.add(new Person("Oleg", 17));


        Set<Person> set1 = new HashSet<>(list1);
        Set<Person> set2 = new HashSet<>(list2);

        set1.retainAll(set2);

        for (Person person : set1) {
            System.out.println(person.getName() + " " + person.getAge());
        }

    }
}