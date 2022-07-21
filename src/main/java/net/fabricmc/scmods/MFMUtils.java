package net.fabricmc.scmods;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MFMUtils implements ModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger("scmmfmutils");

    public static final String woodLogs[] = {
        "oak", "birch", "spruce", "jungle", "dark_oak", "acacia", "mangrove", "warped", "crimson"
    };
    
    public static final String strippedLogs[] = {
        "stripped_oak", "stripped_birch", "stripped_spruce", "stripped_jungle", "stripped_dark_oak", "stripped_acacia", 
        "stripped_mangrove", "stripped_warped", "stripped_crimson"
    };

    public static final Block woodBlocks[] = {
        Blocks.OAK_PLANKS, Blocks.BIRCH_PLANKS, Blocks.SPRUCE_PLANKS, Blocks.JUNGLE_PLANKS, Blocks.DARK_OAK_PLANKS, 
        Blocks.ACACIA_PLANKS, Blocks.MANGROVE_PLANKS, Blocks.WARPED_PLANKS, Blocks.CRIMSON_PLANKS
    };

    // Create Log Tables
    public static ArrayList<Block> woodTables = new ArrayList<Block>();
    static { for (int i = 0; i < woodLogs.length; i++) {
        woodTables.add(new Block(FabricBlockSettings.of(Material.WOOD, woodBlocks[i].getDefaultMapColor())
        .strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD).nonOpaque()));
    } };

    // Create Stripped Tables
    public static ArrayList<Block> strippedTables = new ArrayList<Block>();
    static { for (int i = 0; i < woodLogs.length; i++) {
        strippedTables.add(new Block(FabricBlockSettings.of(Material.WOOD, woodBlocks[i].getDefaultMapColor())
        .strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD).nonOpaque()));
    } };

    @Override
    public void onInitialize() {
        // Add Log Tables
        for (int i = 0; i < woodLogs.length; i++) {
            String currentTableName = woodLogs[i] + "_table";
            Registry.register(Registry.BLOCK, new Identifier("mfm_utils", currentTableName), woodTables.get(i));
            Registry.register(Registry.ITEM, new Identifier("mfm_utils", currentTableName), 
                new BlockItem(woodTables.get(i), new FabricItemSettings().group(ItemGroup.MISC)));
        }

        // Add Stripped Tables
        for (int i = 0; i < woodLogs.length; i++) {
            String currentTableName = strippedLogs[i] + "_table";
            Registry.register(Registry.BLOCK, new Identifier("mfm_utils", currentTableName), strippedTables.get(i));
            Registry.register(Registry.ITEM, new Identifier("mfm_utils", currentTableName), 
                new BlockItem(strippedTables.get(i), new FabricItemSettings().group(ItemGroup.MISC)));
        }
    }
}
