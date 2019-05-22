package es.codeurjc.ais.tictactoe;
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
public class PrimeroGana {
	
	@Parameters
	public static Collection<Object[]> data() {
	Object[][] values = {
			{0, 8, 1, 3, 2},
	        {3, 0, 4, 8, 5},
			{6, 0, 7, 3, 8},
			{0, 2, 3, 4, 6},
			{1, 2, 4, 8, 7},
			{2, 4, 5, 7, 8},
			{0, 2, 4, 6, 8},
			{6, 0, 4, 7, 2}
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
	@Test
	public void testAñadirJugadores() {

	tg.addPlayer(p1);
	
	ArrayList<Player> jugadores= new ArrayList<Player>();
	jugadores.add(p1);
	verify(c1).sendEvent(EventType.JOIN_GAME,jugadores);
	verify(c2).sendEvent(EventType.JOIN_GAME,jugadores);
	reset(c1);
	reset(c2);
	
	jugadores.add(p2);
	tg.addPlayer(p1);
	tg.addPlayer(p2);
	verify(c1,atLeastOnce()).sendEvent(
			 EventType.JOIN_GAME,jugadores);
	verify(c2,atLeastOnce()).sendEvent(
			EventType.JOIN_GAME,jugadores);
	}
	
	@Test 
	public void testCheckTurnos(){
		tg.addPlayer(p1);
		tg.addPlayer(p2);
		
		assertEquals(tg.checkTurn(p1.getId()),true);
		assertEquals(tg.checkTurn(p2.getId()),false);
		
		reset(c1);
		reset(c2);
		
		ArgumentCaptor<CellMarkedValue> argument =
				ArgumentCaptor.forClass(CellMarkedValue.class);
		tg.mark(0);
		
		verify(c1).sendEvent(eq(EventType.MARK), argument.capture());
		CellMarkedValue cell =  argument.getValue();
		verify(c2).sendEvent(eq(EventType.MARK), argument.capture());
		CellMarkedValue cell2 =  argument.getValue();
		assertEquals(cell.cellId,0);
		assertEquals(cell.player,p1);
		assertEquals(cell2.cellId,0);
		assertEquals(cell2.player,p1);
		
		assertEquals(tg.checkTurn(p2.getId()),true);
		assertEquals(tg.checkTurn(p1.getId()),false);
		
		
	}
	@Parameter(0)public int marked0;
	@Parameter(1)public int marked1;
	@Parameter(2)public int marked2;
	@Parameter(3)public int marked3;
	@Parameter(4)public int marked4;
	
	@Test
	public void PrimeroGana() {
		ArgumentCaptor<WinnerValue> argument =
				ArgumentCaptor.forClass(WinnerValue.class);
				
		tg.addPlayer(p1);
		tg.addPlayer(p2);
		reset(c1);
        reset(c2);
        tg.mark(marked0);
        tg.mark(marked1);
        tg.mark(marked2);
        tg.mark(marked3);
        reset(c1);
        reset(c2);
        tg.mark(marked4);//marca p1 en la casilla 2 y gana la partida
        
      
      
        verify(c1).sendEvent(eq(EventType.GAME_OVER), argument.capture());
		WinnerValue event = argument.getValue();
		
		verify(c2).sendEvent(eq(EventType.GAME_OVER), argument.capture());
		WinnerValue event2 = argument.getValue();
		
		assertEquals(event,event2);
		
		assertEquals(event.player,p1);// aseguramos que el p1 es el ganador
		 
        
	}
	
	}


