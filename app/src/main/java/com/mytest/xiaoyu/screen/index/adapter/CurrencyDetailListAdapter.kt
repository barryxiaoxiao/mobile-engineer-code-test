package com.mytest.xiaoyu.screen.index.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mytest.xiaoyu.R
import com.mytest.xiaoyu.binding.ext.viewBind
import com.mytest.xiaoyu.databinding.CurrencyListItemBinding
import com.mytest.xiaoyu.greendao.database.CurrencyDetail

class CurrencyDetailListAdapter(
    private val list: List<CurrencyDetail>
) :
    RecyclerView.Adapter<CurrencyDetailListAdapter.ActivityListHolder>(
    ) {

    inner class ActivityListHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding: CurrencyListItemBinding by viewBind()
        fun bindData(item: CurrencyDetail) {
            binding.buy.text = item.buy
            binding.change.text = item.change
            binding.sell.text = item.sell
            binding.symbol.text = item.symbol

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActivityListHolder =
        ActivityListHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.currency_list_item, parent, false
            )
        )


    override fun onBindViewHolder(holder: ActivityListHolder, position: Int) {
        holder.bindData(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}