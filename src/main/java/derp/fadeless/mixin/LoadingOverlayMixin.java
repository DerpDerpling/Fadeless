package derp.fadeless.mixin;

import derp.fadeless.config.FadelessConfig;
import derp.fadeless.config.FadelessConfig.OverlayFade;

import net.minecraft.client.Minecraft;

import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.screens.LoadingOverlay;
import net.minecraft.client.gui.screens.Overlay;
import net.minecraft.util.Util;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LoadingOverlay.class)
public abstract class LoadingOverlayMixin extends Overlay {
    @Shadow private long fadeOutStart;
    @Shadow @Final private Minecraft minecraft;
    @Shadow private boolean fadeIn;
    @Shadow private long fadeInStart;

    @Inject(method = "extractRenderState", at = @At("HEAD"))
    private void onRender(GuiGraphicsExtractor graphics, int mouseX, int mouseY, float a, CallbackInfo ci) {
        if (FadelessConfig.overlayFade == OverlayFade.DISABLED) {
            if (this.fadeIn && this.fadeInStart == -1L) {
                long now = Util.getMillis();
                this.fadeInStart = now - 1000L;
            }
        }
        if (this.fadeOutStart > 1L && FadelessConfig.overlayFade == OverlayFade.DISABLED) {
            this.minecraft.setOverlay(null);
        }
    }
}