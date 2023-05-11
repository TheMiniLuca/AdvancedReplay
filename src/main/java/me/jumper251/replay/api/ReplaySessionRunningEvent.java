package me.jumper251.replay.api;

import me.jumper251.replay.replaysystem.Replay;
import me.jumper251.replay.replaysystem.replaying.Replayer;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class ReplaySessionRunningEvent extends Event {

    private static final HandlerList HANDLERS = new HandlerList();

    private final Replayer replayer;

    private final Player player;
    private final int duration;
    private final boolean paused;

    public ReplaySessionRunningEvent(Replayer replayer, Player player, int duration, boolean paused) {
        super(!Bukkit.isPrimaryThread());
        this.replayer = replayer;
        this.player = player;
        this.duration = duration;
        this.paused = paused;
    }

    public boolean isPaused() {
        return paused;
    }

    public int getDuration() {
        return duration;
    }

    public Player getPlayer() {
        return player;
    }

    public Replayer getReplayer() {
        return replayer;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }
}