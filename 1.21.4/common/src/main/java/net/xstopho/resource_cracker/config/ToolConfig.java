package net.xstopho.resource_cracker.config;

import net.xstopho.resourceconfigapi.annotations.Config;
import net.xstopho.resourceconfigapi.annotations.ConfigEntry;
import net.xstopho.resourceconfigapi.annotations.RangedEntry;
import net.xstopho.resourceconfigapi.api.ConfigType;

@Config(fileName = "tool_settings", type = ConfigType.COMMON)
public class ToolConfig {

    @ConfigEntry(category = "Scythe")
    @RangedEntry(minValue = 1, maxValue = 3)
    public static int scytheHarvestRadius = 1;

    @ConfigEntry(category = "Crack Hammer Durability", translation = "copper")
    public static int copperHammer = 64;

    @ConfigEntry(category = "Crack Hammer Durability", translation = "gold")
    public static int goldHammer = 96;

    @ConfigEntry(category = "Crack Hammer Durability", translation = "iron")
    public static int ironHammer = 128;

    @ConfigEntry(category = "Crack Hammer Durability", translation = "steel")
    public static int steelHammer = 160;

    @ConfigEntry(category = "Crack Hammer Durability", translation = "diamond")
    public static int diamondHammer = 256;

    @ConfigEntry(category = "Crack Hammer Durability", translation = "netherite")
    public static int netheriteHammer = 384;

    @ConfigEntry(category = "Chisel Durability", translation = "copper")
    public static int copperChisel = 10;

    @ConfigEntry(category = "Chisel Durability", translation = "gold")
    public static int goldChisel = 15;

    @ConfigEntry(category = "Chisel Durability", translation = "iron")
    public static int ironChisel = 30;

    @ConfigEntry(category = "Chisel Durability", translation = "steel")
    public static int steelChisel = 45;

    @ConfigEntry(category = "Chisel Durability", translation = "diamond")
    public static int diamondChisel = 64;

    @ConfigEntry(category = "Chisel Durability", translation = "netherite")
    public static int netheriteChisel = 96;
}
