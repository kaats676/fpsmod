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
        
        // Проверка загрузки мира
        if (mc.player == null || mc.world == null) {
            return;
        }
        
        // Скрываем при нажатии F1
        if (mc.gameSettings.hideGUI) {
            return;
        }
        
        // FPS из статического поля
        int fps = Minecraft.debugFPS;
        String text = "FPS: " + fps;
        
        FontRenderer font = mc.fontRenderer;
        MatrixStack stack = event.getMatrixStack();
        
        // ✅ В 1.16.5 нет drawStringWithShadow, используем drawString
        font.drawString(stack, text, 10, 10, 0xFFFFFF);
    }
}
