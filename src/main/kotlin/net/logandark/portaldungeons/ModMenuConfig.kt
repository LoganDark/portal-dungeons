package net.logandark.portaldungeons

import io.github.prospector.modmenu.api.ConfigScreenFactory
import io.github.prospector.modmenu.api.ModMenuApi
import net.minecraft.client.gui.screen.Screen

@Suppress("unused")
class ModMenuConfig : ModMenuApi {
	override fun getModId() = PortalDungeons.modid
	override fun getModConfigScreenFactory(): ConfigScreenFactory<Screen> =
		ConfigScreenFactory(PortalDungeonsConfig::createConfigScreen)
}
