package com.openclassrooms.realestatemanager.ui.real_estate_list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.openclassrooms.realestatemanager.R
import kotlinx.android.synthetic.main.real_estate_ad_item.view.*

class RealEstateAdAdapter : ListAdapter<RealEstateInfoUiModel, RealEstateAdAdapter.ViewHolder>(
    RealEstateAdDiffCallBack
) {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(realEstateInfoUiModel: RealEstateInfoUiModel) {
            itemView.real_estate_ad_item_tv_city.text = realEstateInfoUiModel.realEstateTown
            itemView.real_estate_ad_item_tv_type.text = realEstateInfoUiModel.realEstateType
            itemView.real_estate_ad_item_tv_price.text = realEstateInfoUiModel.realEstatePrice
            itemView.real_estate_ad_item_iv_is_sold.isVisible = realEstateInfoUiModel.realEstateStatue
        }

    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.real_estate_ad_item, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, index: Int) {
        viewHolder.bind(getItem(index))
    }

}

object RealEstateAdDiffCallBack : DiffUtil.ItemCallback<RealEstateInfoUiModel>() {

    override fun areItemsTheSame(oldItem: RealEstateInfoUiModel, newItem: RealEstateInfoUiModel) =
        oldItem.realEstateAdId == newItem.realEstateAdId

    override fun areContentsTheSame(oldItem: RealEstateInfoUiModel, newItem: RealEstateInfoUiModel)=
        oldItem == newItem
}
