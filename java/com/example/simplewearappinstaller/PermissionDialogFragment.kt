package com.example.simplewearappinstaller

import android.app.Dialog
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class PermissionDialogFragment : DialogFragment() {

    private val permissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()
    ) { permissions ->
        val allGranted = permissions.values.all { it }
        if (allGranted) {
            (activity as? OnPermissionsGrantedListener)?.onPermissionsGranted()
        }
        dismiss()
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return AlertDialog.Builder(requireContext())
            .setTitle("Permissions Required")
            .setMessage("This app needs Bluetooth and Location permissions to work with Wear devices.")
            .setPositiveButton("Grant") { _, _ ->
                permissionLauncher.launch(
                    arrayOf(
                        android.Manifest.permission.BLUETOOTH,
                        android.Manifest.permission.BLUETOOTH_ADMIN,
                        android.Manifest.permission.ACCESS_FINE_LOCATION
                    )
                )
            }
            .setNegativeButton("Cancel") { _, _ -> dismiss() }
            .create()
    }

    interface OnPermissionsGrantedListener {
        fun onPermissionsGranted()
    }
}