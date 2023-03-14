package com.example.instapic

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class PostAdapter(private val context: Context, private val posts: List<Post>)
    : RecyclerView.Adapter<PostAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // Specify the layout file to use for this item.
        val view = LayoutInflater.from(context).inflate(R.layout.item_post, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val post = posts.get(position)
        //call bind method to display relative information we want.
        holder.bind(post) 
    }

    override fun getItemCount(): Int {
        return posts.size
    }
    // class involved in laying out individual items in the layout file.
    // takes in View
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
       private val tvUsername: TextView
       private val ivImage: ImageView
       private val tvDescription: TextView

        init {
            tvUsername = itemView.findViewById(R.id.tvUsername)
            ivImage = itemView.findViewById(R.id.ivImage)
            tvDescription = itemView.findViewById(R.id.tvDescription)
        }

        // method that associates data with the recyclerView layout.
        // takes post object and displays the correct information inside the item.
        fun bind(post: Post) {
            tvDescription.text = post.getDescription()
            tvUsername.text = post.getUser()?.username

            // Populate the image
            Glide.with(itemView.context).load(post.getImage()?.url).into(ivImage)
        }
    }
}
