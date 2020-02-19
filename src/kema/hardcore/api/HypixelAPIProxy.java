package kema.hardcore.api;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import kema.hardcore.Game;
import net.hypixel.api.HypixelAPI;
import net.hypixel.api.reply.PlayerReply;

public class HypixelAPIProxy implements APIProxy {

	private HypixelAPI api = new HypixelAPI(Game.hypixelAPIKey);

	public void getRank(UUID target) {
		CompletableFuture<PlayerReply> player = api.getPlayerByUuid(target);
		player.whenComplete(callback(player, target));
	}

	private BiConsumer<? super PlayerReply, ? super Throwable> callback(CompletableFuture<PlayerReply> player,
			UUID target) {
		return (result, throwable) -> {
			try {
				PlayerReply rep = player.get();

				if (rep == null) {
					return;
				}

				if (rep.isSuccess()) {
					RankFormat format = new RankFormat();
					if (rep.getPlayer().get("newPackageRank") != null) {
						format.setRank(rep.getPlayer().get("newPackageRank").getAsString());
					}else if (rep.getPlayer().get("packageRank") != null) {
						format.setRank(rep.getPlayer().get("packageRank").getAsString());
					}

					if (rep.getPlayer().get("rankPlusColor") != null) {
						format.setColor(rep.getPlayer().get("rankPlusColor").getAsString());
					}

					Player pl = Bukkit.getPlayer(target);
					if (pl != null && pl.isOnline()) {
						String nameFormat = format.format(pl);

						pl.setCustomName(nameFormat);
						pl.setPlayerListName(nameFormat);
						pl.setDisplayName(nameFormat);
					}
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		};
	}

	@Override
	public APIProxy getInstance() {
		return this;
	}

	@Override
	public void onJoin(Player player) {
	}

	@Override
	public void onQuit(Player player) {
	}

}
