package com.example.sprezzatura.event

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sprezzatura.R
import com.example.sprezzatura.databinding.EventItemBinding

class EventAdapter: RecyclerView.Adapter<EventAdapter.EventHolder>() {

    val eventList = ArrayList<Event>()

    class EventHolder(item: View): RecyclerView.ViewHolder(item) {
        val binding = EventItemBinding.bind(item)

        fun bind(event: Event) = with(binding) {
            eventTitle.text = event.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.event_item, parent, false)
        return EventHolder(view)
    }

    override fun onBindViewHolder(holder: EventHolder, position: Int) {
        holder.bind(eventList[position])
    }

    override fun getItemCount(): Int {
        return eventList.size
    }

    fun addEvent(event: Event) {
        eventList.add(event)
        notifyDataSetChanged()
    }
}