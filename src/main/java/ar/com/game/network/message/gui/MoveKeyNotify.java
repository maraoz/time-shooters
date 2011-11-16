package ar.com.game.network.message.gui;

import ar.com.game.backend.domain.Vector2D;
import ar.com.game.network.BaseMessage;

public class MoveKeyNotify extends BaseMessage {
	private final Vector2D pos;

	public MoveKeyNotify(Vector2D pos) {
		super();
		this.pos = pos;
	}

	public Vector2D getPosition() {
		return pos;
	}

}
