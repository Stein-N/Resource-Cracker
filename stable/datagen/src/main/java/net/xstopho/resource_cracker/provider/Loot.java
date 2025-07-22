package net.xstopho.resource_cracker.provider;

import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.xstopho.resource_cracker.block.GarlicCropBlock;
import net.xstopho.resource_cracker.registries.BlockRegistry;
import net.xstopho.resource_cracker.registries.ItemRegistry;
import net.xstopho.resourcelibrary.registration.RegistryObject;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class Loot extends BlockLootSubProvider {

    public static LootTableProvider create(PackOutput output, CompletableFuture<HolderLookup.Provider> provider) {
        return new LootTableProvider(output, Set.of(), List.of(
                new LootTableProvider.SubProviderEntry(Loot::new, LootContextParamSets.BLOCK)), provider);
    }

    public Loot(HolderLookup.Provider provider) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), provider);
    }

    @Override
    public void generate() {
        this.add(BlockRegistry.GARLIC_CROP.get(), createCropDrops(BlockRegistry.GARLIC_CROP.get(), ItemRegistry.GARLIC.get(),
                ItemRegistry.GARLIC.get(), LootItemBlockStatePropertyCondition
                        .hasBlockStateProperties(BlockRegistry.GARLIC_CROP.get())
                        .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(GarlicCropBlock.AGE, 5))));

        this.dropSelf(BlockRegistry.STEEL_BLOCK.get());
        this.dropSelf(BlockRegistry.WATER_SPRING_BLOCK.get());
        this.dropSelf(BlockRegistry.LAVA_SPRING_BLOCK.get());
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return BlockRegistry.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}