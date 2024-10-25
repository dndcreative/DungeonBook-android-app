package com.mkvsk.dundgeonbook.utils

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatEditText
import com.mkvsk.dundgeonbook.R

class LinedEditText(context: Context, attrs: AttributeSet) : AppCompatEditText(context, attrs) {

    private var linePaint: Paint = Paint()

    init {
        linePaint.style = Paint.Style.STROKE
        linePaint.color = resources.getColor(R.color.white_opacity_20, null)
        linePaint.strokeWidth = 2f
    }

    override fun onDraw(canvas: Canvas) {
        val availableHeight = height
        val totalLineHeight = lineHeight
        val totalLines = lineCount
        val paddingTop = paddingTop
        val paddingBottom = paddingBottom

        val numberOfLines =
            totalLines.coerceAtLeast((availableHeight - paddingTop - paddingBottom) / totalLineHeight)

        for (i in 0..numberOfLines) {
            val baseline = (i + 1) * totalLineHeight + paddingTop
            canvas.drawLine(0f, baseline.toFloat(), width.toFloat(), baseline.toFloat(), linePaint)
        }

        super.onDraw(canvas)
    }
}
