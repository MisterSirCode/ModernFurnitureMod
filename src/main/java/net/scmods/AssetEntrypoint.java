package net.scmods;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Block;
import net.minecraft.client.render.model.json.ItemModelGenerator;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.scmods.MFMUtils;


public class AssetEntrypoint implements DataGeneratorEntrypoint {

	@Override
	public void onInitializeDataGenerator(FabricDataGenerator dataGenerator) {
        
		dataGenerator.addProvider(WoodModelProvider::new);
    }

	private static class WoodModelProvider extends FabricModelProvider {
		private WoodModelProvider(FabricDataGenerator generator) {
			super(generator);
		}

		@Override
		public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
            
            for (int i = 0; i < MFMUtils.vanillaLogs.length; i++) {
                blockStateModelGenerator.registerSimpleCubeAll(MFMUtils.woodTables.get(i));
            }
		}

		@Override
		public void generateItemModels(ItemModelGenerator itemModelGenerator) {
			
		}
	}
}