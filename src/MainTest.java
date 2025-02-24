import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@DisplayName("Person Intersection Tests")
class MainTest {
    @Nested
    @DisplayName("Tests for Common Persons in Lists")
    class CommonPersonsTests{


    @Test
    @DisplayName("Lists have common persons")
    void testCommonPersonsPresent() {
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

        Assertions.assertEquals(2, set1.size(), "Expected 2 common persons");
        Assertions.assertTrue(set1.contains(new Person("Jack", 26)));
        Assertions.assertTrue(set1.contains(new Person("Sandra", 22)));
    }

        @Test
        @DisplayName("Lists have no common persons")
        void testNoCommonPersons(){
            List<Person> list1 = List.of(
                    new Person("Olga", 34),
                    new Person("Jack", 26)
            );

            Set<Person> set1 = new HashSet<>(list1);
            Set<Person> set2 = new HashSet<>(list1);

            set1.retainAll(set2);

            Assertions.assertTrue(set1.isEmpty(), "Expected no common persons");
        }

        @Test
        @DisplayName("Empty input lists")
        void testEmptyLists() {
            List<Person> list1 = List.of();
            List<Person> list2 = List.of();

            Set<Person> set1 = new HashSet<>(list1);
            Set<Person> set2 = new HashSet<>(list2);

            set1.retainAll(set2);

            Assertions.assertTrue(set1.isEmpty(), "Expected no common persons with empty lists");
        }
    }
}
