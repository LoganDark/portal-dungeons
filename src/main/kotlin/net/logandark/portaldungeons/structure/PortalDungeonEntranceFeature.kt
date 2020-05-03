package net.logandark.portaldungeons.structure

import net.logandark.portaldungeons.PortalDungeons
import net.logandark.portaldungeons.SelfRegistering
import net.logandark.portaldungeons.block.BricksBlock
import net.minecraft.structure.StructureManager
import net.minecraft.structure.StructureStart
import net.minecraft.util.math.*
import net.minecraft.util.registry.Registry
import net.minecraft.world.Heightmap
import net.minecraft.world.IWorld
import net.minecraft.world.biome.Biome
import net.minecraft.world.biome.source.BiomeAccess
import net.minecraft.world.gen.GenerationStep
import net.minecraft.world.gen.chunk.ChunkGenerator
import net.minecraft.world.gen.decorator.ChanceDecoratorConfig
import net.minecraft.world.gen.decorator.Decorator
import net.minecraft.world.gen.feature.*
import net.minecraft.world.gen.feature.StructureFeature.StructureStartFactory
import java.util.*
import java.util.function.Function

object PortalDungeonEntranceFeature : AbstractTempleFeature<DefaultFeatureConfig>(
	Function { DefaultFeatureConfig.deserialize(it) }
), SelfRegistering {
	override fun shouldStartAt(
		biomeAccess: BiomeAccess?,
		chunkGenerator: ChunkGenerator<*>?,
		random: Random?,
		chunkZ: Int,
		i: Int,
		biome: Biome?
	): Boolean {
		return true
	}

	override fun getName() = "Portal Dungeon"
	override fun getRadius() = 8
	override fun getSeedModifier() = 0

	override fun getStructureStartFactory() = StructureStartFactory(::PortalDungeonEntranceStart)

	class PortalDungeonEntranceStart(
		feature: StructureFeature<*>,
		chunkX: Int,
		chunkZ: Int,
		box: BlockBox,
		references: Int,
		worldSeed: Long
	) : StructureStart(feature, chunkX, chunkZ, box, references, worldSeed) {
		override fun initialize(
			chunkGenerator: ChunkGenerator<*>,
			structureManager: StructureManager,
			chunkX: Int,
			chunkZ: Int,
			biome: Biome
		) {
			val chunkPos = ChunkPos(chunkX, chunkZ)
			this.boundingBox = BlockBox.create(
				chunkPos.startX,
				0,
				chunkPos.startZ,
				chunkPos.endX,
				255,
				chunkPos.endZ
			)
		}

		override fun hasChildren() = true

		override fun generateStructure(
			world: IWorld,
			chunkGenerator: ChunkGenerator<*>,
			random: Random,
			blockBox: BlockBox,
			chunkPos: ChunkPos
		) {
			println("hi")
			val x = chunkPos.startX + random.nextInt(15)
			val z = chunkPos.startZ + random.nextInt(15)
			val pos = BlockPos(x, chunkGenerator.getHeightOnGround(x, z, Heightmap.Type.WORLD_SURFACE_WG) - 1, z)
			val facing = Direction.fromHorizontal(this.random.nextInt(4))

			for (zOff in -1..1) {
				for (xOff in -1..1) {
					world.setBlockState(pos.add(xOff, 0, zOff), BricksBlock.defaultState, 0)
				}
			}

			val left = facing.rotateYClockwise().vector
			val front = facing.vector
			val up = Vec3i(0, 1, 0)

			world.setBlockState(pos.add(left).add(up), BricksBlock.defaultState, 0)
			world.setBlockState(pos.add(left).add(up).add(up), BricksBlock.defaultState, 0)
			world.setBlockState(pos.add(left).add(up).add(up).add(up), BricksBlock.defaultState, 0)
			world.setBlockState(pos.add(up).add(up).add(up), BricksBlock.defaultState, 0)
			world.setBlockState(pos.subtract(left).add(up).add(up).add(up), BricksBlock.defaultState, 0)
			world.setBlockState(pos.subtract(left).add(up).add(up), BricksBlock.defaultState, 0)
			world.setBlockState(pos.subtract(left).add(up), BricksBlock.defaultState, 0)
		}
	}

	override fun register() {
		Registry.register(Registry.FEATURE, PortalDungeons.identifier("dungeon_feature"), this)
		Registry.register(Registry.STRUCTURE_FEATURE, PortalDungeons.identifier("dungeon_structure"), this)
		Feature.STRUCTURES[this.name] = this

		for (biome in Registry.BIOME) {
			val configured = this.configure(FeatureConfig.DEFAULT)

			biome.addStructureFeature(configured)
			biome.addFeature(
				GenerationStep.Feature.SURFACE_STRUCTURES, configured.createDecoratedFeature(
					Decorator.CHANCE_PASSTHROUGH.configure(
						ChanceDecoratorConfig(0)
					)
				)
			)
		}
	}
}
