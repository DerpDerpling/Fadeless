package derp.fadeless;

import derp.fadeless.config.FadelessConfig;
import eu.midnightdust.lib.config.MidnightConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Fadeless {
    public static final String MOD_ID = "assets/lang/fadeless";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);


    public void onInitialize() {
        String loader = "Fabric";
        LOGGER.info("Loading Fadeless {}", loader);
        MidnightConfig.init("fadeless", FadelessConfig.class);

    }
}
