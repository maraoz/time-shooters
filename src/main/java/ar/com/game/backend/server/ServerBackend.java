package ar.com.game.backend.server;

import java.util.Collection;
import java.util.Map;

import ar.com.game.backend.domain.Position;

import com.google.common.collect.Maps;

public class ServerBackend {
	
	private static Map<Long, Position> playerPositions = Maps.newHashMap();
	
	public static void movePlayer(Long id, Position delta) {
		playerPositions.put(id, playerPositions.get(id).add(delta));
	}
	
	public static void removePlayer(Long id) {
		playerPositions.remove(id);
	}
	
	public static Collection<Position> getPositions() {
		return playerPositions.values();
	}
	
	public static Position addPlayer( Long id ){
		Position pos = new Position( 50, 50 );
		playerPositions.put(id,pos);
		return pos;
	}

	public static Position getPosition(Long sessionId) {
		return playerPositions.get(sessionId);
	}

}
