package ar.com.game.gui;

import org.lwjgl.LWJGLException;
import org.lwjgl.Sys;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

import ar.com.game.backend.client.ClientBackend;
import ar.com.game.backend.domain.Position;
import ar.com.game.network.dispatch.MessageHub;
import ar.com.game.network.message.gui.CloseNotify;
import ar.com.game.network.message.gui.MouseMovedNotify;

public class GraphicsDisplayTask implements Runnable {

	private static final int MOUSE_NETWORK_RESOLUTION = 4;
	private static final int PLAYER_SIZE = 10;

	public void run() {
		try {
			Display.setDisplayMode(new DisplayMode(800, 600));
			Display.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
		}

		initGL(); // init OpenGL
		getDelta(); // call once before loop to initialise lastFrame
		lastFPS = getTime(); // call before loop to initialise fps timer

		int frame = 0;
		while (!Display.isCloseRequested()) {


			update(getDelta());
			renderGL();


			int x = Mouse.getX();
			int y = Mouse.getY();
			if (frame % MOUSE_NETWORK_RESOLUTION == 0) {
				MessageHub.route(new MouseMovedNotify(new Position(x, y)));
			}
			frame++;
			Display.update();
			Display.sync(60); // cap fps to 60fps
		}

		MessageHub.route(new CloseNotify());
		Display.destroy();

	}

	/** angle of quad rotation */
	float rotation = 0;

	/** time at last frame */
	long lastFrame;

	/** frames per second */
	int fps;
	/** last fps time */
	long lastFPS;

	public void update(int delta) {
		// rotate quad
		rotation += 0.15f * delta;

		updateFPS(); // update FPS Counter
	}

	/**
	 * Calculate how many milliseconds have passed since last frame.
	 * 
	 * @return milliseconds passed since last frame
	 */
	public int getDelta() {
		long time = getTime();
		int delta = (int) (time - lastFrame);
		lastFrame = time;

		return delta;
	}

	/**
	 * Get the accurate system time
	 * 
	 * @return The system time in milliseconds
	 */
	public long getTime() {
		return (Sys.getTime() * 1000) / Sys.getTimerResolution();
	}

	/**
	 * Calculate the FPS and set it in the title bar
	 */
	public void updateFPS() {
		if (getTime() - lastFPS > 1000) {
			Display.setTitle("FPS: " + fps);
			fps = 0;
			lastFPS += 1000;
		}
		fps++;
	}

	public void initGL() {
		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity();
		GL11.glOrtho(0, 800, 600, 0, 1, -1);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
	}

	public void renderGL() {
		// Clear The Screen And The Depth Buffer
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);

		// R,G,B,A Set The Color To Blue One Time Only
		GL11.glColor3f(0.5f, 0.5f, 1.0f);

		// draw quads
		for (Position p : ClientBackend.getPositions()) {
			int x = p.getX();
			int y = Display.getHeight() - p.getY();
			
			GL11.glPushMatrix();
			GL11.glTranslatef(x, y, 0);
			GL11.glRotatef(rotation, 0f, 0f, 1f);
			GL11.glTranslatef(-x, -y, 0);
			
			GL11.glBegin(GL11.GL_QUADS);
			GL11.glVertex2f(x - PLAYER_SIZE, y - PLAYER_SIZE);
			GL11.glVertex2f(x + PLAYER_SIZE, y - PLAYER_SIZE);
			GL11.glVertex2f(x + PLAYER_SIZE, y + PLAYER_SIZE);
			GL11.glVertex2f(x - PLAYER_SIZE, y + PLAYER_SIZE);
			GL11.glEnd();
			GL11.glPopMatrix();
		}
	}

}
