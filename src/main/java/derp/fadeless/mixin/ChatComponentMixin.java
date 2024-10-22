package derp.fadeless.mixin;

import derp.fadeless.config.FadelessConfig;
import net.minecraft.client.gui.components.ChatComponent;
import net.minecraft.util.Mth;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ChatComponent.class)
public class ChatComponentMixin {
    @Redirect(
            method = "render(Lnet/minecraft/client/gui/GuiGraphics;IIIZ)V",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/components/ChatComponent;getTimeFactor(I)D")
    )
    private double modifyChatFade(int t) {
        if (FadelessConfig.chatFade.equals(FadelessConfig.ChatFade.DISABLED)) {
            return 1.0;
        }
        return getTimeFactor(t);
    }
    @Shadow
    private static double getTimeFactor(int i) {
        double d = (double)i / 200.0;
        d = 1.0 - d;
        d *= 10.0;
        d = Mth.clamp(d, 0.0, 1.0);
        d *= d;
        return d;
    }
}
