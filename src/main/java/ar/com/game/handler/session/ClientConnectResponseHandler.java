package ar.com.game.handler.session;

import ar.com.game.handler.base.BaseClientHandler;
import ar.com.game.network.dispatch.MessageListener;
import ar.com.game.network.message.session.ConnectResponse;

public class ClientConnectResponseHandler extends BaseClientHandler implements
		MessageListener<ConnectResponse> {

	private static final ClientConnectResponseHandler INSTANCE = new ClientConnectResponseHandler();

	private ClientConnectResponseHandler() {
	}

	public static ClientConnectResponseHandler get() {
		return INSTANCE;
	}

	public void handle(ConnectResponse message) {
		System.out.println("Connected to server, session id: "
				+ message.getYourSession());
		setChannel(message.getChannel());
		setSession(message.getYourSession());
	}

}
