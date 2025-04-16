package com.example.day1.dialogs

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.day1.databinding.CustomDialogBinding

class CustomDialogFragment : DialogFragment() {

    private var listener: CustomDialogListener? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is CustomDialogListener) {
            listener = context
        }

    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val customView = CustomDialogBinding.inflate(layoutInflater, null, false)
        val dialog = AlertDialog.Builder(requireContext())
            .setView(customView.root)
            .setTitle("Custom Dialog")
            .setMessage("This is a custom dialog.")
            .setPositiveButton("OK") { dialog, _ ->
                listener?.onNewNameEntered(customView.nameEditText.text.toString())
                dialog.dismiss()
            }
            .setNegativeButton("Cancel") { dialog, _ ->
                dialog.dismiss()
            }
            .create()
        return dialog
    }


}