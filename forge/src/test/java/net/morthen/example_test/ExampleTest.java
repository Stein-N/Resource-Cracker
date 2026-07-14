package net.morthen.example_test;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(ExampleTestConstants.MOD_ID)
public class ExampleTest {
    public ExampleTest(FMLJavaModLoadingContext context) {
        ExampleTestConstants.LOGGER.info("Loading ExampleTest");
    }
}
