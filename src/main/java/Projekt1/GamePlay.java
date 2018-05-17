package projekt1;

import java.io.IOException;
import java.util.Scanner;

public class GamePlay {
	
	public Player player_1;
	public Player player_2;
	private boolean turn = true;
	private boolean draw = false;	
	
	
	public void startGamePlay() throws Exception {
		System.out.println("Podaj nick gracza nr 1");	 
		player_1 = new Player(this.setName(),0);
		
		System.out.println("Podaj nick gracza nr 2");
		player_2 = new Player(this.setName(),1);
		
		System.out.println("Wybierz: \n1 - Zagraj \n2 - Pokaz tabele przed gra\n");
		Integer gm = getScanInt();
		if(gm == 2) {
			ScoreList score = new ScoreList();
			score.printAll();
		}			
		gamePlay();
	}
	
	public String setName() {		
		String name = "";
		Scanner sc = new Scanner(System.in);
		name = sc.nextLine();	
		return name;
	}
	
	public int getScanInt() {
		Scanner sc = new Scanner(System.in);
		int scInt = sc.nextInt();
		return scInt;
	}
	
	public String getColor() {	
		String color = "";
		Scanner sc = new Scanner(System.in);
		color = sc.nextLine();	
		return color;
	}
	
	public void pickColor(String color) {
		
		     if(color.equals("c")) {
		    	 player_1.changeId(1); 	
		    	 player_2.changeId(0); 	
		     } else {
		    	 player_1.changeId(0); 
		    	 player_2.changeId(1); 
		     }
		     
	}	
	
	
	//to print correct player in console
		public String printPlayer(boolean turn) {		
			if (turn) 			
				return player_1.getPlayerStr();
			else 
				return player_2.getPlayerStr();
		}
	
	
	public void gamePlay() throws Exception {		
	
		int player1 = 0;
		int player2 = 1;
		int i = 0;
		
		ConnectFour game = new ConnectFour();		
		
		game.makeBoard();
		System.out.println(player_1.getPlayerStr()+", wybierz kolor: (c - czerwony, z - zielony)");
		this.pickColor(getColor());
		player1 = player_1.getPlayerId();
		player2 = player_2.getPlayerId();
		
		
		
		while( game.getWinner() == 0 ) {
			System.out.println("\nGracz " + this.printPlayer(turn) + " wybierz miejsce dla krazka (1-7)");
			
			Scanner sc = new Scanner(System.in);
		    int pos = sc.nextInt() - 1;
		    
		    if(turn) {		    	
		    	if(game.placeDisc(pos, player1)) {
		    		turn = false;
		    		i++;
		    	}		    	
		    } else {		    	
		    	if(game.placeDisc(pos, player2)) {
		    		turn = true;
		    		i++;
		    	}
		    	
		    }
		    
		    game.printBoard();
		    

			if(i == game.getHeight() * game.getWidth()) {
				draw = true;
				break;
			}
		}
		if(!draw) {
			System.out.println("\nWygral gracz: "+ this.printPlayer(!turn));
			ScoreList score = new ScoreList();
			score.add(this.printPlayer(!turn));
			score.print(this.printPlayer(!turn));
		} else
			System.out.println("\nRemis");
	}
	
	
	public static void main(String args[]) throws Exception {		
		
		GamePlay gameplay = new GamePlay();		
		gameplay.startGamePlay();
		

	}
	
}