package uz.ruzibekov.rxjavatest.ui.main

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import uz.ruzibekov.rxjavatest.R
import uz.ruzibekov.rxjavatest.data.model.PostResponse

class PostListAdapter : RecyclerView.Adapter<PostListAdapter.ViewHolder>() {

    var items: List<PostResponse> = listOf()
        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostListAdapter.ViewHolder {
        return ViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.item_post, parent, false)
        )
    }

    override fun onBindViewHolder(holder: PostListAdapter.ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private var tvTitle: TextView? = null
        private var tvBody: TextView? = null

        init {
            itemView.initViews()
        }

        private fun View.initViews(){
            tvTitle = findViewById(R.id.tv_title)
            tvBody = findViewById(R.id.tv_body)
        }

        fun bind(data: PostResponse) {
            tvTitle?.text = data.title
            tvBody?.text = data.body
        }
    }
}