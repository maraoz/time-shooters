package ar.com.game.backend.tasks;

public class SynchedTask {

	protected void waitFPS() {
		try {
			Thread.sleep(1000/60);
		} catch (InterruptedException e) {
		}
	}

}