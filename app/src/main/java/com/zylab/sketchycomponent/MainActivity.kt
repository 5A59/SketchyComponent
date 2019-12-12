package com.zylab.sketchycomponent

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.zylab.sketchy.drawable.SkCircleDrawable
import com.zylab.sketchy.drawable.SkSquareDrawable
import com.zylab.sketchycomponent.drawable.SkPieChatDrawable
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : BaseActivity() {
    val skItemList: MutableList<SkItem> = ArrayList()
    val bgColorList = arrayListOf(
        R.color.bg1, R.color.bg2, R.color.bg3, R.color.bg4
    )
    val imgColorList = arrayListOf(
        R.color.logo1, R.color.logo2, R.color.logo3, R.color.logo4
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initData()

        toolbar.background = SkSquareDrawable().apply {
            fillColor = resources.getColor(R.color.toolbar)
        }

        recycler.adapter = SkAdapter()
        recycler.layoutManager = LinearLayoutManager(this)
    }

    private fun initData() {
        skItemList.add(SkItem("S", "Shape", "We provide drawing capabilities through base shapes."))
        skItemList.add(SkItem("I", "Icons", "We provide several icons."))
        skItemList.add(SkItem("O", "Others", "You can draw other graphics like chats."))
    }

    private fun gotoDemoActivity(skItem: SkItem) {
        when (skItem.logo) {
            "S" -> {
                val intent = Intent(this, ShapeActivity::class.java)
                startActivity(intent)
            }
            "I" -> {
                val intent = Intent(this, IconActivity::class.java)
                startActivity(intent)
            }
            "O" -> {
                val intent = Intent(this, OtherActivity::class.java)
                startActivity(intent)
            }
        }
    }

    inner class SkAdapter : RecyclerView.Adapter<SkViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SkViewHolder {
            val view =
                LayoutInflater.from(this@MainActivity).inflate(R.layout.sk_item, parent, false)
            return SkViewHolder(view)
        }

        override fun getItemCount(): Int {
            return skItemList.size
        }

        override fun onBindViewHolder(holder: SkViewHolder, position: Int) {
            holder.itemView.background = SkSquareDrawable().apply {
                fillColor = resources.getColor(bgColorList[position])
            }
            holder.nameText.background = SkSquareDrawable().apply {
                fillColor = resources.getColor(android.R.color.transparent)
            }
            holder.nameText.text = skItemList[position].name
            holder.descText.text = skItemList[position].desc

            holder.logo.background = SkCircleDrawable().apply {
                fillColor = resources.getColor(imgColorList[position])
            }
            holder.logo.text = skItemList[position].logo

            holder.itemView.setOnClickListener {
                gotoDemoActivity(skItemList[position])
            }
        }
    }

    inner class SkViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var logo: TextView = itemView.findViewById(R.id.logo)
        var nameText: TextView = itemView.findViewById(R.id.nameText)
        var descText: TextView = itemView.findViewById(R.id.descText)
    }

    data class SkItem(var logo: String, var name: String, var desc: String)
}
