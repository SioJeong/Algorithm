package step4;

import java.util.Scanner;

public class _03_10818{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] numbers = new int[N];

        int X = sc.nextInt();

        for(int i = 0; i < N; i++) {
            numbers[i] = sc.nextInt();
            if(numbers[i] < X) {
                System.out.print(numbers[i] + " ");
            }
        }
    }
}

