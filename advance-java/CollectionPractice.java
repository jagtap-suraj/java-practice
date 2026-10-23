import java.util.*;

public class CollectionPractice {
    public static void main(String[] args) {
        // Define
        List<Integer> nums = new ArrayList<Integer>();
        // Hashshet is a collection of unique values
        // Treeset has all the unique elements sorted
        Map<String, Integer> students = new HashMap<>();
        // HashTable is synchronized (multithreaded environment)

        // Fill in Data
        nums.add(6);
        nums.add(5);
        nums.add(7);

        students.put("Suraj", 10);
        students.put("Rajesh", 20);
        students.put("Ramesh", 30);
        students.put("Rajesh", 40);

        // Print Array/Set
        System.out.println(nums.indexOf(6));
        System.out.println(nums.get(2));
        System.out.println(nums);
        for (Integer i : nums) {
            System.out.println(i);
        }

        Iterator<Integer> values = nums.iterator();

        while (values.hasNext()) {
            System.out.println("Student Keys:" + values.next());
        }

        // Print Map
        System.out.println("Students keys: " + students.keySet());
        for (String name : students.keySet()) {
            System.out.println("Name: " + name + "Marks: " + students.get(name));
        }
    }
}
