package net.morthen.resource_cracker.provider;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.morthen.resource_cracker.CrackerConstants;
import net.morthen.resource_cracker.registries.BlockRegistry;
import net.morthen.resourcelibrary.registration.RegistryObject;
import net.neoforged.neoforge.common.data.BlockTagsProvider;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class BlockTags extends BlockTagsProvider {
    public BlockTags(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, CrackerConstants.MOD_ID);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.addAll(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE,
                List.of(BlockRegistry.STEEL_BLOCK, BlockRegistry.LAVA_SPRING_BLOCK, BlockRegistry.WATER_SPRING_BLOCK));

        this.addAll(net.minecraft.tags.BlockTags.NEEDS_IRON_TOOL,
                List.of(BlockRegistry.STEEL_BLOCK, BlockRegistry.LAVA_SPRING_BLOCK, BlockRegistry.WATER_SPRING_BLOCK));
    }

    private void add(TagKey<Block> key, RegistryObject<Block> block) {
        Identifier id = block.getId();
        this.tag(key).add(ResourceKey.create(Registries.BLOCK, id));
    }

    private void addAll(TagKey<Block> key, List<RegistryObject<Block>> blocks) {
        blocks.forEach(block -> this.add(key, block));
    }
}
