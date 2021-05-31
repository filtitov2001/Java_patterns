package Lab2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    static List<Human> people = List.of(Human.of(74, "Joseph", "Stalin", LocalDate.of(1878, 12, 18), 70),
            Human.of(56, "Adolf", "Hitler", LocalDate.of(1889, 4, 20), 50),
            Human.of(90, "Winston", "Churchill", LocalDate.of(1874, 11, 30), 95),
            Human.of(63, "Franklin", "Roosevelt", LocalDate.of(1882, 1, 30), 77),
            Human.of(61, "Benito", "Mussolini", LocalDate.of(1883, 7, 29), 66));

    public static void main(String[] args) {
        Function<String, Character> getSecondLetter = x -> x.charAt(1);
        Function<Human, Character> getHSecondLetter = h -> getSecondLetter.apply(h.getFirstname());
        System.out.println("Сортировка по 2 букве имени: ");
        List<Human> stream = people.stream().sorted(Comparator.comparing(getHSecondLetter).reversed()).collect(Collectors.toList());
        stream.forEach(System.out::println);
        System.out.println("\nФильтрация по весу больше чем 60: ");
        people.stream().filter(human -> human.getWeight() > 60).forEach(System.out::println);
        System.out.println("\nСортировка по возрасту: ");
        List<Human> stream2 = people.stream().sorted(Comparator.comparing(Human::getAge)).collect(Collectors.toList());
        stream2.forEach(System.out::println);
        System.out.println("\nПроизведение всех возрастов: ");
        System.out.println(people.stream().mapToInt(Human::getAge).reduce((h1, h2) -> h1 * h2));

    }
}
