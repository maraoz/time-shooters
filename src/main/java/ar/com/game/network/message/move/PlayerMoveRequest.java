package ar.com.game.network.message.move;

import ar.com.game.backend.domain.Position;
import ar.com.game.network.BaseMessage;

public class PlayerMoveRequest extends BaseMessage {

	private final Position pos;

	public PlayerMoveRequest(Position pos) {
		super();
		this.pos = pos;
	}

	public Position getPosition() {
		return pos;
	}

}
