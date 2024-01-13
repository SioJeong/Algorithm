import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String numbersString = sc.nextLine();
        String[] numbersSplit = numbersString.split(" ");

        int[] numbers = new int[numbersSplit.length];

        for( int i = 0; i<numbers.length; i++) {
            numbers[i] = Integer.parseInt(numbersSplit[i]);
        }

        if(numbers[0] > numbers[1]){
            System.out.println(">");
        } else if(numbers[0] < numbers[1]) {
            System.out.println("<");
        } else {
            System.out.println("==");
        }
    }
}