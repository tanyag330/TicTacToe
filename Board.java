package TicTacToe;

public class Board {

	
	private char[][] board;
	Player player1;
	Player player2;
	//int status;
	public final static int PLAYER1WON = 1;
	public final static int PLAYER2WON = 2;
	public final static int  DRAW = 3;
	public final static int INCOMPLETE = 4;
	Board(Player p1, Player p2){
		this.player1 = p1;
		this.player2 = p2;
		board = new char[3][3];
		for(int i =0; i < board.length; i++){
			for(int j = 0; j < board.length; j++){
				board[i][j] = ' ';
			}
		}
	//	status = 4; // incomplete
	}
	
	
	public void move(char symbol,int x, int y) throws WrongInputException{
		if(x<0 || x >= 3 || y < 0 || y >=3 || board[x][y] != ' '){
			WrongInputException e = new WrongInputException();
			throw e;
		}
		board[x][y] = symbol;
		
	}
	
	
	public void printBoard(){
		System.out.println("---------");
		for(int i =0; i < 3; i++){
			for(int j =0; j < 3; j++){
				System.out.print(" | "+board[i][j]+" | ");
			}
			System.out.println();
			System.out.println("----------");
		}	
	}
	
	public int gameStatus(){
		
		for(int i =0; i < 3; i++){
			if(board[i][0] != ' ' && board[i][0] == board[i][1] && board[i][0] == board[i][2]){
				if(board[i][0] == player1.symbol){
					return 1;
				}
				else{
					return 2;
				}
			}
		}
		for(int i =0; i < 3; i++){
			if(board[0][i] != ' ' && board[0][i] == board[1][i] && board[0][i] == board[2][i]){
				if(board[0][i] == player1.symbol){
					return PLAYER1WON;
				}
				else{
					return PLAYER2WON;
				}
			}
		}
		
		if(board[0][0] != ' ' && board[0][0] == board[1][1] && board[0][0] == board[2][2]){
			if(board[0][0] == player1.symbol){
				return PLAYER1WON;
			}
			else{
				return PLAYER2WON;
			}
		}
		if(board[2][0] != ' ' && board[2][0] == board[1][1] && board[2][0] == board[0][2]){
			if(board[2][0] == player1.symbol){
				return PLAYER1WON;
			}
			else{
				return PLAYER2WON;
			}
		}
		
		for(int i =0; i < 3; i++){
			for(int j =0; j < 3; j++){
				if(board[i][j] == ' '){
					return INCOMPLETE;
				}
			}
		}
		
		return DRAW;
		
	}
	
	
	
}
