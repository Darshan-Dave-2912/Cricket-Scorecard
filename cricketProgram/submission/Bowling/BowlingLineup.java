    package Bowling;
import java.util.*;

public class BowlingLineup{
    public static Bowler[] lineup1 = new Bowler[5];
    public static Bowler[] lineup2 = new Bowler[5];
    
    public static void start(){
        Scanner sc = new Scanner(System.in);
        String name = "";
        System.out.println("Enter First Team's Bowling Lineup");
        for(int i=0;i<lineup1.length-1;i++){
            System.out.print("Enter Bowler Name : ");
            name = sc.nextLine();
            lineup1[i] = new Bowler(i, name);
            System.out.println();
        }
        System.out.println("Enter Second Team's Bowling Lineup");
        for(int i=0;i<lineup2.length-1;i++){
            System.out.print("Enter Bowler Name : ");
            name = sc.nextLine();
            lineup2[i] = new Bowler(i, name);
            System.out.println();
        }
        //sc.close();
    }

    public static void displayLineup(int bowling){
        
        if(bowling == 1){
            System.out.println("Today's Bowling of Team 1");
            System.out.println("------------------------------------------------------------");
            for(int i=0;i<=lineup1.length-1;i++){
                System.out.println(lineup1[i].name);
                try {
                    Thread.sleep(500);
                }
                catch(InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        else{
            System.out.println("Today's Bowling of Team 2");
            System.out.println("------------------------------------------------------------");
            for(int i=0;i<=lineup2.length-1;i++){
                System.out.println(lineup2[i].name);
                try {
                    Thread.sleep(500);
                }
                catch(InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    } 
}