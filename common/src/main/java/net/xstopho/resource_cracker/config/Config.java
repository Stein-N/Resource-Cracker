package net.xstopho.resource_cracker.config;

import net.xstopho.simpleconfig.builder.SimpleConfigBuilder;

import java.util.function.Supplier;

public class Config {
    public static final SimpleConfigBuilder BUILDER = new SimpleConfigBuilder();

    public static final Supplier<Integer>
            CRACK_HAMMER_COPPER, CRACK_HAMMER_GOLD, CRACK_HAMMER_IRON, CRACK_HAMMER_STEEL, CRACK_HAMMER_DIAMOND, CRACK_HAMMER_NETHERITE,
            CHISEL_COPPER, CHISEL_GOLD, CHISEL_IRON, CHISEL_STEEL, CHISEL_DIAMOND, CHISEL_NETHERITE,
            SCYTHE_RADIUS;

    public static final Supplier<Double>
            DIAMOND_NUGGET_FROM_COAL_ORE, DIAMOND_NUGGET_FROM_DIAMOND_ORE,
            GARLIC_FROM_ZOMBIE, SULFUR_FROM_CREEPER, SALTPETER_FROM_CREEPER,
            SALTPETER_FROM_BRICKS;

    public static final Supplier<Double>
            SULFUR, SALTPETER, GARLIC,
            NUGGET_DIAMOND,
            DUST_COPPER, DUST_IRON, DUST_GOLD, DUST_CARBON, DUST_STEEL, DUST_EMERALD, DUST_DIAMOND, DUST_NETHERITE_SCRAP, DUST_NETHERITE,
            HAMMER_COPPER, HAMMER_IRON, HAMMER_STEEL,
            STEEL_INGOT;

    static {
        BUILDER.push("Crack Hammer Durability");

        CRACK_HAMMER_COPPER = BUILDER.define("copper", 64);
        CRACK_HAMMER_GOLD = BUILDER.define("gold", 96);
        CRACK_HAMMER_IRON = BUILDER.define("iron", 128);
        CRACK_HAMMER_STEEL = BUILDER.define("steel", 160);
        CRACK_HAMMER_DIAMOND = BUILDER.define("diamond", 256);
        CRACK_HAMMER_NETHERITE = BUILDER.define("netherite", 384);

        BUILDER.pop().push("Chisel Durability");

        CHISEL_COPPER = BUILDER.define("copper", 10);
        CHISEL_GOLD = BUILDER.define("gold", 15);
        CHISEL_IRON = BUILDER.define("iron", 30);
        CHISEL_STEEL = BUILDER.define("steel", 45);
        CHISEL_DIAMOND = BUILDER.define("diamond", 64);
        CHISEL_NETHERITE = BUILDER.define("netherite", 96);

        BUILDER.pop().push("Scythe Harvest Radius");

        SCYTHE_RADIUS = BUILDER.defineInRange("radius", 1, 1, 3);

        BUILDER.pop().push("Block and Mob Loot Settings");

        DIAMOND_NUGGET_FROM_DIAMOND_ORE = BUILDER.comment("Determine the chance with which an item can drop from Ores and Mobs.\n 0.0 = 0% ~ 1.0 = 100%")
                .define("diamond_nugget_from_diamond_ore", 0.15);
        DIAMOND_NUGGET_FROM_COAL_ORE = BUILDER.define("diamond_nugget_from_coal_ore", 0.025);
        GARLIC_FROM_ZOMBIE = BUILDER.define("garlic_from_zombie", 0.20);
        SULFUR_FROM_CREEPER = BUILDER.define("sulfur_from_creeper", 0.20);
        SALTPETER_FROM_CREEPER = BUILDER.define("saltpeter_from_creeper", 0.20);
        SALTPETER_FROM_BRICKS = BUILDER.define("saltpeter_from_bricks", 0.50);

        BUILDER.pop().push("Structure Loot Settings");

        SULFUR = BUILDER.comment("Determine the chance with which an item could be generated in any structures.\n 0.0 = 0% ~ 1.0 = 100%")
                .define("sulfur_dust", 0.25);
        SALTPETER = BUILDER.define("saltpeter_dust", 0.25);
        DUST_COPPER = BUILDER.define("copper_dust", 0.25);
        DUST_IRON = BUILDER.define("iron_dust", 0.20);
        DUST_GOLD = BUILDER.define("gold_dust", 0.20);
        DUST_CARBON = BUILDER.define("carbon_dust", 0.40);
        DUST_DIAMOND = BUILDER.define("diamond_dust", 0.10);
        DUST_EMERALD = BUILDER.define("emerald_dust", 0.10);
        DUST_STEEL = BUILDER.define("steel_dust", 0.20);
        DUST_NETHERITE_SCRAP = BUILDER.define("netherite_scrap_dust", 0.05);
        DUST_NETHERITE = BUILDER.define("netherite_dust", 0.05);

        NUGGET_DIAMOND = BUILDER.define("diamond_nugget", 0.10);

        STEEL_INGOT = BUILDER.define("steel_ingot", 0.10);

        GARLIC = BUILDER.define("garlic", 0.40);

        HAMMER_COPPER = BUILDER.define("copper_crack_hammer", 0.15);
        HAMMER_IRON = BUILDER.define("iron_crack_hammer", 0.10);
        HAMMER_STEEL = BUILDER.define("steel_crack_hammer", 0.08);
    }
}
