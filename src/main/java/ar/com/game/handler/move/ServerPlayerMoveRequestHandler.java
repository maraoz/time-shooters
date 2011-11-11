package ar.com.game.handler.move;

import ar.com.game.handler.base.BaseServerHandler;
import ar.com.game.network.dispatch.MessageListener;
import ar.com.game.network.message.move.PlayerMoveNotify;
import ar.com.game.network.message.move.PlayerMoveRequest;

public class ServerPlayerMoveRequestHandler extends BaseServerHandler implements
		MessageListener<PlayerMoveRequest> {

	private static final ServerPlayerMoveRequestHandler INSTANCE = new ServerPlayerMoveRequestHandler();

	public static ServerPlayerMoveRequestHandler get() {
		return INSTANCE;
	}

	private ServerPlayerMoveRequestHandler() {
	}

	public void handle(PlayerMoveRequest message) {
		Long sessionId = getClient(message.getChannel());
		sendToAll(new PlayerMoveNotify(sessionId, message.getPosition()));
	}

}
