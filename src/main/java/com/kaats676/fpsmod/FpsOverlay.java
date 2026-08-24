package com.kaats676.fpsmod;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class FpsOverlay {
    
    // ✅ Переменные на уровне класса — сохраняют состояние
    private long lastTime = 0;
    private int fps = 0;
    private int frames = 0;

    @SubscribeEvent
    public void onRenderGui(RenderGameOverlayEvent.Text event) {
        Minecraft mc = Minecraft.getInstance();
        
        if (mc.player == null || mc.level == null) {
            return;
        }
        
        if (mc.options.hideGui) {
            return;
        }
        
        // Считаем FPS
        frames++;
        long currentTime = System.currentTimeMillis();
        if (currentTime - lastTime >= 1000) {
            fps = frames;
            frames = 0;
            lastTime = currentTime;
        }
        
        String text = "FPS: " + fps;
        
        FontRenderer font = mc.font;
        MatrixStack stack = event.getMatrixStack();
        
        font.drawShadow(stack, text, 10, 10, 0xFFFFFF);
    }
}
