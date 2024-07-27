// This is Kats's code
// Tic Tac Toe

/*open scanner, later close scanner
Initialize 2D array , 3x3

__| A | B | C |
  -------------
 1|   |   |   |
  -------------
 2|   |   |   |
  -------------
 3|   |   |   |



print instructions
ask player name and char
ask 2nd player name and assing different char

loop:
  clearscreen
  print instructions
  draw current state of  grid
  Let next player choose empty location, row and column  1a, 2b, 3c
  switch turn - player 1 or player 2
  Player 1 plays first,so turn == 0

  Check chosen column ->
  check chosen row ->
  check diagonals ->
    -> announce winner  --> break

  check grid full -> draw  --> break

Do yuo want to play again Y/N?
Y - start over
N - thanks for playing & close scanner
*/

import java.util.Scanner;

public class Main {

  public static char[][] board; // class level variables HERE!
  public static String currentPlayer;
  public static char currentChar;
  public static boolean gameOver = false;
  
  public static void main(String[] args) {
    
  Scanner scanner = new Scanner(System.in);
    
    board = new char[3][3];
    boolean playAgain = true;
    
    String player1, player2;
    char char1 = ' ', char2 = ' ';
    initializeBoard();
        
    String instructions = "\nThe first player to get 3 in a row, column or diagonal is winner";

   // players and their characters
    
    System.out.println("Welcome to Tic Tac Toe!\n" + "One player will be X and the other will be O");

    System.out.println("\nWhat is your name, Player 1? ");
    player1 = scanner.nextLine();
 

    // loop to get correct char1 for player to play
    while (true){

      System.out.println("What character would you like to be, " + player1 + "? ");
      String input = scanner.nextLine();  
      char1 = input.toUpperCase().charAt(0); // this reads char at index 0
      
      if (char1 == 'X'){
        char2 = 'O';
        break;
    }
      else if (char1 == 'O'){
        char2 = ('X');
        break;
    }
      else{
        System.out.println("Please enter a valid character");        
      }
  }

  
    
    System.out.println("What is your name, Player 2? ");
    player2 = scanner.nextLine();
    System.out.println(player2 + ", You will play as " + char2);


    
// GAME STARTS HERE 
    
    while (playAgain){
      initializeBoard();
      gameOver = false;
      
       while (!gameOver){

        System.out.println(instructions);
        System.out.println("\n" + player1 + " plays " + char1 + "\n" + player2 + " plays " + char2);
        System.out.println("Here is the board:");
        printBoard();

         
//  whos turn it is, odd or even
    for (int turn = 0; turn < 9; turn++){
        
      if (turn % 2 == 0) {
        currentPlayer = player1;
        currentChar = char1;
        } 
      else {
        currentPlayer = player2;
        currentChar = char2;
        }


// get the player's move, uses scanner,how to put scanner if this would be a method?
        while(true){ // loop until correct move is made
          System.out.println(currentPlayer + " choose an empty location for your " + currentChar);
          String input = scanner.nextLine().toLowerCase();
          int row = input.charAt(0) - '1';
          int col = input.charAt(1) - 'a'; // this converts to 0,1,2 for the array index
          if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' '){
              board[row][col] = currentChar;
              break;
          }
          else if (row < 0 || row > 2 || col < 0 || col > 2){ // or-operator, out of coordinates
            System.out.println("Please enter a valid location");
          }
          else if (board[row][col] != ' '){ // not empty
            System.out.println("Please choose an empty location");
          }
        } // END of loop until correct move is made

// show the move on the board      
      clearConsole();
      System.out.println(instructions + "\n" + "Type row and column coordinates, for example: 1a or 2b");
      System.out.println();
      printBoard();
      
// check winner, when winner, then game is ove and break from loop
    if (checkWinner()){
      System.out.println(currentPlayer + " is the winner!");
      gameOver = true;  
      break;
    }
      
// check for draw -> break
      if (turn == 8){
        System.out.println("Its a draw!");
        gameOver = true;
        break;
      }
    }
  } 
    

// PlayAgain
    System.out.println("Play again with same players and same characters. Answer 'Yes' or 'Any key' to exit");
    String input2 = scanner.nextLine();  
      char playAgainQuestion = input2.toUpperCase().charAt(0); 

    if (playAgainQuestion == 'Y'){
      playAgain = true;
      initializeBoard();
      clearConsole();
    }else{
      playAgain = false;
      System.out.println ("\n" + "Thanks for playing!");
 
    }
  }
scanner.close();
} // main ends

  private static void initializeBoard() {
      for (int i = 0; i < 3; i++) {
          for (int j = 0; j < 3; j++) {
              board[i][j] = ' ';
          }
      }
  }

  public static void printBoard() {
      System.out.println("  | A | B | C |");
      System.out.println("  -----------");
      for (int i = 0; i < 3; i++) {
          System.out.print((i + 1) + " | ");
          for (int j = 0; j < 3; j++) {
              System.out.print(board[i][j] + " | ");
          }
          System.out.println();
          System.out.println("  ------------");
      }
  }

  public static void clearConsole(){
      System.out.print("\033[H\033[2J");
      System.out.flush();
  }

public static boolean checkWinner(){
  // check rows
  for (int i = 0; i < 3; i++) {
      if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != ' ') {
        return true;
      }
  }
  // check columns
  for (int j = 0; j < 3; j++) {
      if (board[0][j] == board[1][j] && board[1][j] == board[2][j] && board[0][j] != ' ') {
      return true;
      }
  }
  // check diagonals 1a equal 2b and 2b equal 3c 
  if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != ' '){
    return true;
  } 
    
       // check diagonals 1c equal 2b and 2b equal 3a 
  if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[2][0] != ' '){
    return true;
  }

  return false;

}

  

}

  
