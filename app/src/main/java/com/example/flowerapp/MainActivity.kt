package com.example.flowerapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.window.SplashScreen
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.flowerapp.ui.adapter.FeaturedItemAdapter
import com.example.flowerapp.databinding.ActivityMainBinding
import com.example.flowerapp.model.Items
import com.example.flowerapp.ui.adapter.ItemsAdapter
import com.example.flowerapp.ui.recyclerItemDecoration.HorizontalMarginIDecoration
import com.example.flowerapp.viewModel.MainViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var keepSplashOnScreen = true
    val delay = 3000L

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen().setKeepOnScreenCondition { keepSplashOnScreen }
        Handler(Looper.getMainLooper()).postDelayed({ keepSplashOnScreen = false }, delay)
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        val featuredItemList:MutableList<Items> = mutableListOf()
        val itemList:MutableList<Items> = mutableListOf()
        val mainVM = MainViewModel()
        
        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        val featuredItemAdapter = FeaturedItemAdapter(featuredItemList, this)
        val itemsAdapter = ItemsAdapter(itemList,this)
        val gridLayoutManager = GridLayoutManager(this,2)
        
        mainVM.featuredItems!!.observe(this, Observer {
            if(it!= null) {
                featuredItemList.addAll(it)
                featuredItemAdapter.notifyDataSetChanged()
            }
        })

        mainVM.items!!.observe(this, Observer {
            if(it!= null) {
                itemList.addAll(it)
                itemsAdapter.notifyDataSetChanged()
            }
        })

        with(binding){
            featuredItemsRcy.layoutManager = linearLayoutManager
            featuredItemsRcy.adapter= featuredItemAdapter
            featuredItemsRcy.addItemDecoration(HorizontalMarginIDecoration(this@MainActivity,8))
            featuredItemsRcy.setHasFixedSize(true)

            itemsRcy.layoutManager= gridLayoutManager
            itemsRcy.adapter= itemsAdapter




            
        }




    }
}