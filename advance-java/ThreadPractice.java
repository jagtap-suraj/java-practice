class A extends Thread {
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("Hi");
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class B extends Thread {
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("Hello");
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class ThreadPractice {
    public static void main(String[] args) {
        A objA = new A();
        B objB = new B();

        objA.start();
        // objA.setPriority(Thread.MAX_PRIORITY); 1- Least, 10 - Max
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        objB.start();
    }
}
