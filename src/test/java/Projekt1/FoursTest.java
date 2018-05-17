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


public class FoursTest {

	private ConnectFour game;
	
	@BeforeEach
	public void setUp() {
		game = new ConnectFour();	
		
		System.setOut(new PrintStream(new OutputStream() {
		    @Override
		    public void write(int b) throws IOException {}
		}));	
		game.printBoard();	
	}
	
	
	
	@Test
	@DisplayName("makeBoard default length test (6,7)")
	public void makeBoardTestDefaultLength() {
		game.makeBoard();
		
		Boolean flag = true;
		if(game.board.length != 6 || game.board[0].length != 7 )	  
			flag = false;			
		
		assertTrue(flag); 
	 
	}

	@DisplayName("changeSize width test")
	@ParameterizedTest
	@ValueSource(ints = { 5,16,32,74,10,7,27,31,52,66,105,15,48,63,16,12 })
	public void changeSizeTestWidth(int testInt) {
		game.makeBoard();
		game.changeSize(7, testInt);
		
		Boolean flag = true;
		if(game.board.length != testInt)  
			flag = false;			
		
		assertTrue(flag); 
	 
	}
	
	@DisplayName("changeSize width test using getWidth method")
	@ParameterizedTest
	@ValueSource(ints = { 1,2,5,6,7,8,9,10,11,15,16,19,20,25,26 })
	public void changeSizeTestWidthWithReturn(int testInt) {
		game.makeBoard();
		game.changeSize(testInt, 6);
		
		Boolean flag = true;
		if(game.getWidth() != testInt)  
			flag = false;			
		
		assertTrue(flag); 
	 
	}
	
	@DisplayName("changeSize height test using getHeight method")
	@ParameterizedTest
	@ValueSource(ints = { 20,10,7,6,5,2,1 })
	public void changeSizeTestHeightWithReturn(int testInt) {
		game.makeBoard();
		game.changeSize(7,testInt);
		
		Boolean flag = true;
		if(game.getHeight() != testInt)  
			flag = false;			
		
		assertTrue(flag); 
	 
	}
	
	@DisplayName("changeSize height test")
	@ParameterizedTest
	@ValueSource(ints = { 30,50,70,32,15,36,20,50 })
	public void changeSizeTestHeight(int testInt) {
		game.makeBoard();
		game.changeSize(testInt, 7);	
		
		assertEquals(testInt, game.board[0].length); 
	 
	}
	
	
	@Test
	@DisplayName("makeBoard test")
	public void makeBoardTest() {
		game.makeBoard();
		
		Boolean flag = true;
		
		for(int i=0; i<6; i++) {
            for(int j=0; j<7; j++) {
                if(game.board[i][j] != '-')
                	flag = false;
            }
        }
		
		assertTrue(flag); 
	 
	}
	
	@Test
	@DisplayName("PlaceDisc exception test (wrong pos, large)")
	  public void wrongPlaceDiscExceptionTest_tooLarge() {
	    String st = null;
	    Throwable exception = assertThrows(Exception.class, () -> {
	      game.placeDisc(9, 1);
	    });
	    assertEquals("Zla pozycja. Krazek nie moze znajdowac sie w tym miejscu", exception.getMessage());
	  }	  
	
	@Test
	@DisplayName("PlaceDisc exception test (wrong pos, low)")
	  public void wrongPlaceDiscExceptionTest_tooLow() {
	    String st = null;
	    Throwable exception = assertThrows(Exception.class, () -> {
	      game.placeDisc(-1, 1);
	    });
	    assertEquals("Zla pozycja. Krazek nie moze znajdowac sie w tym miejscu", exception.getMessage());
	  }	 
	
	
	@Test
	@DisplayName("single PlaceDisc test")
	public void placeDiscTest_single() throws Exception {
		game.makeBoard();
		game.placeDisc(1, 1);
		assertEquals('x', game.board[5][1]);		
	}
	
	@Test
	@DisplayName("stacking discs test")
	public void placeDiscTest_stacking() throws Exception {
		game.makeBoard();
		game.placeDisc(1, 1);
		game.placeDisc(1, 1);
		assertEquals('x', game.board[4][1]);		
	}
	
	@Test
	@DisplayName("full stack of discs test")
	public void placeDiscTest_fullstack() throws Exception {
		game.makeBoard();
		game.placeDisc(1, 1);
		game.placeDisc(1, 0);
		game.placeDisc(1, 1);
		game.placeDisc(1, 0);
		game.placeDisc(1, 1);
		game.placeDisc(1, 0);	
		assertTrue(!game.placeDisc(1, 1));		
	}
	
	@Test
	@DisplayName("winTest horizontal")
	public void winTestHorizontalTest() throws Exception {
		game.makeBoard();
		int winner = game.getWinner();
		game.placeDisc(1, 1);
		game.placeDisc(2, 1);
		game.placeDisc(4, 1);
		game.placeDisc(5, 1);
		game.placeDisc(3, 1);		
		assertNotSame(winner, game.getWinner());		
	}
	
	@Test
	@DisplayName("winTest vertical")
	public void winTestVerticalUpTest() throws Exception {
		game.makeBoard();
		int winner = game.getWinner();
		game.placeDisc(1, 1);
		game.placeDisc(1, 1);
		game.placeDisc(1, 1);
		game.placeDisc(1, 1);
		assertNotSame(winner, game.getWinner());	
	}
	
	@Test
	@DisplayName("winTest diagonal left")
	public void winTestDiagonalLeftTest() throws Exception {
		game.makeBoard();		
		int winner = game.getWinner();
		game.placeDisc(6, 0);		
		game.placeDisc(5, 1);
		game.placeDisc(5, 0);
		game.placeDisc(4, 1);
		game.placeDisc(3, 0);
		game.placeDisc(4, 1);
		game.placeDisc(3, 1);	
		game.placeDisc(3, 1);
		game.placeDisc(3, 0);
		game.placeDisc(4, 0);		

		assertNotSame(winner, game.getWinner());	
	}
	
	@Test
	@DisplayName("winTest diagonal right")
	public void winTestDiagonalRightTest() throws Exception {
		game.makeBoard();		
		int winner = game.getWinner();
		game.placeDisc(1, 0);		
		game.placeDisc(2, 1);
		game.placeDisc(2, 0);
		game.placeDisc(3, 1);
		game.placeDisc(3, 1);
		game.placeDisc(4, 1);
		game.placeDisc(4, 1);
		game.placeDisc(4, 1);
		game.placeDisc(4, 0);
		game.placeDisc(3, 0);
		
		assertNotSame(winner, game.getWinner());	
	}
	
	

}
