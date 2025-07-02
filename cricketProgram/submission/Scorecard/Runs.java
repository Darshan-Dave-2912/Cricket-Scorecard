package Scorecard;
import Overs.*;
import Batting.*;

import java.util.NoSuchElementException;
import java.util.Scanner;


class IllegalRunOut extends Exception{
    IllegalRunOut(String msg){
        super(msg);
    }
}

class RunStructure extends Scorecard implements Runnable{
    public static int totalRuns;   //Use Access Specifiers
    public static int totalBalls;
    protected int ballsPerOver;
    protected static int totalExtras;
    protected static int totalWicket;
    protected boolean freeHit;
    protected Batsman striker;
    protected Batsman nonStriker;
    protected int batsmanCounter;
    protected int team;
    protected static int totalFour;
    protected static int totalSix;
    protected boolean isAllout = false;
    public RunStructure(int team){
        totalRuns = 0;
        totalFour=0;
        totalSix=0;
        totalBalls = 1;
        ballsPerOver=1;
        totalWicket = 0;
        totalExtras = 0;
        freeHit = false;
        striker = team==1?BattingLineup.lineup1[0]:BattingLineup.lineup2[0];
        striker.isOnStrike=true;
        nonStriker = team==1?BattingLineup.lineup1[1]:BattingLineup.lineup2[1];
        batsmanCounter = 1;
        this.team = team;
    }

    public void changeStrike(Batsman batsman1,Batsman batsman2){
        striker = batsman2;
        nonStriker = batsman1;
        batsman1.isOnStrike = !batsman1.isOnStrike;
        batsman2.isOnStrike = !batsman2.isOnStrike;
        System.out.println("Current Batsman on Strike is "+(batsman1.isOnStrike?batsman1.name:batsman2.name));
    }

    public void wideBall() {
        System.out.println("Wide Ball.................");
        totalRuns++; // Add 1 extra run for wide
        totalExtras += 1;
        // Do not increment totalBalls, since wide ball doesn't count
    }

    public void addWicket(){
        totalWicket++;
        totalBalls++;
        ballsPerOver++;
        System.out.println(" "+striker.name+" is out!.............");
        striker.isOut=true;

        batsmanCounter++;
        if(totalWicket==10){
            System.out.println("Team is All Out..................");
            isAllout = true;
        }
        striker = team == 1?BattingLineup.lineup1[batsmanCounter]:BattingLineup.lineup2[batsmanCounter];
        System.out.println("New Batsman is "+striker.name);
    }

    public void noBall() {
        System.out.println("---------------------- NO BALL ----------------------------------");
        System.out.println("Next Ball is Free Hit.........................................");
        totalRuns++; // Add 1 extra run for no-ball
        totalExtras++;
        freeHit = true; // Set free hit flag for next ball
        // Do not increment totalBalls, since no-ball doesn't count
    }

    public void processBall(int runs, boolean isFreeHit) throws IllegalRunOut{
        if (isFreeHit) {
            if(runs==-4){
                throw new IllegalRunOut("Batsman Can't Run-Out on Free Hit");  //Custom Exception...
            }
            freeHit = false; // Reset free hit flag after the free hit is used
        }
        if(runs==1) {
            changeStrike(striker, nonStriker);
        }
        striker.runs +=runs;
        striker.ballFaced++;
        totalRuns += runs;
        ballsPerOver++;
        totalBalls++; // Free hit is still a legal delivery, count the ball
    }

    public void getRuns() throws Exception{
        Scanner sc = new Scanner(System.in);
        int ov = SetOvers.overs;
        int run=0;
        System.out.println("--------------------------------------------------------------------");
        System.out.println("--------------------------------------------------------------------");
        System.out.println("0 to No Run.");
        System.out.println("1 to Single.");
        System.out.println("2 to Double.");
        System.out.println("3 to Three.");
        System.out.println("4 to 4 runs.");
        System.out.println("6 to 6 runs.");
        System.out.println("-1 to Wicket.");
        System.out.println("-2 to Wide.");
        System.out.println("-3 to No Ball.");
        System.out.println("-4 to Run-Out");
        System.out.println("--------------------------------------------------------------------");
        System.out.println("--------------------------------------------------------------------");
        for(int i=1;i<=ov;i++){
            System.out.println("Enter Runs for Over "+i);
            while(ballsPerOver<=6){
                if(isAllout){
                    break;
                }
                System.out.print("Enter Run for ball "+ballsPerOver+" : ");
                try{
                    run = sc.nextInt();
                }
                catch(NoSuchElementException e){

                }

                switch (run) {
                    case 0:{
                        processBall(0, false);
                    }
                    case 1:{
                        processBall(1, false);
                        break;
                    }
                    case 2:{
                        processBall(2, false);
                        break;
                    }
                    case 3:{
                        processBall(3, false);
                        break;
                    }
                    case 4:{
                        totalFour++;
                        processBall(4, false);
                        break;
                    }
                    case 6:{
                        totalSix++;
                        processBall(6, false);
                        break;
                    }
                    case -1:{
                        addWicket();
                        break;
                    }
                    case -2:{
                        wideBall();
                        break;
                    }
                    case -3:{
                        noBall();
                        break;
                    }
                    case -4:{
                        processBall(-4, false);
                    }
                    default: System.out.println("Enter valid run Enter");
                        break;
                }
            }
            ballsPerOver=1;
        }
        Thread.sleep(5000);
        displayScore(team);
        new Overs.Calculations().calculateAverageRun();
    }
    public void run(){
        //new Overs.Calculations().calculateAverageRun();
    } 
}   

public class Runs extends RunStructure{

    public Runs(int team) 
    {
        super(team); //Calling Constructor of Super Class Using Super()...........
    }
}