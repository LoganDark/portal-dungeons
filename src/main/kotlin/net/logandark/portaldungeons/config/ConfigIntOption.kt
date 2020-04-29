package net.logandark.portaldungeons.config

import com.google.gson.JsonElement
import com.google.gson.JsonPrimitive
import me.shedaniel.clothconfig2.api.AbstractConfigListEntry
import me.shedaniel.clothconfig2.api.ConfigEntryBuilder
import net.logandark.config.Config.ConfigOption
import net.minecraft.util.Identifier

@Suppress("MemberVisibilityCanBePrivate")
class ConfigIntOption(
	identifier: Identifier,
	category: String,
	defaultValue: Int,
	val minValue: Int,
	val maxValue: Int,
	tweakEntry: (AbstractConfigListEntry<Int>.() -> Unit)? = null
) : ConfigOption<Int>(identifier, category, defaultValue, tweakEntry) {
	override fun makeEntry(entryBuilder: ConfigEntryBuilder): AbstractConfigListEntry<Int> =
		entryBuilder
			.startIntSlider(translationKey, get(), minValue, maxValue)
			.setSaveConsumer(this::set)
			.build()

	override fun serialize(): JsonElement = JsonPrimitive(get())

	override fun deserialize(jsonElement: JsonElement) =
		if (jsonElement is JsonPrimitive && jsonElement.isNumber)
			jsonElement.asInt
		else
			error("Invalid JsonElement to deserialize")
}
