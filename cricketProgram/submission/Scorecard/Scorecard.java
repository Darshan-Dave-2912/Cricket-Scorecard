package Scorecard;

import Batting.BattingLineup;

class ScoreBoard{
    public static int team1Score;
    public static int team2Score;
    ScoreBoard(){
        team1Score=0;
        team2Score=0;
    }
    public static void displayScore(int teamBat){
        System.out.println("---------------------- Scoreboard ----------------------");
        System.out.println();
        System.out.println("Batsman Name\t\t\t\tRun\t\t\t\tballs");
        if(teamBat==1){
            for(int i=0;i<=BattingLineup.lineup1.length-1;i++){
                System.out.println(BattingLineup.lineup1[i].name+"\t\t\t\t\t"+BattingLineup.lineup1[i].runs+"\t\t\t"+BattingLineup.lineup1[i].ballFaced);
            }
        }
        else{
            for(int i=0;i<=BattingLineup.lineup2.length-1;i++){
                System.out.println(BattingLineup.lineup2[i].name+"\t\t\t\t\t"+BattingLineup.lineup2[i].runs+"\t\t\t"+BattingLineup.lineup2[i].ballFaced);
            }
        }
        if(teamBat==1){
            team1Score=Runs.totalRuns;
        }
        else{
            team2Score = Runs.totalRuns;
        }
        System.out.println();
        System.out.println("--------------------------------------------------------");
        System.out.println("Total Score : "+Runs.totalRuns+"/ "+Runs.totalWicket+"\t\t\t\t Extras : "+Runs.totalExtras);
        System.out.println("4's : "+Runs.totalFour+"\t\t\t\t"+"6's : "+Runs.totalSix);    
    }

    public static void displayWinner(){
        if(team1Score>team2Score){
            System.out.println(".................................. Team 1 Winner ..................................");
        }
        else if(team2Score>team1Score){
            System.out.println(".................................. Team 2 Winner ..................................");
        }
        else{
            System.out.println(".................................. Match Tied ..................................");
        }
    }   
}


//Extends Class And Implement Interface at a Same Time
public class Scorecard extends ScoreBoard{
    Scorecard(){
        super();
    }
}