package com.example.sprezzatura

import androidx.lifecycle.ViewModel
import com.example.sprezzatura.guider.Guider
import com.example.sprezzatura.guider.GuiderAdapter
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AppViewModel @Inject constructor(private val guider: Guider) : ViewModel(), GuiderAdapter.OnItemClickListener {

    private var currentNode = guider.getCurrentNode()
    var flag = true

    fun getCurrentNode(): Guider.TreeNode {
        return guider.getCurrentNode()
    }

    fun returnToHomeNode() {
        guider.returnToHomeNode()
    }

    override fun onItemClick(contentItem: Guider.ContentItem, listener: GuiderAdapter.OnItemClickListener) {
        guider.goToNextNode(contentItem.nextNode)
        currentNode = guider.getCurrentNode()
        listener.onNodeChanged()
    }

    override fun onNodeChanged() {
    }


}