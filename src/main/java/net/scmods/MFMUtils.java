package net.scmods;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import java.util.ArrayList;

public class MFMUtils implements ModInitializer {
    public static final String vanillaLogs[] = {
        "oak", "birch", "spruce", "jungle", "dark_oak", "acacia", "mangrove", "warped", "crimson", 
        "stripped_oak", "stripped_birch", "stripped_spruce", "stripped_jungle", "stripped_dark_oak",
        "stripped_acacia", "stripped_mangrove", "stripped_warped", "stripped_crimson"
    };

    public static final Block woodBlocks[] = {
        Blocks.OAK_LOG, Blocks.BIRCH_LOG, Blocks.SPRUCE_LOG, Blocks.JUNGLE_LOG, Blocks.DARK_OAK_LOG, 
        Blocks.ACACIA_LOG, Blocks.MANGROVE_LOG, Blocks.WARPED_STEM, Blocks.CRIMSON_STEM, 
        Blocks.STRIPPED_OAK_LOG, Blocks.STRIPPED_BIRCH_LOG, Blocks.STRIPPED_SPRUCE_LOG, 
        Blocks.STRIPPED_JUNGLE_LOG, Blocks.STRIPPED_DARK_OAK_LOG, Blocks.STRIPPED_ACACIA_LOG, 
        Blocks.STRIPPED_MANGROVE_LOG, Blocks.STRIPPED_WARPED_STEM, Blocks.STRIPPED_CRIMSON_STEM
    };

    // Create Furniture
    public static ArrayList<Block> woodTables = new ArrayList<Block>();
    public static ArrayList<Block> woodBenches = new ArrayList<Block>();
    static { for (int i = 0; i < vanillaLogs.length; i++) {
        woodTables.add(new Table(FabricBlockSettings.of(Material.WOOD, woodBlocks[i].getDefaultMapColor())
        .strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD).nonOpaque()));
        woodBenches.add(new Bench(FabricBlockSettings.of(Material.WOOD, woodBlocks[i].getDefaultMapColor())
        .strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD).nonOpaque()));
    } };

    public static final ItemGroup MFM_GROUP = FabricItemGroupBuilder.create(new Identifier("scm_mfmutils", "mfmitemgroup"))
        .icon(() -> new ItemStack(woodTables.get(6)))
        .build();
    
    // new ItemGroup(13, "mfmutilsmod") {
    //     @Override
    //     public ItemStack createIcon() {
    //         return new ItemStack(woodTables.get(6));
    //     }
    // }.setName("Modern Furniture Mod");

    @Override
    public void onInitialize() {
        // Add Furniture
        for (int i = 0; i < vanillaLogs.length; i++) {
            String currentTableName = vanillaLogs[i] + "_table";
            Registry.register(Registry.BLOCK, new Identifier("mfm_utils", currentTableName), woodTables.get(i));
            Registry.register(Registry.ITEM, new Identifier("mfm_utils", currentTableName), 
                new BlockItem(woodTables.get(i), new FabricItemSettings().group(MFM_GROUP)));
            String currentBenchName = vanillaLogs[i] + "_bench";
            Registry.register(Registry.BLOCK, new Identifier("mfm_utils", currentBenchName), woodBenches.get(i));
            Registry.register(Registry.ITEM, new Identifier("mfm_utils", currentBenchName), 
                new BlockItem(woodBenches.get(i), new FabricItemSettings().group(MFM_GROUP)));
        }
    }
}
