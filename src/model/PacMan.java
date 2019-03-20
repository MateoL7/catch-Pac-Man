package model;

public class PacMan {
	

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
		switch (orientation) {
			case RIGHT:
				if ((x+=5) >= width) {
					orientation = Direction.LEFT;
				}
				else {
					x = x+5;
				}
				break;
			case LEFT:
				if ((x-=5) <= 0) {
					orientation = Direction.RIGHT;
				}
				else {
					x = x-5;
				}
				break;
			case UP:
				if ((y-=5) <= 0) {
					orientation = Direction.DOWN;
				}
				else {
					y = y-5;
				}
			case DOWN:
				if ((y+=5)>= height) {
					orientation = Direction.UP;
				}
				else {
					y = y+5;
				}
		}

	}
}