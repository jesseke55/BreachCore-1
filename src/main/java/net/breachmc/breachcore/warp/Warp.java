package net.breachmc.breachcore.warp;

import org.bukkit.Location;
import org.bukkit.entity.Player;

/**
 * Copyright (c) 2015, Experminator.
 */
public class Warp {

    private String name;
    private Location location;

    public Warp(String name, Location location) {
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public Location getLocation() {
        return location;
    }

    public void teleport(Player p) {
        p.teleport(location);
    }
}
