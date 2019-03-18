package threads;

import java.io.IOException;

import javax.swing.JOptionPane;

import model.PacMan;
import userInterface.PacManController;

public class PacManThread extends Thread {
	PacManController pc;
	//PacMan p;
	//private boolean moving; 
	
	public PacManThread(PacManController opc) {
		pc = opc;
		//p = op;
		//moving = true;

	}
	
	public void run() {
		while(true) {
			try {
				pc.loadGame(pc.chooseLevel());
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			pc.updateGame();
			try {
				sleep(10);
			} catch(InterruptedException e) {
				JOptionPane.showMessageDialog(null, "The sleep has been interrupted");
			}
		}
	}
	
}
