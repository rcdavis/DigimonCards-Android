package com.example.digimoncards.ui.dashboard

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.digimoncards.databinding.FragmentDashboardBinding
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class DashboardFragment : Fragment() {
    private lateinit var binding: FragmentDashboardBinding

    private val viewModel: DashboardViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDashboardBinding.inflate(inflater, container, false)

        binding.buttonSearch.setOnClickListener {
            printAgumonCards()
        }

        return binding.root
    }

    private fun printAgumonCards() {
        lifecycleScope.launch {
            val cards = viewModel.getAgumonCards()
            Log.d("DigimonAgumon", cards.toString())
        }
    }
}