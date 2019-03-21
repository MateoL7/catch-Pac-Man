package model;


import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Test;

import javafx.scene.layout.Pane;
import model.Direction;

public class PacManTest {

	private PacMan pac;
	private Pane pn;

	private void setupScenary1() {
	}

	private void setupScenary2() {
		double radius = 50.0;
		double x = 100.0;
		double y = 100.0;
		Direction orientation = Direction.RIGHT;
		boolean stp = false;
		pac = new PacMan(radius, x, y, orientation, stp);
		pn = new Pane();
		pn.setLayoutX(500.0);
		pn.setLayoutY(500.0);
	}

	@Test
	void testPacMan() {
		setupScenary1();
		double radius = 50.0;
		double x = 100.0;
		double y = 100.0;
		Direction orientation = Direction.RIGHT;
		boolean stp = false;
		PacMan pm;

		pm = new PacMan(radius, x, y, orientation, stp);
		assertNotNull("The PacMan is null", pm);
		assertTrue("The get for the attribute is not correct", pm.getRadius() == 50.0);
		assertTrue("The get for the attribute is not correct", pm.getX() == 100.0);
		assertTrue("The get for the attribute is not correct",pm.getY() == 100.0);
		assertTrue("The get for the attribute is not correct",pm.getOrientation() == Direction.RIGHT);
		assertTrue("The get for the attribute is not correct",pm.getStp() == false);
		
	}

	@Test
	void testMovePacMan() {
		setupScenary2();
		boolean works = false;
		pac.movePacMan(pn.getWidth(), pn.getHeight());
		if (pac.getX() >= pn.getWidth()) {
			pac.setOrientation(Direction.LEFT);
			if (pac.getOrientation().equals(Direction.LEFT)) {
				works = true;
			}
		}
		else if(pac.getY() >= pn.getHeight()) {
			pac.setOrientation(Direction.UP);
			if (pac.getOrientation().equals(Direction.UP)) {
				works = true;
			}
		}
		assertTrue("The position is not correct", works);
	}

	public PacMan getPac() {
		return pac;
	}

	public void setPac(PacMan p) {
		this.pac = p;
	}

}