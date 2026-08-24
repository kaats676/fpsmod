package com.kaats676.fpsmod;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class FpsOverlay {

    @SubscribeEvent
    public void onRenderGui(RenderGameOverlayEvent.Text event) {
        Minecraft mc = Minecraft.getInstance();
        
        if (mc.player == null || mc.level == null) {
            return;
        }
        
        if (mc.options.hideGui) {
            return;
        }
        
        // ✅ В официальных маппингах 1.16.5 поле называется getFps()
        int fps = mc.getFps();
        String text = "FPS: " + fps;
        
        FontRenderer font = mc.font;
        MatrixStack stack = event.getMatrixStack();
        
        font.drawShadow(stack, text, 10, 10, 0xFFFFFF);
    }
}
