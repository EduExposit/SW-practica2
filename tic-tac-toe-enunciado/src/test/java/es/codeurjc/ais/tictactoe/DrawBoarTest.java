package es.codeurjc.ais.tictactoe;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import es.codeurjc.ais.tictactoe.Board;
import es.codeurjc.ais.tictactoe.TicTacToeGame.Cell;


@RunWith(Parameterized.class)
public class DrawBoarTest {
protected Board board;

	
	@Parameters
	public static Collection<Object[]> data(){
		
	    Object[][] data = {
	    	{0, 1, 2, 4, 3, 6, 5, 8, 7},
	        {4, 2, 0, 8, 5, 3, 1, 7, 6},
			{3, 4, 2, 8, 0, 1, 7, 6, 5}
			
	    };
	    
	    return Arrays.asList(data);
	}
	
	@Parameter(0) public int pos0;
	@Parameter(1) public int pos1;
	@Parameter(2) public int pos2;
	@Parameter(3) public int pos3;
	@Parameter(4) public int pos4;
	@Parameter(5) public int pos5;
	@Parameter(6) public int pos6;
	@Parameter(7) public int pos7;
	@Parameter(8) public int pos8;
	@Test
	public void testGetCellsIfWinner() {
		board=new Board();
		String label1="player1";
		String label2="player2";
		Cell c=board.getCell(pos0);
		c.value=label1;
		c.active=false;
		Cell c1=board.getCell(pos1);
		c1.value=label2;
		c1.active=false;
		Cell c2=board.getCell(pos2);
		c2.value=label1;
		c2.active=false;
		Cell c3=board.getCell(pos3);
		c3.value=label2;
		c3.active=false;
		Cell c4=board.getCell(pos4);
		c4.value=label1;
		c4.active=false;
		Cell c5=board.getCell(pos5);
		c5.value=label2;
		c5.active=false;
		Cell c6=board.getCell(pos6);
		c6.value=label1;
		c6.active=false;
		Cell c7=board.getCell(pos7);
		c7.value=label2;
		c7.active=false;
		Cell c8=board.getCell(pos8);
		c8.value=label1;
		c8.active=false;
		int [] valoreswin1=board.getCellsIfWinner(label1);
		int [] valoreswin2=board.getCellsIfWinner(label2);
		boolean draw=board.checkDraw();
		assertEquals(valoreswin1, null);
		assertEquals(valoreswin2, null);
		assertEquals(draw, true);
	}
}
