package derp.fadeless.mixin;

import derp.fadeless.config.FadelessConfig;
import net.minecraft.client.gui.components.ChatComponent;
import net.minecraft.util.Mth;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ChatComponent.class)
public class ChatComponentMixin {
    @Inject(method = "getTimeFactor", at = @At("HEAD"), cancellable = true)
    private static void modifyChatFade(int ticksElapsed, CallbackInfoReturnable<Double> cir) {
        int maxTicks = FadelessConfig.customChatFadeTime;

        switch (FadelessConfig.chatFade) {
            case DISABLED -> cir.setReturnValue(ticksElapsed >= maxTicks ? 0.0 : 1.0);
            case PERMANENT -> cir.setReturnValue(1.0);
            case ENABLED -> {
                double d = (double) ticksElapsed / maxTicks;
                d = 1.0 - d;
                d *= 10.0;
                d = Mth.clamp(d, 0.0, 1.0);
                d *= d;
                cir.setReturnValue(d);
            }
        }
    }
}
