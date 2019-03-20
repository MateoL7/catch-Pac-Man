package threads;

import userInterface.PacManController;

public class ControllerUpdateRunnable implements Runnable{
	private PacManController pc;
	public ControllerUpdateRunnable(PacManController opc) {
		pc = opc;
	}
	
	@Override
	public void run() {
		pc.updateGame();
	}
}