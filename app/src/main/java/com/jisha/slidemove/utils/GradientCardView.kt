package com.jisha.slidemove.utils

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import com.google.android.material.card.MaterialCardView
import kotlin.math.cos
import kotlin.math.sin

class GradientCardView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : MaterialCardView(context, attrs, defStyleAttr) {

    private val strokePaint: Paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private var gradientColors: IntArray? = null
    private var strokeWidth: Float = 0f
    private var gradientAngle: Float = 0f

    init {
        strokePaint.style = Paint.Style.STROKE
    }

    fun setGradientStrokeColors(startColor: String, middleColor: String, endColor: String,width: Float, angle: Float) {
        try {
            strokeWidth = width
            gradientAngle = angle

            val colors = intArrayOf(
                Color.parseColor(startColor),
                Color.parseColor(middleColor),
                Color.parseColor(endColor)
            )
            gradientColors = colors
            invalidate() // Redraw the view
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        if (gradientColors != null && gradientColors!!.size >= 2) {
            val centerX = width.toFloat() / 2
            val centerY = height.toFloat() / 2
            val radius = (width - strokeWidth) / 2

            val angleRadians = Math.toRadians(gradientAngle.toDouble())
            val startX = centerX + radius * cos(angleRadians).toFloat()
            val startY = centerY + radius * sin(angleRadians).toFloat()
            val endX = centerX - radius * cos(angleRadians).toFloat()
            val endY = centerY - radius * sin(angleRadians).toFloat()

            val shader = LinearGradient(
                startX, startY, endX, endY,
                gradientColors!!, null, Shader.TileMode.CLAMP
            )
            strokePaint.shader = shader
            strokePaint.strokeWidth = strokeWidth

            val rect = RectF(
                strokeWidth / 2,
                strokeWidth / 2,
                width.toFloat() - strokeWidth / 2,
                height.toFloat() - strokeWidth / 2
            )

            canvas.drawRoundRect(rect, radius, radius, strokePaint)
        }
        /*  if (gradientColors != null && gradientColors!!.size >= 2) {
              val centerX = width.toFloat() / 2
              val centerY = height.toFloat() / 2
              val radius = (width - strokeWidth) / 2

              val shader = LinearGradient(
                  centerX - radius, centerY, centerX + radius, centerY,
                  gradientColors!!, null, Shader.TileMode.CLAMP
              )
              strokePaint.shader = shader
               strokePaint.strokeWidth = strokeWidth

              val rect = RectF(
                  strokeWidth / 2,
                  strokeWidth / 2,
                  width.toFloat() - strokeWidth / 2,
                  height.toFloat() - strokeWidth / 2
              )

              canvas.drawRoundRect(rect, radius, radius, strokePaint)
          }*/
    }
}
