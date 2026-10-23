class CustomException extends Exception {
    public CustomException(String str) {
        super(str);
    }
}

class ExceptionHelper {
    void findClass() throws ClassNotFoundException {
        Class.forName("calc");
    }
}

public class ExceptionPractice {
    public static void main(String[] args) {

        try {
            ExceptionHelper eh = new ExceptionHelper();
            eh.findClass();
        } catch (ClassNotFoundException e) {
            System.out.println(e);
            e.printStackTrace();
        }

        int i = 0;
        int j = 8;

        int nums[] = new int[5];

        try {
            if (i == 0)
                throw new CustomException("Can't divide by a zero");
            int res = j / i;
            System.out.println("Result:" + res);
            System.out.println(nums[6]);
        } catch (CustomException e) {
            i = 1;
            System.out.println("I is set to 1 & " + e);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Array length exceeded");
        } catch (Exception e) {
            System.out.println("Exception Occured");
        } finally {
            System.out.println("In Finally Block");
        }
        System.out.println("After the try-catch block");
    }
}
