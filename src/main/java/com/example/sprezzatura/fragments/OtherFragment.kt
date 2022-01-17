package com.example.sprezzatura.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sprezzatura.AppViewModel
import com.example.sprezzatura.guider.Guider
import com.example.sprezzatura.guider.GuiderAdapter
import com.example.sprezzatura.R
import com.example.sprezzatura.databinding.FragmentOtherBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OtherFragment : Fragment(), GuiderAdapter.OnItemClickListener {

    private var _binding: FragmentOtherBinding? = null
    private lateinit var binding: FragmentOtherBinding

    private val adapter = GuiderAdapter(this)

    private val viewModel by viewModels<AppViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentOtherBinding.bind(view)
        _binding = binding

        viewModel
        init()
        addNode(viewModel.getCurrentNode())
    }

    override fun onItemClick(contentItem: Guider.ContentItem, listener: GuiderAdapter.OnItemClickListener) {
        viewModel.onItemClick(contentItem, listener)
    }

    private fun init() {
        binding.apply {
            guiderRecyclerView.layoutManager = LinearLayoutManager(this@OtherFragment.context)
            guiderRecyclerView.adapter = adapter

            returnBackView.setOnClickListener {
                viewModel.returnToHomeNode()
                addNode(viewModel.getCurrentNode())
                if (viewModel.flag) {
                    Toast.makeText(this@OtherFragment.context, "Наставник прислал вам сообщение!", Toast.LENGTH_SHORT).show()
                    viewModel.flag = false
                }
            }
        }
    }

    private fun addNode(node: Guider.TreeNode) {
        binding.guiderTextView.text = node.titleText
        adapter.addNode(node)
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_other, container, false)
    }

    override fun onNodeChanged() {
        addNode(viewModel.getCurrentNode())
    }


}