package TicTacToe;

import java.util.Scanner;

public class TicTacToe {
	
	private Player player1, player2;
	private Board board;
	
	public void startGame(){
		
		Scanner s = new Scanner(System.in);
		player1 = takePlayerInput(1);
		player2 = takePlayerInput(2);
		
		while(player1.getSymbol() == player2.getSymbol()){
			System.out.println("Symbol already taken!! Please retype symbol: ");
			player2.setSymbol(s.next().charAt(0));
		}
		//Create the board
		board = new Board(player1.getSymbol(), player2.getSymbol());
		//conduct game
		boolean player1Turn = true;
		int status = Board.INCOMPLETE;
		
		while(status == board.INCOMPLETE || status == board.INVALID){
			if(player1Turn){
				System.out.println("Player 1- "+player1.getName()+"'s turn");
				System.out.println("Enter x: ");
				int x = s.nextInt();
				System.out.println("Enter y: ");
				int y = s.nextInt();
				//
				status = board.move(player1.getSymbol(), x, y);	
				if(status != Board.INVALID){
					player1Turn = false;
					board.print();
				}else{
					System.out.println("Your Move is invalid!! Try again!");
				}
			}else{
				System.out.println("Player 2- "+player2.getName()+"'s turn");
				System.out.println("Enter x: ");
				int x = s.nextInt();
				System.out.println("Enter y: ");
				int y = s.nextInt();
				//
				status = board.move(player2.getSymbol(), x, y);
				if(status != Board.INVALID){
					player1Turn = true;
					board.print();
				}else{
					System.out.println("Your Move is invalid!! Try again!");
				}
			}
	    }
		if(status == board.PLAYER_1_WINS){
			System.out.println("Player 1- "+player1.getName()+" Wins!!");
		}else if(status == board.PLAYER_2_WINS){
			System.out.println("Player 2- "+player2.getName()+" Wins!!");
		}else{
			System.out.println("Draw !!");
		}
		
    }
	
	public Player takePlayerInput(int num){
		
		Scanner s = new Scanner(System.in);
		System.out.println("Enter player"+num+"'s Name:");
		String name = s.next();
		System.out.println("Enter player"+num+"'s Symbol:");
		char symbol = s.next().charAt(0);
		Player p = new Player(name, symbol);
		return p;
	}

}
