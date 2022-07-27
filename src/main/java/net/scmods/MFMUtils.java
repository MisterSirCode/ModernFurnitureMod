package net.scmods;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.block.AbstractBlock.Settings;
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

    public static final String furnitures[] = {
        "table", "bench", "grate", "box"
    };

    public static ArrayList<ArrayList<Block>> typeLists = new ArrayList<ArrayList<Block>>();

    // Create Furniture
    static {
        for (int i = 0; i < furnitures.length; i++) {
            ArrayList<Block> tempBlocks = new ArrayList<Block>();
            for (int j = 0; j < vanillaLogs.length; j++) {
                Block block;
                Settings blockSettings = FabricBlockSettings.of(Material.WOOD, woodBlocks[j].getDefaultMapColor())
                    .strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD).nonOpaque();
                if (i == 0) block = new Table(blockSettings);
                else if (i == 1) block = new Bench(blockSettings);
                else if (i == 2) block = new Grate(blockSettings);
                else block = new Box(blockSettings);
                tempBlocks.add(block);
            }
            typeLists.add(tempBlocks);
        }
    }

    public static final ItemGroup MFM_GROUP = FabricItemGroupBuilder.create(new Identifier("mfm_utils", "mfmitemgroup"))
        .icon(() -> new ItemStack(typeLists.get(0).get(6)))
        .build();

    @Override
    public void onInitialize() {
        // Add Furniture
        for (int i = 0; i < furnitures.length; i++) {
            ArrayList<Block> tempBlocks = typeLists.get(i);
            for (int j = 0; j < vanillaLogs.length; j++) {
                String currentName = vanillaLogs[j] + "_" + furnitures[i];
                Registry.register(Registry.BLOCK, new Identifier("mfm_utils", currentName), tempBlocks.get(j));
                Registry.register(Registry.ITEM, new Identifier("mfm_utils", currentName), 
                    new BlockItem(tempBlocks.get(j), new FabricItemSettings().group(MFM_GROUP)));
            }
        }
    }
}
