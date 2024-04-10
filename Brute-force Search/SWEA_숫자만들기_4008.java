import java.util.Scanner;

public class SWEA_숫자만들기_4008 {
    static int n;
    static int[] operators;
    static int[] nums;
    static int maxResult;
    static int minResult;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            n = sc.nextInt();
            operators = new int[4]; // +, -, *, /
            nums = new int[n];

            for (int i = 0; i < 4; i++) {
                operators[i] = sc.nextInt();
            }

            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
            }

            maxResult = Integer.MIN_VALUE;
            minResult = Integer.MAX_VALUE;

            calculate(0, nums[0]);

            System.out.println("#" + tc + " " + (maxResult - minResult));
        }
    }

    private static void calculate(int idx, int result) {
        if (idx == n - 1) {
            maxResult = Math.max(maxResult, result);
            minResult = Math.min(minResult, result);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operators[i] > 0) {
                operators[i]--;
                int newResult = performOperation(result, nums[idx + 1], i);
                calculate(idx + 1, newResult);
                operators[i]++;
            }
        }
    }

    private static int performOperation(int num1, int num2, int operator) {
        switch (operator) {
            case 0:
                return num1 + num2;
            case 1:
                return num1 - num2;
            case 2:
                return num1 * num2;
            case 3:
                return num1 / num2;
        }
        return -1;
    }
}
