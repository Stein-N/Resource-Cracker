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
import net.minecraft.world.level.material.Fluid;
import net.xstopho.resource_cracker.CrackerConstants;
import net.xstopho.resourcelibrary.registration.RegistryObject;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

public class ResourceBlockModels {
    private final BlockModelGenerators generator;

    public ResourceBlockModels(BlockModelGenerators generator) {
        this.generator = generator;
    }

    public void createSpringBlock(RegistryObject<Block> block, Fluid fluid) {
        this.createSpringBlock(block, fluid, "minecraft:cutout");
    }

    public void createTintedSpringBlock(RegistryObject<Block> block, Fluid fluid, int value) {
        ResourceLocation modelLocation = this.createSpringBlock(block, fluid, "minecraft:cutout");
        generator.itemModelOutput.accept(block.get().asItem(), ItemModelUtils.tintedModel(modelLocation, ItemModelUtils.constantTint(value)));
    }

    private ResourceLocation createSpringBlock(RegistryObject<Block> block, Fluid fluid, @NotNull String renderType) {
        TextureMapping textureMap = new TextureMapping();
        textureMap.put(TextureSlot.INSIDE, getKey(fluid).withSuffix("_still"));

        ModelTemplate modelTemplate = new ModelTemplate(
                Optional.of(CrackerConstants.of("block/spring_block")),
                Optional.empty(), TextureSlot.INSIDE)
                .extend().renderType(renderType).build();

        ResourceLocation modelLocation = modelTemplate.create(block.get(), textureMap, generator.modelOutput);
        generator.blockStateOutput.accept(MultiVariantGenerator.dispatch(block.get()).with(createPropertyDispatch(modelLocation)));

        return modelLocation;
    }

    private PropertyDispatch<MultiVariant> createPropertyDispatch(ResourceLocation location) {
        MultiVariant model = BlockModelGenerators.plainVariant(location);

        return PropertyDispatch.initial(BlockStateProperties.HORIZONTAL_FACING)
                .select(Direction.NORTH, model)
                .select(Direction.EAST, model.with(VariantMutator.Y_ROT.withValue(Quadrant.R90)))
                .select(Direction.SOUTH, model.with(VariantMutator.Y_ROT.withValue(Quadrant.R180)))
                .select(Direction.WEST, model.with(VariantMutator.Y_ROT.withValue(Quadrant.R270)));
    }

    private ResourceLocation getKey(Fluid fluid) {
        return BuiltInRegistries.FLUID.getKey(fluid).withPrefix("block/");
    }
}
