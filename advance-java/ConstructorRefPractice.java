import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Student {
    String name;
    int marks;

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Student [name=" + name + ", marks=" + marks + "]";
    }

}

public class ConstructorRefPractice {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("John", "Lenon", "Harry");

        List<Student> students = new ArrayList<>();

        // Method 1
        for (String name : names) {
            students.add(new Student(name));
        }

        // Method 2
        students = names.stream()
                .map(name -> new Student(name))
                .toList();

        // Method 3
        students = names.stream()
                .map(Student::new)
                .toList();

        System.out.println(students);
    }
}
