package com.corona.savelive.util

import android.content.Context
import androidx.core.content.ContextCompat
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.corona.savelive.R

fun showLoading(context: Context,swipeRefreshLayout: SwipeRefreshLayout){
        swipeRefreshLayout.setColorSchemeColors(ContextCompat.getColor(context, R.color.bgDark))

    swipeRefreshLayout.isEnabled = true
    swipeRefreshLayout.isRefreshing = true

}
fun dissmisLoading(swipeRefreshLayout: SwipeRefreshLayout){
    swipeRefreshLayout.isRefreshing = true
    swipeRefreshLayout.isEnabled = true
}