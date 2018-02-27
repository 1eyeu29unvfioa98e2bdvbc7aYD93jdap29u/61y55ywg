package ru.pavlov.palestra.utils

import android.graphics.PorterDuff
import android.graphics.drawable.Drawable
import android.support.annotation.ColorInt
import android.support.v4.graphics.drawable.DrawableCompat

/**
 * Changes tint color for drawable
 *
 * @param drawable  Drawable resource
 * @param color     A color to be applied
 * @param forceTint true if apply tint for given drawable, false if generate the new one
 * @return Drawable with applied tint color
 */
fun Drawable.getTintDrawable(drawable: Drawable, @ColorInt color: Int, forceTint: Boolean): Drawable {
    if (forceTint) {
        drawable.clearColorFilter()
        drawable.setColorFilter(color, PorterDuff.Mode.SRC_IN)
        drawable.invalidateSelf()
        return drawable
    }
    val wrapDrawable: Drawable = DrawableCompat.wrap(drawable).mutate()
    DrawableCompat.setTint(wrapDrawable, color)
    return wrapDrawable
}