package userInterface;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import model.PacMan;
import model.Direction;
import threads.PacManControllerThread;
import threads.PacManThread;

public class PacManController {

	private Stage stage;

	private List<PacMan> pacManList;

	private List<Arc> arcs;

	private PacMan p1;

	@FXML
	private BorderPane screen;

	@FXML
	private MenuBar menu;

	@FXML
	private Menu loadMenu;

	@FXML
	private MenuItem lvl0;

	@FXML
	private MenuItem lvl1;

	@FXML
	private MenuItem lvl2;

	@FXML
	private MenuItem saveMenu;

	@FXML
	private MenuItem exitMenu;

	@FXML
	private MenuItem scoresMenu;

	@FXML
	private Pane field;

	public void setStage(Stage pStage) {
		stage = pStage;

	}

	public double getWidth() {
		return field.getMaxWidth();
	}

	public double getHeight() {
		return field.getMaxHeight();
	}
	
	@FXML
	public void initialize() {
		pacManList = new ArrayList<PacMan>();
		arcs = new ArrayList<Arc>();

	}

	@FXML
	public void getLevel0(ActionEvent event) {
		String level = "data/level0.txt";
		try {
			loadGame(level);
		} catch (IOException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < pacManList.size(); i++) {
			PacManThread pt = new PacManThread(this, pacManList.get(i));
			pt.setDaemon(true);
			pt.start();
		}
		PacManControllerThread pct = new PacManControllerThread(this);
		pct.setDaemon(true);
		pct.start();
	}

	@FXML
	public void getLevel1(ActionEvent event) {
		String level = "data/level1.txt";
		try {
			loadGame(level);
		} catch (IOException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < pacManList.size(); i++) {
			PacManThread pt = new PacManThread(this, pacManList.get(i));
			pt.setDaemon(true);
			pt.start();
		}
		PacManControllerThread pct = new PacManControllerThread(this);
		pct.setDaemon(true);
		pct.start();
	}

	@FXML
	public void getLevel2(ActionEvent event) {
		String level = "data/level2.txt";
		try {
			loadGame(level);
		} catch (IOException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < pacManList.size(); i++) {
			PacManThread pt = new PacManThread(this, pacManList.get(i));
			pt.setDaemon(true);
			pt.start();
		}
		PacManControllerThread pct = new PacManControllerThread(this);
		pct.setDaemon(true);
		pct.start();
	}

	public void loadGame(String level) throws IOException {
		File n = new File(level);
		FileReader fr = new FileReader(n);
		BufferedReader br = new BufferedReader(fr);

		String line = br.readLine();
		String sep = "\t";
		double extra = Math.random();
		while (line != null) {
			String[] info = line.split(sep);
			if (info[0].charAt(0) != '#') {
				if (info.length == 1) {
					int lvl = Integer.parseInt(info[0]);
				} else {
					double rad = Double.parseDouble(info[0]);
					double posX = Double.parseDouble(info[1]);
					double posY = Double.parseDouble(info[2]);
					Direction ori = Direction.valueOf(info[4]);
					Boolean stp = Boolean.valueOf(info[5]);

					p1 = new PacMan(rad, posX, posY, ori, stp);
					Arc arc1 = new Arc(posX, posY, rad, rad, 45, 270);
					arc1.setFill(Color.YELLOW);
					arc1.setType(ArcType.ROUND);
					field.getChildren().add(arc1);
					try {
						pacManList.add(p1);
						arcs.add(arc1);
					} catch (NullPointerException e) {
						JOptionPane.showMessageDialog(null, "An object is null");
					}
				}

			}

			line = br.readLine();
		}
		br.close();
		fr.close();
	}

	public void updateGame() {
		Arc actualArc = new Arc();
		PacMan actualPacMan;
		for (int i = 0; i < pacManList.size() && i < arcs.size(); i++) {
			actualArc = arcs.get(i);
			actualPacMan = pacManList.get(i);

			actualArc.setLayoutX(actualPacMan.getX());

			actualArc.setLayoutY(actualPacMan.getY());
		}
	}

	public List<PacMan> getPacList() {
		return pacManList;
	}

}