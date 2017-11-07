package TicTacToe;

public class Board {
	
	private char Board[][];
	private int boardSize = 3;
	private int count;                  //No. of cells of Board that have been marked
    private char p1Symbol, p2Symbol;
    
    public static final int PLAYER_1_WINS = 1;
    public static final int PLAYER_2_WINS = 2;
    public static final int DRAW = 3;
    public static final int INVALID = 4;
    public static final int INCOMPLETE = 5;
	
    
    public Board(char p1Symbol, char p2Symbol){
    	Board = new char[boardSize][boardSize];
    	for(int i=0; i<boardSize; i++){
    		for(int j=0; j<boardSize; j++){
    			Board[i][j] = ' ';          //space will indicate ki yaha pe kicci ne abhi tak move nahi challa
    		}
    	}
    	this.p1Symbol = p1Symbol;
    	this.p2Symbol = p2Symbol;
    }


	public int move(char symbol, int x, int y) {
		
		if(x < 0 || x >= boardSize || y < 0 || y >= boardSize || Board[x][y] != ' '){
			return INVALID;
		}
		
		Board[x][y] = symbol;
		count++;
		
		//Check row
		if(Board[x][0] == Board[x][1] && Board[x][0] == Board[x][2]){
			return symbol == p1Symbol ? PLAYER_1_WINS : PLAYER_2_WINS;
		}
		//Check col
		if(Board[0][y] == Board[1][y] && Board[0][y] == Board[2][y]){
			return symbol == p1Symbol ? PLAYER_1_WINS : PLAYER_2_WINS;
		}
		//First diag
		if(Board[0][0] != ' ' && Board[0][0] == Board[1][1] && Board[0][0] == Board[2][2]){
			return symbol == p1Symbol ? PLAYER_1_WINS : PLAYER_2_WINS;
		}
		//Second diag
		if(Board[0][2] != ' ' && Board[0][2] == Board[1][1] && Board[0][2] == Board[2][0]){
			return symbol == p1Symbol ? PLAYER_1_WINS : PLAYER_2_WINS;
		}
		
		if(count == boardSize * boardSize){
			return DRAW;
		}
		
		return INCOMPLETE;
	}
    
    public void print(){
    	System.out.println("-----------------");
    	for(int i=0; i<boardSize; i++){
    		for(int j=0; j<boardSize; j++){
    			System.out.print("| " + Board[i][j]+" |");   
    		}
    		System.out.println();
    	}
    	System.out.println("-----------------");
    	System.out.println();
    }
}
