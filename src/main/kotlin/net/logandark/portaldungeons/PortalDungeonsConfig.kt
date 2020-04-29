package net.logandark.portaldungeons

import net.logandark.config.Config
import net.logandark.portaldungeons.config.ConfigIntOption

object PortalDungeonsConfig : Config("portal-dungeons.json", 1) {
	val spawnChance = add(
		ConfigIntOption(
			PortalDungeons.identifier("spawn_chance"),
			"spawning",
			25,
			0,
			100,
			null
		) as ConfigOption<Int>
	)

	val roomChance = add(
		ConfigIntOption(
			PortalDungeons.identifier("room_chance"),
			"spawning",
			50,
			0,
			100,
			null
		) as ConfigOption<Int>
	)
}
