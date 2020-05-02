package net.logandark.portaldungeons.block

import net.logandark.portaldungeons.SelfRegistering
import net.minecraft.block.BlockState
import net.minecraft.block.Material
import net.minecraft.block.StairsBlock
import net.minecraft.item.BlockItem
import net.minecraft.item.Item
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry

abstract class SelfRegisteringStairsBlock(
	private val identifier: Identifier,
	baseBlockState: BlockState,
	settings: Settings = Settings.of(Material.AIR),
	itemSettings: Item.Settings = Item.Settings()
) : StairsBlock(baseBlockState, settings), SelfRegistering {
	@Suppress("LeakingThis")
	val item = BlockItem(this, itemSettings)

	override fun register() {
		Registry.register(Registry.BLOCK, identifier, this)
		Registry.register(Registry.ITEM, identifier, item)
	}
}
