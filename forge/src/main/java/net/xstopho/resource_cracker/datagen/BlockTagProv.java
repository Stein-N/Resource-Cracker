package net.xstopho.resource_cracker.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.xstopho.resource_cracker.Constants;
import net.xstopho.resource_cracker.registries.BlockRegistry;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class BlockTagProv extends BlockTagsProvider {
    public BlockTagProv(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Constants.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(BlockRegistry.STEEL_BLOCK.get(), BlockRegistry.LAVA_SPRING_BLOCK.get(),
                     BlockRegistry.WATER_SPRING_BLOCK.get());

        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(BlockRegistry.STEEL_BLOCK.get(), BlockRegistry.LAVA_SPRING_BLOCK.get(),
                        BlockRegistry.WATER_SPRING_BLOCK.get());
    }
}
