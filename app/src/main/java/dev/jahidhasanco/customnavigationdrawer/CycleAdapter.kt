package dev.jahidhasanco.customnavigationdrawer

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class CycleAdapter(private val cycleList: ArrayList<Cycle>, private val context: Context): RecyclerView.Adapter<CycleAdapter.ViewHolder>()  {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.single_item,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val cycle: Cycle = cycleList[position]

        Glide.with(context)
            .load(cycle.url)
            .into(holder.image)

        holder.nameC.text = cycle.name
        holder.des.text = cycle.des
        holder.price.text = cycle.price

    }

    override fun getItemCount(): Int {
        return cycleList.size
    }

     class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        val image: ImageView = itemView.findViewById(R.id.cycleImage)
        val nameC: TextView = itemView.findViewById(R.id.cycleName)
        val des:TextView = itemView.findViewById(R.id.cycleDes)
        val price:TextView = itemView.findViewById(R.id.cyclePrice)

    }

}