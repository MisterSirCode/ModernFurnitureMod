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

	public static final Item fuel1 = new Item(new FabricItemSettings().group(ItemGroup.MISC));
	public static final Item fuel2 = new Item(new FabricItemSettings().group(ItemGroup.MISC));
	public static final Item fuel3 = new Item(new FabricItemSettings().group(ItemGroup.MISC));
	public static final Item fuel4 = new Item(new FabricItemSettings().group(ItemGroup.MISC));
	public static final Item fuel5 = new Item(new FabricItemSettings().group(ItemGroup.MISC));
	public static final Item fuel6 = new Item(new FabricItemSettings().group(ItemGroup.MISC));
	public static final Item fuel7 = new Item(new FabricItemSettings().group(ItemGroup.MISC));
	public static final Item fuel8 = new Item(new FabricItemSettings().group(ItemGroup.MISC));
	public static final Item fuel9 = new Item(new FabricItemSettings().group(ItemGroup.MISC));
	public static final Item fuel10 = new Item(new FabricItemSettings().group(ItemGroup.MISC));

    @Override
    public void onInitialize() {
        FuelRegistry.INSTANCE.add(fuel1, 800);
        FuelRegistry.INSTANCE.add(fuel2, 1600);
        FuelRegistry.INSTANCE.add(fuel3, 3200);
        FuelRegistry.INSTANCE.add(fuel4, 6400);
        FuelRegistry.INSTANCE.add(fuel5, 12800);
        FuelRegistry.INSTANCE.add(fuel6, 25600);
        FuelRegistry.INSTANCE.add(fuel7, 51200);
        FuelRegistry.INSTANCE.add(fuel8, 102400);
        FuelRegistry.INSTANCE.add(fuel9, 204800);
        FuelRegistry.INSTANCE.add(fuel10, 409600);
        Registry.register(Registry.ITEM, new Identifier("sch_utils", "fuel1"), fuel1);
        Registry.register(Registry.ITEM, new Identifier("sch_utils", "fuel2"), fuel2);
        Registry.register(Registry.ITEM, new Identifier("sch_utils", "fuel3"), fuel3);
        Registry.register(Registry.ITEM, new Identifier("sch_utils", "fuel4"), fuel4);
        Registry.register(Registry.ITEM, new Identifier("sch_utils", "fuel5"), fuel5);
        Registry.register(Registry.ITEM, new Identifier("sch_utils", "fuel6"), fuel6);
        Registry.register(Registry.ITEM, new Identifier("sch_utils", "fuel7"), fuel7);
        Registry.register(Registry.ITEM, new Identifier("sch_utils", "fuel8"), fuel8);
        Registry.register(Registry.ITEM, new Identifier("sch_utils", "fuel9"), fuel9);
        Registry.register(Registry.ITEM, new Identifier("sch_utils", "fuel10"), fuel10);
    }
}
