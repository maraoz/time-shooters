package ar.com.game.handler.gui;

import ar.com.game.handler.base.BaseClientHandler;
import ar.com.game.network.dispatch.MessageListener;
import ar.com.game.network.message.gui.MoveKeyNotify;
import ar.com.game.network.message.move.PlayerMoveRequest;

public class ClientMoveKeyNotifyHandler extends BaseClientHandler implements
		MessageListener<MoveKeyNotify> {

	private static final ClientMoveKeyNotifyHandler INSTANCE = new ClientMoveKeyNotifyHandler();

	private ClientMoveKeyNotifyHandler() {
	}

	public static ClientMoveKeyNotifyHandler get() {
		return INSTANCE;
	}

	public void handle(MoveKeyNotify message) {
		send(new PlayerMoveRequest(message.getPosition()));
	}

}
