/**
 * 
 */
package game.tictactoe.tictactoegame.engine;

/**
 * @author Ahmed Badr
 *
 */
public class BoardMini {

	private boolean[][] turnsBoardMini;
	private Character[][] gameBoardMini;

	public BoardMini() {

		turnsBoardMini = new boolean[3][3];
		gameBoardMini = new Character[3][3];

		for (int i = 0; i < gameBoardMini.length; i++) {
			for (int j = 0; j < gameBoardMini[i].length; j++) {
				gameBoardMini[i][j] = ' ';
			}
		}

	}

	/**
	 * @return the gameBoard
	 */
	public Character[][] getGameBoard() {
		return gameBoardMini;
	}

	public boolean playAction(PointPosition position, Character playerType) {
		int pointX = position.getPointX();
		int pointY = position.getPointY();

		if (isAllowedToPlay(position)) {
			turnsBoardMini[pointX][pointY] = true;
			gameBoardMini[pointX][pointY] = playerType;
			System.out.println("point x: " + pointX + "point y: " + pointY + " " + playerType);
			return true;
		}
		return false;
	}

	public boolean isAllowedToPlay(PointPosition position) {
		int pointX = position.getPointX();
		int pointY = position.getPointY();
		if (!(pointX < 3 && pointY < 3)) {
			return false;
		}
		if (turnsBoardMini[pointX][pointY] == false) {
			return true;
		}
		return false;

	}

	// ---------- Check for game over cases -------------//
	public boolean gameOver(Character playerType) {

		// ----------- Search Horizontally ---------------//
		for (int i = 0; i < gameBoardMini.length; i++) {
			int counterWinner = 0;
			for (int j = 0; j < gameBoardMini[i].length; j++) {
				if (gameBoardMini[i][j].equals(playerType)) {
					counterWinner = counterWinner + 1;
					if (counterWinner == 3) {
						return true;
					}
				} else {
					counterWinner = 0;
					break;
				}
			}
		}

		// ----------- Search Vertically ---------------//
		for (int i = 0; i < gameBoardMini.length; i++) {
			int counterWinner = 0;
			for (int j = 0; j < gameBoardMini[i].length; j++) {
				if (gameBoardMini[j][i].equals(playerType)) {
					counterWinner = counterWinner + 1;
					if (counterWinner == 3) {
						return true;
					}
				} else {
					counterWinner = 0;
					break;
				}
			}
		}

		// ----------- Search Diagonally to Right ---------------//
		int counterWinnerDR = 0;
		for (int i = 0, j = 0; i < gameBoardMini.length && j < gameBoardMini.length; i++, j++) {
			if (gameBoardMini[i][j].equals(playerType)) {
				counterWinnerDR = counterWinnerDR + 1;
				if (counterWinnerDR == 3) {
					return true;
				}
			} else {
				break;
			}
		}

		// ----------- Search Diagonally to Left ---------------//
		int counterWinnerDL = 0;
		for (int i = 0, j = gameBoardMini.length - 1; i < gameBoardMini.length && j >= 0; i++, j--) {
			if (gameBoardMini[i][j].equals(playerType)) {
				counterWinnerDL = counterWinnerDL + 1;
				if (counterWinnerDL == 3) {
					return true;
				}
			} else {
				break;
			}
		}
		return false;
	}

	public boolean isBoardFull(){
		int counter = 0;
		for (int i = 0; i < turnsBoardMini.length ; i++) {
			for (int j = 0; j < turnsBoardMini[i].length; j++){
				if(turnsBoardMini[i][j] == true){
					counter++;
				}
			}
		}
		if(counter == 9){
			return  true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {

		BoardMini x = new BoardMini();

		boolean y = x.gameOver('o');
		System.out.println("test" + y);

	}
}
