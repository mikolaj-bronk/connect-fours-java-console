package projekt1;

public class Player {
	
	private String player;
	private int id_player;
	
	Player(String player, int id){
		this.player = player;
		this.id_player = id;
	}
	
	public String getPlayerStr() {
		return player;
	}
	
	public int getPlayerId() {
		return id_player;
	}
	
	public void changeId(int value) {
		this.id_player = value;
	}
	
}