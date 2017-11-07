package TicTacToe;

public class Player {
	
	private String name;
	private char symbol;
	
	Player(String name, char symbol){
		 setName(name);
		 setSymbol(symbol);
	}
	
	public String getName(){
		return this.name;
	}
	
	public void setSymbol(char symbol) {
		if(symbol != '\0'){
			this.symbol = symbol;
		}
	}

	public void setName(String name){
		if(!name.isEmpty()){        //To put constraints on writing name of player 
			this.name = name;       //Can also put other constraints like no digit or special symbol should be used 
		}
	}
	
	public char getSymbol(){
		return this.symbol;
	}
}
