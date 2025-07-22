package net.xstopho.resource_cracker.config;

import net.xstopho.resourceconfigapi.annotations.Config;
import net.xstopho.resourceconfigapi.annotations.ConfigEntry;
import net.xstopho.resourceconfigapi.annotations.RangedEntry;
import net.xstopho.resourceconfigapi.api.ConfigType;

@Config(fileName = "block_mob_loot", type = ConfigType.COMMON)
public class LootConfig {


    @ConfigEntry(category = "Block Loot", needsWorldRestart = true)
    @RangedEntry(minValue = 0, maxValue = 1)
    public static float copperNuggetFromOre = 0.1f;

    @ConfigEntry(category = "Block Loot", needsWorldRestart = true)
    @RangedEntry(minValue = 0, maxValue = 1)
    public static float diamondNuggetFromCoalOre = 0.03f;

    @ConfigEntry(category = "Block Loot", needsWorldRestart = true)
    @RangedEntry(minValue = 0, maxValue = 1)
    public static float diamondNuggetFromDiamondOre = 0.1f;

    @ConfigEntry(category = "Block Loot", needsWorldRestart = true)
    @RangedEntry(minValue = 0, maxValue = 1)
    public static float emeraldNuggetFromOre = 0.08f;

    @ConfigEntry(category = "Block Loot", needsWorldRestart = true)
    @RangedEntry(minValue = 0, maxValue = 1)
    public static float saltpeterFromBricks = 0.2f;


    @ConfigEntry(category = "Mob Loot", needsWorldRestart = true)
    @RangedEntry(minValue = 0, maxValue = 1)
    public static float garlicFromZombie = 0.1f;

    @ConfigEntry(category = "Mob Loot", needsWorldRestart = true)
    @RangedEntry(minValue = 0, maxValue = 1)
    public static float copperNuggetFromZombie = 0.1f;

    @ConfigEntry(category = "Mob Loot", needsWorldRestart = true)
    @RangedEntry(minValue = 0, maxValue = 1)
    public static float sulfurFromCreeper = 0.1f;

    @ConfigEntry(category = "Mob Loot", needsWorldRestart = true)
    @RangedEntry(minValue = 0, maxValue = 1)
    public static float saltpeterFromCreeper = 0.1f;


    @ConfigEntry(category = "Structure Loot", needsWorldRestart = true)
    @RangedEntry(minValue = 0, maxValue = 1)
    public static float sulfur = 0.25f;

    @ConfigEntry(category = "Structure Loot", needsWorldRestart = true)
    @RangedEntry(minValue = 0, maxValue = 1)
    public static float saltpeter = 0.25f;

    @ConfigEntry(category = "Structure Loot", needsWorldRestart = true)
    @RangedEntry(minValue = 0, maxValue = 1)
    public static float copperDust = 0.25f;

    @ConfigEntry(category = "Structure Loot", needsWorldRestart = true)
    @RangedEntry(minValue = 0, maxValue = 1)
    public static float ironDust = 0.2f;

    @ConfigEntry(category = "Structure Loot", needsWorldRestart = true)
    @RangedEntry(minValue = 0, maxValue = 1)
    public static float goldDust = 0.2f;

    @ConfigEntry(category = "Structure Loot", needsWorldRestart = true)
    @RangedEntry(minValue = 0, maxValue = 1)
    public static float carbonDust = 0.4f;

    @ConfigEntry(category = "Structure Loot", needsWorldRestart = true)
    @RangedEntry(minValue = 0, maxValue = 1)
    public static float diamondDust = 0.1f;

    @ConfigEntry(category = "Structure Loot", needsWorldRestart = true)
    @RangedEntry(minValue = 0, maxValue = 1)
    public static float emeraldDust = 0.1f;

    @ConfigEntry(category = "Structure Loot", needsWorldRestart = true)
    @RangedEntry(minValue = 0, maxValue = 1)
    public static float steelDust = 0.2f;

    @ConfigEntry(category = "Structure Loot", needsWorldRestart = true)
    @RangedEntry(minValue = 0, maxValue = 1)
    public static float netheriteScrapDust = 0.05f;

    @ConfigEntry(category = "Structure Loot", needsWorldRestart = true)
    @RangedEntry(minValue = 0, maxValue = 1)
    public static float netheriteDust = 0.05f;

    @ConfigEntry(category = "Structure Loot", needsWorldRestart = true)
    @RangedEntry(minValue = 0, maxValue = 1)
    public static float copperNugget = 0.2f;

    @ConfigEntry(category = "Structure Loot", needsWorldRestart = true)
    @RangedEntry(minValue = 0, maxValue = 1)
    public static float diamondNugget = 0.1f;

    @ConfigEntry(category = "Structure Loot", needsWorldRestart = true)
    @RangedEntry(minValue = 0, maxValue = 1)
    public static float emeraldNugget = 0.15f;

    @ConfigEntry(category = "Structure Loot", needsWorldRestart = true)
    @RangedEntry(minValue = 0, maxValue = 1)
    public static float steelIngot = 0.1f;

    @ConfigEntry(category = "Structure Loot", needsWorldRestart = true)
    @RangedEntry(minValue = 0, maxValue = 1)
    public static float garlic = 0.4f;

    @ConfigEntry(category = "Structure Loot", needsWorldRestart = true)
    @RangedEntry(minValue = 0, maxValue = 1)
    public static float copperHammer = 0.15f;

    @ConfigEntry(category = "Structure Loot", needsWorldRestart = true)
    @RangedEntry(minValue = 0, maxValue = 1)
    public static float ironHammer = 0.1f;

    @ConfigEntry(category = "Structure Loot", needsWorldRestart = true)
    @RangedEntry(minValue = 0, maxValue = 1)
    public static float steelHammer = 0.05f;
}
