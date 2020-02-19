package kema.hardcore.commands;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BeliveCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (!(sender instanceof Player)) {
			return true;
		}

		Player p = (Player) sender;
		if (p.getGameMode().equals(GameMode.SPECTATOR)) {
			double per = (Math.random() * 100);
			if (per <= 25.0) {
				p.setGameMode(GameMode.SURVIVAL);
				p.teleport(Bukkit.getWorlds().get(0).getSpawnLocation());
			}
		}

		return true;
	}

}
