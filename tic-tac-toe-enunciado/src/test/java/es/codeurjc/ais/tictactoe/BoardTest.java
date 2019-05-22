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
public class BoardTest {

	protected Board board;

	
	@Parameters
	public static Collection<Object[]> data(){
		
	    Object[][] data = {
	    	{0, 1, 2},
	        {3, 4, 5},
			{6, 7, 8},
			{0, 3, 6},
			{1, 4, 7},
			{2, 5, 8},
			{0, 4, 8},
			{6, 4, 2}
	    };
	    
	    return Arrays.asList(data);
	}
	
	@Parameter(0) public int pos1;
	@Parameter(1) public int pos2;
	@Parameter(2) public int pos3;
	@Test
	public void testGetCellsIfWinnerPrimeroGana() {
		board=new Board();
		String label="player1";
		Cell c=board.getCell(pos1);
		c.value=label;
		c.active=false;
		Cell c1=board.getCell(pos2);
		c1.value=label;
		c1.active=false;
		Cell c2=board.getCell(pos3);
		c2.value=label;
		c2.active=false;
		int [] valoreswin=board.getCellsIfWinner(label);;
		int [] positionmarcadas= {pos1,pos2,pos3};
		boolean draw=board.checkDraw();
		assertEquals(valoreswin[0], positionmarcadas[0]);
		assertEquals(valoreswin[1], positionmarcadas[1]);
		assertEquals(valoreswin[2], positionmarcadas[2]);
		assertEquals(draw, false);
	}
	@Test
	public void testGetCellsIfWinnerReturnNull() {
		board=new Board();
		String label="player1";
		Cell c=board.getCell(pos1);
		c.value=label;
		c.active=false;
		Cell c1=board.getCell(pos2+1);
		c1.value=label;
		c1.active=false;
		Cell c2=board.getCell(pos3-2);
		c2.value=label;
		c2.active=false;
		int [] valoreswin=board.getCellsIfWinner(label);;
		
		assertEquals(valoreswin,null);
	}

}
