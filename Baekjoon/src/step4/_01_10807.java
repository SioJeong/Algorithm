import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int count = 0;
        int[] numbers = new int[N];

        for (int i = 0; i < N; i++)	{
            numbers[i] = sc.nextInt();
        }

        int findNum = sc.nextInt();
        for(int i = 0; i < N; i++) {
            if(findNum == numbers[i]) {
                count++;
            }
        }
        System.out.println(count);
    }
}

