package es.codeurjc.ais.tictactoe;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.mockito.ArgumentCaptor;
import org.mockito.ArgumentMatcher;
import org.mockito.Mockito;

import es.codeurjc.ais.tictactoe.TicTacToeGame.CellMarkedValue;
import es.codeurjc.ais.tictactoe.TicTacToeGame.EventType;
import es.codeurjc.ais.tictactoe.TicTacToeGame.WinnerValue;
@RunWith(Parameterized.class)
public class Empate{
	
	@Parameters
	public static Collection<Object[]> data() {
	Object[][] values = {
			{0, 1, 2, 4, 3, 6, 5, 8, 7},
	        {4, 2, 0, 8, 5, 3, 1, 7, 6},
			{3, 4, 2, 8, 0, 1, 7, 6, 5}
	};
	return Arrays.asList(values);
	}

	TicTacToeGame tg;
	 Connection c1;
	 Connection c2;
	 Player p1;
		Player p2;
@Before 
public void setUp() {
 tg= new TicTacToeGame();
 c1 = mock(Connection.class);
 c2 = mock(Connection.class);
 p1 = new Player(1,"player1","Eduardo");
p2 = new Player(2,"player2","Fran");
tg.addConnection(c1);
tg.addConnection(c2);
}
@Parameter(0)public int marked0;
@Parameter(1)public int marked1;
@Parameter(2)public int marked2;
@Parameter(3)public int marked3;
@Parameter(4)public int marked4;
@Parameter(5)public int marked5;
@Parameter(6)public int marked6;
@Parameter(7)public int marked7;
@Parameter(8)public int marked8;


@Test
public void Empate() {
	ArgumentCaptor<Object> argument =
			ArgumentCaptor.forClass(Object.class);
			
	tg.addPlayer(p1);
	tg.addPlayer(p2);
	reset(c1);
    reset(c2);
    tg.mark(marked0);
    tg.mark(marked1);
    tg.mark(marked2);
    tg.mark(marked3);
    tg.mark(marked4);
    tg.mark(marked5);
    tg.mark(marked6);
    tg.mark(marked7);
    
    reset(c1);
    reset(c2); 
    
    tg.mark(marked8);
    verify(c1).sendEvent(eq(EventType.GAME_OVER), argument.capture());
	Object event = argument.getValue();
	assertEquals(event,null);
   	verify(c2).sendEvent(eq(EventType.GAME_OVER), argument.capture());
	Object event2 = argument.getValue();
	assertEquals(event,null);
    
    
   
  
    
  
  
   
    
}
}
