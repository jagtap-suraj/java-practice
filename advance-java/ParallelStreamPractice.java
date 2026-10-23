import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ParallelStreamPractice {
    public static void main(String[] args) {
        int size = 100;
        List<Integer> nums = new ArrayList<>();
        Random ran = new Random();
        for (int i = 0; i < size; i++) {
            nums.add(ran.nextInt(10));
        }
        System.out.println(nums);

        int sum1 = nums.stream()
                .map(n -> n * 2)
                .reduce(0, (c, e) -> c + e);

        long startSequence = System.currentTimeMillis();
        int sum2 = nums.stream()
                .map(n -> {
                    try {
                        Thread.sleep(1);
                    } catch (Exception e) {
                    }
                    return n * 2;
                })
                .mapToInt(i -> i)
                .sum();
        long endSequence = System.currentTimeMillis();

        long startParallel = System.currentTimeMillis();
        int sum3 = nums.parallelStream()
                .map(n -> {
                    try {
                        Thread.sleep(1);
                    } catch (Exception e) {
                    }
                    return n * 2;
                })
                .mapToInt(i -> i)
                .sum();
        long endParallel = System.currentTimeMillis();

        System.out.println("Sum1: " + sum1 + " sum2: " + sum2 + " sum3: " + sum3);
        System.out.println("Seq: " + (endSequence - startSequence));
        System.out.println("Parallel: " + (endParallel - startParallel));
        // Parallel takes more time without adding delay, with added delay seq takes more time
    }
}
