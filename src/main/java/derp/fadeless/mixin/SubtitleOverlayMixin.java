package derp.fadeless.mixin;

import derp.fadeless.config.FadelessConfig;
import net.minecraft.client.gui.components.SubtitleOverlay;
import net.minecraft.util.Mth;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(SubtitleOverlay.class)
public class SubtitleOverlayMixin {
    @Redirect(
            method = "render(Lnet/minecraft/client/gui/GuiGraphics;)V",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Mth;clampedLerp(FFF)F")
    )
    private float removeFadeOut(float start, float end, float delta) {
        if (FadelessConfig.subtitleFade.equals(FadelessConfig.SubtitleFade.DISABLED)) {
            return 255.0F;
        } else {
            return Mth.clampedLerp(start, end, delta);
        }
    }
}
