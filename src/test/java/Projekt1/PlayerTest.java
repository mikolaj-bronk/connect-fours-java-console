package projekt1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class PlayerTest {
	
	private Player[] players;
	private Player player;
	
	private int[] ids_array = {0,1};	
	private ArrayList<Integer> ids;	
	
	private ArrayList<String> names_list;
	private String[] names = {"Stachu", "Andrzej"};
	
	@BeforeEach
	public void setUp() {	
		ids = new ArrayList<Integer>();
		names_list = new ArrayList<String>();
		
		players = new Player[2];
		for(int i=0; i<2; i++)
			players[i] = new Player(names[i],ids_array[i]);
	}

	@Test
	void getPlayerIdTest() {
		for(int i = 0; i<2;	i++) {
			ids.add(players[i].getPlayerId());		
		}		
	   assertThat(ids, contains(0,1));
	}
	
	@Test
	void getPlayerStrTest() {
		for(int i = 0; i<2;	i++) {
			names_list.add(players[i].getPlayerStr());
		}		
	   assertThat(names_list, contains("Stachu", "Andrzej"));
	}
	
	@Test
	void changeIdTest() {
		int id_old = players[0].getPlayerId();
		players[0].changeId(5);
		 assertNotEquals(id_old, players[0].getPlayerId());
	}

}
	
