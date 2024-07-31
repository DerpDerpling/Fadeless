package derp.fadeless;

import net.minecraft.client.Minecraft;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//#if LOADER == FORGE
//$$ import net.minecraftforge.fml.common.Mod;
//#elseif LOADER == NEOFORGE
//$$ import net.neoforged.fml.common.Mod;
//#endif
//#if LOADER <= FORGE
//$$ @Mod(Fadeless.MOD_ID)
//#endif
public class Fadeless {
    public static final String MOD_ID = "fadeless";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    //#if LOADER <= FORGE
    //$$ public Fadeless() {
    //$$     onInitialize();
    //$$ }
    //#endif

    public void onInitialize() {
        //#if LOADER == FABRIC
        String loader = "Fabric";
        //#elseif LOADER == FORGE
        //$$ String loader = "Forge";
        //#elseif LOADER == NEOFORGE
        //$$ String loader = "NeoForge";
        //#endif
        LOGGER.info("Loading Fadeless {}", loader);
    }
}
