package net.xstopho.resource_cracker.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;
import net.xstopho.resource_cracker.registries.BlockRegistry;

import java.util.concurrent.CompletableFuture;

public class BlockTagProv extends FabricTagProvider.BlockTagProvider{
    public BlockTagProv(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider arg) {
        getOrCreateTagBuilder(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(BlockRegistry.STEEL_BLOCK.get(), BlockRegistry.LAVA_SPRING_BLOCK.get(), BlockRegistry.WATER_SPRING_BLOCK.get());

        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(BlockRegistry.STEEL_BLOCK.get(), BlockRegistry.LAVA_SPRING_BLOCK.get(), BlockRegistry.WATER_SPRING_BLOCK.get());
    }
}
