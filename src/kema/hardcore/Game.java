package kema.hardcore;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import kema.hardcore.commands.BeliveCommand;
import kema.hardcore.listener.ChatListener;
import kema.hardcore.listener.DeathListener;
import kema.hardcore.listener.JoinListener;
import kema.hardcore.listener.LevelListener;
import kema.hardcore.listener.OreListener;
import kema.hardcore.listener.SpawnListener;
import kema.hardcore.task.ScoreTask;

public class Game extends JavaPlugin {

	@Override
	public void onDisable() {
		super.onDisable();
	}

	@Override
	public void onEnable() {
		super.onEnable();

		Bukkit.getPluginManager().registerEvents(new JoinListener(), this);
		Bukkit.getPluginManager().registerEvents(new ChatListener(), this);

		Bukkit.getPluginManager().registerEvents(new LevelListener(), this);

		Bukkit.getPluginManager().registerEvents(new OreListener(), this);

		Bukkit.getPluginManager().registerEvents(new DeathListener(), this);
		Bukkit.getPluginManager().registerEvents(new SpawnListener(), this);

		Bukkit.getPluginCommand("belive").setExecutor(new BeliveCommand());

		ScoreTask task = new ScoreTask();
		task.runTaskTimer(this, 0L, 20L);
	}

}
