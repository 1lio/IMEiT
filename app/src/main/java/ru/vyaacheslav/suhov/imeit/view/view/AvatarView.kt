package ru.vyaacheslav.suhov.imeit.view.view

import android.content.Context
import android.graphics.*
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.VectorDrawable
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.content.ContextCompat
import ru.vyaacheslav.suhov.imeit.R

/** Custom view - User Avatar */

class AvatarView : AppCompatImageView {

    // Дефолтные значения
    companion object {
        private const val DEF_SPACING = 16f             // Отступ
        private const val DEF_STROKE_COLOR = 62141784   // Цвет обводки в binary
        private const val DEF_STROKE_WIDTH = 0          // Размер обводки
    }

    // Переменные рисования.
    private var paint: Paint = Paint()
    private lateinit var image: Bitmap
    private lateinit var shader: Shader

    // Переменные размеров
    private var padding = 18f
    private var radius = 0f

    // Переменные атрибутов
    private var strokeColor: Int = 0
    private var strokeWidth: Float = 0f

    // Статус инициализации
    private var isInitialized: Boolean = false
    // Статус пользователя
    private var isCheckedStatus: Boolean = false

    // Конструкторы
    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {

        // Прикручиваем атрибуты
        val a = context.obtainStyledAttributes(attrs, R.styleable.AvatarView, 0, 0)

        try {
            // инициализируем атрибуты
            strokeColor = a.getColor(R.styleable.AvatarView_strokeColor, DEF_STROKE_COLOR)
            strokeWidth = a.getDimensionPixelSize(R.styleable.AvatarView_strokeWidth, DEF_STROKE_WIDTH).toFloat()

        } finally {
            // recycle() должен выполниться в любом случае
            a.recycle()
        }
    }

    // Вызывается когда нашу вью пытаются измерить :з
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        // Размеры вью по минимальной стороне
        val size = if (widthMeasureSpec <= heightMeasureSpec) widthMeasureSpec else heightMeasureSpec
        // устанавливаем финальный размер
        setMeasuredDimension(size, size)
    }

    // Рисуем нашу view
    override fun onDraw(canvas: Canvas) {
        if (!isInitialized) {
            val min = Math.min(height, width)
            padding = DEF_SPACING
            radius = min / 2 - padding
            isInitialized = true
        }
        // Рисуем аватарку если тип не совподает рисуем цвет
        if (this.drawable is BitmapDrawable) drawImage(canvas) else drawOvalFullColor(canvas)
        drawStroke(canvas)  // Рисуем обводку, поверх аватарки
    }

    // Рисуем картинку
    private fun drawImage(canvas: Canvas) {
        val bitmapDrawable: BitmapDrawable = this.drawable as BitmapDrawable
        val sMode = Shader.TileMode.CLAMP
        paint.reset()
        // Берем картинку, устанавливаем на BitMap
        image = bitmapDrawable.bitmap
        // Установим шейдер
        shader = BitmapShader(image, sMode, sMode)
        shader = BitmapShader(Bitmap.createScaledBitmap(image, canvas.width, canvas.height, false), sMode, sMode)
        paint.shader = shader
        // Обрезаем шейдер ввиде круга
        val circleCenter = width.toFloat() / 2
        canvas.drawCircle(circleCenter, circleCenter, circleCenter - 4.0f, paint)
    }

    // Рисуем цветной круг вместо картинки
    private fun drawOvalFullColor(canvas: Canvas) {
        paint(Paint.Style.FILL_AND_STROKE)
        val colorDrawable = try {
            this@AvatarView.drawable as ColorDrawable
        } catch (e: Exception) {
            this@AvatarView.drawable as VectorDrawable
        }

        paint.color = if (colorDrawable is ColorDrawable) colorDrawable.color else ContextCompat.getColor(context, R.color.white)
        val circleCenter = width.toFloat() / 2
        canvas.drawCircle(circleCenter, circleCenter, circleCenter - 4.0f, paint)
    }

    // Рисуем обводку поверх BitMap
    private fun drawStroke(canvas: Canvas) {
        if (strokeWidth > 0) {
            paint(Paint.Style.STROKE, strokeWidth)
            // Определяем центр и обводим по кргуг
            val center: Float = height.toFloat() / 2
            canvas.drawCircle(center, center, center - 4.0f, paint)
        }
    }

    private fun paint(style: Paint.Style, width: Float = 0f) {
        paint.reset()             // сбросим нашу кисть
        paint.style = style       // стиль
        paint.strokeWidth = width // размер
        paint.isAntiAlias = true  // Включить сглаживание
        paint.color = if (isCheckedStatus) ContextCompat.getColor(context, R.color.colorAccent) else strokeColor
    }
}