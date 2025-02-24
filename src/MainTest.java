import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

class MainTest {
    @Nested
    @DisplayName("test for method retainAll")
    class RetainAllTests{


    @Test
    @DisplayName("checking the intersection between two sets")
    void testRetainAll() {
        List<Person> list1 = List.of(
                new Person("Olga", 34),
                new Person("Jack", 26),
                new Person("Mark", 19),
                new Person("Sandra", 22)
        );

        List<Person> list2 = List.of(
                new Person("Jack", 26),
                new Person("Sandra", 22),
                new Person("John", 62),
                new Person("Oleg", 17)
        );

        Set<Person> set1 = new HashSet<>(list1);
        Set<Person> set2 = new HashSet<>(list2);
        set1.retainAll(set2);

        Set<Person> expectedSet = new HashSet<>(List.of(
                new Person("Jack", 26),
                new Person("Sandra", 22)
        ));

        Assertions.assertEquals(expectedSet,set1);
    }

        @Test
        @DisplayName("checking intersection with an identical set")
        void testRetainAllWithSameSet(){
            List<Person> list1 = List.of(
                    new Person("Olga", 34),
                    new Person("Jack", 26)
            );

            Set<Person> set1 = new HashSet<>(list1);
            Set<Person> set2 = new HashSet<>(list1);

            set1.retainAll(set2);

            Assertions.assertEquals(set1, set2);
        }

}
}