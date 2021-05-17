import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Person> people = Arrays.asList(
                new Person("Shafig","Tahmasib","21"),
                new Person("name2","surname2","15"),
                new Person("name3","surname3","35"),
                new Person("name4","surname4","45"),
                new Person("name5","surname5","49"),
                new Person("name6","surname6","49"),
                new Person("name7","surname7","10"),
                new Person("name8","surname8","12")
                );

//        List<Integer> ageGreaterThan18 = people
//                .stream()
//                .map(Person::getAge)
//                .collect(Collectors.toList())
//                .stream()
//                .map(Integer::parseInt)
//                .filter(x -> x > 18)
//                .collect(Collectors.toList());

        List<Person> filtered =
                people
                .stream()
                .filter(x -> Integer.parseInt(x.getAge()) > 18)
                .collect(Collectors.toList());

        int sum =
                people
                .stream()
                .map(Person::getAge)
                .collect(Collectors.toList())
                .stream()
                .map(Integer::parseInt)
                .filter(x -> x > 18)
                .reduce(0, Integer::sum);

        double p =
                people
                .stream()
                .map(Person::getAge)
                .collect(Collectors.toList())
                .stream()
                .map(Integer::parseInt)
                .mapToDouble(a -> a)
                .average()
                .getAsDouble();

        System.out.println(filtered+"\n");
        System.out.println("Sum of people with age greater than 18: " +sum+ "\n");
        System.out.println("Average age of people: "+p);
    }
}
