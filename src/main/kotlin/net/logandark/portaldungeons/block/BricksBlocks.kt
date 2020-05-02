package net.logandark.portaldungeons.block

import net.logandark.portaldungeons.PortalDungeons

// @formatter:off
object BricksBlock : AbstractBricksBlock(PortalDungeons.identifier("bricks"))
object MossyBricksBlock : AbstractBricksBlock(PortalDungeons.identifier("bricks_mossy"))
object CrackedBricksBlock : AbstractBricksBlock(PortalDungeons.identifier("bricks_cracked"))
object MossyCrackedBricksBlock : AbstractBricksBlock(PortalDungeons.identifier("bricks_mossy_cracked"))
object BrickStairsBlock : AbstractBrickStairsBlock(PortalDungeons.identifier("brick_stairs"), BricksBlock.defaultState)
object MossyBrickStairsBlock : AbstractBrickStairsBlock(PortalDungeons.identifier("brick_stairs_mossy"), MossyBricksBlock.defaultState)
object CrackedBrickStairsBlock : AbstractBrickStairsBlock(PortalDungeons.identifier("brick_stairs_cracked"), CrackedBricksBlock.defaultState)
object MossyCrackedBrickStairsBlock : AbstractBrickStairsBlock(PortalDungeons.identifier("brick_stairs_mossy_cracked"), MossyCrackedBricksBlock.defaultState)
object BrickSlabBlock : AbstractBrickSlabBlock(PortalDungeons.identifier("brick_slab"))
object MossyBrickSlabBlock : AbstractBrickSlabBlock(PortalDungeons.identifier("brick_slab_mossy"))
object CrackedBrickSlabBlock : AbstractBrickSlabBlock(PortalDungeons.identifier("brick_slab_cracked"))
object MossyCrackedBrickSlabBlock : AbstractBrickSlabBlock(PortalDungeons.identifier("brick_slab_mossy_cracked"))
object ChiseledBricksBlock : AbstractBricksBlock(PortalDungeons.identifier("chiseled_bricks"))
object ChiseledMossyBricksBlock : AbstractBricksBlock(PortalDungeons.identifier("chiseled_bricks_mossy"))
object ChiseledCrackedBricksBlock : AbstractBricksBlock(PortalDungeons.identifier("chiseled_bricks_cracked"))
object ChiseledMossyCrackedBricksBlock : AbstractBricksBlock(PortalDungeons.identifier("chiseled_bricks_mossy_cracked"))
object ChiseledBrickStairsBlock : AbstractBrickStairsBlock(PortalDungeons.identifier("chiseled_brick_stairs"), BricksBlock.defaultState)
object ChiseledMossyBrickStairsBlock : AbstractBrickStairsBlock(PortalDungeons.identifier("chiseled_brick_stairs_mossy"), MossyBricksBlock.defaultState)
object ChiseledCrackedBrickStairsBlock : AbstractBrickStairsBlock(PortalDungeons.identifier("chiseled_brick_stairs_cracked"), CrackedBricksBlock.defaultState)
object ChiseledMossyCrackedBrickStairsBlock : AbstractBrickStairsBlock(PortalDungeons.identifier("chiseled_brick_stairs_mossy_cracked"), MossyCrackedBricksBlock.defaultState)
object ChiseledBrickSlabBlock : AbstractBrickSlabBlock(PortalDungeons.identifier("chiseled_brick_slab"))
object ChiseledMossyBrickSlabBlock : AbstractBrickSlabBlock(PortalDungeons.identifier("chiseled_brick_slab_mossy"))
object ChiseledCrackedBrickSlabBlock : AbstractBrickSlabBlock(PortalDungeons.identifier("chiseled_brick_slab_cracked"))
object ChiseledMossyCrackedBrickSlabBlock : AbstractBrickSlabBlock(PortalDungeons.identifier("chiseled_brick_slab_mossy_cracked"))
// @formatter:on
