package userInterface;

import javafx.fxml.FXML;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Arc;
import javafx.stage.Stage;
import model.PacMan;
import model.Direction;
import threads.PacManThread;

public class PacManController {

	private Stage stage;

	private List<PacMan> pacManList;
    
	private List<Arc> arcs ;
	
	private PacMan p1;
	
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
		return field.getWidth();
	}
	public double getHeight() {
		return field.getHeight();
	}
	
	@FXML
	void initialize(){
		pacManList = new ArrayList<PacMan>();
		arcs = new ArrayList<Arc>();
		PacManThread pt = new PacManThread(this);
		pt.setDaemon(true);
		pt.start();
	}
	
	public String chooseLevel() {
		String msg = "C:\\Users\\thetr\\Documents\\Segundo Semestre\\APO II\\ECLIPSE\\Workspace\\catch-Pac-Man\\src\\data\\level0.txt";
		if(loadMenu.getOnAction() == lvl0) {
			msg = "C:\\Users\\thetr\\Documents\\Segundo Semestre\\APO II\\ECLIPSE\\Workspace\\catch-Pac-Man\\src\\data\\level0.txt";
		}
		else if(loadMenu.getOnAction() == lvl1) {
			msg = "C:\\Users\\thetr\\Documents\\Segundo Semestre\\APO II\\ECLIPSE\\Workspace\\catch-Pac-Man\\src\\data\\level1.txt";
		}
		else if(loadMenu.getOnAction() == lvl2) {
			msg = "C:\\Users\\thetr\\Documents\\Segundo Semestre\\APO II\\ECLIPSE\\Workspace\\catch-Pac-Man\\src\\data\\level2.txt";
		}
		return msg;
	}
	
	public void loadGame(String level) throws IOException {
		File n = new File("C:\\Users\\thetr\\Documents\\Segundo Semestre\\APO II\\ECLIPSE\\Workspace\\catch-Pac-Man\\src\\data\\level0.txt");
		FileReader fr = new FileReader(n);
		BufferedReader br = new BufferedReader(fr);
		
		String line = br.readLine();
		String sep = "\t";
		double extra = Math.random();
		while(line != null) {
			String[] info = line.split(sep);
			if(info[0].charAt(0) != '#') {
				if(info.length == 1) {
					int lvl= Integer.parseInt(info[0]);
				}
				else {
					double rad = Double.parseDouble (info[0]);
					double posX = Double.parseDouble (info[1]);
					double posY = Double.parseDouble (info[2]);
					Direction ori = Direction.valueOf(info[4]); 
					Boolean stp = Boolean.valueOf(info[5]);
					
					PacMan pac1 = new PacMan(rad, posX, posY, ori, stp);
					Arc arc1 = new Arc(posX, posY, rad, rad, extra, extra);
					try {
					pacManList.add(pac1);
					arcs.add(arc1);
					}catch(NullPointerException e) {
					JOptionPane.showMessageDialog(null, "An object is null");}
				}
				
			}
			

			line = br.readLine();
		}
		br.close();
		fr.close();
	}	
	public void updateGame() {
		Arc ar = new Arc();
		//double extra = (Math.random()*200.0) + 100.0;
		for(int i = 0; i < pacManList.size() && i < arcs.size(); i++) {
			
			if(pacManList.get(i) != null && arcs.get(i) != null) {
				
				arcs.get(i).setRadiusX(pacManList.get(i).getRadius());
				
				arcs.get(i).setRadiusY(pacManList.get(i).getRadius());
				
				//arcs.get(i).setCenterX(pacManList.get(i).getX());
				//arcs.get(i).setCenterY(pacManList.get(i).getY());
				//arcs.get(i).setStartAngle(20.0);
				
				ar = arcs.get(i);
				
				field.getChildren().add(ar);
				ar.setVisible(true);
				
				pacManList.get(i).movePacMan(this.getWidth(), this.getHeight());
				
				ar.setLayoutX(pacManList.get(i).getX());
				
				ar.setLayoutY(pacManList.get(i).getY());
				
			}
		}
	}
	public List<PacMan> getPacList(){
		return pacManList;
	}	

}