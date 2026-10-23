import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class InputPractice {
    public static void main(String[] args) throws NumberFormatException, IOException {
        // First Approach
        // System.out.println("Enter a number:");
        // try {
        // int n = System.in.read();
        // System.out.println(n); // It'll print ascii, so we'll need to print n - 48
        // } catch (IOException e) {
        // System.out.println(e);
        // }

        // Second Approach
        System.out.println("Enter a number:");
        try (BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));) {
            
            int n = Integer.parseInt(bf.readLine());
            System.out.println(n);
        } catch (IOException e) {
            System.out.println(e);
        } finally {
            // bf.close(); no need to close since its auto closable
        }

        // Third Approach
        System.out.println("Enter another number:");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        System.out.println(num);
        sc.close();
    }
}
