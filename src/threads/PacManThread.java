package threads;

import javax.swing.JOptionPane;

import model.PacMan;
import userInterface.PacManController;

public class PacManThread extends Thread {
	PacManController pc;
	PacMan p;
	
	public PacManThread(PacManController opc) {
		pc = opc;

	}
	
	public void run() {
		//double w = pc.getWidth();
		//double h = pc.getHeight();
		while(true) {
			//p.movePacMan(w, h);
			pc.updateGame();
			try {
				sleep(10);
			} catch(InterruptedException e) {
				JOptionPane.showMessageDialog(null, "The sleep has been interrupted");
			}
		}
	}
	
}
