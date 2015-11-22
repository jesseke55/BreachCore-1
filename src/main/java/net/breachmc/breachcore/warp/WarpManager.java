package net.breachmc.breachcore.warp;

import org.bukkit.Location;

import java.util.HashSet;
import java.util.Set;

/**
 * Copyright (c) 2015, Experminator.
 */
public class WarpManager {

    private static Set<Warp> warps = new HashSet<>();

    private WarpManager() {
    }

    public static Set<Warp> getWarps() {
        return warps;
    }

    public static void addWarp(Warp warp) {
        warps.add(warp);
    }

    public static void removeWarp(String name) {
        warps.remove(WarpManager.getWarp(name));
    }

    public static Warp getWarp(String name) {
        for (Warp warp : WarpManager.getWarps()) {
            if (warp.getName().equalsIgnoreCase(name)) {
                return warp;
            }
        }

        return null;
    }

    public static Warp getWarp(Location loc) {
        for (Warp warp : WarpManager.getWarps()) {
            if (warp.getLocation().equals(loc)) {
                return warp;
            }
        }

        return null;
    }

    public static int getTotalWarps() {
        return WarpManager.getWarps().size();
    }
}
