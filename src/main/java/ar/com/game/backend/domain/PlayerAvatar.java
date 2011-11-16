package ar.com.game.backend.domain;

public class PlayerAvatar extends GameObject {

	private Vector2D position;
	private Double hitPoints;

	public PlayerAvatar(Vector2D position, Double hitPoints, Long session) {
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

	public void reduceHP() {
		this.hitPoints -= 10;
		System.out.println(this.getId() + ": " + hitPoints);
	}

}
