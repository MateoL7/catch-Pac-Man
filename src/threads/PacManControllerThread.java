package threads;


import javafx.application.Platform;
import userInterface.PacManController;

public class PacManControllerThread extends Thread {

	PacManController pc;
	
	public PacManControllerThread(PacManController opc) {
		pc = opc;

	}
	public void run() {
		while (true) {
			ControllerUpdateRunnable cur = new ControllerUpdateRunnable(pc);
			Platform.runLater(cur);

			try {
				sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
