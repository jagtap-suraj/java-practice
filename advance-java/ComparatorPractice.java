import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Comparator;

class Student {
    int age;
    String name;

    public Student(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public String toString() {
        return "Student [age=" + age + ", name=" + name + "]";
    }

}

class Student2 implements Comparable<Student2> {
    int age;
    String name;

    public Student2(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public String toString() {
        return "Student [age=" + age + ", name=" + name + "]";
    }

    public int compareTo(Student2 that) {
        if (this.age > that.age)
            return 1;
        else
            return -1;
    }

}

public class ComparatorPractice {
    public static void main(String[] args) {

        // Comparator<Integer> comp = new Comparator<Integer>() {
        //     public int compare(Integer i, Integer j) {
        //         if (i % 10 > j % 10)
        //             return 1;
        //         else
        //             return -1;
        //     }
        // };
        Comparator<Integer> comp = (i, j) -> i%10 > j%10 ? 1:-1;

        Comparator<Student> comp2 = new Comparator<Student>() {
            public int compare(Student i, Student j) {
                if (i.age > j.age)
                    return 1;
                else
                    return -1;
            }
        };
        //
        List<Integer> nums = new ArrayList<>();
        nums.add(43);
        nums.add(31);
        nums.add(72);
        nums.add(29);
        Collections.sort(nums, comp);
        System.out.println(nums);
        //
        List<Student> studs = new ArrayList<>();
        studs.add(new Student(21, "Navin"));
        studs.add(new Student(12, "John"));
        studs.add(new Student(18, "Parul"));
        studs.add(new Student(20, "Kiran"));

        Collections.sort(studs, comp2);
        for (Student s : studs)
            System.out.println(s);
        //
        System.out.println();
        List<Student2> studs2 = new ArrayList<>();
        studs2.add(new Student2(21, "Navin2"));
        studs2.add(new Student2(12, "John2"));
        studs2.add(new Student2(18, "Parul2"));
        studs2.add(new Student2(20, "Kiran2"));

        Collections.sort(studs2);
        for (Student2 s : studs2)
            System.out.println(s);
    }

}
