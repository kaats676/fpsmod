package com.kaats676.fpsmod;  // Package matches GitHub username 'kaats676'

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;

/**
 * Main mod class for FPS Display mod.
 * Uses manual event bus registration to allow non-static event handlers.
 * 
 * @author kaats676
 */
@Mod("fpsmod")  // Mod ID must match mods.toml
public class FpsMod {
    
    /**
     * Constructor - called when Forge initializes the mod.
     * Registers the FpsOverlay instance to receive render events.
     */
    public FpsMod() {
        // Manual registration (not @EventBusSubscriber)
        // This allows the event handler method to be non-static
        MinecraftForge.EVENT_BUS.register(new FpsOverlay());
    }
}
