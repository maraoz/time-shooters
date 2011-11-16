package ar.com.game.backend.domain;

public class Bullet implements Updatable {

	private static final int VELOCITY = 5;
	
	private Vector2D pos;
	private final Vector2D speed;
	
	public Bullet(Vector2D pos, Vector2D target) {
		super();
		this.pos = pos;
		this.speed = pos.directionTo(target).times(VELOCITY);
	}
	public Vector2D getPos() {
		return pos;
	}
	public Vector2D getSpeed() {
		return speed;
	} 
	
	public void update() {
		this.pos = this.pos.plus(speed);
	}
	
	
	
	
}
