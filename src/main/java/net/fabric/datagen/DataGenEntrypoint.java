/*
 * Copyright (c) 2016, 2017, 2018, 2019 FabricMC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.fabric.datagen;

import static net.fabric.datagen.DataGenContent.BLOCK_WITHOUT_ITEM;
import static net.fabric.datagen.DataGenContent.BLOCK_WITHOUT_LOOT_TABLE;
import static net.fabric.datagen.DataGenContent.SIMPLE_BLOCK;
import java.util.function.Consumer;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.tag.BlockTags;
import net.minecraft.tag.ItemTags;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fabricmc.fabric.api.resource.conditions.v1.ConditionJsonProvider;
import net.fabricmc.fabric.api.resource.conditions.v1.DefaultResourceConditions;

public class DataGenEntrypoint implements DataGeneratorEntrypoint {
	private static final ConditionJsonProvider NEVER_LOADED = DefaultResourceConditions.allModsLoaded("a");
	private static final ConditionJsonProvider ALWAYS_LOADED = DefaultResourceConditions.not(NEVER_LOADED);

	@Override
	public void onInitializeDataGenerator(FabricDataGenerator dataGenerator) {
		dataGenerator.addProvider(TestRecipeProvider::new);
		dataGenerator.addProvider(TestModelProvider::new);
		dataGenerator.addProvider(TestBlockLootTableProvider::new);

		TestBlockTagProvider blockTagProvider = dataGenerator.addProvider(TestBlockTagProvider::new);
		dataGenerator.addProvider(new TestItemTagProvider(dataGenerator, blockTagProvider));
	}

	private static class TestRecipeProvider extends FabricRecipeProvider {
		private TestRecipeProvider(FabricDataGenerator dataGenerator) {
			super(dataGenerator);
		}

		@Override
		protected void generateRecipes(Consumer<RecipeJsonProvider> exporter) {
			offerPlanksRecipe2(exporter, SIMPLE_BLOCK, ItemTags.ACACIA_LOGS);
		}
	}

	private static class TestModelProvider extends FabricModelProvider {
		private TestModelProvider(FabricDataGenerator generator) {
			super(generator);
		}

		@Override
		public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
			blockStateModelGenerator.registerSimpleCubeAll(SIMPLE_BLOCK);
			blockStateModelGenerator.registerSimpleCubeAll(BLOCK_WITHOUT_ITEM);
			blockStateModelGenerator.registerSimpleCubeAll(BLOCK_WITHOUT_LOOT_TABLE);
		}

		@Override
		public void generateItemModels(ItemModelGenerator itemModelGenerator) {
			//itemModelGenerator.register(item, Models.SLAB);
		}
	}

	private static class TestBlockTagProvider extends FabricTagProvider.BlockTagProvider {
		private TestBlockTagProvider(FabricDataGenerator dataGenerator) {
			super(dataGenerator);
		}

		@Override
		protected void generateTags() {
			getOrCreateTagBuilder(BlockTags.FIRE).add(SIMPLE_BLOCK);
			getOrCreateTagBuilder(BlockTags.ANVIL).setReplace(true).add(SIMPLE_BLOCK, BLOCK_WITHOUT_ITEM);
			getOrCreateTagBuilder(BlockTags.ACACIA_LOGS).forceAddTag(BlockTags.ANIMALS_SPAWNABLE_ON);
		}
	}

	private static class TestItemTagProvider extends FabricTagProvider.ItemTagProvider {
		private TestItemTagProvider(FabricDataGenerator dataGenerator, BlockTagProvider blockTagProvider) {
			super(dataGenerator, blockTagProvider);
		}

		@Override
		protected void generateTags() {
			copy(BlockTags.ANVIL, ItemTags.ANVIL);
		}
	}

	private static class TestBlockLootTableProvider extends FabricBlockLootTableProvider {
		private TestBlockLootTableProvider(FabricDataGenerator dataGenerator) {
			super(dataGenerator);
		}

		@Override
		protected void generateBlockLootTables() {
			addDrop(SIMPLE_BLOCK);
			addDrop(BLOCK_WITHOUT_ITEM, drops(SIMPLE_BLOCK));

			excludeFromStrictValidation(BLOCK_WITHOUT_LOOT_TABLE);
		}
	}
}