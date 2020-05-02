package net.logandark.portaldungeons.block

import net.fabricmc.fabric.api.block.FabricBlockSettings
import net.logandark.portaldungeons.PortalDungeons
import net.minecraft.block.BlockState
import net.minecraft.block.Blocks
import net.minecraft.entity.EntityType
import net.minecraft.item.Item
import net.minecraft.item.ItemGroup
import net.minecraft.util.Rarity
import net.minecraft.util.math.BlockPos
import net.minecraft.world.BlockView

object LanternBlock : SelfRegisteringBlock(
	PortalDungeons.identifier("lantern"),
	FabricBlockSettings.copy(Blocks.STONE_BRICKS)
		.strength(-1f, Blocks.BEDROCK.blastResistance)
		.lightLevel(15)
		.build(),
	Item.Settings().rarity(Rarity.UNCOMMON).group(ItemGroup.BUILDING_BLOCKS)
) {
	override fun allowsSpawning(state: BlockState, view: BlockView, pos: BlockPos, type: EntityType<*>): Boolean {
		return BricksCommon.allowsSpawning(state, view, pos, type)
	}
}
