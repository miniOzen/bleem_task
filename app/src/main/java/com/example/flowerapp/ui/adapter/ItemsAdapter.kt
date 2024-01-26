package com.example.flowerapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.flowerapp.databinding.ItemProductBinding
import com.example.flowerapp.model.Items

class ItemsAdapter (private val dataSet: List<Items>, private val context: Context):
    RecyclerView.Adapter<ItemsAdapter.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder)
     */
    class ViewHolder(val binding:  ItemProductBinding) :
        RecyclerView.ViewHolder(binding.root) {


    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val binding = ItemProductBinding.inflate(
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

                price.text = item.price
                productName.text = item.item_name
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