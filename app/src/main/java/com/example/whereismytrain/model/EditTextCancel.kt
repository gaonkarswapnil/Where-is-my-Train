package com.example.whereismytrain.model

import android.view.MotionEvent
import android.widget.EditText

object EditTextCancel {
    fun setClearIconListener(editText: EditText) {
        editText.setOnTouchListener { v, event ->
            val drawableEnd = 2
            if (event.action == MotionEvent.ACTION_UP) {
                // Check if the touch event is inside the bounds of the drawableEnd icon
                if (event.rawX >= (editText.right - editText.compoundDrawables[drawableEnd].bounds.width())) {
                    editText.text.clear()
                }
            }
            false
        }
    }
}