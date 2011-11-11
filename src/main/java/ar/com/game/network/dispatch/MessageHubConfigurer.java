package ar.com.game.network.dispatch;

import ar.com.game.handler.chat.ClientChatNotifyHandler;
import ar.com.game.handler.chat.ServerChatRequestHandler;
import ar.com.game.handler.gui.ClientLineTypedNotifyHandler;
import ar.com.game.handler.login.ClientConnectNotifyHandler;
import ar.com.game.handler.login.ClientConnectResponseHandler;
import ar.com.game.handler.login.ServerConnectRequestHandler;
import ar.com.game.network.message.chat.ChatNotify;
import ar.com.game.network.message.chat.ChatRequest;
import ar.com.game.network.message.gui.LineTypedNotify;
import ar.com.game.network.message.login.ConnectNotify;
import ar.com.game.network.message.login.ConnectRequest;
import ar.com.game.network.message.login.ConnectResponse;

public class MessageHubConfigurer {

	public static void setupServer() {

		MessageHub.subscribe(ChatRequest.class, ServerChatRequestHandler.get());
		// no handler for ChatNotify
		MessageHub.subscribe(ConnectRequest.class, ServerConnectRequestHandler.get());
		// no handler for ConnectNotify
		// no handler for ConnectResponse
		// no handler for LineTypedNotify
	}

	public static void setupClient() {

		// no handler for ChatRequest
		MessageHub.subscribe(ChatNotify.class, ClientChatNotifyHandler.get());
		// no handler for ConnectRequest
		MessageHub.subscribe(ConnectNotify.class, ClientConnectNotifyHandler.get());
		MessageHub.subscribe(ConnectResponse.class, ClientConnectResponseHandler.get());
		MessageHub.subscribe(LineTypedNotify.class, ClientLineTypedNotifyHandler.get());
	}

}
