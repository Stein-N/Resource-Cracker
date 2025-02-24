package net.xstopho.resource_cracker.provider;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.xstopho.resource_cracker.CrackerConstants;
import net.xstopho.resource_cracker.registries.BlockRegistry;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class BlockTags extends BlockTagsProvider {
    public BlockTags(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, CrackerConstants.MOD_ID, existingFileHelper);
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
