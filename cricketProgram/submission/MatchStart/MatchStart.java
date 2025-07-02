package MatchStart;
import Batting.BattingLineup;
import Bowling.BowlingLineup;
import Overs.*;
import Scorecard.*;
import java.util.Scanner;

public class MatchStart{

    
    //Using Static Block...................
    static {
        try{
            System.out.println("-----------------------------------------------------------------------------------------------------------");
            System.out.println("-----------------------------------------------------------------------------------------------------------");
            System.out.println("Good morning, everyone!\n It's a beautiful day for cricket  your energy and support make all the difference\nLet the game begin, and may the best team win!");
            Thread.sleep(1000);
            System.out.println("-----------------------------------------------------------------------------------------------------------");
        }
        catch(InterruptedException e){}
    }

    //Using Static Method...................
    public static void selectFormat() throws Exception{
        Scanner sc = new Scanner(System.in);
        System.out.println("1 to T10");
        System.out.println("2 to T20");
        System.out.println("5 to ODI");
        System.out.println("0 to Custom");
        System.out.println("-----------------------------------------------------------------------------------------------------------");
        System.out.println("-----------------------------------------------------------------------------------------------------------");
        System.out.print("Choose Format of the Match : ");
        final int choice = sc.nextInt();
        System.out.println("-----------------------------------------------------------------------------------------------------------");
        System.out.println("-----------------------------------------------------------------------------------------------------------");
        switch (choice) {
            case 1:{
                new SetOvers(10);
                break;
            }
            case 2:{
                new SetOvers(20);
                break;
            }
            case 5:{
                new SetOvers(50);
                break;
            }
            case 0:{
                System.out.print("Enter The Overs you want to play : ");
                int overs = sc.nextInt();
                new SetOvers(overs);
                break;
            }
            default: System.out.print("Invalid Choice Kindly enter Valid choice");
                break;
        }

        BattingLineup.start();
        BowlingLineup.start();
        System.out.println("-----------------------------------------------------------------------------------------------------------");
        System.out.println("-----------------------------------------------------------------------------------------------------------");
        System.out.println("1 to Team A");
        System.out.println("2 to Team B");
        System.out.print("Select Team to Bat First : ");
        int teamBat = sc.nextInt();
        System.out.println("-----------------------------------------------------------------------------------------------------------");
        System.out.println("-----------------------------------------------------------------------------------------------------------");
        if(teamBat==1){
            BattingLineup.displayLineup(1);
            //BowlingLineup.displayLineup(2);
        }
        else{
            BattingLineup.displayLineup(2);
            //BowlingLineup.displayLineup(1);
        }       
        System.out.println();
        
        new Runs(teamBat).getRuns();

        System.out.println("----------------------------------------------------------------------------");
        System.out.println("-----------------1st Inning Completed-----------------");
        System.out.println("----------------------------------------------------------------------------");
        System.out.println();
        System.out.println("-----------------------------------------------------------------------------------------------------------");
        System.out.println("-----------------------------------------------------------------------------------------------------------");
        System.out.println("-------------------------------------- 2nd Inning Started --------------------------------------");
        System.out.println("-----------------------------------------------------------------------------------------------------------");
        System.out.println("-----------------------------------------------------------------------------------------------------------");
        if(teamBat==1){
            BattingLineup.displayLineup(2);
            //BowlingLineup.displayLineup(2);
        }
        else{
            BattingLineup.displayLineup(1);
            //BowlingLineup.displayLineup(1);
        } 
        if(teamBat==1){
            new Runs(2).getRuns();
        }
        else{
            new Runs(1).getRuns();
 
       }
       Scorecard.displayWinner();
    }
}