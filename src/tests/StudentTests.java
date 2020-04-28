package tests;

import static org.junit.Assert.*;

import system.*;

import org.junit.Test;

import app.DrawingApp;
import gui.BoardCell;

public class StudentTests {

	// other methods

	private boolean compareTwoDimArray(char[][] array1, char[][] array2) {

		if (array1.length != array2.length) {
			return false;
		}

		for (int i = 0; i < array1.length; i++) {
			for (int j = 0; j < array1[i].length; j++) {
				if (array1[i][j] != array2[i][j])
					return false;
			}
		}

		return true;

	}

	// TwoDimArrayUtil class

	@Test
	public void testIsRagged() {

		char[][] test = { { 'A', 'B' }, { 'C', 'D' }, { 'F', 'G' } };

		assertFalse(TwoDimArrayUtil.isRagged(test));

	}

	@Test
	public void testIsRagged2() {

		char[][] test = { { 'A', 'B' }, { 'C', 'D', 'E' }, { 'F', 'G' } };

		assertTrue(TwoDimArrayUtil.isRagged(test));

	}

	@Test
	public void testRotateTopOneRow() {

		char[][] test = { { 'A', 'B' }, { 'C', 'D' }, { 'E', 'F' } };

		TwoDimArrayUtil.rotateTopOneRow​(test);

		char[][] expected = { { 'C', 'D' }, { 'E', 'F' }, { 'A', 'B' } };

		assertTrue(compareTwoDimArray(test, expected));

	}

	@Test
	public void testRotateLeftOneColumn() {

		char[][] test = { { 'A', 'B', 'C' }, { 'D', 'E', 'F' },
				{ 'G', 'H', 'I' } };

		TwoDimArrayUtil.rotateLeftOneColumn​(test);

		char[][] expected = { { 'B', 'C', 'A' }, { 'E', 'F', 'D' },
				{ 'H', 'I', 'G' } };

		assertTrue(compareTwoDimArray(test, expected));

	}

	@Test
	public void testAppendTopBottom() {

		char[][] top = { { 'A', 'B' }, { 'C', 'D', 'E' }, { 'F', 'G' } };

		char[][] bottom = { { 'B', 'C', 'A' }, { 'E', 'F', 'D' }, 
				{ 'H', 'I', 'G' } };

		char[][] test = TwoDimArrayUtil.appendTopBottom​(top, bottom);

		char[][] expected = { { 'A', 'B' }, { 'C', 'D', 'E' }, 
				{ 'F', 'G' }, { 'B', 'C', 'A' }, { 'E', 'F', 'D' },
				{ 'H', 'I', 'G' }

		};

		assertTrue(compareTwoDimArray(test, expected));

	}

	@Test
	public void testAppendLeftRight() {

		char[][] left = { { 'A', 'B' }, { 'F', 'G', 'H' }, { 'L', 'M' }

		};

		char[][] right = { { 'C', 'D', 'E' }, { 'I', 'J', 'K' }, 
				{ 'N', 'O', 'P' }, { 'Q', 'R' } };

		char[][] test = TwoDimArrayUtil.appendLeftRight​(left, right);

		char[][] expected = { { 'A', 'B', 'C', 'D', 'E' }, 
				{ 'F', 'G', 'H', 'I', 'J', 'K' },
				{ 'L', 'M', 'N', 'O', 'P' }, { 'Q', 'R' } };

		assertTrue(compareTwoDimArray(test, expected));

	}

	// HorizontalBars Class

	@Test
	public void hBarsGetBoardTest() {

		HorizontalBars h = new HorizontalBars(6, 5, 3, 'R', 'G', 'B', 1);

		char[][] test = h.getBoard();

		char[][] expected = BoardCell.getCharArray(DrawingApp.
				getHorizontalBars(6, 5, 3, 'R', 'G', 'B'));

		assertTrue(compareTwoDimArray(test, expected));

	}

	@Test
	public void hBarsNextAnimationStepTest() {

		HorizontalBars h = new HorizontalBars(6, 5, 3, 'R', 'G', 'B', 1);

		char[][] test = h.nextAnimationStep();

		// char[][] expected =

	}

	@Test
	public void hBarsGetNumberRowsTest() {

		HorizontalBars h = new HorizontalBars(6, 5, 3, 'R', 'G', 'B', 1);

		int test = h.getNumberRows();

		int expected = 6;

		assertTrue(test == expected);

	}

	@Test
	public void hBarsGetNumberColsTest() {

		HorizontalBars h = new HorizontalBars(6, 5, 3, 'R', 'G', 'B', 1);

		int test = h.getNumberCols();

		int expected = 5;

		assertTrue(test == expected);

	}

	// VerticalBars Class

	@Test
	public void vBarsGetBoardTest() {

		VerticalBars v = new VerticalBars(5, 6, 3, 'G', 'B', 'R', 1);

		char[][] test = v.getBoard();

		char[][] expected = BoardCell.getCharArray(DrawingApp.
				getVerticalBars(5, 6, 3, 'G', 'B', 'R'));

		assertTrue(compareTwoDimArray(test, expected));

	}

	@Test
	public void vBarsNextAnimationStepTest() {

		VerticalBars v = new VerticalBars(5, 6, 3, 'G', 'B', 'R', 1);

		char[][] test = v.nextAnimationStep();

		TwoDimArrayUtil.rotateLeftOneColumn​(v.getBoard());

	}

	@Test
	public void vBarsGetNumberRowsTest() {

		VerticalBars v = new VerticalBars(5, 6, 3, 'G', 'B', 'R', 1);

		int test = v.getNumberRows();

		int expected = 5;

		assertTrue(test == expected);

	}

	@Test
	public void vBarsGetNumberColsTest() {

		VerticalBars v = new VerticalBars(5, 6, 3, 'G', 'B', 'R', 1);

		int test = v.getNumberCols();

		int expected = 6;

		assertTrue(test == expected);

	}

	// Flag Class

	@Test
	public void flagGetBoardTest() {

		Flag f = new Flag(5, 'R', 'B', 'G', 1);

		char[][] test = f.getBoard();

		char[][] expected = BoardCell.getCharArray(DrawingApp.getFlag
				(5, 'R', 'B', 'G'));

		assertTrue(compareTwoDimArray(test, expected));

	}

	@Test
	public void flagNextAnimationStepTest() {

		Flag f = new Flag(5, 'R', 'B', 'G', 2);

		char[][] test = f.nextAnimationStep();

		TwoDimArrayUtil.rotateTopOneRow​(f.getBoard());

		assertTrue(compareTwoDimArray(test, f.getBoard()));

	}

	@Test
	public void flagGetNumberRowsTest() {

		Flag f = new Flag(5, 'R', 'G', 'G', 2);

		int test = f.getNumberRows();

		int expected = 10;

		assertTrue(test == expected);

	}

	@Test
	public void flagGetNumberColsTest() {

		Flag f = new Flag(5, 'R', 'G', 'G', 2);

		int test = f.getNumberCols();

		int expected = 25;

		assertTrue(test == expected);

	}

	// CombineLeftRight class

	@Test
	public void combineLeftRightGetBoardTest() {

		HorizontalBars h = new HorizontalBars(6, 5, 3, 'R', 'G', 'B', 1);

		CombineLeftRight l = new CombineLeftRight(h, h, 1);

		char[][] test = l.getBoard();

		char[][] expected = TwoDimArrayUtil.appendLeftRight​(h.getBoard(), 
				h.getBoard());

		assertTrue(compareTwoDimArray(test, expected));

	}

	@Test
	public void combineLeftRightNextAnimationStepTest() {

		HorizontalBars h = new HorizontalBars(4, 2, 1, 'R', 'G', 'B', 1);

		CombineLeftRight l = new CombineLeftRight(h, h, 1);

		char[][] test = l.nextAnimationStep();

		TwoDimArrayUtil.rotateLeftOneColumn​(l.getBoard());

		assertTrue(compareTwoDimArray(test, l.getBoard()));

	}

	@Test
	public void combineLeftRightGetNumberRowsTest() {

		HorizontalBars h = new HorizontalBars(6, 5, 3, 'R', 'G', 'B', 1);

		CombineLeftRight l = new CombineLeftRight(h, h, 1);

		int test = l.getNumberRows();

		int expected = 6;

		assertTrue(test == expected);

	}

	@Test
	public void combineLeftRightGetNumberColsTest() {

		HorizontalBars h = new HorizontalBars(6, 5, 3, 'R', 'G', 'B', 1);

		CombineLeftRight l = new CombineLeftRight(h, h, 1);

		int test = l.getNumberCols();
		// System.out.println(test);

		int expected = 10;

		assertTrue(test == expected);

	}

	// CombineTopBottom class

	@Test
	public void combineTopBottomGetBoardTest() {

		HorizontalBars h = new HorizontalBars(6, 5, 3, 'R', 'G', 'B', 1);

		CombineTopBottom t = new CombineTopBottom(h, h, 1);

		char[][] test = t.getBoard();

		char[][] expected = TwoDimArrayUtil.appendTopBottom​(h.getBoard(),
				h.getBoard());

		assertTrue(compareTwoDimArray(test, expected));

	}

	@Test
	public void combineTopBottomNextAnimationStepTest() {

		HorizontalBars h = new HorizontalBars(6, 5, 3, 'R', 'G', 'B', 1);

		CombineTopBottom t = new CombineTopBottom(h, h, 1);

		char[][] test = t.nextAnimationStep();

		TwoDimArrayUtil.rotateLeftOneColumn​(t.getBoard());

		assertTrue(compareTwoDimArray(test, t.getBoard()));

	}

	@Test
	public void combineTopBottomGetNumberRowsTest() {

		HorizontalBars h = new HorizontalBars(6, 5, 3, 'R', 'G', 'B', 1);

		CombineTopBottom t = new CombineTopBottom(h, h, 1);

		int test = t.getNumberRows();

		int expected = 12;

		assertTrue(test == expected);

	}

	@Test
	public void combineTopBottomGetNumberColsTest() {

		HorizontalBars h = new HorizontalBars(6, 5, 3, 'R', 'G', 'B', 1);

		CombineTopBottom t = new CombineTopBottom(h, h, 1);

		int test = t.getNumberCols();

		int expected = 5;

		assertTrue(test == expected);

	}

}
