package com.example.flowerapp.ui.recyclerItemDecoration

import android.content.Context
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class HorizontalMarginIDecoration constructor(context: Context, horizontalMarginInDp: Int) :
    RecyclerView.ItemDecoration() {
    private val horizontalMarginInPx =
        horizontalMarginInDp * context.resources.displayMetrics.density

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State,
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        val totalItemCount = parent.adapter?.itemCount?.minus(1)
        val currentCount = parent.getChildAdapterPosition(view)
        if (currentCount == 0) {
            outRect.right = horizontalMarginInPx.toInt()
            outRect.left = horizontalMarginInPx.toInt() * 2
        } else if (currentCount == totalItemCount) {
            outRect.right = horizontalMarginInPx.toInt() * 2
        } else {
            outRect.right = horizontalMarginInPx.toInt()

        }


    }
}