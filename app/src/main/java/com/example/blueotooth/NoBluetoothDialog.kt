package com.example.blueotooth

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class NoBluetoothDialog : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            builder.setMessage("no bluetooth support").setPositiveButton("ok", DialogInterface.OnClickListener { dialog, id ->
                println(id)
                dialog.cancel()
            })
            builder.create()
        }?: throw IllegalStateException("activity cannot be null")
    }
}