package system;

import app.DrawingApp;
import gui.BoardCell;

public class VerticalBars extends java.lang.Object implements Diagram {

	int animationType;
	char[][] board = {};

	public VerticalBars(int maxRows, int maxCols, int bars, char color1,
			char color2, char color3, int animationType) {

		this.animationType = animationType;
		this.board = BoardCell.getCharArray(DrawingApp.getVerticalBars
				(maxRows, maxCols, bars, color1, color2, color3));

	}

	public char[][] getBoard() {
		return board;
	}

	public char[][] nextAnimationStep() {

		if (animationType == 1) {
			TwoDimArrayUtil.rotateLeftOneColumn​(board);
		}

		return board;
	}

	public int getNumberRows() {

		return board.length;
	}

	public int getNumberCols() {

		return board[0].length;
	}

}
