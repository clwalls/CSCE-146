//Written by Christopher Walls. TA said because since it was first lab he'd give us that were there a little more time.
import java.util.Random;

public class Minesweeper3 {
  
  
  public static final int BOARD_SIZE = 10;
  public static final int NUM_MINES = 10;
  
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    
    Random r = new Random();
    int[][] board = new int[BOARD_SIZE][BOARD_SIZE];
    System.out.println("Creating an empty board");
    
    //Sets board as Empty
    for(int y=0; y<board.length; y++)
    {
      for(int x=0; x<board[y].length; x++)
      {
        board[x][y] = 0;
      }
    }
    //Prints Board
    for(int y=0; y<board.length; y++)
    {
      for(int x=0; x<board[y].length; x++)
      {
        switch(board[x][y])
        {
          case 0:
            System.out.print("_");
            break;
          case 1:
            System.out.print("*");
            break;
        }
      }
      System.out.println("");
    }
    
    //Sets 10 mines on the Empty places
    System.out.println("Placing mines");
    int mX = 0; int mY = 0;
    for(int i = 0; i<NUM_MINES; i++)
    {
      mX = r.nextInt(BOARD_SIZE);
      mY = r.nextInt(BOARD_SIZE);
      if (board[mX][mY] == 0) {
        board[mX][mY] = 10;//10 is value for mine
      }
      else {
        i--;
      }
    }
    //Prints Board with Mines
    for(int y=0; y<board.length; y++)
    {
      for(int x=0; x<board[y].length; x++)
      {
        switch(board[x][y])
        {
          case 0:
            System.out.print("_");
            break;
          case 10:
            System.out.print("*");
            break;
        }
      }
      System.out.println("");
    }
    
    //Performing mine Count
    System.out.println("Performing mine count");
    int countOfMines = 0;
    for(int y=0; y<board.length; y++)
    {
      for(int x=0; x<board[y].length; x++)
      {
        countOfMines = 0;
        if (board[x][y] != 10) {
          //General Cases, with boundaries
          if (y-1 > 0 && board[x][y-1] == 10) {
            countOfMines++;
          }
          if (y+1 < BOARD_SIZE && board[x][y+1] == 10) {
            countOfMines++;
          }
          if (x-1 > 0 && board[x-1][y] == 10) {
            countOfMines++;
          }
          if (x-1 > 0 && y-1 > 0 && board[x-1][y-1] == 10) {
            countOfMines++;
          }
          if (x-1 > 0 && y+1 < BOARD_SIZE && board[x-1][y+1] == 10) {
            countOfMines++;
          }
          if (x+1 < BOARD_SIZE && board[x+1][y] == 10) {
            countOfMines++;
          } 
          if (x+1 < BOARD_SIZE && y-1 > 0 && board[x+1][y-1] == 10) {
            countOfMines++;
          }
          if (x+1 < BOARD_SIZE && y+1 < BOARD_SIZE && board[x+1][y+1] == 10) {
            countOfMines++;
          }
          board[x][y] = countOfMines;
        }
      }
    }//end mine count
    
    //Print Board
    for (int y=0; y<board.length; y++)
    {
      for(int x=0; x<board[y].length; x++)
      {
        if (board[x][y]==10) {
          System.out.print("*");
        }
        if (board[x][y]!=10) {
          System.out.print(board[x][y]);
        }
      }
      System.out.println("");
    }
    
    
  }
}
