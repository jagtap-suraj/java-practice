import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class OptionalClsMethodRefPractice {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("John", "Lenon", "Harry");
        Optional<String> res = names.stream()
                .filter(name -> name.contains("z"))
                .findFirst();

        System.out.println("Result: " + res.orElse("Not Found"));

        String res2 = names.stream()
                .filter(name -> name.contains("J"))
                .findFirst()
                .orElse("Not Found");

        System.out.println("Result2: " + res2);

        List<String> uNames = names.stream()
                .map(String::toUpperCase)
                .toList();

        uNames.forEach(System.out::println);
    }
}
