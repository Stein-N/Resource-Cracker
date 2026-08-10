plugins {
    id("net.morthen.gradle.multiloader")
}

multiloader {
    loader = "datagen"
    neoForgeVersion = providers.gradleProperty("neoforge")

    applyMetadataReplacements(listOf("pack.mcmeta", "META-INF/neoforge.mods.toml"))
}