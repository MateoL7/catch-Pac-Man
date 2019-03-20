package threads;


import userInterface.PacManController;

public class PacManControllerThread extends Thread {

	PacManController pc;
	
	public PacManControllerThread(PacManController opc) {
		pc = opc;

	}
	public void run() {
		while(true) {
			pc.updateGame();
			try {
				sleep(10);
			} catch(InterruptedException e) {
				System.out.println("The sleep has been interrupted");
			}
		}
	}
}
