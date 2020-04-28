package system;

public class CombineTopBottom extends java.lang.Object 
implements Diagram {

	
	int animationType;
	char[][] board;
	
	
	public CombineTopBottom(Diagram top, Diagram bottom, 
			int animationType) {
		
		if(top.getNumberCols()!=bottom.getNumberCols()) {
			throw new IllegalArgumentException("Invalid parameter");
		}
		
		
		this.animationType = animationType;
		this.board = TwoDimArrayUtil.appendTopBottom​(top.getBoard(),
				bottom.getBoard());
		
		
	}
	
	
	public char[][] getBoard() {
		return board;
	}
	
	
	public char[][] nextAnimationStep() {
		
		if (animationType == 1) {
			TwoDimArrayUtil.rotateLeftOneColumn​(board);
		}else if (animationType == 1) {
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
