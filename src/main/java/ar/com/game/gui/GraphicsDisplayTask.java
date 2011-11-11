package ar.com.game.gui;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

import ar.com.game.network.dispatch.MessageHub;
import ar.com.game.network.message.gui.CloseNotify;

public class GraphicsDisplayTask implements Runnable {

	public void run() {
		try {
			Display.setDisplayMode(new DisplayMode(800, 600));
			Display.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
		}

		while (!Display.isCloseRequested()) {
			int x = Mouse.getX();
			int y = Mouse.getY();
			//System.out.println(x+" "+y);
			Display.update();
		}
		
		MessageHub.route(new CloseNotify());
		Display.destroy();

	}

}
