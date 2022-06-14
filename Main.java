import java.util.Scanner;
class Main {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    System.out.print("Welcome to Ultimate TicTacToe.\nRules: Be the first to get a three-in-a-row but be careful, all positions can be stolen at any time! No other rules apply. \nStart game? (Y/n) ");
    String userAns = scan.nextLine();
    if (userAns.toUpperCase().equals("Y")){
      System.out.println("Yay! You are player X.");
      System.out.println("Below is what an empty game board looks like: \n");
      Tictactoe player = new Tictactoe();
      player.displayBoard();
      System.out.println("");
      while(player.getGame()){
        System.out.print("Row (0-2): ");
        int userRow = scan.nextInt();
        System.out.print("Column (0-2): ");
        int userCol = scan.nextInt();
        System.out.println("");
        if(player.isValid(userRow,userCol)){
          player.playMove(userRow,userCol);
          System.out.println("");
        } 
        else{
          System.out.println("Unvalid move. Game has ended.");
          break;
        }
        player.checkGame();
        if(player.getGame()){
          System.out.println("Computer's Turn:\n");
          player.compMove();
          System.out.println("");
          player.checkGame();
          if(player.getGame() != true){
            break;
          }
        }
      }
      System.out.println("Game has ended! Thanks for playing!");
        }
    else{
      System.out.println("Okay, maybe next time. Goodbye!");
    } 
  }
}