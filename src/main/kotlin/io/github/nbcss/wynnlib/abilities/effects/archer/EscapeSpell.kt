package io.github.nbcss.wynnlib.abilities.effects.archer

import com.google.gson.JsonObject
import io.github.nbcss.wynnlib.abilities.Ability
import io.github.nbcss.wynnlib.abilities.display.DamageTooltip
import io.github.nbcss.wynnlib.abilities.display.EffectTooltip
import io.github.nbcss.wynnlib.abilities.display.ManaCostTooltip
import io.github.nbcss.wynnlib.abilities.effects.AbilityEffect
import io.github.nbcss.wynnlib.abilities.effects.SpellUnlock
import io.github.nbcss.wynnlib.abilities.properties.DamageProperty

class EscapeSpell(parent: Ability, json: JsonObject): SpellUnlock(parent, json), DamageProperty {
    companion object: AbilityEffect.Factory {
        override fun create(parent: Ability, properties: JsonObject): EscapeSpell {
            return EscapeSpell(parent, properties)
        }
    }
    private val damage: DamageProperty.Damage = DamageProperty.readDamage(json)

    override fun getDamage(): DamageProperty.Damage = damage

    override fun getTooltipItems(): List<EffectTooltip> {
        return listOf(ManaCostTooltip, DamageTooltip)
    }
}