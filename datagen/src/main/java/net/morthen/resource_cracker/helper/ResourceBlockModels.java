package net.morthen.resource_cracker.helper;

import com.mojang.math.Quadrant;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.MultiVariant;
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.client.data.models.blockstates.PropertyDispatch;
import net.minecraft.client.data.models.model.ModelTemplate;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.data.models.model.TextureSlot;
import net.minecraft.client.renderer.block.dispatch.VariantMutator;
import net.minecraft.client.resources.model.sprite.Material;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.Fluid;
import net.morthen.resource_cracker.CrackerConstants;
import net.morthen.resourcelibrary.registration.RegistryObject;

import java.util.Optional;

public class ResourceBlockModels {
    private final BlockModelGenerators generator;

    public ResourceBlockModels(BlockModelGenerators generator) {
        this.generator = generator;
    }


    public Identifier createSpringBlock(RegistryObject<Block> block, Fluid fluid, Identifier identifier) {
        TextureMapping textureMap = new TextureMapping();
        textureMap.put(TextureSlot.INSIDE, new Material(identifier));

        ModelTemplate modelTemplate = new ModelTemplate(
                Optional.of(CrackerConstants.of("block/spring_block")),
                Optional.empty(), TextureSlot.INSIDE);

        Identifier modelLocation = modelTemplate.create(block.get(), textureMap, generator.modelOutput);
        generator.blockStateOutput.accept(MultiVariantGenerator.dispatch(block.get()).with(createPropertyDispatch(modelLocation)));

        return modelLocation;
    }

    private PropertyDispatch<MultiVariant> createPropertyDispatch(Identifier location) {
        MultiVariant model = BlockModelGenerators.plainVariant(location);

        return PropertyDispatch.initial(BlockStateProperties.HORIZONTAL_FACING)
                .select(Direction.NORTH, model)
                .select(Direction.EAST, model.with(VariantMutator.Y_ROT.withValue(Quadrant.R90)))
                .select(Direction.SOUTH, model.with(VariantMutator.Y_ROT.withValue(Quadrant.R180)))
                .select(Direction.WEST, model.with(VariantMutator.Y_ROT.withValue(Quadrant.R270)));
    }

    private Identifier getKey(Fluid fluid) {
        return BuiltInRegistries.FLUID.getKey(fluid).withPrefix("block/");
    }
}
