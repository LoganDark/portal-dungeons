package net.logandark.portaldungeons

import net.fabricmc.api.ModInitializer

// For support join https://discord.gg/v6v4pMv

@Suppress("unused")
object PortalDungeons : ModInitializer {
	override fun onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		println("Hello Fabric world!")
	}
}
