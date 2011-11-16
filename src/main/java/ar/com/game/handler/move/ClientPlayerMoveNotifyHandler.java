package ar.com.game.handler.move;

import ar.com.game.backend.client.ClientBackend;
import ar.com.game.backend.domain.Position;
import ar.com.game.handler.base.BaseClientHandler;
import ar.com.game.network.dispatch.MessageListener;
import ar.com.game.network.message.move.PlayerMoveNotify;

public class ClientPlayerMoveNotifyHandler extends BaseClientHandler implements
		MessageListener<PlayerMoveNotify> {

	private static final ClientPlayerMoveNotifyHandler INSTANCE = new ClientPlayerMoveNotifyHandler();

	private ClientPlayerMoveNotifyHandler() {
	}

	public static ClientPlayerMoveNotifyHandler get() {
		return INSTANCE;
	}

	public void handle(PlayerMoveNotify message) {
		Long who = message.getWho();
		Position where = message.getWhere();
		
		ClientBackend.movePlayer(who, where);
	}

}
