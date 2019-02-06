// On my honor:
//
// - I have not used code obtained from another student,
// or any other unauthorized source, either modified or unmodified.
//
// - All code and documentation used in my program is either my original
// work, or was derived, by me, from the source code provided by the assignment.
//
// - I have not discussed coding details about this project with anyone
// other than my instructor, teaching assistants assigned to this
// course, except via the message board for the course. I understand that I
// may discuss the concepts of this program with other students, and that
// another student may help me debug my program so long as neither of us
// writes anything during the discussion or modifies any computer file
// during the discussion. I have violated neither the spirit nor letter of this restriction.
//
import java.util.*;

public class TicTacToe {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		//Initializations
		String[][] gameBoard = initBoard(); //populate the board with initial values
		
		boolean play = false;
		int answer = 0;
		int turn = 0;
		String player = "";
		
		while(!play){
			try {
				
				printBoard(gameBoard); //print the board
				
				if(checkForWinner(gameBoard) == true){
					play = true;
					System.out.println("Player " + player + " has won the game!");
					System.exit(0);
				}
				
				if(checkForWinner(gameBoard) == false && turn == 9){
					System.out.println("Players X and O have tied.");
					System.exit(0);
				}
				
				if(turn%2 == 0)
					player = "X";
				else{
					player = "O";
				}
				
				System.out.println("Please enter a box number for player " + player + ", or -1 to quit: "); //user prompt statement
				answer = input.nextInt();
				if(answer >= 1 && answer <= 9){
					if(populateBoard(answer, gameBoard, turn) == true)
						turn++;
				}
				else if(answer == -1)
					System.exit(0);
			} catch (InputMismatchException ex){
				input.nextLine();
			}
		}
	}

	
	public static String[][] initBoard(){
		String[][] board = new String[3][3]; //initialize the board
		
		int z = 1;
		
		for(int x = 0; x < 3; x++){
			for(int y = 0; y < 3; y++){
				board[x][y] = String.valueOf(z); //convert int to String using String.valueOf(int)
				z++;
			}
		}
		
		return board;
	}
	
	public static void printBoard(String [][] array){
		for(int i = 0; i <= 2; i++){
			for(int j = 0; j <=2 ; j++){
				if(j != 2)
					System.out.print(" " + array[i][j] + " |");
				
				else{ //cut off printing "|" on last column
					System.out.print(" " + array[i][j]);
				}
			}
			System.out.println();
			System.out.println("---+---+---");
		}
	}//end of printing method
	public static boolean populateBoard(int answer, String[][] gameBoard, int turn){
		
		if(turn%2 == 0){
			for(int x = 0; x < 3; x++){
				for(int y = 0; y < 3; y++){
					if(gameBoard[x][y] != "O" && gameBoard[x][y] != "X"){
						if(answer == Integer.parseInt(gameBoard[x][y])){ //compare answer value to int value of String using Integer.parseInt(String)
							gameBoard[x][y] = "X";							
							return true;
						}
					}
				}
			}return false;
		}//end of if it's X's turn
		
		else{
			for(int x = 0; x < 3; x++){
				for(int y = 0; y < 3; y++){
					if(gameBoard[x][y] != "O" && gameBoard[x][y] != "X"){
						if(answer == Integer.parseInt(gameBoard[x][y])){
							gameBoard[x][y] = "O";
							return true;
						}
					}
				}
			}return false;
		}//end of if it O's turn
		
	}//end of populating board method
	
	public static boolean checkForWinner(String[][] array){
		boolean winner = false;
		
		for(int i = 0; i <= 2; i++){
			if(array[i][0] == array[i][1] && array[i][1] == array[i][2]){
				winner = true;
				break;
			}
			
			else if(array[0][i] == array[1][i] && array[1][i] == array[2][i]){
				winner = true;
				break;
			}
		}
		
		if((array[0][0] == array[1][1] && array[1][1] == array[2][2]) || (array[0][2] == array[1][1] && array[1][1] == array[2][0]))
			winner = true;
		
		return winner;
	}
	
}
