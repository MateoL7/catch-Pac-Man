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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
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
	private MenuItem lastGame;

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
		return 1900;
	}

	public double getHeight() {
		return 900;
	}

	@FXML
	public void initialize() {
		pacManList = new ArrayList<PacMan>();
		arcs = new ArrayList<Arc>();

	}

	@FXML
	public void exitGame(ActionEvent event) {
		stage.close();
	}

	@FXML
	public void getSavedGame(ActionEvent event) {
		field.getChildren().clear();
		String level = "data/savedGame.txt";
		PacManControllerThread pct = new PacManControllerThread(this);
		try {
			loadGame(level);
		} catch (IOException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < pacManList.size(); i++) {
			PacManThread pt = new PacManThread(this, pacManList.get(i));
			// pacManList.get(i).setStp(false);
			pt.setDaemon(true);
			pt.start();
		}
		pct.setDaemon(true);
		pct.start();
	}

	@FXML
	public void getLevel0(ActionEvent event) {
		field.getChildren().clear();
		String level = "data/level0.txt";
		PacManControllerThread pct = new PacManControllerThread(this);
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
		pct.setDaemon(true);
		pct.start();
	}

	@FXML
	public void getLevel1(ActionEvent event) {
		field.getChildren().clear();
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
		field.getChildren().clear();
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
		//int lvl;
		String line = br.readLine();
		String sep = "\t";
		while (line != null) {
			String[] info = line.split(sep);
			if (info[0].charAt(0) != '#') {
				if (info.length == 1) {
					//lvl = Integer.parseInt(info[0]);
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
			
			actualArc.setCenterY(actualPacMan.getY());
		}
	}

	@FXML
	public void saveGame(ActionEvent event) {
		double radius;
		double x;
		double y;
		Direction d;
		boolean stp;

		try {
			File f = new File("data/savedGame.txt");
			FileWriter fw = new FileWriter(f);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			pw.write("#Last\tgame\tinfo:\n#radius posX posY orientation stopped\n");
			for (int i = 0; i < pacManList.size(); i++) {
				PacMan actual = pacManList.get(i);
				actual.setStp(true);
				radius = actual.getRadius();
				x = actual.getX();
				y = actual.getY();
				d = actual.getOrientation();
				stp = actual.getStp();
				pw.write(radius + "\t" + x + "\t" + y + "\t" + 10 + "\t" + d + "\t" + stp + "\t");
				pw.append("\n");
			}
			pw.close();
			bw.close();
			JOptionPane.showMessageDialog(null, "GAME HAS BEEN SAVED!");
			field.getChildren().clear();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("Cannot find file");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		try {
			ObjectOutputStream ois = new ObjectOutputStream(new FileOutputStream(new File("data/serealizedGame.txt")));
			ois.writeObject(pacManList);
			ois.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	@FXML
   public void stopPacMan(MouseEvent event) {
		double x = event.getX();
		double y = event.getY();
		for(int i = 0; i < pacManList.size(); i++) {
			PacMan actual = pacManList.get(i);
			double aX = actual.getX();
			double aY = actual.getY();
			double aR = actual.getRadius();
			if(x > (aX - aR) && x < (aX + aR) && y > (aY - aR) && y < (aY + aR)) {
				actual.setStp(true);
			}
		}
	}

	@FXML
	public void showScores(ActionEvent event) {
		JOptionPane.showMessageDialog(null, "You are the best player!\nStill working on it, sorry.");
	}
}