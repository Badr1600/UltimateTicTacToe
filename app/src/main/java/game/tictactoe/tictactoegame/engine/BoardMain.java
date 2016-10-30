/**
 * 
 */
package game.tictactoe.tictactoegame.engine;

import java.util.ArrayList;

/**
 * @author Ahmed Badr
 *
 */

public class BoardMain {

	private BoardMini[][] mainBoard;
	private boolean[][] turnsBoardMain;
	private ArrayList<Integer> nextMove;

	public BoardMain() {

		mainBoard = new BoardMini[3][3];
		turnsBoardMain = new boolean[3][3];
        nextMove = new ArrayList<Integer>();
		for (int i = 0; i < turnsBoardMain.length; i++) {
			for (int j = 0; j < turnsBoardMain[i].length; j++) {
				mainBoard[i][j] = new BoardMini();
				turnsBoardMain[i][j] = true;
			}
		}
	}

	public int[] playAction(PointPosition position, Character playerType, int miniBoardOrder) {
		int[] outputAction = new int[2];
		int pointX = position.getPointX();
		int pointY = position.getPointY();
		if (!(pointX < 3 && pointY < 3)) {
			outputAction[0] = 0;
			outputAction[1] = 0;
			return outputAction;
		}
        boolean output = false;
		if (isAllowedToPlay(position, miniBoardOrder)) {
			BoardMini miniBoard = getBoardMiniByID(miniBoardOrder);
            output = miniBoard.playAction(position, playerType);
			if (output) {
				outputAction[0] = 1;
				if (pointX == 0 && pointY == 0) {
                    if(getBoardMiniByID(1).isBoardFull()){
                        ArrayList<Integer> allowedBoards = new ArrayList<Integer>();
                        ArrayList<Integer> blockedBoards = new ArrayList<Integer>();
                        allowedBoards.add(0,1);
                        allowedBoards.add(1,2);
                        allowedBoards.add(2,3);
                        allowedBoards.add(3,4);
                        allowedBoards.add(4,5);
                        allowedBoards.add(5,6);
                        allowedBoards.add(6,7);
                        allowedBoards.add(7,8);
                        allowedBoards.add(8,9);
                        blockedBoards.add(0,1);
                        updateBoardsAvailability(blockedBoards, allowedBoards);
                        outputAction[1] = 10;
                    } else {
                        setNotAllowedBoard(1);
                        outputAction[1] = 1;
                    }
				}
				if (pointX == 0 && pointY == 1) {
                    if(getBoardMiniByID(2).isBoardFull()){
                        ArrayList<Integer> allowedBoards = new ArrayList<Integer>();
                        ArrayList<Integer> blockedBoards = new ArrayList<Integer>();
                        allowedBoards.add(0,1);
                        allowedBoards.add(1,2);
                        allowedBoards.add(2,3);
                        allowedBoards.add(3,4);
                        allowedBoards.add(4,5);
                        allowedBoards.add(5,6);
                        allowedBoards.add(6,7);
                        allowedBoards.add(7,8);
                        allowedBoards.add(8,9);
                        blockedBoards.add(0,2);
                        updateBoardsAvailability(blockedBoards,allowedBoards);
                        outputAction[1] = 10;
                    } else {
                        setNotAllowedBoard(2);
                        outputAction[1] = 2;
                    }
				}
				if (pointX == 0 && pointY == 2) {
                    if(getBoardMiniByID(3).isBoardFull()){
                        ArrayList<Integer> allowedBoards = new ArrayList<Integer>();
                        ArrayList<Integer> blockedBoards = new ArrayList<Integer>();
                        allowedBoards.add(0,1);
                        allowedBoards.add(1,2);
                        allowedBoards.add(2,3);
                        allowedBoards.add(3,4);
                        allowedBoards.add(4,5);
                        allowedBoards.add(5,6);
                        allowedBoards.add(6,7);
                        allowedBoards.add(7,8);
                        allowedBoards.add(8,9);
                        blockedBoards.add(0,3);
                        updateBoardsAvailability(blockedBoards,allowedBoards);
                        outputAction[1] = 10;
                    } else {
                        setNotAllowedBoard(3);
                        outputAction[1] = 3;
                    }
				}
				if (pointX == 1 && pointY == 0) {
                    if(getBoardMiniByID(4).isBoardFull()){
                        ArrayList<Integer> allowedBoards = new ArrayList<Integer>();
                        ArrayList<Integer> blockedBoards = new ArrayList<Integer>();
                        allowedBoards.add(0,1);
                        allowedBoards.add(1,2);
                        allowedBoards.add(2,3);
                        allowedBoards.add(3,4);
                        allowedBoards.add(4,5);
                        allowedBoards.add(5,6);
                        allowedBoards.add(6,7);
                        allowedBoards.add(7,8);
                        allowedBoards.add(8,9);
                        blockedBoards.add(0,4);
                        updateBoardsAvailability(blockedBoards,allowedBoards);
                        outputAction[1] = 10;
                    } else {
                        setNotAllowedBoard(4);
                        outputAction[1] = 4;
                    }
                }
				if (pointX == 1 && pointY == 1) {
                    if(getBoardMiniByID(5).isBoardFull()){
                        ArrayList<Integer> allowedBoards = new ArrayList<Integer>();
                        ArrayList<Integer> blockedBoards = new ArrayList<Integer>();
                        allowedBoards.add(0,1);
                        allowedBoards.add(1,2);
                        allowedBoards.add(2,3);
                        allowedBoards.add(3,4);
                        allowedBoards.add(4,5);
                        allowedBoards.add(5,6);
                        allowedBoards.add(6,7);
                        allowedBoards.add(7,8);
                        allowedBoards.add(8,9);
                        blockedBoards.add(0,5);
                        updateBoardsAvailability(blockedBoards,allowedBoards);
                        outputAction[1] = 10;
                    } else {
                        setNotAllowedBoard(5);
                        outputAction[1] = 5;
                    }
				}
				if (pointX == 1 && pointY == 2) {
                    if(getBoardMiniByID(6).isBoardFull()){
                        ArrayList<Integer> allowedBoards = new ArrayList<Integer>();
                        ArrayList<Integer> blockedBoards = new ArrayList<Integer>();
                        allowedBoards.add(0,1);
                        allowedBoards.add(1,2);
                        allowedBoards.add(2,3);
                        allowedBoards.add(3,4);
                        allowedBoards.add(4,5);
                        allowedBoards.add(5,6);
                        allowedBoards.add(6,7);
                        allowedBoards.add(7,8);
                        allowedBoards.add(8,9);
                        blockedBoards.add(0,6);
                        updateBoardsAvailability(blockedBoards,allowedBoards);
                        outputAction[1] = 10;
                    } else {
                        setNotAllowedBoard(6);
                        outputAction[1] = 6;
                    }
				}
				if (pointX == 2 && pointY == 0) {
                    if(getBoardMiniByID(7).isBoardFull()){
                        ArrayList<Integer> allowedBoards = new ArrayList<Integer>();
                        ArrayList<Integer> blockedBoards = new ArrayList<Integer>();
                        allowedBoards.add(0,1);
                        allowedBoards.add(1,2);
                        allowedBoards.add(2,3);
                        allowedBoards.add(3,4);
                        allowedBoards.add(4,5);
                        allowedBoards.add(5,6);
                        allowedBoards.add(6,7);
                        allowedBoards.add(7,8);
                        allowedBoards.add(8,9);
                        blockedBoards.add(0,7);
                        updateBoardsAvailability(blockedBoards,allowedBoards);
                        outputAction[1] = 10;
                    } else {
                        setNotAllowedBoard(7);
                        outputAction[1] = 7;
                    }
				}
				if (pointX == 2 && pointY == 1) {
                    if(getBoardMiniByID(8).isBoardFull()){
                        ArrayList<Integer> allowedBoards = new ArrayList<Integer>();
                        ArrayList<Integer> blockedBoards = new ArrayList<Integer>();
                        allowedBoards.add(0,1);
                        allowedBoards.add(1,2);
                        allowedBoards.add(2,3);
                        allowedBoards.add(3,4);
                        allowedBoards.add(4,5);
                        allowedBoards.add(5,6);
                        allowedBoards.add(6,7);
                        allowedBoards.add(7,8);
                        allowedBoards.add(8,9);
                        blockedBoards.add(0,8);
                        updateBoardsAvailability(blockedBoards,allowedBoards);
                        outputAction[1] = 10;
                    } else {
                        setNotAllowedBoard(8);
                        outputAction[1] = 8;
                    }
				}
				if (pointX == 2 && pointY == 2) {
                    if(getBoardMiniByID(9).isBoardFull()){
                        ArrayList<Integer> allowedBoards = new ArrayList<Integer>();
                        ArrayList<Integer> blockedBoards = new ArrayList<Integer>();
                        allowedBoards.add(0,1);
                        allowedBoards.add(1,2);
                        allowedBoards.add(2,3);
                        allowedBoards.add(3,4);
                        allowedBoards.add(4,5);
                        allowedBoards.add(5,6);
                        allowedBoards.add(6,7);
                        allowedBoards.add(7,8);
                        allowedBoards.add(8,9);
                        blockedBoards.add(0,9);
                        updateBoardsAvailability(blockedBoards,allowedBoards);
                        outputAction[1] = 10;
                    } else {
                        setNotAllowedBoard(9);
                        outputAction[1] = 9;
                    }
				}
			}
		}
		return outputAction;
	}

	public boolean isAllowedToPlay(PointPosition position, int miniBoardOrder) {
        BoardMini miniBoard = getBoardMiniByID(miniBoardOrder);
        if(!miniBoard.isAllowedToPlay(position)){
            System.out.println("Cell Position is Already Occupied in MiniBoard #" + miniBoardOrder);
            return false;
        }
        if(getTurnsBoardByID(miniBoardOrder) == false) {
                System.out.println("MiniBoard #" + miniBoardOrder + "is Blocked!!");
                return false;
        }
        if(miniBoard.isBoardFull()){
            setNotAllowedToPlay(miniBoardOrder);
            System.out.println("MiniBoard #" + miniBoardOrder + "is All Occupied");
        }
        return true;
    }

	/**
	 * @param playerType
	 * @return
	 */
	public boolean gameOver(Character playerType) {

		// ----------- Search Horizontally ---------------//
		for (int i = 0; i < mainBoard.length; i++) {
			int counterWinner = 0;
			for (int j = 0; j < mainBoard[i].length; j++) {
				if (mainBoard[i][j].gameOver(playerType)) {
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
		for (int i = 0; i < mainBoard.length; i++) {
			int counterWinner = 0;
			for (int j = 0; j < mainBoard[i].length; j++) {
				if (mainBoard[j][i].gameOver(playerType)) {
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
		for (int i = 0, j = 0; i < mainBoard.length && j < mainBoard.length; i++, j++) {
			if (mainBoard[i][j].equals(playerType)) {
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
		for (int i = 0, j = mainBoard.length - 1; i < mainBoard.length && j >= 0; i++, j--) {
			if (mainBoard[i][j].equals(playerType)) {
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

	public ArrayList<Integer> getAllowedBoardID() {
		ArrayList<Integer> boardNumbers = new ArrayList<Integer>();
		for (int i = 1; i < turnsBoardMain.length + 1; i++) {
			for (int j = 1; j < turnsBoardMain[i].length + 1; j++) {
				if (turnsBoardMain[i - 1][j - 1] == true) {
					boardNumbers.add(i * j);
				}
			}
		}
		return boardNumbers;
	}

	public ArrayList<Integer> getBlockedBoardID() {
		ArrayList<Integer> boardNumbers = new ArrayList<Integer>();
		for (int i = 1; i < turnsBoardMain.length + 1; i++) {
			for (int j = 1; j < turnsBoardMain[i].length + 1; j++) {
				if (turnsBoardMain[i - 1][j - 1] == false) {
					boardNumbers.add(i * j);
				}
			}
		}
		return boardNumbers;
	}

	/**
	 * Standard TicTacToe boards are numbered from 1:9 inside the main board of
	 * the game. The Functionality of the method is to get the board by knowing
	 * the number of its position.
	 * 
	 * @param boardNumber
	 * @return BoardMini
	 * 
	 */
	public BoardMini getBoardMiniByID(int boardNumber) {
		if (boardNumber > 9) {
			return null;
		}
		switch (boardNumber) {
		case 1:
			return mainBoard[0][0];
		case 2:
			return mainBoard[0][1];
		case 3:
			return mainBoard[0][2];
		case 4:
			return mainBoard[1][0];
		case 5:
			return mainBoard[1][1];
		case 6:
			return mainBoard[1][2];
		case 7:
			return mainBoard[2][0];
		case 8:
			return mainBoard[2][1];
		case 9:
			return mainBoard[2][2];
		default:
			break;
		}
		return null;
	}

	private boolean getTurnsBoardByID(int boardNumber) {
		if (boardNumber > 9) {
			return false;
		}
		switch (boardNumber) {
		case 1:
			return turnsBoardMain[0][0];
		case 2:
			return turnsBoardMain[0][1];
		case 3:
			return turnsBoardMain[0][2];
		case 4:
			return turnsBoardMain[1][0];
		case 5:
			return turnsBoardMain[1][1];
		case 6:
			return turnsBoardMain[1][2];
		case 7:
			return turnsBoardMain[2][0];
		case 8:
			return turnsBoardMain[2][1];
		case 9:
			return turnsBoardMain[2][2];
		default:
			break;
		}
		return false;
	}

	/**
	 * @param miniBoardOrder
	 * @return
	 */
	private boolean setNotAllowedToPlay(int miniBoardOrder) {
		switch (miniBoardOrder) {
		case 1:
			turnsBoardMain[0][0] = false;
			return true;
		case 2:
			turnsBoardMain[0][1] = false;
			return true;
		case 3:
			turnsBoardMain[0][2] = false;
			return true;
		case 4:
			turnsBoardMain[1][0] = false;
			return true;
		case 5:
			turnsBoardMain[1][1] = false;
			return true;
		case 6:
			turnsBoardMain[1][2] = false;
			return true;
		case 7:
			turnsBoardMain[2][0] = false;
			return true;
		case 8:
			turnsBoardMain[2][1] = false;
			return true;
		case 9:
			turnsBoardMain[2][2] = false;
			return true;
		default:
			break;
		}
		return false;
	}

    private boolean setAllowedToPlay(int miniBoardOrder) {
        switch (miniBoardOrder) {
            case 1:
                turnsBoardMain[0][0] = true;
                return true;
            case 2:
                turnsBoardMain[0][1] = true;
                return true;
            case 3:
                turnsBoardMain[0][2] = true;
                return true;
            case 4:
                turnsBoardMain[1][0] = true;
                return true;
            case 5:
                turnsBoardMain[1][1] = true;
                return true;
            case 6:
                turnsBoardMain[1][2] = true;
                return true;
            case 7:
                turnsBoardMain[2][0] = true;
                return true;
            case 8:
                turnsBoardMain[2][1] = true;
                return true;
            case 9:
                turnsBoardMain[2][2] = true;
                return true;
            default:
                break;
        }
        return false;
    }

    private void setNotAllowedBoard(int miniBoardOrder) {
        switch (miniBoardOrder) {
            case 1:
                turnsBoardMain[0][0] = true;
                turnsBoardMain[0][1] = false;
                turnsBoardMain[0][2] = false;
                turnsBoardMain[1][0] = false;
                turnsBoardMain[1][1] = false;
                turnsBoardMain[1][2] = false;
                turnsBoardMain[2][0] = false;
                turnsBoardMain[2][1] = false;
                turnsBoardMain[2][2] = false;
                break;
            case 2:
                turnsBoardMain[0][0] = false;
                turnsBoardMain[0][1] = true;
                turnsBoardMain[0][2] = false;
                turnsBoardMain[1][0] = false;
                turnsBoardMain[1][1] = false;
                turnsBoardMain[1][2] = false;
                turnsBoardMain[2][0] = false;
                turnsBoardMain[2][1] = false;
                turnsBoardMain[2][2] = false;
                break;
            case 3:
                turnsBoardMain[0][0] = false;
                turnsBoardMain[0][1] = false;
                turnsBoardMain[0][2] = true;
                turnsBoardMain[1][0] = false;
                turnsBoardMain[1][1] = false;
                turnsBoardMain[1][2] = false;
                turnsBoardMain[2][0] = false;
                turnsBoardMain[2][1] = false;
                turnsBoardMain[2][2] = false;
                break;
            case 4:
                turnsBoardMain[0][0] = false;
                turnsBoardMain[0][1] = false;
                turnsBoardMain[0][2] = false;
                turnsBoardMain[1][0] = true;
                turnsBoardMain[1][1] = false;
                turnsBoardMain[1][2] = false;
                turnsBoardMain[2][0] = false;
                turnsBoardMain[2][1] = false;
                turnsBoardMain[2][2] = false;
                break;
            case 5:
                turnsBoardMain[0][0] = false;
                turnsBoardMain[0][1] = false;
                turnsBoardMain[0][2] = false;
                turnsBoardMain[1][0] = false;
                turnsBoardMain[1][1] = true;
                turnsBoardMain[1][2] = false;
                turnsBoardMain[2][0] = false;
                turnsBoardMain[2][1] = false;
                turnsBoardMain[2][2] = false;
                break;
            case 6:
                turnsBoardMain[0][0] = false;
                turnsBoardMain[0][1] = false;
                turnsBoardMain[0][2] = false;
                turnsBoardMain[1][0] = false;
                turnsBoardMain[1][1] = false;
                turnsBoardMain[1][2] = true;
                turnsBoardMain[2][0] = false;
                turnsBoardMain[2][1] = false;
                turnsBoardMain[2][2] = false;
                break;
            case 7:
                turnsBoardMain[0][0] = false;
                turnsBoardMain[0][1] = false;
                turnsBoardMain[0][2] = false;
                turnsBoardMain[1][0] = false;
                turnsBoardMain[1][1] = false;
                turnsBoardMain[1][2] = false;
                turnsBoardMain[2][0] = true;
                turnsBoardMain[2][1] = false;
                turnsBoardMain[2][2] = false;
                break;
            case 8:
                turnsBoardMain[0][0] = false;
                turnsBoardMain[0][1] = false;
                turnsBoardMain[0][2] = false;
                turnsBoardMain[1][0] = false;
                turnsBoardMain[1][1] = false;
                turnsBoardMain[1][2] = false;
                turnsBoardMain[2][0] = false;
                turnsBoardMain[2][1] = true;
                turnsBoardMain[2][2] = false;
                break;
            case 9:
                turnsBoardMain[0][0] = false;
                turnsBoardMain[0][1] = false;
                turnsBoardMain[0][2] = false;
                turnsBoardMain[1][0] = false;
                turnsBoardMain[1][1] = false;
                turnsBoardMain[1][2] = false;
                turnsBoardMain[2][0] = false;
                turnsBoardMain[2][1] = false;
                turnsBoardMain[2][2] = true;
                break;
            default:
                break;
        }
    }

    public void updateBoardsAvailability(ArrayList<Integer> blockedBoards, ArrayList<Integer> allowedBoards){
        int boardNumber;
        for (int i = 0; i < blockedBoards.size() ; i++) {
            boardNumber = blockedBoards.get(i);
            setNotAllowedToPlay(boardNumber);
        }
        for (int i = 0; i < allowedBoards.size() ; i++) {
            boardNumber = allowedBoards.get(i);
            setAllowedToPlay(boardNumber);
        }
    }

}
