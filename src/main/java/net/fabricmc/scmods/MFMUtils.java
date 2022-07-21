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

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MFMUtils implements ModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger("modid");

    public static final String woodLogs[] = {
        "oak", "birch", "spruce", "jungle", "dark_oak", "acacia", "mangrove", "warped", "crimson"
    };

    public static final Block woodBlocks[] = {
        OAK_PLANKS, BIRCH_PLANKS, SPRUCE_PLANKS, JUNGLE_PLANKS, DARK_OAK_PLANKS, ACACIA_PLANKS, MANGROVE_PLANKS, WARPED_PLANKS, CRIMSON_PLANKS
    };

    public static Map<String, Block> blockMap = new HashMap<String, Block>();S
    for (int i = 0; i < woodLogs.length; i++) {

    }


	//public static final Item fuel = new Item(new FabricItemSettings().group(ItemGroup.MISC));
    public static final Block oak_table = new Block(FabricBlockSettings.of(Material.WOOD, Blocks.OAK_PLANKS.getDefaultMapColor())
        .strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD).nonOpaque());
    public static final Block birch_table = new Block(FabricBlockSettings.of(Material.WOOD, Blocks.BIRCH_PLANKS.getDefaultMapColor())
        .strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD).nonOpaque());
    public static final Block spruce_table = new Block(FabricBlockSettings.of(Material.WOOD, Blocks.SPRUCE_PLANKS.getDefaultMapColor())
        .strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD).nonOpaque());
    public static final Block jungle_table = new Block(FabricBlockSettings.of(Material.WOOD, Blocks.JUNGLE_PLANKS.getDefaultMapColor())
        .strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD).nonOpaque());
    public static final Block dark_oak_table = new Block(FabricBlockSettings.of(Material.WOOD, Blocks.DARK_OAK_PLANKS.getDefaultMapColor())
        .strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD).nonOpaque());
    public static final Block acacia_table = new Block(FabricBlockSettings.of(Material.WOOD, Blocks.ACACIA_PLANKS.getDefaultMapColor())
        .strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD).nonOpaque());
    public static final Block mangrove_table = new Block(FabricBlockSettings.of(Material.WOOD, Blocks.MANGROVE_PLANKS.getDefaultMapColor())
        .strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD).nonOpaque());
    public static final Block warped_table = new Block(FabricBlockSettings.of(Material.WOOD, Blocks.WARPED_PLANKS.getDefaultMapColor())
        .strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD).nonOpaque());
    public static final Block crimson_table = new Block(FabricBlockSettings.of(Material.WOOD, Blocks.CRIMSON_PLANKS.getDefaultMapColor())
        .strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD).nonOpaque());

    @Override
    public void onInitialize() {
        //FuelRegistry.INSTANCE.add(fuel, 409600);
        //Registry.register(Registry.ITEM, new Identifier("mfm_utils", "fuel"), fuel);
        Registry.register(Registry.BLOCK, new Identifier("mfm_utils", "oak_table"), oak_table);
        Registry.register(Registry.ITEM, new Identifier("mfm_utils", "oak_table"), 
            new BlockItem(oak_table, new FabricItemSettings().group(ItemGroup.MISC)));
        Registry.register(Registry.BLOCK, new Identifier("mfm_utils", "birch_table"), birch_table);
        Registry.register(Registry.ITEM, new Identifier("mfm_utils", "birch_table"), 
            new BlockItem(birch_table, new FabricItemSettings().group(ItemGroup.MISC)));
        Registry.register(Registry.BLOCK, new Identifier("mfm_utils", "spruce_table"), spruce_table);
        Registry.register(Registry.ITEM, new Identifier("mfm_utils", "spruce_table"), 
            new BlockItem(spruce_table, new FabricItemSettings().group(ItemGroup.MISC)));
        Registry.register(Registry.BLOCK, new Identifier("mfm_utils", "jungle_table"), jungle_table);
        Registry.register(Registry.ITEM, new Identifier("mfm_utils", "jungle_table"), 
            new BlockItem(jungle_table, new FabricItemSettings().group(ItemGroup.MISC)));
        Registry.register(Registry.BLOCK, new Identifier("mfm_utils", "dark_oak_table"), dark_oak_table);
        Registry.register(Registry.ITEM, new Identifier("mfm_utils", "dark_oak_table"), 
            new BlockItem(dark_oak_table, new FabricItemSettings().group(ItemGroup.MISC)));
        Registry.register(Registry.BLOCK, new Identifier("mfm_utils", "acacia_table"), acacia_table);
        Registry.register(Registry.ITEM, new Identifier("mfm_utils", "acacia_table"), 
            new BlockItem(acacia_table, new FabricItemSettings().group(ItemGroup.MISC)));
        Registry.register(Registry.BLOCK, new Identifier("mfm_utils", "mangrove_table"), mangrove_table);
        Registry.register(Registry.ITEM, new Identifier("mfm_utils", "mangrove_table"), 
            new BlockItem(mangrove_table, new FabricItemSettings().group(ItemGroup.MISC)));
        Registry.register(Registry.BLOCK, new Identifier("mfm_utils", "warped_table"), warped_table);
        Registry.register(Registry.ITEM, new Identifier("mfm_utils", "warped_table"), 
            new BlockItem(warped_table, new FabricItemSettings().group(ItemGroup.MISC)));
        Registry.register(Registry.BLOCK, new Identifier("mfm_utils", "crimson_table"), crimson_table);
        Registry.register(Registry.ITEM, new Identifier("mfm_utils", "crimson_table"), 
            new BlockItem(crimson_table, new FabricItemSettings().group(ItemGroup.MISC)));
    }
}
