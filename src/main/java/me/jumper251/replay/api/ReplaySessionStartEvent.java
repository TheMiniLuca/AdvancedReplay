package me.jumper251.replay.api;

import me.jumper251.replay.replaysystem.Replay;
import me.jumper251.replay.replaysystem.replaying.ReplaySession;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class ReplaySessionStartEvent extends Event {
    private static final HandlerList HANDLERS = new HandlerList();

    private final ReplaySession session;

    private final Player player;

    public ReplaySessionStartEvent(ReplaySession session, Player player) {
        super(!Bukkit.isPrimaryThread());

        this.session = session;
        this.player = player;
    }


    public Player getPlayer() {
        return player;
    }

    public ReplaySession getReplaySession() {
        return session;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }
}