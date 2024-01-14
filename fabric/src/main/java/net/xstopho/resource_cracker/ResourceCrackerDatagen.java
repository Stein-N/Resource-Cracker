package net.xstopho.resource_cracker;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.xstopho.resource_cracker.datagen.*;

public class ResourceCrackerDatagen implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

        //pack.addProvider(LootProv::new);
        //pack.addProvider(ModelProv::new);
        pack.addProvider(BlockTagProv::new);
        pack.addProvider(ItemTagProv::new);
        pack.addProvider(RecipeProv::new);
    }
}