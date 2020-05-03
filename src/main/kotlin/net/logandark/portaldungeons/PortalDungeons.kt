package net.logandark.portaldungeons

import net.fabricmc.api.ModInitializer
import net.logandark.portaldungeons.block.*
import net.logandark.portaldungeons.structure.PortalDungeonEntranceFeature
import net.minecraft.util.Identifier

// For support join https://discord.gg/v6v4pMv

@Suppress("unused")
object PortalDungeons : ModInitializer {
	const val modid = "portal-dungeons"

	override fun onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		PortalDungeonsConfig.load()
		PortalDungeonsConfig.save()

		println("Hello Fabric world!")

		registerBlocks()

		PortalDungeonEntranceFeature.register()
	}

	private fun registerBlocks() {
		BricksBlock.register()
		MossyBricksBlock.register()
		CrackedBricksBlock.register()
		MossyCrackedBricksBlock.register()
		BrickStairsBlock.register()
		MossyBrickStairsBlock.register()
		CrackedBrickStairsBlock.register()
		MossyCrackedBrickStairsBlock.register()
		BrickSlabBlock.register()
		MossyBrickSlabBlock.register()
		CrackedBrickSlabBlock.register()
		MossyCrackedBrickSlabBlock.register()
		ChiseledBricksBlock.register()
		ChiseledMossyBricksBlock.register()
		ChiseledCrackedBricksBlock.register()
		ChiseledMossyCrackedBricksBlock.register()
		ChiseledBrickStairsBlock.register()
		ChiseledMossyBrickStairsBlock.register()
		ChiseledCrackedBrickStairsBlock.register()
		ChiseledMossyCrackedBrickStairsBlock.register()
		ChiseledBrickSlabBlock.register()
		ChiseledMossyBrickSlabBlock.register()
		ChiseledCrackedBrickSlabBlock.register()
		ChiseledMossyCrackedBrickSlabBlock.register()
		LanternBlock.register()
	}

	fun identifier(path: String) = Identifier(modid, path)
}
