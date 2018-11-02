package org.smwu.smwuandroid.ui.service_dialog

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.ContextMenu
import android.view.Window
import kotlinx.android.synthetic.main.dialog_service.*
import smwu.com.smwuandroid.R

class ServiceDialog(context: Context) : Dialog(context) {
    init {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        setContentView(R.layout.dialog_service)
        btn_dialog_exit.setOnClickListener {
            dismiss()
        }
    }
}