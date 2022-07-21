package net.fabricmc.example;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MFMUtils implements ModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger("modid");

	//public static final Item fuel = new Item(new FabricItemSettings().group(ItemGroup.MISC));
    
    public static final Block oak_table = new Block(FabricBlockSettings.of(Material.WOOD).strength(4.0f).nonOpaque());

    @Override
    public void onInitialize() {
        //FuelRegistry.INSTANCE.add(fuel, 409600);
        //Registry.register(Registry.ITEM, new Identifier("mfm_utils", "fuel"), fuel);
        Registry.register(Registry.BLOCK, new Identifier("mfm_utils", "oak_table"), oak_table);
        Registry.register(Registry.ITEM, new Identifier("mfm_utils", "oak_table"), 
            new BlockItem(oak_table, new FabricItemSettings().group(ItemGroup.MISC)));
    }
}
