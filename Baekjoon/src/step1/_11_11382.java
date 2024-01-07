import java.util.Scanner;

public class Main{
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        String[] values = input.split(" ");

        long A = Long.parseLong(values[0]);
        long B = Long.parseLong(values[1]);
        long C = Long.parseLong(values[2]);

        System.out.println(A + B + C);

    }
}