package com.weayrihs.touchcontrollerscalibrating

import android.animation.ObjectAnimator
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

		title = "Immobilize controller and pull the trigger or \"A\" to calibrate"
    }

	//	Простейшее анимированное перемещение (gliding)
	override fun onTouchEvent(event: MotionEvent): Boolean {
		val x = event.x.toInt()
		val y = event.y.toInt()
		when (event.action) {
			MotionEvent.ACTION_DOWN, MotionEvent.ACTION_BUTTON_PRESS   -> {
				// Получим ссылку на круг
				val circleImageView: ImageView = findViewById<View>(R.id.circle) as ImageView

				// Берем координаты нажатия
				val newX = (x - 480).toFloat()
				val newY = (y - 520).toFloat()

				// Анимация перемещения по координатам
				ObjectAnimator.ofFloat(circleImageView, View.TRANSLATION_X, newX).start()
				ObjectAnimator.ofFloat(circleImageView, View.TRANSLATION_Y, newY).start()
			}
		}
		return false
	}

	/*	Простейшее анимированное перемещение (gliding)

	override fun onTouchEvent(event: MotionEvent): Boolean {
		val x = event.x.toInt()
		val y = event.y.toInt()
		when (event.action) {
			MotionEvent.ACTION_DOWN, MotionEvent.ACTION_BUTTON_PRESS   -> {
				// Получим ссылку на круг
				val circleImageView: ImageView = findViewById<View>(R.id.circle) as ImageView

				// Берем координаты нажатия
				val newX = (x - 480).toFloat()
				val newY = (y - 520).toFloat()

				// Анимация перемещения по координатам
				ObjectAnimator.ofFloat(circleImageView, View.TRANSLATION_X, newX).start()
				ObjectAnimator.ofFloat(circleImageView, View.TRANSLATION_Y, newY).start()
			}
		}
		return false
	}
	*/

	/*	Простейшая телепортация (blink)

    override fun onTouchEvent(event: MotionEvent): Boolean {
        val x = event.x.toInt()
        val y = event.y.toInt()
        Log.e("Начальные координаты", "$x   $y")
        when (event.action) {
			MotionEvent.ACTION_MOVE, MotionEvent.ACTION_DOWN, MotionEvent.ACTION_BUTTON_PRESS -> {
				// Получим ссылку на круг
				val circleImageView: ImageView = findViewById<View>(R.id.circle) as ImageView
				// Берем координаты на данный момент
				val startX = circleImageView.x
				val startY = circleImageView.y

				// Берем координаты нажатия
				val newX = (x - 13).toFloat()
				val newY = (y - 92).toFloat()
				Log.e("Новые координаты", "$newX   $newY")

				// Телепортация
				circleImageView.x = newX
				circleImageView.y = newY
			}
        }
        return false
    }
	*/

}
