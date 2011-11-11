package ar.com.game.main;

import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

import org.jboss.netty.bootstrap.ClientBootstrap;
import org.jboss.netty.channel.socket.nio.NioClientSocketChannelFactory;

import ar.com.game.gui.LineReaderTask;
import ar.com.game.network.GameClientPipelineFactory;
import ar.com.game.network.dispatch.MessageHubConfigurer;

public class GameClient implements Runnable {

	public static void main(String[] args) {
		new GameClient().run();
	}

	public void run() {
		// TODO: configuration file or command line arguments
		String host = "localhost";
		int port = GameServer.SERVER_DEFAULT_PORT;

		// bind message handlers
		MessageHubConfigurer.setupClient();

		// create GUI for client
		Executors.newSingleThreadExecutor().execute(new LineReaderTask());

		// Configure the network client.
		ClientBootstrap bootstrap = new ClientBootstrap(
				new NioClientSocketChannelFactory(
						Executors.newCachedThreadPool(),
						Executors.newCachedThreadPool()));

		// Set up the game client pipeline factory.
		bootstrap.setPipelineFactory(new GameClientPipelineFactory());

		// Start the connection attempt.
		bootstrap.connect(new InetSocketAddress(host, port));
	}
}
