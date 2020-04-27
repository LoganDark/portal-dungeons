package net.logandark.portaldungeons

import io.github.prospector.modmenu.api.ConfigScreenFactory
import io.github.prospector.modmenu.api.ModMenuApi
import me.shedaniel.clothconfig2.api.ConfigBuilder
import net.minecraft.client.gui.screen.Screen

@Suppress("unused")
class ModMenuConfig : ModMenuApi {
	override fun getModId() = "portal-dungeons"

	override fun getModConfigScreenFactory(): ConfigScreenFactory<Screen> {
		return ConfigScreenFactory { parent ->
			val builder = ConfigBuilder.create()
			val entryBuilder = builder.entryBuilder()

			val spawningCategory = builder.getOrCreateCategory("$modId.config.category_spawning")

			val spawnChanceSlider = entryBuilder
				.startIntSlider("$modId.config.spawn_chance", 25, 0, 100)
				.setTooltip("$modId.config.spawn_chance.tooltip")
				.setDefaultValue(25)
				.build()

			val roomChanceSlider = entryBuilder
				.startIntSlider("$modId.config.room_chance", 50, 0, 100)
				.setTooltip("$modId.config.room_chance.tooltip")
				.setDefaultValue(50)
				.build()

			spawningCategory.addEntry(spawnChanceSlider)
			spawningCategory.addEntry(roomChanceSlider)

			builder
				.setParentScreen(parent)
				.setSavingRunnable {
					println(spawnChanceSlider)
					println(roomChanceSlider)
				}
				.build()
		}
	}
}
