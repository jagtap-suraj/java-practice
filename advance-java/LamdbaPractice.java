@FunctionalInterface
interface A {
    void show(int i);
}

@FunctionalInterface
interface B {
    int add(int i, int j);
}

public class LamdbaPractice {
    public static void main(String[] args) {
        // Annonymous Class
        A objA1 = new A() {
            public void show(int i) {
                System.out.println("in show " + i);
            }
        };
        objA1.show(0);

        // Lambda Expression
        A objA2 = i -> System.out.println("on show " + i);
        objA2.show(1);

        // Annonymous Class
        B objB1 = new B() {
            public int add(int i, int j) {
                return i + j;
            }
        };
        System.out.println("Addition: " + objB1.add(2, 3));

        // Lambda Expression
        B objB2 = (i, j) -> i + j;
        System.out.println("Addition: " + objB2.add(3, 4));
    }
}
