package kema.hardcore;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import kema.hardcore.api.HypixelAPIProxy;
import kema.hardcore.commands.BeliveCommand;
import kema.hardcore.listener.ArrowListener;
import kema.hardcore.listener.ChatListener;
import kema.hardcore.listener.CombatListener;
import kema.hardcore.listener.DeathListener;
import kema.hardcore.listener.JoinListener;
import kema.hardcore.listener.LevelListener;
import kema.hardcore.listener.SpawnListener;
import kema.hardcore.store.Config;
import kema.hardcore.task.ScoreTask;

public class Game extends JavaPlugin {

	public static Game getInstance() {
		return Game.getPlugin(Game.class);
	}

	private Config config;
	public Config getGConfig() {
		return config;
	}

	public static UUID hypixelAPIKey;
	public HypixelAPIProxy hypixelAPIProxy;

	@Override
	public void onDisable() {
		super.onDisable();

		config = null;
	}

	@Override
	public void onEnable() {
		super.onEnable();

		try {
			saveDefaultConfig();
			FileConfiguration conf = getConfig();
			this.config = new Config(conf);
		} catch (Exception e) {
			e.printStackTrace();
		}

		hypixelAPIKey = UUID.fromString("0764a580-72c6-4594-bd06-8d7f29916dd5");
		hypixelAPIProxy = new HypixelAPIProxy();

		Bukkit.getPluginManager().registerEvents(new JoinListener(), this);
		Bukkit.getPluginManager().registerEvents(new ChatListener(), this);

		Bukkit.getPluginManager().registerEvents(new LevelListener(), this);

		Bukkit.getPluginManager().registerEvents(new CombatListener(), this);
		Bukkit.getPluginManager().registerEvents(new ArrowListener(), this);
		Bukkit.getPluginManager().registerEvents(new DeathListener(), this);
		Bukkit.getPluginManager().registerEvents(new SpawnListener(), this);

		Bukkit.getPluginCommand("belive").setExecutor(new BeliveCommand());

		ScoreTask task = new ScoreTask();
		task.runTaskTimer(this, 0L, 20L);
	}

}
