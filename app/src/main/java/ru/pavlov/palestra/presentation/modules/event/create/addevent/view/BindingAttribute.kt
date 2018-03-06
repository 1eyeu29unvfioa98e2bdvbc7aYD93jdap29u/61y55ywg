package ru.pavlov.palestra.presentation.modules.event.create.addevent.view

import android.content.Context
import android.databinding.BindingAdapter
import android.graphics.drawable.GradientDrawable
import android.support.v4.content.ContextCompat
import android.util.DisplayMetrics
import android.util.TypedValue
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import palestra.kotlin.R
import ru.pavlov.palestra.data.models.EventCategories
import ru.pavlov.palestra.data.models.EventsType

const val STROKE_SIZE = 4

@BindingAdapter("addevent_category_checked")
fun categoryChecked(view: ImageView, event: EventCategories) {
    val context: Context = view.context
    val displayMetrics: DisplayMetrics = context.resources.displayMetrics
    val layoutParams: LinearLayout.LayoutParams = view.layoutParams as LinearLayout.LayoutParams

    val colorId = getNeedColor(event.eventType)
    val color = ContextCompat.getColor(context, colorId)
    var viewSize = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 14F, displayMetrics).toInt()

    val viewBackground = view.background
    when (event.checked) {
        true -> {
            when (viewBackground) {
                is GradientDrawable -> {
                    viewBackground.setColor(color)
                    viewBackground.setStroke(STROKE_SIZE, color)
                    viewSize = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 18F, displayMetrics).toInt()
                }
            }
        }
        false -> {
            when (viewBackground) {
                is GradientDrawable -> {
                    viewBackground.setColor(ContextCompat.getColor(context, R.color.colorWhite100))
                    viewBackground.setStroke(STROKE_SIZE, color)
                }
            }
        }
    }

    layoutParams.width = viewSize
    layoutParams.height = viewSize

    view.background = viewBackground
    view.layoutParams = layoutParams
}

private fun getNeedColor(eventType: EventsType): Int {
    return when (eventType) {
        EventsType.NO_FUN -> R.color.color_fun_event_type
        EventsType.MIDDLE_FUN -> R.color.color_middle_fun_event_type
        EventsType.FUN -> R.color.color_no_fun_event_type
    }
}
