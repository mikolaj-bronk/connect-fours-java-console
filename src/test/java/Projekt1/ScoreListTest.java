package projekt1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

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


public class ScoreListTest {

	private ScoreList score;
	
	@BeforeEach
	public void setUp() throws ClassNotFoundException, IOException {
		score = new ScoreList();	
		
		System.setOut(new PrintStream(new OutputStream() {
		    @Override
		    public void write(int b) throws IOException {}
		}));	
		
		score.printAll();
	}
	
	@Test
	@DisplayName("add first win")
	public void addWinTeste() throws Exception {
		score.players.remove("ObiektTestowy1");
		int wins = score.print("ObiektTestowy1");
		score.add("ObiektTestowy1");		
		assertNotSame(wins, score.print("ObiektTestowy1"));		
	}
	
	@Test
	@DisplayName("add 2 wins")
	public void addWinTest() throws Exception {
		int wins = score.print("ObiektTestowy1");
		score.add("ObiektTestowy1");		
		score.add("ObiektTestowy1");	
		assertEquals(wins+2, score.print("ObiektTestowy1"));		
	}


}
