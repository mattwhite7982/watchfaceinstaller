package com.example.simplewearappinstaller

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import android.widget.TextView
import android.view.Gravity

class ContentFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Replace R.layout.content_main with your actual layout resource
        return inflater.inflate(R.layout.content_main, container, false)
    }
}

class TestFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val tv = TextView(requireContext())
        tv.text = "Test Fragment"
        tv.gravity = Gravity.CENTER
        return tv
    }
}