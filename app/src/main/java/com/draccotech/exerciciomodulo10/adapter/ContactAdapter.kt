package com.draccotech.exerciciomodulo10.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.draccotech.exerciciomodulo10.databinding.ItemContactBinding
import com.draccotech.exerciciomodulo10.models.ContactInfo

class ContactAdapter(
    private val listContacts: List<ContactInfo>,
    val listener: ContacAdapterListener
): RecyclerView.Adapter<ContactAdapter.ContactViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        return ContactViewHolder(
            ItemContactBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val contact = listContacts[position]
        val letter = contact.name[0].toString()

        holder.iconText.text = letter
        holder.name.text = contact.name
        holder.phone.text = contact.phone

        if(!contact.first){
            holder.iconText.visibility = View.INVISIBLE
        }else{
            holder.iconText.visibility = View.VISIBLE
        }

        holder.root.setOnClickListener {
            listener.onItemClicked(contact.phone)
        }

    }

    override fun getItemCount(): Int {
        return listContacts.size
    }

    class ContactViewHolder(binding: ItemContactBinding): RecyclerView.ViewHolder(binding.root) {
        var root = binding.root
        var name = binding.textName
        var phone = binding.textPhone
        var iconText = binding.textIcon
    }

    interface ContacAdapterListener{
        fun onItemClicked(number: String)
    }


}