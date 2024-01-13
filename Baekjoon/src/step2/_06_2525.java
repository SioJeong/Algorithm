import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String timeString = sc.nextLine();
        String[] timeStringArray = timeString.split(" ");

        int startHour = Integer.parseInt(timeStringArray[0]);
        int startMinuet = Integer.parseInt(timeStringArray[1]);
        int ovenTime = sc.nextInt();
        sc.nextLine();

        if(startMinuet + ovenTime >= 60){
            startHour = startHour + ((startMinuet + ovenTime) / 60);
            startMinuet = (ovenTime + startMinuet) % 60;
            if(startHour >= 24)
                startHour = startHour / 24;
        }
        System.out.println(startHour + " " + startMinuet);
    }
}