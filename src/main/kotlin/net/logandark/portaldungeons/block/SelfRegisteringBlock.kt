package net.logandark.portaldungeons.block

import net.logandark.portaldungeons.SelfRegistering
import net.minecraft.block.Block
import net.minecraft.block.Material
import net.minecraft.item.BlockItem
import net.minecraft.item.Item
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry

abstract class SelfRegisteringBlock(
	private val identifier: Identifier,
	settings: Settings = Settings.of(Material.AIR),
	itemSettings: Item.Settings = Item.Settings()
) : Block(settings), SelfRegistering {
	@Suppress("LeakingThis")
	val item = BlockItem(this, itemSettings)

	override fun register() {
		Registry.register(Registry.BLOCK, identifier, this)
		Registry.register(Registry.ITEM, identifier, item)
	}
}
