package kema.hardcore.listener;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import trans.jp.IMEConverter;
import trans.jp.KanaConverter;

public class ChatListener implements Listener {
	@EventHandler
	public void onChat(AsyncPlayerChatEvent event) {
		Player pl = event.getPlayer();
		boolean spectator = pl.getGameMode().equals(GameMode.SPECTATOR);

		if (spectator) {
			event.getRecipients().clear();
			for (Player p : Bukkit.getOnlinePlayers()) {
				if (p.getGameMode().equals(GameMode.SPECTATOR)) {
					event.getRecipients().add(p);
				}
			}
		}

		event.setMessage(ChatColor.translateAlternateColorCodes('&', event.getMessage()));

		String kanaTemp = ChatColor.stripColor(event.getMessage());
		boolean skip = false;

		if (!skip
				&& (kanaTemp.getBytes().length > kanaTemp.length()
						|| kanaTemp.matches("[ \\uFF61-\\uFF9F]+"))) {
			skip = true;
		}

		if (!skip) {
			String kana = KanaConverter.conv(event.getMessage());
			String ime = IMEConverter.convByGoogleIME(kana);

			String format = ime + " §7(" + event.getMessage() + "§7)";

			event.setMessage(format);
		}

		if (spectator) {
			event.setFormat("§7[SPEC] §b%s§7: §f%s");
		}else {
			event.setFormat("§6[" + pl.getLevel() + "] " + "§b%s§7: §f%s");
		}

	}
}
