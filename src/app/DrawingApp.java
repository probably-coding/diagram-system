package app;

import java.util.Random;

public class DrawingApp {

	public static void main(String[] args) {

		String test = getFlag(9, 'R', '.', 'Y');
		System.out.println(test);
	}

	private static boolean isValidColor(char color) {

		if (color == 'R' || color == 'G' || color == 'B' || color == 'Y' || color == 'Y' || color == '*'
				|| color == '.') {
			return true;
		}

		else {
			return false;
		}

	}

	public static String getRectangle(int maxRows, int maxCols, char symbol) {

		String rectangle = "";

		if (maxRows < 1 || maxCols < 1) {
			return null;
		} else {
			for (int i = 0; i < maxRows; i++) {
				for (int j = 0; j < maxCols; j++) {
					rectangle += symbol;

				}

				if (i == maxRows - 1) { // to make sure it doesn't create an extra line after the string

				} else {
					rectangle += "\n";
				}
			}
		}

		return rectangle;

	}

	public static char getRandomColor(Random random) {

		int color = random.nextInt(6);
		char character = '0';

		if (color == 0) {
			character = 'R';
		} else if (color == 1) {
			character = 'G';
		} else if (color == 2) {
			character = 'B';
		} else if (color == 3) {
			character = 'Y';
		} else if (color == 4) {
			character = '*';
		} else if (color == 5) {
			character = '.';
		}

		return character;

	}

	public static String getHorizontalBars(int maxRows, int maxCols, int bars, char color1, char color2, char color3) {

		String hBars = "";
		int x = bars;
		int a = 1;

		if (maxRows < 1 || maxCols < 1 || !isValidColor(color1) || !isValidColor(color2) || !isValidColor(color3)) {
			return null;
		}

		while (a <= bars) {

			for (int i = 0; i < maxRows / x; i++) {
				for (int j = 0; j < maxCols; j++) {
					if (a % 3 == 1) {
						hBars += color1;
					} else if (a % 3 == 2) {
						hBars += color2;
					} else if (a % 3 == 0) {
						hBars += color3;
					}

				}

				if (i == (maxRows / x) - 1 && a == bars) { // to make sure it doesn't create an extra line after the
															// string

				} else {
					hBars += "\n";
				}
			}

			a++;
		}

		return hBars;

	}

	public static String getFlag(int size, char color1, char color2, char color3) {

		String flag = "";

		if (size < 3) {
			return null;
		}

		for (int i = 1; i <= size; i++) {
			for (int j = 1; j <= size * 5; j++) {
				if(j <= i) {
					flag += color1;
				}
				else if(i == 1 || i == size) {
					flag += color2;
				}
				else {
					flag += color3;
				}
			}
			
				flag += "\n";
			
		}

		for(int i = size; i > 0; i--) {
			for(int j = 1; j<=size*5; j++) {
				if(j <= i) {
					flag += color1;
				}
				else if(i == 1 || i == size) {
					flag += color2;
				}
				else {
					flag += color3;
				}	
			}
			
			if(i!=1)
				flag += "\n";
		}
		
		

		
		return flag;
		
		
	}

	public static String getVerticalBars(int maxRows, int maxCols, int bars, char color1, char color2, char color3) {

		String vBars = "";

		if (maxRows < 1 || maxCols < 1 || !isValidColor(color1) || !isValidColor(color2) || !isValidColor(color3)) {
			return null;
		}

		for (int i = 0; i < maxRows; i++) {

			int x = 1;

			while (x <= bars) {
				for (int j = 1; j <= maxCols / bars; j++) {

					if (x % 3 == 1) {
						vBars += color1;
					} else if (x % 3 == 2) {
						vBars += color2;
					} else if (x % 3 == 0) {
						vBars += color3;
					}

				}
				x++;
			}

			if (i == maxRows - 1) { // to make sure it doesn't add an extra line after the string is completed

			} else {
				vBars += "\n";
			}
		}

		return vBars;

	}

}