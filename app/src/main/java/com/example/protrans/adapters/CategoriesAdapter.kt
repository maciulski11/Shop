package com.example.protrans.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.protrans.R
import com.example.protrans.data.Categories
import java.util.ArrayList

class CategoriesAdapter(private val categoriesList: ArrayList<Categories>): RecyclerView.Adapter<CategoriesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_categories, parent, false)

        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

    }

    override fun getItemCount(): Int = categoriesList.size


    inner class ViewHolder(private var view: View) : RecyclerView.ViewHolder(view){

    }

}