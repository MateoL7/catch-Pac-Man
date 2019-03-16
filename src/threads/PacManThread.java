package threads;

import javax.swing.JOptionPane;

import model.PacMan;
import userInterface.PacManController;

public class PacManThread extends Thread {
	PacManController pc;
	PacMan p;
	
	public PacManThread(PacManController opc, PacMan p1) {
		pc = opc;
		p = p1;
	}
	
	public void run() {
		double w = pc.getWidth();
		double h = pc.getHeight();
		while(p.getStp() != true) {
			p.movePacMan(w, h);
			try {
				sleep(10);
			} catch(InterruptedException e) {
				JOptionPane.showMessageDialog(null, "The sleep has been interrupted");
			}
		}
	}
	
}
