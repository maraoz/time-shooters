package ar.com.game.backend.domain;

public class PlayerAvatar {

	private Vector2D position;
	private Double hitPoints;
	
	public PlayerAvatar(Vector2D position, Double hitPoints) {
		super();
		this.position = position;
		this.hitPoints = hitPoints;
	}
	
	public Vector2D getPosition() {
		return position;
	}
	public void setPosition(Vector2D position) {
		this.position = position;
	}
	public Double getHitPoints() {
		return hitPoints;
	}
	public void setHitPoints(Double hitPoints) {
		this.hitPoints = hitPoints;
	}
	
}
