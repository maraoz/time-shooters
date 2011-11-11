package ar.com.game.network.message.session;

import ar.com.game.network.BaseMessage;

public class DisconnectNotify extends BaseMessage {
	
	private final String who;

	public DisconnectNotify(String who) {
		super();
		this.who = who;
	}
	
	public String getWho() {
		return who;
	}
	

}
