import java.util.*;

public class BJ2343_기타레슨 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] lecture = new int[n];

        int totalLectureTime = 0;
        int maxLectureTime = 0;

        for (int i = 0; i < n; i++) {
            lecture[i] = sc.nextInt();
            totalLectureTime += lecture[i];
            maxLectureTime = Math.max(maxLectureTime, lecture[i]);
        }

        int left = maxLectureTime;
        int right = totalLectureTime;

        while (left <= right) {
            int mid = (left + right) / 2;
            int cnt = countDVD(lecture, mid);

            if (cnt <= m) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(left);
    }

    private static int countDVD(int[] lecture, int mid) {
        int cnt = 0;
        int sum = 0;

        for (int i = 0; i < lecture.length; i++) {
            if (sum + lecture[i] > mid) {
                cnt++;
                sum = 0;
            }
            sum += lecture[i];
        }

        if (sum > 0) {
            cnt++;
        }

        return cnt;
    }
}
