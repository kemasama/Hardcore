package kema.hardcore.store;

import org.bukkit.configuration.file.FileConfiguration;

public class Config {
	public Config(FileConfiguration conf) {
	}

	private int worldBorder;
	public int getWorldBorder() {
		return worldBorder;
	}
}
