package com.example.flowerapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.flowerapp.R
import com.example.flowerapp.databinding.ItemFeatureProductBinding
import com.example.flowerapp.model.Items
import java.util.Locale

class FeaturedItemAdapter(private val dataSet: List<Items>, private val context: Context) :
    RecyclerView.Adapter<FeaturedItemAdapter.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder)
     */
    class ViewHolder(val binding: ItemFeatureProductBinding) :
        RecyclerView.ViewHolder(binding.root) {


    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val binding = ItemFeatureProductBinding.inflate(
            LayoutInflater.from(viewGroup.context),
            viewGroup,
            false
        )
        return ViewHolder(binding)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dataSet[position]
        with(holder) {
            with(binding) {
                currency.text = item.currency
                price.text = String.format(Locale.US,context.getString(R.string.price_format),item.price_per.toDouble())
                shopName.text = item.shop_name
                if (item.same_day_delivery) {
                    sameDayLabel.visibility = View.VISIBLE
                } else {
                    sameDayLabel.visibility = View.GONE
                }
                Glide.with(context).load(item.pic).into(productImage)

            }
        }


    }

    override fun getItemCount() = dataSet.size

}
