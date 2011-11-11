package ar.com.game.network.message.move;

import ar.com.game.backend.domain.Position;
import ar.com.game.network.BaseMessage;

public class PlayerMoveNotify extends BaseMessage {

	private final Long who;
	private final Position where;

	public PlayerMoveNotify(Long who, Position where) {
		super();
		this.who = who;
		this.where = where;
	}

	public Long getWho() {
		return who;
	}

	public Position getWhere() {
		return where;
	}

}
