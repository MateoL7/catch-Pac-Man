package model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class PacMan implements Serializable {
	

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
				if (radius+(x+=10) >= width) {
					orientation = Direction.LEFT;
				}
				else {
					x = x+5;
				}
				break;
			case LEFT:
				if ((x-=10)-radius <= (x-x)) {
					orientation = Direction.RIGHT;
				}
				else {
					x = x-10;
				}
				break;
			case UP:
				if ((y-=10)-radius <= (y-y)) {
					orientation = Direction.DOWN;
				}
				else {
					y = y-10;
				}
				break;
			case DOWN:
				if (radius+(y+=10)>= height) {
					orientation = Direction.UP;
				}
				else {
					y = y+10;
				}
				break;
		}

	}
}