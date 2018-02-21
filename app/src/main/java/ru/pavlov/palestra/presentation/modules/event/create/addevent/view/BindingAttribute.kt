package ru.pavlov.palestra.presentation.modules.event.create.addevent.view

import android.content.Context
import android.databinding.BindingAdapter
import android.graphics.drawable.GradientDrawable
import android.support.v4.content.ContextCompat
import android.widget.TextView
import palestra.kotlin.R
import ru.pavlov.palestra.data.models.EventCategories
import ru.pavlov.palestra.data.models.EventsType

const val STROKE_SIZE = 6

@BindingAdapter("addevent_category_checked")
fun categoryChecked(view: TextView, event: EventCategories) {
    val context: Context = view.context
    val colorId = getNeedColor(event.eventType)
    val color = ContextCompat.getColor(context, colorId)

    val LEFT_IMG_INDEX = 0
    val viewBackground = view.compoundDrawables[LEFT_IMG_INDEX]

    when (event.checked) {
        true -> {
            when (viewBackground) {
                is GradientDrawable -> {
                    viewBackground.setColor(color)
                    viewBackground.setStroke(STROKE_SIZE, color)
                }
            }
        }
        false -> {
            when (viewBackground) {
                is GradientDrawable -> {
                    viewBackground.setColor(ContextCompat.getColor(context, R.color.whiteColor100))
                    viewBackground.setStroke(STROKE_SIZE, color)
                }
            }
        }
    }

    view.setCompoundDrawablesWithIntrinsicBounds(viewBackground, null, null, null)
}

private fun getNeedColor(eventType: EventsType): Int {
    return when (eventType) {
        EventsType.NO_FUN -> R.color.color_fun_event_type
        EventsType.MIDDLE_FUN -> R.color.color_middle_fun_event_type
        EventsType.FUN -> R.color.color_no_fun_event_type
    }
}