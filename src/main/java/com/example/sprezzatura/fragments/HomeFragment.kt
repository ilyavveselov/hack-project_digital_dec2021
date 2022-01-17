package com.example.sprezzatura.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sprezzatura.event.Event
import com.example.sprezzatura.event.EventAdapter
import com.example.sprezzatura.R
import com.example.sprezzatura.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private lateinit var binding: FragmentHomeBinding

    private val adapter = EventAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeBinding.bind(view)
        _binding = binding

        init()
    }

    private fun init() {
        binding.apply {
            recyclerView.layoutManager = LinearLayoutManager(this@HomeFragment.context)
            recyclerView.adapter = adapter
            adapter.addEvent(Event("ПСБ нарастил прибыль более чем двукратно - до 38,7 млрд рублей по МСФО за 9 месяцев 2021"))
            adapter.addEvent(Event("Чистая прибыль ПСБ по РСБУ за девять месяцев выросла почти вдвое – до 30 млрд рублей"))
            adapter.addEvent(Event("S&P подтвердило высокий кредитный рейтинг ПСБ на уровне BB, пересмотрев прогноз на позитивный"))
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }
}