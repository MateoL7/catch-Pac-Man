package threads;

import java.io.IOException;

import javax.swing.JOptionPane;

import model.PacMan;
import userInterface.PacManController;

public class PacManThread extends Thread {
	PacManController pc;
	PacMan p;
	//private boolean moving; 
	
	public PacManThread(PacManController opc, PacMan op) {
		pc = opc;
		p = op;
		//moving = true;

	}
	
	public void run() {
		while(true) {
			p.movePacMan(pc.getWidth(), pc.getHeight());
			try {
				sleep(50);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
