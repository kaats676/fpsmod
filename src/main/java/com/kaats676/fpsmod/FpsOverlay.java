package com.kaats676.fpsmod;  // Package matches GitHub username 'kaats676'

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

/**
 * FPS Overlay Renderer.
 * Displays FPS counter in the top-right corner of the game screen.
 * 
 * Registered manually via FpsMod class.
 * Event handler method is non-static (called on instance).
 * 
 * @author kaats676
 */
public class FpsOverlay {

    /**
     * Renders the FPS counter on the game overlay.
     * Triggered every frame after the default text overlay.
     * 
     * @param event The RenderGameOverlayEvent.Text event
     */
    @SubscribeEvent
    public void onRenderGui(RenderGameOverlayEvent.Text event) {
        Minecraft mc = Minecraft.getInstance();

        // Safety checks: prevent crash during world loading
        if (mc.player == null || mc.world == null) {
            return;
        }

        // Respect F1 key (hide GUI)
        if (mc.gameSettings.hideGUI) {
            return;
        }

        // IMPORTANT: debugFPS is STATIC in 1.16.5
        // Must use Minecraft.debugFPS (not mc.debugFPS)
        int fps = Minecraft.debugFPS;
        String text = "FPS: " + fps;

        FontRenderer font = mc.fontRenderer;
        MatrixStack stack = event.getMatrixStack();

        // drawStringWithShadow(MatrixStack, String, float, float, int)
        // Correct method for 1.16.5 (not drawShadow or drawStringWithShadow without MatrixStack)
        font.drawStringWithShadow(stack, text, 10, 10, 0xFFFFFF);
    }
}
