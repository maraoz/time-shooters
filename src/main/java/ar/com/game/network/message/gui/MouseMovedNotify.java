package ar.com.game.network.message.gui;

import ar.com.game.backend.domain.Position;
import ar.com.game.network.BaseMessage;

public class MouseMovedNotify extends BaseMessage {
	private final Position pos;

	public MouseMovedNotify(Position pos) {
		super();
		this.pos = pos;
	}

	public Position getPosition() {
		return pos;
	}

}
