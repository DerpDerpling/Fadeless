package derp.fadeless.mixin;

import net.minecraft.client.gui.screens.TitleScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(TitleScreen.class)
public class TitleScreenMixin {
    @ModifyConstant(
            method = "render", constant = @Constant(floatValue = 2000.0F, ordinal = 0), require = 0
    )
    public float removeFade(float instance) {
        return animationSpeed() * 2;
    }

    @Unique
    private float animationSpeed() {
        return 0;
    }
}

