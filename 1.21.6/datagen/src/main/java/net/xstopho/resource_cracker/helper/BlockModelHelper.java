package net.xstopho.resource_cracker.helper;

import com.mojang.math.Quadrant;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.MultiVariant;
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.client.data.models.blockstates.PropertyDispatch;
import net.minecraft.client.data.models.model.ItemModelUtils;
import net.minecraft.client.data.models.model.ModelTemplate;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.data.models.model.TextureSlot;
import net.minecraft.client.renderer.block.model.VariantMutator;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.xstopho.resource_cracker.CrackerConstants;

import java.util.Optional;

public class BlockModelHelper {

    public static void createLavaSpring(BlockModelGenerators generator, Block block) {
        createSpringBlock(generator, block, ResourceLocation.withDefaultNamespace("block/lava_still"));
    }

    public static void createWaterSpring(BlockModelGenerators generator, Block block) {
        createSpringBlock(generator, block, ResourceLocation.withDefaultNamespace("block/water_still"));

        ResourceLocation location = getKey(block).withPrefix("block/");
        generator.itemModelOutput.accept(block.asItem(), ItemModelUtils.tintedModel(location, ItemModelUtils.constantTint(0x3F76E4)));
    }

    public static void createSpringBlock(BlockModelGenerators generator, Block block, ResourceLocation fluid) {
        TextureMapping map = new TextureMapping();
        map.put(TextureSlot.INSIDE, fluid);

        ResourceLocation model = new ModelTemplate(Optional.of(CrackerConstants.of("block/spring_block")),
                Optional.empty(), TextureSlot.INSIDE).create(block, map, generator.modelOutput);
        generator.blockStateOutput.accept(MultiVariantGenerator.dispatch(block).with(createPropertyDispatch(model)));
        new ModelTemplate(Optional.of(model), Optional.empty()).create(block.asItem(), new TextureMapping(), generator.modelOutput);
    }

    private static PropertyDispatch<MultiVariant> createPropertyDispatch(ResourceLocation location) {
        MultiVariant model = BlockModelGenerators.plainVariant(location);

        return PropertyDispatch.initial(BlockStateProperties.HORIZONTAL_FACING)
                .select(Direction.NORTH, model)
                .select(Direction.EAST, model.with(VariantMutator.Y_ROT.withValue(Quadrant.R90)))
                .select(Direction.SOUTH, model.with(VariantMutator.Y_ROT.withValue(Quadrant.R180)))
                .select(Direction.WEST, model.with(VariantMutator.Y_ROT.withValue(Quadrant.R270)));
    }

    private static ResourceLocation getKey(Block block) {
        return BuiltInRegistries.BLOCK.getKey(block);
    }
}
