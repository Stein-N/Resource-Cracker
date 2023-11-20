package net.xstopho.resource_cracker.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class ConstantConfig {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.ConfigValue<Integer>
            CRACK_HAMMER_COPPER, CRACK_HAMMER_GOLD, CRACK_HAMMER_IRON, CRACK_HAMMER_STEEL, CRACK_HAMMER_DIAMOND, CRACK_HAMMER_NETHERITE,
            CHISEL_COPPER, CHISEL_GOLD, CHISEL_IRON, CHISEL_STEEL, CHISEL_DIAMOND, CHISEL_NETHERITE,
            SCYTHE_RADIUS;

    public static final ForgeConfigSpec.ConfigValue<Double>
            DIAMOND_NUGGET_FROM_COAL, DIAMOND_NUGGET_FROM_DIAMOND, GARLIC_FROM_ZOMBIE, SULFUR_FROM_CREEPER, SALTPETER_FROM_CREEPER,
            SALTPETER_FROM_BRICKS;

    public static final ForgeConfigSpec.ConfigValue<Double>
            SULFUR, SALTPETER, NETHERITE_SCRAP, NETHERITE, DIAMOND_NUGGET, GARLIC, HAMMER_COPPER, HAMMER_IRON, HAMMER_STEEL, COPPER_DUST,
            IRON_DUST, GOLD_DUST, CARBON_DUST, STEEL_DUST, EMERALD_DUST, DIAMOND_DUST, STEEL_INGOT;

    static {
        BUILDER.push("Tool Durability");

        CRACK_HAMMER_COPPER = BUILDER.define("copperCrackHammer", 64);
        CRACK_HAMMER_GOLD = BUILDER.define("goldCrackHammer", 96);
        CRACK_HAMMER_IRON = BUILDER.define("ironCrackHammer", 128);
        CRACK_HAMMER_STEEL = BUILDER.define("steelCrackHammer", 160);
        CRACK_HAMMER_DIAMOND = BUILDER.define("diamondCrackHammer", 256);
        CRACK_HAMMER_NETHERITE = BUILDER.define("netheriteCrackHammer", 384);

        CHISEL_COPPER = BUILDER.define("copperChisel", 10);
        CHISEL_GOLD = BUILDER.define("goldChisel", 15);
        CHISEL_IRON = BUILDER.define("ironChisel", 30);
        CHISEL_STEEL = BUILDER.define("steelChisel", 45);
        CHISEL_DIAMOND = BUILDER.define("diamondCHisel", 64);
        CHISEL_NETHERITE = BUILDER.define("netheriteChisel", 96);

        BUILDER.pop().push("Scythe Harvest Radius");

        SCYTHE_RADIUS = BUILDER.defineInRange("radius", 1, 1, 3);

        BUILDER.pop().push("Block and Mob Loot Settings")
                .comment("Determine the chance with which an item can drop from Ores and Mobs.\n   0.0 = 0%    1.0 = 100%");

        DIAMOND_NUGGET_FROM_DIAMOND = BUILDER.define("diamondNuggetFromDiamondOre", 0.15);
        DIAMOND_NUGGET_FROM_COAL = BUILDER.define("diamondNuggetFromCoalOre", 0.025);
        GARLIC_FROM_ZOMBIE = BUILDER.define("garlicFromZombie", 0.20);
        SULFUR_FROM_CREEPER = BUILDER.define("sulfurFromCreeper", 0.20);
        SALTPETER_FROM_CREEPER = BUILDER.define("saltpeterFromCreeper", 0.20);
        SALTPETER_FROM_BRICKS = BUILDER.define("saltpeterFromBricks", 0.50);

        BUILDER.pop().push("Structure Loot Settings")
                .comment("Determine the chance with which an item could be generated in structures.\n   0.0 = 0%    1.0 = 100%");

        SULFUR = BUILDER.define("sulfurDust", 0.25);
        SALTPETER = BUILDER.define("saltpeterDust", 0.25);
        NETHERITE_SCRAP = BUILDER.define("netheriteScrapDust", 0.05);
        NETHERITE = BUILDER.define("netheriteDust", 0.05);
        GARLIC = BUILDER.define("garlic", 0.40);
        HAMMER_COPPER = BUILDER.define("copperCrackHammer", 0.15);
        HAMMER_IRON = BUILDER.define("ironCrackHammer", 0.10);
        HAMMER_STEEL = BUILDER.define("steelCrackHammer", 0.08);

        DIAMOND_NUGGET = BUILDER.define("diamondNugget", 0.10);
        COPPER_DUST = BUILDER.define("copperDust", 0.25);
        IRON_DUST = BUILDER.define("ironDust", 0.20);
        GOLD_DUST = BUILDER.define("goldDust", 0.20);
        CARBON_DUST = BUILDER.define("carbonDust", 0.40);
        DIAMOND_DUST = BUILDER.define("diamondDust", 0.10);
        EMERALD_DUST = BUILDER.define("emeraldDust", 0.10);
        STEEL_DUST = BUILDER.define("steelDust", 0.20);
        STEEL_INGOT = BUILDER.define("steelIngot", 0.10);

        BUILDER.pop();

        SPEC = BUILDER.build();
    }
}
