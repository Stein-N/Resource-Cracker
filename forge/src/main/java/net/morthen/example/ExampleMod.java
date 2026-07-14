package net.morthen.example;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(ExampleConstants.MOD_ID)
public class ExampleMod {
    public ExampleMod(FMLJavaModLoadingContext context) {
        System.out.println("ExampleMod Loaded");
    }
}
