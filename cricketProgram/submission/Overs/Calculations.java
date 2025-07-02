package Overs;
import Scorecard.*;

public class Calculations extends OversMethods{
    
    public double calculateAverageRun() {
        int totalRuns = Runs.totalRuns;
       int totalBalls = Runs.totalBalls-1;
       double averageRuns; 
       Runs.totalRuns=0;  
       Runs.totalBalls=1;
        averageRuns = totalRuns/totalBalls;
       
       System.out.println("Average run per over in this Inning is "+averageRuns);
       return averageRuns;
    } 
   
    public double calculateEconomy(int totalRuns,int totalBalls){
        double economy = totalRuns/totalBalls;
        return economy;
    }

    public double calculateStrikeRate(int totalRuns, int totalBalls) {
        double strikeRate = totalRuns/totalBalls;
        return strikeRate;
    }
}