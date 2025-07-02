package Overs;


class Overs{
    public static int overs; // Use Static variables
    static int ballsPerOver = 6;
}

//Extending Class Overs;
public class SetOvers extends Overs{
    
    public SetOvers(int finalovers){
        overs= finalovers;
        System.out.println("Match is of over : "+overs);
   }
} 