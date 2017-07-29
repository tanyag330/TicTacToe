package TicTacToe;

import java.util.Scanner;

public class TicTacToe {

	public static Player takePlayerInput(int num){
		Scanner s = new Scanner(System.in);
		System.out.println("Enter Player "+num+" name :");
		String name = s.nextLine();
		System.out.println("Enter Player "+num+" symbol :");
		char symbol = s.nextLine().charAt(0);
		Player p = new Player(name,symbol);

		return p;
	}

	public static void start(){
		Player p1 = takePlayerInput(1);
		Player p2 = takePlayerInput(2);
		Scanner s = new Scanner(System.in);
		while(p1.symbol == p2.symbol){
			System.out.println("Symbol taken !! Take someother symbol");
			p2 = takePlayerInput(2);
		}
		Board board = new Board(p1,p2);
		boolean player1turn = true;
		boolean done = false;
		while(board.gameStatus() == 4){
			done = false;
			if(player1turn){
				while(!done){
					System.out.println("Player 1 turn ");
					System.out.println("Enter x :");
					int x = s.nextInt();
					System.out.println("Enter y :");
					int y = s.nextInt();
					try {
						board.move(p1.symbol, x, y);
						done = true;
					} catch (WrongInputException e) {
						// TODO Auto-generated catch block
						System.out.println("Invalid Input :");
					}				
				}
				player1turn = false;
			}

			else{
				while(!done){
					System.out.println("Player 2 turn ");
					System.out.println("Enter x :");
					int x = s.nextInt();
					System.out.println("Enter y :");
					int y = s.nextInt();
					try {
						board.move(p2.symbol, x, y);
						done = true;
					} catch (WrongInputException e) {
						// TODO Auto-generated catch block
						System.out.println("Invalid Input :");
					}				
				}
				player1turn = true;
			}
			board.printBoard();
		}
		
		if(board.gameStatus() == 1){
			System.out.println("Player 1 Won !!");
		}
		else if(board.gameStatus() == 2){
			System.out.println("Player 2 Won !!");
		}
		else{
			System.out.println("Its a Draw !!");
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		start();
	}

}
