package derp.fadeless.mixin;

import derp.fadeless.config.FadelessConfig;
import net.minecraft.client.GuiMessage;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.ChatComponent;
import net.minecraft.util.Mth;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import com.llamalad7.mixinextras.sugar.Local;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(ChatComponent.class)
public abstract class ChatComponentMixin {

    @Shadow @Final
    Minecraft minecraft;

    @ModifyVariable(method = "forEachLine", at = @At("STORE"), ordinal = 0)
    private float modifyChatFade(float original, @Local GuiMessage.Line line) {
        int maxTicks = Math.max(1, FadelessConfig.customChatFadeTime);
        int nowTicks = this.minecraft.gui.getGuiTicks();
        int ticksElapsed = nowTicks - line.addedTime();

        return switch (FadelessConfig.chatFade) {
            case DISABLED -> ticksElapsed >= maxTicks ? 0.0F : 1.0F;
            case PERMANENT -> 1.0F;
            case ENABLED -> {
                double d = (double) ticksElapsed / (double) maxTicks;
                d = 1.0D - d;
                d *= 10.0D;
                d = Mth.clamp(d, 0.0D, 1.0D);
                d *= d;
                yield (float) d;
            }
        };
    }
}
