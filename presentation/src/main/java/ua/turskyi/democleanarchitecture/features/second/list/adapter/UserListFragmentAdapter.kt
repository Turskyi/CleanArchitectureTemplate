package ua.turskyi.democleanarchitecture.features.second.list.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ua.turskyi.democleanarchitecture.databinding.UserItemBinding
import ua.turskyi.domain.models.User

class UserListFragmentAdapter: RecyclerView.Adapter<UserListFragmentAdapter.ExampleViewHolder>() {
    private val exampleList: MutableList<User> = mutableListOf()
    fun setData(exampleList: MutableList<User>) {
        this.exampleList.clear()
        this.exampleList.addAll(exampleList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExampleViewHolder {
        val itemView = UserItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ExampleViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ExampleViewHolder, position: Int) {
        val currentItem = exampleList[position]
        holder.textView1.text = currentItem.name
        holder.textView2.text = currentItem.phone
    }

    override fun getItemCount() = exampleList.size

    class ExampleViewHolder(itemView: UserItemBinding) : RecyclerView.ViewHolder(itemView.root) {
        val textView1: TextView = itemView.tvName
        val textView2: TextView = itemView.tvPhone
    }
}