package net.logandark.portaldungeons

import net.fabricmc.api.ModInitializer
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
	}

	fun identifier(path: String) = Identifier(modid, path)
}
