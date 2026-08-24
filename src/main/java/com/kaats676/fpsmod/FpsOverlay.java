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
        
        // ✅ В official mappings используется getInstance(), а не прямой доступ
        if (mc.player == null || mc.level == null) {  // ← level вместо world!
            return;
        }
        
        // ✅ options вместо gameSettings!
        if (mc.options.hideGui) {  // ← options.hideGui!
            return;
        }
        
        // ✅ В official mappings debugFPS - это статическое поле
        int fps = Minecraft.debugFPS;
        String text = "FPS: " + fps;
        
        // ✅ font вместо fontRenderer!
        FontRenderer font = mc.font;
        MatrixStack stack = event.getMatrixStack();
        
        // ✅ В 1.16.5 с official mappings есть drawString с тенью
        font.drawShadow(stack, text, 10, 10, 0xFFFFFF);
    }
}
