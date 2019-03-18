package model;

public class PacMan {
	public enum Direction {
		RIGHT, LEFT, UP, DOWN
	};

	private double radius;
	private Direction orientation;
	private double x;
	private double y;
	private boolean stp;

	public PacMan(double pRadius, double pX, double pY, Direction pOrientation, boolean pStp) {
		radius = pRadius;
		x = pX;
		y = pY;
		orientation = pOrientation;
		stp = pStp;
	}

	public Direction getOrientation() {
		return orientation;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getRadius() {
		return radius;
	}

	public boolean getStp() {
		return stp;
	}

	public void setStp(boolean stp) {
		this.stp = stp;
	}

	public void setOrientation(Direction pOrien) {
		orientation = pOrien;
	}

	public void setX(double pX) {
		x = pX;
	}

	public void setY(double pY) {
		x = pY;
	}

	public void setRadius(double pR) {
		radius = pR;
	}

	public void movePacMan(double width, double height) {
		while (stp != true) {
			switch (orientation) {
			case RIGHT:
				x = x + 5;
				if (x >= width) {
					orientation = Direction.LEFT;
				}
				break;
			case LEFT:
				x = x - 5;
				if (x <= 0) {
					orientation = Direction.LEFT;
				}
				break;
			case UP:
				y = y - 5;
				if (y <= 0) {
					orientation = Direction.DOWN;
				}
			case DOWN:
				y = y + 5;
				if (y >= height) {
					orientation = Direction.UP;
				}
			}
		}

	}
}