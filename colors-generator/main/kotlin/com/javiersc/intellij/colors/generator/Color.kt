package com.javiersc.intellij.colors.generator

import com.javiersc.kotlin.stdlib.capitalize

data class ColorGroup(
    val name: String,
    val color: Color,
    val onColor: Color,
    val container: Color,
    val onContainer: Color,
) {

    val surface1: Color = color.copy(color.hex.copy(0.05))
    val surface2: Color = color.copy(color.hex.copy(0.08))
    val surface3: Color = color.copy(color.hex.copy(0.11))
    val surface4: Color = color.copy(color.hex.copy(0.12))
    val surface5: Color = color.copy(color.hex.copy(0.14))

    val colors: List<String> = buildList {
        add(""""$name": "$color"""")
        add(""""on${name.capitalize()}": "$onColor"""")
        add(""""${name}Container": "$container"""")
        add(""""on${name.capitalize()}Container": "$onContainer"""")
        add(""""${name}Surface1": "$surface1"""")
        add(""""${name}Surface2": "$surface2"""")
        add(""""${name}Surface3": "$surface3"""")
        add(""""${name}Surface4": "$surface4"""")
        add(""""${name}Surface5": "$surface5"""")
    }
}

@JvmInline
value class Color(val hex: Hex) {

    fun copy(hex: Hex) = Color(hex)

    override fun toString(): String = hex.value
}

@JvmInline
value class Hex(val value: String) {

    fun copy(opacity: Double): Hex {
        require(opacity in 0.0..1.0)
        val opacityValue = (opacity * 255).toInt()
        val hexValue = Integer.toHexString(opacityValue)
        return Hex(if (hexValue.length == 1) "0$hexValue" else hexValue)
    }

    override fun toString(): String = value
}
