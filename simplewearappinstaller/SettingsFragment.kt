package com.example.simplewearappinstaller

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatDelegate
import androidx.preference.ListPreference
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat
import androidx.preference.PreferenceManager
import com.google.android.material.snackbar.Snackbar
import android.view.View
import androidx.core.content.ContextCompat

class SettingsFragment : PreferenceFragmentCompat() {
    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.preferences, rootKey)

        findPreference<ListPreference>("theme")?.setOnPreferenceChangeListener { _, newValue ->
            val mode = when (newValue) {
                "light" -> AppCompatDelegate.MODE_NIGHT_NO
                "dark" -> AppCompatDelegate.MODE_NIGHT_YES
                else -> AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM
            }
            if (AppCompatDelegate.getDefaultNightMode() != mode) {
                AppCompatDelegate.setDefaultNightMode(mode)
                requireActivity().recreate()
            }
            true
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val notificationPref =
            findPreference<androidx.preference.SwitchPreferenceCompat>("enable_notifications")
        notificationPref?.onPreferenceChangeListener =
            Preference.OnPreferenceChangeListener { _, _ ->
                Snackbar.make(
                    requireActivity().findViewById(android.R.id.content),
                    "More options coming soon!",
                    Snackbar.LENGTH_SHORT
                ).show()
                true
            }
    }

    override fun onPreferenceTreeClick(preference: Preference): Boolean {
        if (preference.key == "reset_preferences") {
            // ... existing reset code ...
            return true
        }
        if (preference.key == "settings") {
            val rootView = requireActivity().findViewById<View>(android.R.id.content)
            Snackbar.make(rootView, "More options coming soon!", Snackbar.LENGTH_SHORT).show()
            return true
        }
        if (preference.key == "settings_snackbar") {
            val rootView = requireActivity().findViewById<View>(android.R.id.content)
            val snackbar =
                Snackbar.make(rootView, "More settings coming soon!", Snackbar.LENGTH_LONG)
            snackbar.setAction("Test Notifications") {
                Toast.makeText(requireContext(), "Test notification sent!", Toast.LENGTH_SHORT)
                    .show()
            }
            snackbar.setActionTextColor(ContextCompat.getColor(requireContext(), R.color.teal_200))
            snackbar.show()
            return true
        }
        return super.onPreferenceTreeClick(preference)
    }
}