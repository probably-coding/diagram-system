package system;

public class CombineLeftRight extends java.lang.Object
implements Diagram {

	
	int animationType;
	char[][] board;
	
	
	public CombineLeftRight(Diagram left, Diagram right,
			int animationType) {
		
		if(left.getNumberRows()!=right.getNumberRows()) {
			throw new IllegalArgumentException("Invalid parameter");
		}
		
		
		this.animationType = animationType;
		this.board = TwoDimArrayUtil.appendLeftRight​(left.getBoard(),
				right.getBoard());
		
		
	}
	
	
	
	public char[][] getBoard() {
		return board;
	}
	
	
	public char[][] nextAnimationStep() {
		
		if (animationType == 1) {
			TwoDimArrayUtil.rotateLeftOneColumn​(board);
		}else if (animationType == 2) {
			TwoDimArrayUtil.rotateTopOneRow​(board);
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
