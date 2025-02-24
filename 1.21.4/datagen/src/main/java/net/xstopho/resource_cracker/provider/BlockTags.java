package net.xstopho.resource_cracker.provider;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.xstopho.resource_cracker.CrackerConstants;
import net.xstopho.resource_cracker.registries.BlockRegistry;

import java.util.concurrent.CompletableFuture;

public class BlockTags extends BlockTagsProvider {
    public BlockTags(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, CrackerConstants.MOD_ID);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE)
                .add(BlockRegistry.STEEL_BLOCK.get(), BlockRegistry.LAVA_SPRING_BLOCK.get(),
                        BlockRegistry.WATER_SPRING_BLOCK.get());

        this.tag(net.minecraft.tags.BlockTags.NEEDS_IRON_TOOL)
                .add(BlockRegistry.STEEL_BLOCK.get(), BlockRegistry.LAVA_SPRING_BLOCK.get(),
                        BlockRegistry.WATER_SPRING_BLOCK.get());
    }
}
