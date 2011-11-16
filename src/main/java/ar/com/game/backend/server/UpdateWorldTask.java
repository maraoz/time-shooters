package ar.com.game.backend.server;

import ar.com.game.backend.SynchedTask;



public class UpdateWorldTask extends SynchedTask implements Runnable {

	public void run() {
		while (true) {
			ServerBackend.update();
			waitFPS();
		}

	}

}
