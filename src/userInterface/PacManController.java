package userInterface;

import javafx.fxml.FXML;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import javafx.scene.control.MenuBar;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Arc;
import javafx.stage.Stage;
import model.PacMan;
import model.PacMan.Direction;

public class PacManController {

	private Stage stage;

	private List<PacMan> pacManList;
    
	private List<Arc> arcs ;
	
	private PacMan p1;
	
    @FXML
    private MenuBar menu;

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
	}

	public void getLevel0(String path) throws IOException {
		File n = new File(path);
		FileReader fr = new FileReader(n);
		BufferedReader br = new BufferedReader(fr);
		
		String line = br.readLine();
		String sep = "\t";
		double extra = Math.random();
		while(line != null) {
			String[] info = line.split(sep);
			if(info[0].charAt(0) != '#') {
				if(info.length == 1) {
					int level = Integer.parseInt(info[0]);
				}
				else {
					double rad = Double.parseDouble (info[0]);
					double posX = Double.parseDouble (info[1]);
					double posY = Double.parseDouble (info[2]);
					Direction ori = Direction.valueOf(info[4]); 
					Boolean stp = Boolean.valueOf(info[5]);
					
					PacMan pac1 = new PacMan(rad, posX, posY, ori, stp);
					Arc arc1 = new Arc(posX, posY, rad, rad, extra, extra);
					//try {
					pacManList.add(pac1);
					arcs.add(arc1);
					//}catch(NullPointerException e) {
					//	JOptionPane.showMessageDialog(null, "An object is null");}
				}
				
			}
			

			line = br.readLine();
		}
		br.close();
		fr.close();
	}
	
	/*public void getLevel1(String path) throws IOException {
		File n = new File(path);
		FileReader fr = new FileReader(n);
		BufferedReader br = new BufferedReader(fr);
		
		String line = br.readLine();
		String sep = "\t";
		while(line != null) {
			String[] info = line.split(sep);
			if(info[0].charAt(0) != '#') {
				if(info.length == 1) {
					int level = Integer.parseInt(info[0]);
				}
				else {
					double rad = Double.parseDouble (info[0]);
					double posX = Double.parseDouble (info[1]);
					double posY = Double.parseDouble (info[2]);
					Direction ori = Direction.valueOf(info[4]); 
					Boolean stp = Boolean.valueOf(info[5]);
					
					PacMan pac1 = new PacMan(rad, posX, posY, ori, stp);
					pacManList.add(pac1);
				}
				
			}
			

			line = br.readLine();
		}
		br.close();
		fr.close();
	}*/
	
	public void updateGame() {
		//double extra = (Math.random()*200.0) + 100.0;
		for(int i = 0; i < pacManList.size() && i < arcs.size(); i++) {
			if(pacManList.get(i) != null && arcs.get(i) != null) {
				arcs.get(i).setRadiusX(pacManList.get(i).getRadius());
				arcs.get(i).setRadiusY(pacManList.get(i).getRadius());
				field.getChildren().add(arcs.get(i));
				pacManList.get(i).movePacMan(this.getWidth(), this.getHeight());
				arcs.get(i).setLayoutX(pacManList.get(i).getX());
				arcs.get(i).setLayoutY(pacManList.get(i).getY());
			}
		}
	}
	public List<PacMan> getPacList(){
		return pacManList;
	}	

}