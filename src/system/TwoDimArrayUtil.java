package system;

public class TwoDimArrayUtil {

	public static void main(String[] args) {

	}

	public TwoDimArrayUtil() { // constructor

	}

	public static boolean isRagged(char[][] array) {
		// if all rows are of equal length, return false, else true
		// a.length = row #,
		// a[i].length = col # does not matter what 'i' is

		if (array == null) {
			throw new IllegalArgumentException("Invalid parameter");
		}

		int firstRow = array[0].length;

		for (int i = 1; i < array.length; i++) {
			if (array[i].length != firstRow) {
				return true;
			}
		}

		return false;

	}

	public static void rotateTopOneRow​(char[][] array) {

		if (array == null || isRagged(array)) {
			throw new IllegalArgumentException("Invalid parameter");
		}

		if (array.length == 1) {
			return;
		}

		char[] temp = new char[array[0].length];

		temp = array[0]; // first row to temp

		for (int i = 1; i < array.length; i++) { // this works
			array[i - 1] = array[i];
		}
		System.out.println(TwoDimArrayUtil.toString(array));

		array[array.length - 1] = temp; // temp to last row

	}

	public static void rotateLeftOneColumn​(char[][] array) {

		if (array == null || isRagged(array)) {
			throw new IllegalArgumentException("Invalid parameter");
		}

		if (array[0].length == 1) {
			return;
		}

		char[] temp = new char[array.length];

		for (int i = 0; i < array.length; i++) { // first col to temp
			temp[i] = array[i][0];
		}

		// shift all cols over one

		for (int i = 1; i < array[0].length; i++) {
			for (int j = 0; j < array.length; j++) {
				array[j][i - 1] = array[j][i];
			}
		}

		for (int i = 0; i < array.length; i++) { // temp to last col
			array[i][array[0].length - 1] = temp[i];
		}

	}

	public static char[][] appendTopBottom​(char[][] top, char[][] bottom) {

		char[][] output;

		// doing as if array is ragged, but applies to all arrays

		// finding longest row to set number of columns
		int numCol = 0;
		int longestTopRow = findLongestRow(top);
		int longestBottomRow = findLongestRow(bottom);

		if (longestTopRow >= longestBottomRow)
			numCol = longestTopRow;
		else
			numCol = longestBottomRow;

		int numRow = top.length + bottom.length;

		output = new char[numRow][numCol];

		for (int i = 0; i < top.length; i++) {
			output[i] = top[i];
		}
		for (int i = 0; i < bottom.length; i++) {
			output[top.length + i] = bottom[i];
		}

		return output;

	}

	public static char[][] appendLeftRight​(char[][] left, 
			char[][] right) {

		char[][] output;

		int numRow = 0;

		if (left.length > right.length) {
			numRow = left.length;
		} else
			numRow = right.length;

		output = new char[numRow][];
		// will specify numCol individually

		for (int i = 0; i < numRow; i++) {

			if (left.length > i && right.length > i) {
				output[i] = new char[left[i].length + 
				                     right[i].length];
			} else if (left.length > i) {
				output[i] = new char[left[i].length];
			} else if (right.length > i) {
				output[i] = new char[right[i].length];
			}

			if (left.length > i && left[i] != null) {
				for (int j = 0; j < left[i].length; j++) {
					output[i][j] = left[i][j];
				}
			}

			if (right.length > i && right[i] != null) {
				for (int k = 0; k < right[i].length; k++) {

					int x;
					if (left.length - 1 < i) {
						x = 0;
					} else {
						x = left[i].length;
					}
					output[i][x + k] = right[i][k];
				}
			}

		}

		return output;
	}

	private static int findLongestRow(char[][] array) {

		int maxRowLength = array[0].length;
		int maxRow = 0;

		for (int i = 1; i < array.length; i++) {

			if (array[i].length > maxRowLength) {
				maxRowLength = array[i].length;
				maxRow = i;
			}
		}

		return maxRow;

	}

	public static String toString(char[][] arr) {

		String output = "";

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				output += arr[i][j];
			}
			output += "\n";
		}

		return output;

	}

}
