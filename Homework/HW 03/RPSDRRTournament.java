/**
 * Written by Christopher Walls. 
 * So for this lab I feel like I cheated a bit because I only used my LinkedList to store and print
 * the data, which is technically the purpose of a linked list. I feel like this was not the intention,
 * and we should have to manipulate the data in the LinkedList instead.
 * You decide what you wanna do, and I'll talk to JJ about it.
 */
import java.util.Scanner;

public class RPSDRRTournament {
  //public static final int NUM_PLAYERS = 5; 
  //Normally this would be uncommented but I ask for user input.
  
  
  public static void main(String[] args) { 
    CircularLinkedList<Player> list = new CircularLinkedList<Player>();
    //GAMES PLAYED = n(n-1)
    //Prompts user for number of players in tournament
    System.out.println("Welcome to the Rock Paper Scissors Tournament!");
    Scanner keyboard = new Scanner(System.in);
    int NUM_PLAYERS = 10;
    String userInput = "";
    while(isNumber(userInput)==false) {
      //Makes sure that the user inputs an integer value.
      System.out.println("Please enter the number of players in the double round robin tournament:");
      userInput = keyboard.nextLine();
    }
    NUM_PLAYERS = Integer.parseInt(userInput);
    keyboard.close();
    System.out.println("We have " + NUM_PLAYERS + " players. Let's BEGIN!");
    /*
     * For loop creates/resets a new instance of Player curr each iteration.
     * Sets name based on position of 'i' in for loop. Inserts this into the
     * listnode.
     */
    for (int i = 0; i<NUM_PLAYERS; i++) 
    {
      Player curr = new Player();
      curr.setName(i);
      list.insert(curr);
      /* 
       * For loop creates/resets a new instance of Player temp each iteration.
       * It generates random values 0-2 for var play & opp and sends to helper
       * method getRoundResult(int playerMove, int opponentMove, int playerLocation, int opponentLocation)
       * where player is i and opponent is j. It will only send it if j!=i to
       * make sure game will not play itself.
       */
      for(int j = 1; j<NUM_PLAYERS; j++)
      {
        Player temp = new Player();
        int play = (int)(Math.random()*3);
        int opp = (int)(Math.random()*3);
        //WIN = 0; LOSS = 1; TIE = 2;
        if(j!=i) {
          switch(getRoundResult(play, opp, i, j))
          {
            //Cases are based off the player's results.
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
    }
    list.showList();
    //This showList of ListNode list defaults to the toString of the class object Player's method.
  }//end main
  
  //HELPER METHODS
  //Makes it easier to read.
  public static final int ROCK = 0;
  public static final int PAPER = 1;
  public static final int SCISSORS = 2;
  public static final int WIN = 0;
  public static final int LOSS = 1;
  public static final int TIE = 2;
  public static int getRoundResult(int play, int opp, int pSpot, int oSpot) {
    //pass in something like 2 x (int)(Math.random()*3); and player poss
    //Decides outcome of the game
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
  //This is just an extra method which will make sure userInput is an integer.
  public static boolean isNumber(String str) {
    try
    {
      int i = Integer.parseInt(str);
    }
    catch(NumberFormatException a)
    {
      return false;
    }
    return true;
  }
  
}//end class
