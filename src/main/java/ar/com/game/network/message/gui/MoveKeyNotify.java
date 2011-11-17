package ar.com.game.network.message.gui;

import ar.com.game.backend.domain.Position;
import ar.com.game.network.BaseMessage;

public class MoveKeyNotify extends BaseMessage {
	private final Position pos;

	public MoveKeyNotify(Position pos) {
		super();
		this.pos = pos;
	}

	public Position getPosition() {
		return pos;
	}

}
