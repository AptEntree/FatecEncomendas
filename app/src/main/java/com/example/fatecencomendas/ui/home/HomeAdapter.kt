package com.example.fatecencomendas.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fatecencomendas.data.entity.PackageEntity
import com.example.fatecencomendas.databinding.ItemPackageBinding

class HomeAdapter(private val renderList: List<PackageEntity>) :
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

    override fun onBindViewHolder(holder: PackageViewHolder, position: Int) =
        holder.bind(renderList[position])

    inner class PackageViewHolder(private val binding: ItemPackageBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(packageEntity: PackageEntity) {
            with(binding) {
                packageArrived.text = "Arrived: ${packageEntity.arrivedDate}"
                packageReceiver.text = "Receiver: ${packageEntity.receiverEmail}"
                packagePickUp.text = "Removed: ${packageEntity.pickupDate}"
            }
        }
    }
}