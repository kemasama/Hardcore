package kema.hardcore.api;

import org.bukkit.entity.Player;

public interface APIProxy {
	public APIProxy getInstance();
	public void onJoin(Player player);
	public void onQuit(Player player);
}
