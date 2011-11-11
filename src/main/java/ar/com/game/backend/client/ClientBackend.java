package ar.com.game.backend.client;

import java.util.Collection;
import java.util.Map;

import ar.com.game.backend.domain.Position;

import com.google.common.collect.Maps;

public class ClientBackend {
	
	private static Map<Long, Position> playerPositions = Maps.newHashMap();
	
	public static void movePlayer(Long id, Position where) {
		playerPositions.put(id, where);
	}
	
	public static void removePlayer(Long id) {
		playerPositions.remove(id);
	}
	
	public static Collection<Position> getPositions() {
		return playerPositions.values();
	}

}
