import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int priceAmount = sc.nextInt();
        int productslist = sc.nextInt();
        int sum = 0;

        for(int i = 1; i <= productslist; i++) {

            int price = sc.nextInt();
            int quantity = sc.nextInt();

            sum += (price * quantity);
        }

        if(sum == priceAmount) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}

