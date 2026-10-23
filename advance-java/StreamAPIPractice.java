import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class StreamAPIPractice {

    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(4, 5, 7, 3, 2, 6);

        System.out.print("Consumer: ");
        Consumer<Integer> con = n -> System.out.print(n);
        nums.forEach(con);
        // or
        System.out.print("\nforEach: ");
        nums.forEach(n -> System.out.print(n));

        Stream<Integer> s1 = nums.stream();

        Stream<Integer> s2 = s1.filter(n -> n % 2 == 0).sorted();
        System.out.print("\nFilter: ");
        s2.forEach(n -> System.out.print(n)); // We can't reuse a stream

        // Stream<Integer> s3 = s2.map(n -> n * 2);
        // System.out.print("\nMap: ");
        // s3.forEach(n -> System.out.print(n));

        // int result = s3.reduce(0, (c, e)->c + e);
        // System.out.print("\nReduce: ");
        // System.out.println(result);

        // Combined
        int combinedResult = nums.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> n * 2)
                .reduce(0, (c, e) -> c + e);
        System.out.println("\nCombined Result: " + combinedResult);

        // Individual
        Predicate<Integer> p = n -> n % 2 == 0 ? true : false;
        Function<Integer, Integer> fun = n -> n * 2;
        BinaryOperator<Integer> acc = (t, u) -> t + u;

        int result = nums.stream() // nums.parallelstream() for filtering to work with multiple thread
                .filter(p)
                .map(fun)
                .reduce(0, acc);

        System.out.println("Individual Result: " + result);

    }
}
