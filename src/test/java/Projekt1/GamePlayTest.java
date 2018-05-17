package projekt1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.jupiter.api.DisplayName;


public class GamePlayTest {

	private GamePlay gameplay;
	
	@BeforeEach
	public void setUp() throws ClassNotFoundException, IOException {
		gameplay = new GamePlay();		
		
	}
	
	
	
	@Test
	@DisplayName("setName Test")
	public void setName() throws Exception {
		ByteArrayInputStream in = new ByteArrayInputStream("Kamil".getBytes());
		System.setIn(in);

		String name = gameplay.setName();		
		System.setIn(System.in);
		
		assertEquals("Kamil", name); 	 
	}
	
	
	@Test
	@DisplayName("getScanInt Test")
	public void getScanInt() throws Exception {
		ByteArrayInputStream in = new ByteArrayInputStream("1".getBytes());
		System.setIn(in);
		
	    int integer = 2;
		integer = gameplay.getScanInt();	
		System.setIn(System.in);
		
		assertNotSame(2, integer); 	 
	}
	
	@Test
	@DisplayName("getColor Test")
	public void getColorTest() throws Exception {
		ByteArrayInputStream in = new ByteArrayInputStream("c".getBytes());
		System.setIn(in);		
	    
		String str = gameplay.getColor();
		System.setIn(System.in);
		
		assertEquals("c", str); 	 
	}
	
	@Test
	@DisplayName("pickColor Test")
	public void pickColorTest() throws Exception {
		Boolean flag = true;
		
		gameplay.player_1 = new Player("test1", 0);
		gameplay.player_2 = new Player("test2", 1);
		gameplay.pickColor("c");
		
		if(gameplay.player_1.getPlayerId() == 0) {
			flag = false;
		}
		
		assertTrue(flag); 	 
	}
	
	@Test
	@DisplayName("printPlayer Test - true")
	public void printPlayerTestTr() throws Exception {
		Boolean flag = true;
		
		gameplay.player_1 = new Player("test1", 0);
		gameplay.player_2 = new Player("test2", 1);
		
		assertEquals("test1", gameplay.printPlayer(true)); 	 
	}
	
	@Test
	@DisplayName("printPlayer Test - false")
	public void printPlayerTestFls() throws Exception {
		Boolean flag = true;
		
		gameplay.player_1 = new Player("test1", 0);
		gameplay.player_2 = new Player("test2", 1);
		
		assertEquals("test2", gameplay.printPlayer(false)); 	 
	}



	

}
