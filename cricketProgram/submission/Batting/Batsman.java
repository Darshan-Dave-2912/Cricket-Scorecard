package Batting;

public class Batsman {
        public int no;
        public String name;
        public boolean isOnStrike;
        public int runs;
        public boolean isOut;
        public int ballFaced;
        Batsman(int no,String name){
            this.no =no;
            this.name = name;
            this.isOnStrike = false;
            this.runs = 0;
            this.isOut = false;
            this.ballFaced=0;
        }      
}