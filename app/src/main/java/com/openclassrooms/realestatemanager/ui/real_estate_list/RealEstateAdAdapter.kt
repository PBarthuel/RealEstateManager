package com.openclassrooms.realestatemanager.ui.real_estate_list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.openclassrooms.realestatemanager.R

class RealEstateAdAdapter : ListAdapter<RealEstateInfo, RealEstateAdAdapter.ViewHolder>(
    RealEstateAdDiffCallBack()
) {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.real_estate_ad_item, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, index: Int) {

    }

}

class RealEstateAdDiffCallBack : DiffUtil.ItemCallback<RealEstateInfo>() {

    override fun areItemsTheSame(oldItem: RealEstateInfo, newItem: RealEstateInfo): Boolean {
        TODO("Not yet implemented")
    }

    override fun areContentsTheSame(oldItem: RealEstateInfo, newItem: RealEstateInfo): Boolean {
        TODO("Not yet implemented")
    }
}
