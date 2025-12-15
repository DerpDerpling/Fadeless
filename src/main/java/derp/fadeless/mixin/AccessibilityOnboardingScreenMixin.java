package derp.fadeless.mixin;

import net.minecraft.client.gui.screens.AccessibilityOnboardingScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(AccessibilityOnboardingScreen.class)
public abstract class AccessibilityOnboardingScreenMixin {

    @Redirect(method = "render", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Util;getMillis()J", ordinal = 0))
    private long fakeFadeInStart() {
        return 0L;
    }


    @Redirect(method = "render", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Util;getMillis()J", ordinal = 1))
    private long fakeFadeInProgress() {
        return 0L;
    }


    @Redirect(method = "render", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/Util;getMillis()J", ordinal = 2))
    private long fakeFadeOutTime() {
        return Long.MAX_VALUE;
    }
}
