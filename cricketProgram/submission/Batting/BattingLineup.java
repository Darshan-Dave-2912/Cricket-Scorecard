package Batting;
import Bowling.*;
import java.util.*;

public class BattingLineup implements Runnable
{
        
    public static Batsman[] lineup1 = new Batsman[11];   //Use Array of Objects......
    public static Batsman[] lineup2 = new Batsman[11];   //Use Array of Objects......
    public void run() {}
    
    public static void start(){
        Scanner sc = new Scanner(System.in);
        String name = "";
        System.out.println("Enter First Team's Batting Lineup");
        for(int i=0;i<11;i++){
            System.out.print("Enter Batsman Name : ");
            name = sc.nextLine();
            lineup1[i] = new Batsman(i, name);
            System.out.println();
        }
        System.out.println("Enter Second Team's Batting Lineup");
        for(int i=0;i<11;i++){
            System.out.print("Enter Batsman Name : ");
            name = sc.nextLine();
            lineup2[i] = new Batsman(i, name);
            System.out.println();
        }
        //sc.close();
    }

    public static void displayLineup(int team){
        try {
                if(team==1){
                    System.out.println("Today's Batting Lineup of Team 1");
                    System.out.println("Team A");
                    System.out.println();
                    System.out.println("------------------------------------------------------------");
                    for(int i=0;i<=lineup1.length-1;i++){
                        System.out.println(lineup1[i].name);
                        Thread.sleep(500);
                    }
                    System.out.println();
                }
                else{
                    System.out.println("Today's Batting Lineup of Team 2");
                    System.out.println();
                    System.out.println("Team B");
                    System.out.println("------------------------------------------------------------");
                    for(int i=0;i<=lineup2.length-1;i++){
                        System.out.println(lineup2[i].name);
                        Thread.sleep(500);
                    }
                    System.out.println();
                }
        } catch (InterruptedException e) {}
    }        
}