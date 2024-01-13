import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int byteNumber = sc.nextInt();
        int times = byteNumber / 4;

        for(int i = 1; i <= times; i++) {
            System.out.print("long ");
        }
        System.out.println("int");
    }
}

