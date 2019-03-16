package userInterface;

import javafx.fxml.FXML;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

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
		return stage.getWidth();
	}
	public double getHeight() {
		return stage.getHeight();
	}
	
	@FXML
	void initialize(){
		pacManList = new ArrayList<PacMan>();
		arcs = new ArrayList<Arc>();
	}
	/*public void loadLevelFile(String path, String sep) throws IOException {
		File f = new File(path);
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);
		
		String line = br.readLine();
		while(line != null) {
			String[] info = line.split(sep);
			if(info[0].charAt(0) != '#') { 
				if(info[0].equalsIgnoreCase("0") || info[0].equalsIgnoreCase("1") || info[0].equalsIgnoreCase("2")) {
					String level = info[0];
				}
			double rad = Double.parseDouble (info[0]);
			double posX = Double.parseDouble (info[1]);
			double posY = Double.parseDouble (info[2]);
			Direction ori = Direction.valueOf(info[3]); 

			PacMan p = new PacMan(rad, posX, posY, ori, false);
			pacs.add(p);
			}
			
			line = br.readLine();
		}
		br.close();
		fr.close();
	}*/ 
	public String getLevel0(String path) throws IOException {
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
		
		String msg = sep;
		PrintWriter pw = new PrintWriter(path);
		//pw.print(msg += "HOLAAAAAAA");
		pw.close();
		br.close();
		fr.close();
		return msg;
	}

}