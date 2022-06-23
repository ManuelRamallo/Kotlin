package com.mramalldo.mvvmkotlinex.ui.dialog

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface

class ErrorDialog (context: Context): Dialog(context) {

    init {
        initDialog()
    }

    private fun initDialog() {
        val dialogBuilder = AlertDialog.Builder(context)
        dialogBuilder.setMessage("No se ha encontrado ninguna pelicula, por favor realiza una nueva busqueda")
            .setCancelable(false)
            .setPositiveButton("Volver", DialogInterface.OnClickListener {
                    dialog, _ -> dialog.cancel()
            })

        val alert = dialogBuilder.create()
        alert.setTitle("ERROR")
        alert.show()
    }

}