package ar.com.game.backend.server;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import ar.com.game.backend.domain.Bullet;
import ar.com.game.backend.domain.PlayerAvatar;
import ar.com.game.backend.domain.Updatable;
import ar.com.game.backend.domain.Vector2D;

import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;

public class ServerBackend {
	
	private static Map<Long, PlayerAvatar> players = Maps.newHashMap();
	private static List<Updatable> updatees = Collections.synchronizedList(new ArrayList<Updatable>());
	
	public static void movePlayer(Long id, Vector2D delta) {
		Preconditions.checkNotNull(id);
		Preconditions.checkNotNull(delta);
		
		PlayerAvatar player = getPlayer(id);
		Vector2D moved = player.getPosition().plus(delta);
		player.setPosition(moved);
	}
	
	public static void removePlayer(Long id) {
		players.remove(id);
	}
	
	public static Collection<PlayerAvatar> getPlayers() {
		return players.values();
	}
	
	public static Vector2D addPlayer(Long id){
		Vector2D pos = new Vector2D(50, 50);
		players.put(id, new PlayerAvatar(pos, 100.0));
		return pos;
	}

	public static PlayerAvatar getPlayer(Long sessionId) {
		return players.get(sessionId);
	}
	
	public static Bullet bulletShot(Vector2D origin, Vector2D target) {
		Bullet bullet = new Bullet(origin, target);
		updatees.add(bullet);
		return bullet;
	}
	
	public static void update() {
		for (Updatable u : updatees) {
			u.update();
		}
	}

}
