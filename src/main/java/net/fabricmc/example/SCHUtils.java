package net.fabricmc.example;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SCHUtils implements ModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger("modid");

	public static final Item xfuel = new Item(new FabricItemSettings().group(ItemGroup.MISC));

    @Override
    public void onInitialize() {
        FuelRegistry.INSTANCE.add(xfuel, 409600);
        Registry.register(Registry.ITEM, new Identifier("sch_utils", "xfuel"), xfuel);
    }
}
