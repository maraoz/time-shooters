package ar.com.game.handler.base;

import java.util.Collection;

import org.jboss.netty.channel.Channel;

import ar.com.game.network.BaseMessage;

public class BaseServerHandler {

	private static ServerConnectionManager connectionManager = new ServerConnectionManager();

	public Long addClient(Channel channel) {
		return connectionManager.addClient(channel);
	}
	public Long getClient(Channel channel) {
		return connectionManager.getSessionFor(channel);
	}

	public void send(BaseMessage message, Long destSession) {
		connectionManager.getChannelFor(destSession).write(message);
	}

	public void send(BaseMessage message, Collection<Long> sessions) {
		for (Long session : sessions) {
			send(message, session);
		}
	}

	public void sendToAll(BaseMessage message) {
		send(message, connectionManager.getAll());
	}
}
