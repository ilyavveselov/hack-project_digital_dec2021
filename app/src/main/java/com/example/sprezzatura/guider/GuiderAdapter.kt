package com.example.sprezzatura.guider

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sprezzatura.R
import com.example.sprezzatura.databinding.GuiderButtonBinding

class GuiderAdapter(
    private val listener:OnItemClickListener
): RecyclerView.Adapter<GuiderAdapter.GuiderHolder>() {

    private var content = ArrayList<Guider.ContentItem>()

    inner class GuiderHolder(item: View): RecyclerView.ViewHolder(item), View.OnClickListener {
        val binding = GuiderButtonBinding.bind(item)

        init {
            item.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position: Int = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.onItemClick(content[position], listener)
            }
        }

        fun bind(contentItem: Guider.ContentItem) = with(binding) {
            textView.text = contentItem.title
        }
    }

    interface OnItemClickListener {
        fun onItemClick(contentItem: Guider.ContentItem, listener: OnItemClickListener)
        fun onNodeChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GuiderHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.guider_button, parent, false)
        return GuiderHolder(view)
    }

    override fun onBindViewHolder(holder: GuiderHolder, position: Int) {
        holder.bind(content[position])
    }

    override fun getItemCount(): Int {
        return content.size
    }

    fun addContentItem(contentItem: Guider.ContentItem) {
        content.add(contentItem)
        notifyDataSetChanged()
    }

    fun addNode(node: Guider.TreeNode) {
        content = node.content
        notifyDataSetChanged()
    }
}