/**
 * Written by Christopher Walls. 
 */
public class RPSDRRTournament {
  public static final int NUM_PLAYERS = 5;
  
  public static void main(String[] args) { 
    CircularLinkedList<Player> list = new CircularLinkedList<Player>();
    //GAMES PLAYED = n(n-1)
    System.out.println("Welcome to the Rock Paper Scissors Tournament!");
    System.out.println("We have " + NUM_PLAYERS + " players. Let's BEGIN!");
    for (int i = 0; i<NUM_PLAYERS; i++) 
    {
      Player curr = new Player();
      curr.setName(i);
      list.insert(curr);
      for(int j = 0; j<NUM_PLAYERS; j++)
      {
        Player temp = new Player();
        int play = (int)(Math.random()*3);
        int opp = (int)(Math.random()*3);
        //WIN = 0; LOSS = 1; TIE = 2;
        switch(getRoundResult(play, opp, i, j))
        {
          case 0:
            curr.setWins(curr.getWins()+1);
            temp.setLosses(temp.getLosses()+1);
            break;
          case 1:
            curr.setLosses(curr.getLosses()+1);
            temp.setWins(temp.getWins()+1);
            break;
          case 2:
            curr.setTies(curr.getTies()+1);
            temp.setTies(temp.getTies()+1);
            break;
        }
      }
    }
    list.showList();
  }//end main
  
  //HELPER METHODS
  public static final int ROCK = 0;
  public static final int PAPER = 1;
  public static final int SCISSORS = 2;
  public static final int WIN = 0;
  public static final int LOSS = 1;
  public static final int TIE = 2;
  //Make it easier to read.
  public static int getRoundResult(int play, int opp, int pSpot, int oSpot) {
    //pass in something like 2 x (int)(Math.random()*3); and player poss
    int result = 3;
    if(play == ROCK && opp == ROCK) {
      result = TIE;
      System.out.println(pSpot+" uses Rock\n"+oSpot+" uses Rock\nTIE!");
    }
    if(play == ROCK && opp == PAPER) {
      result = LOSS;
      System.out.println(pSpot+" uses Rock\n"+oSpot+" uses Paper\n"+oSpot+" WINS!");
    }
    if(play == ROCK && opp == SCISSORS) {
      result = WIN;
      System.out.println(pSpot+" uses Rock\n"+oSpot+" uses Scissors\n"+pSpot+" WINS!");
    }
    if(play == PAPER && opp == ROCK) {
      result = WIN;
      System.out.println(pSpot+" uses Paper\n"+oSpot+" uses Rock\n"+pSpot+" WINS!");
    }
    if(play == PAPER && opp == PAPER) {
      result = TIE;
      System.out.println(pSpot+" uses Paper\n"+oSpot+" uses Paper\nTIE!");
    }
    if(play == PAPER && opp == SCISSORS) {
      result = LOSS;
      System.out.println(pSpot+" uses Paper\n"+oSpot+" uses Scissors\n"+oSpot+" WINS!");
    }
    if(play == SCISSORS && opp == ROCK) {
      result = LOSS;
      System.out.println(pSpot+" uses Scissors\n"+oSpot+" uses Rock\n"+oSpot+" WINS!");
    }
    if(play == SCISSORS && opp == PAPER) {
      result = WIN;
      System.out.println(pSpot+" uses Scissors\n"+oSpot+" uses Rock\n"+pSpot+" WINS!");
    }
    if(play == SCISSORS && opp == SCISSORS) {
      result = TIE;
      System.out.println(pSpot+" uses Scissors\n"+oSpot+" uses Scissors\nTIE!");
    }
    return result;
  }
  
}//end class
