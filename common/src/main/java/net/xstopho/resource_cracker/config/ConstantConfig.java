package net.xstopho.resource_cracker.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class ConstantConfig {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.ConfigValue<Integer>
            CRACK_HAMMER_COPPER, CRACK_HAMMER_GOLD, CRACK_HAMMER_IRON, CRACK_HAMMER_STEEL, CRACK_HAMMER_DIAMOND, CRACK_HAMMER_NETHERITE,
            CHISEL_COPPER, CHISEL_GOLD, CHISEL_IRON, CHISEL_STEEL, CHISEL_DIAMOND, CHISEL_NETHERITE,
            SCYTHE_RADIUS;

    public static final ForgeConfigSpec.ConfigValue<Float>
            SULFUR, SALTPETER, NETHERITE_SCRAP, NETHERITE, DIAMOND_NUGGET, GARLIC, HAMMER_COPPER, HAMMER_IRON, HAMMER_STEEL, COPPER_DUST,
            IRON_DUST, GOLD_DUST, CARBON_DUST, STEEL_DUST, EMERALD_DUST, DIAMOND_DUST, STEEL_INGOT;

    static {
        BUILDER.push("Tool Durability");

        CRACK_HAMMER_COPPER = BUILDER.define("Copper Crack Hammer", 64);
        CRACK_HAMMER_GOLD = BUILDER.define("Gold Crack Hammer", 96);
        CRACK_HAMMER_IRON = BUILDER.define("Iron Crack Hammer", 128);
        CRACK_HAMMER_STEEL = BUILDER.define("Steel Crack Hammer", 160);
        CRACK_HAMMER_DIAMOND = BUILDER.define("Diamond Crack Hammer", 256);
        CRACK_HAMMER_NETHERITE = BUILDER.define("Netherite Crack Hammer", 384);

        CHISEL_COPPER = BUILDER.define("Copper Chisel", 10);
        CHISEL_GOLD = BUILDER.define("Gold Chisel", 15);
        CHISEL_IRON = BUILDER.define("Iron Chisel", 30);
        CHISEL_STEEL = BUILDER.define("Steel Chisel", 45);
        CHISEL_DIAMOND = BUILDER.define("Diamond Chisel", 64);
        CHISEL_NETHERITE = BUILDER.define("Netherite Chisel", 96);

        BUILDER.pop().push("Scythe Harvest Radius");

        SCYTHE_RADIUS = BUILDER.defineInRange("radius", 1, 1, 3);

        BUILDER.pop().push("Loot Settings");

        SULFUR = BUILDER.comment("Determine the chance with which an item could be generated in structures.\n   0.0 = 0%    1.0 = 100%")
                .define("Sulfur Dust", 1f);
        SALTPETER = BUILDER.define("Saltpeter Dust", 0.5f);
        NETHERITE_SCRAP = BUILDER.define("Netherite Scrap Dust", 0.5f);
        NETHERITE = BUILDER.define("Netherite Dust", 0.5f);
        DIAMOND_NUGGET = BUILDER.define("Diamond Nugget", 0.5f);
        GARLIC = BUILDER.define("Garlic ", 0.5f);
        HAMMER_COPPER = BUILDER.define("Copper Crack Hammer", 0.5f);
        HAMMER_IRON = BUILDER.define("Iron Crack Hammer", 0.5f);
        HAMMER_STEEL = BUILDER.define("Steel Crack Hammer", 0.5f);

        COPPER_DUST = BUILDER.define("Copper Dust", 0.5f);
        IRON_DUST = BUILDER.define("Iron Dust", 0.5f);
        GOLD_DUST = BUILDER.define("Gold Dust", 0.5f);
        CARBON_DUST = BUILDER.define("Carbon Dust", 0.5f);
        DIAMOND_DUST = BUILDER.define("Diamond Dust", 0.5f);
        EMERALD_DUST = BUILDER.define("Emerald Dust", 0.5f);
        STEEL_DUST = BUILDER.define("Steel Dust", 0.5f);
        STEEL_INGOT = BUILDER.define("Steel Ingot", 0.5f);

        BUILDER.pop();

        SPEC = BUILDER.build();
    }
}
