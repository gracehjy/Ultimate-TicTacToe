import java.util.ArrayList;

public class Tictactoe{
  private boolean game;
  private String[][] board = new String[3][3];
  private ArrayList <Integer> row = new ArrayList <Integer>();
  private ArrayList <Integer> col = new ArrayList <Integer>();  
  
  public Tictactoe(){
    game = true;
    row.add(0);
    row.add(1);
    row.add(2);
    col.add(0);
    col.add(1);
    col.add(2);
    for(int r = 0; r < board.length; r++){
      for(int c = 0; c < board[0].length; c++){
        board[r][c] = "-";
      }
    }
  }

  public boolean isValid(int userRow, int userCol){
    boolean validRow = false;
    boolean validCol = false;
    if (row.contains(userRow)){
      validRow = true;
    }
    if (col.contains(userCol)){
      validCol = true;
    }
    if (validRow && validCol){
      return true;
    }
    return false;
  }

  public void playMove(int userRow, int userCol){
    board[userRow][userCol] = "X";
    displayBoard();
    }

  public void displayBoard(){
    for(int r = 0; r < board.length; r++){
      for(int c = 0; c < board[0].length; c++){
        System.out.print(board[r][c]);
      }
      System.out.println("");
    }
  }

  public boolean checkGame(){
    //check for vertical matches
    int countVX = 0;
    int countVO = 0;
    for(int c = 0; c < board[0].length; c++){
      for(int r = 0; r < board.length; r++){
        if(board[r][c].equals("X")){
          countVX++;
        }
        else if(board[r][c].equals("O")){
          countVO++;
        }
      }
      if((countVX == 3) || (countVO == 3)){
        game = false;
        return game;
      }
      else{
        countVX = 0;
        countVO = 0;
      }
    }
    //check for horizontal matches
    int countHX = 0;
    int countHO = 0;
    for(int r = 0; r < board.length; r++){
      for(int c = 0; c < board[0].length; c++){
        if(board[r][c].equals("X")){
          countHX++;
        }
        else if(board[r][c].equals("O")){
          countHO++;
        }
      }
      if((countHX == 3)||(countHO == 3)){
        game = false;
        return game;
      }
      else{
        countHX = 0;
        countHO = 0;
      }
    }
    //check for diagonal matches (left and right diagonals)
    if((board[0][0].equals("X") && board[1][1].equals("X") && board[2][2].equals("X"))||(board[2][0].equals("X") && board[1][1].equals("X") && board[0][2].equals("X"))||(board[0][0].equals("O") && board[1][1].equals("O") && board[2][2].equals("O"))||(board[2][0].equals("O") && board[1][1].equals("O") && board[0][2].equals("O"))){
      game = false;
      return game;
    }
    else{
      game = true;
    }
      return game;
  }

  public boolean getGame(){
    return game;
  }

  public void compMove(){
    int compRowIndex = (int)(Math.random()*row.size());
    int compColIndex = (int)(Math.random()*col.size());
    board[row.get(compRowIndex)][col.get(compColIndex)] = "O";
    displayBoard();
  }
}