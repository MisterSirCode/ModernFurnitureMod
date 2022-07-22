package scmods;

import java.util.ArrayList;
import net.devtech.arrp.api.RRPPreGenEntrypoint;
import net.devtech.arrp.api.RuntimeResourcePack;
import net.minecraft.resource.ResourceType;
import net.minecraft.util.Identifier;


public class AssetLoader implements RRPPreGenEntrypoint {
    public static final RuntimeResourcePack RESOURCE_PACK = RuntimeResourcePack.create("scmmfmutils:main");
    public static ArrayList<String> woodItems = new ArrayList<String>();
    public static ArrayList<String> woodItemIds = new ArrayList<String>();
    public static final String vanillaLogs[] = {
        "oak", "birch", "spruce", "jungle", "dark_oak", "acacia", "mangrove", "warped", "crimson", 
        "stripped_oak", "stripped_birch", "stripped_spruce", "stripped_jungle", "stripped_dark_oak", "stripped_acacia", 
        "stripped_mangrove", "stripped_warped", "stripped_crimson"
    };

    // Model Generator for all my wood furnitures
    public static String createWoodModelJson(String type, String id, boolean stem) {
        if (stem == true) id += "_stem";
        else id += "_log";
        return "{\n" +
                "    \"parent\": \"mfm_utils:block/" + type + ",\"\n" +
                "    \"textures\": {\n" +
                "        \"top\": \"minecraft:block/" + id + "_top\"," +
                "        \"sides\": \"minecraft:block/" + id + "\"," +
                "}";
    }
    
    @Override
    public void pregen() {
        // Add everything to ARRP to load assets during runtimeS
        for (int i = 0; i < vanillaLogs.length - 1; i++) {
            String bid = vanillaLogs[i];
            boolean stem = false;
            if (bid.contains("warped") || bid.contains("crimson")) stem = true;
            byte[] data = createWoodModelJson("table", bid, stem).getBytes();
            RESOURCE_PACK.addResource(ResourceType.CLIENT_RESOURCES, new Identifier("mfm_utils", "models/block/" + bid + "_table.json"), data);
        }
    }
}
