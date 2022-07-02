package io.github.nbcss.wynnlib.abilities.effects.archer

import com.google.gson.JsonObject
import io.github.nbcss.wynnlib.abilities.Ability
import io.github.nbcss.wynnlib.abilities.display.*
import io.github.nbcss.wynnlib.abilities.effects.AbilityEffect
import io.github.nbcss.wynnlib.abilities.effects.SpellUnlock
import io.github.nbcss.wynnlib.abilities.properties.AreaOfEffectProperty
import io.github.nbcss.wynnlib.abilities.properties.DamageProperty
import io.github.nbcss.wynnlib.abilities.properties.RangeProperty

class ArrowBombSpell(parent: Ability, json: JsonObject): SpellUnlock(parent, json),
    DamageProperty, AreaOfEffectProperty, RangeProperty {
    companion object: AbilityEffect.Factory {
        override fun create(parent: Ability, properties: JsonObject): ArrowBombSpell {
            return ArrowBombSpell(parent, properties)
        }
    }
    private val range: Double = RangeProperty.read(json)
    private val damage: DamageProperty.Damage = DamageProperty.readDamage(json)
    private val aoe: AreaOfEffectProperty.AreaOfEffect = AreaOfEffectProperty.read(json)

    override fun getRange(): Double = range

    override fun getDamage(): DamageProperty.Damage = damage

    override fun getAreaOfEffect(): AreaOfEffectProperty.AreaOfEffect = aoe

    override fun getTooltipItems(): List<EffectTooltip> {
        return listOf(ManaCostTooltip, DamageTooltip, RangeTooltip, AreaOfEffectTooltip)
    }
}