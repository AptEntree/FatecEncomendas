package com.example.fatecencomendas.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fatecencomendas.databinding.ItemPackageBinding

class HomeAdapter(private val renderList: List<String>) :
    RecyclerView.Adapter<HomeAdapter.PackageViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PackageViewHolder =
        PackageViewHolder(
            ItemPackageBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun getItemCount(): Int = renderList.size

    override fun onBindViewHolder(holder: PackageViewHolder, position: Int) = holder.bind()

    inner class PackageViewHolder(binding: ItemPackageBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind() {

        }
    }
}