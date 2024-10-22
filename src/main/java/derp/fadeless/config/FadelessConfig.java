package derp.fadeless.config;

import eu.midnightdust.lib.config.MidnightConfig;

/** Every option in a MidnightConfig class has to be public and static, so we can access it from other classes.
 * The config class also has to extend MidnightConfig*/

public class FadelessConfig extends MidnightConfig {
    public static final String TEXT = "Fadeless Config";

    @Entry(category = TEXT) public static OverlayFade overlayFade = OverlayFade.DISABLED;
    public enum OverlayFade {
        ENABLED, DISABLED
    }
    @Entry(category = TEXT) public static TitleScreenFadeEnabled titlescreenFade = TitleScreenFadeEnabled.DISABLED;
    public enum TitleScreenFadeEnabled {
        ENABLED, DISABLED
    }
    @Entry(category = TEXT, isSlider = true, min = 0f, max = 200f) public static float titlescreenfadetime = 0f;
    @Entry(category = TEXT) public static SubtitleFade subtitleFade = SubtitleFade.ENABLED;
    public enum SubtitleFade {
        ENABLED, DISABLED
    }
    @Entry(category = TEXT) public static ChatFade chatFade = ChatFade.ENABLED;
    public enum ChatFade {
        ENABLED, DISABLED
    }
}
