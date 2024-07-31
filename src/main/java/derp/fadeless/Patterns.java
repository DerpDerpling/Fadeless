package derp.fadeless;

public class Patterns {
    @Pattern
    public static String getModDisplayName(String id) {
        //#if LOADER == FABRIC
        return net.fabricmc.loader.api.FabricLoader.getInstance().getModContainer(id).orElseThrow().getMetadata().getName();
        //#elseif LOADER == FORGE
        //$$ return net.minecraftforge.fml.ModList.get().getModContainerById(id).orElseThrow().getModInfo().getDisplayName();
        //#elseif LOADER == NEOFORGE
        //$$ return net.neoforged.fml.ModList.get().getModContainerById(id).orElseThrow().getModInfo().getDisplayName();
        //#endif
    }
}
