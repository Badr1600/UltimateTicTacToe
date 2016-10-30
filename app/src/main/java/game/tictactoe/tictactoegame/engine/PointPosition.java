/**
 * 
 */
package game.tictactoe.tictactoegame.engine;

/**
 * @author Ahmed Badr
 *
 */
public class PointPosition {

	private int pointX;
	private int pointY;

	public PointPosition() {
		this.pointX = 0;
		this.pointY = 0;
	}

	public PointPosition(int pointX, int pointY) {
		this.setPointX(pointX);
		this.setPointY(pointY);
	}

	/**
	 * @param pointX
	 *            the pointX to set
	 */
	public void setPointX(int pointX) {
		this.pointX = pointX;
	}

	/**
	 * @param pointY
	 *            the pointY to set
	 */
	public void setPointY(int pointY) {
		this.pointY = pointY;
	}

	/**
	 * @return the pointX
	 */
	public int getPointX() {
		return pointX;
	}

	/**
	 * @return the pointY
	 */
	public int getPointY() {
		return pointY;
	}

}
