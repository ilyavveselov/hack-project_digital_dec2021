package com.example.sprezzatura.guider

class Guider(private var currentNode: TreeNode) {

    private var homeNode: TreeNode = currentNode.copyNode()

    class TreeNode(var titleText: String, var content: ArrayList<ContentItem>) {

        fun copyNode(): TreeNode {
            return TreeNode(titleText, ArrayList<ContentItem>(content))
        }
    }

    class ContentItem(val title: String = "placeholder") {
        lateinit var nextNode: TreeNode
        lateinit var link: String
    }

    fun getCurrentNode(): TreeNode {
        return currentNode
    }

    fun goToNextNode(node: TreeNode) {
        currentNode = node
    }

    fun returnToHomeNode() {
        currentNode = homeNode.copyNode()
    }
}