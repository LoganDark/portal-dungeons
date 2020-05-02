package net.logandark.portaldungeons.block

import net.minecraft.block.BlockState
import net.minecraft.entity.EntityType
import net.minecraft.util.math.BlockPos
import net.minecraft.world.BlockView

object BricksCommon {
	// Only allow spawning when there is a ceiling (of any block) above
	fun allowsSpawning(state: BlockState, view: BlockView, pos: BlockPos, type: EntityType<*>): Boolean {
		var current = pos

		while (current.y < 256) {
			current = current.add(0, 1, 0)
			if (!view.getBlockState(current).isAir) return true
		}

		return false
	}
}
