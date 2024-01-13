import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String timeString = sc.nextLine();
        String[] timeStringArray = timeString.split(" ");

        int hour = Integer.parseInt(timeStringArray[0]);
        int minuet = Integer.parseInt(timeStringArray[1]);
        int alarm = 45;

        if(hour == 0 && minuet - alarm < 0) {
            System.out.println("23 " + (minuet + 60 - alarm));
        } else if(minuet - alarm < 0){
            System.out.println((hour - 1) + " " + (minuet + 60 - alarm));
        } else System.out.println(hour + " " + (minuet - alarm));
    }
}