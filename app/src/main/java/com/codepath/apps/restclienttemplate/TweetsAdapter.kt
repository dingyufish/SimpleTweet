package com.codepath.apps.restclienttemplate

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.codepath.apps.restclienttemplate.models.Tweet

class TweetsAdapter(val tweets: ArrayList<Tweet>):RecyclerView.Adapter<TweetsAdapter.viewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TweetsAdapter.viewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)

            //inflater our layout
        val view = inflater.inflate(R.layout.item_tweet_xml, parent,false )
        return viewHolder(view)

    }
//populating data into the item through holder
    override fun onBindViewHolder(holder: TweetsAdapter.viewHolder, position: Int) {
// get the data model based on the position
        val tweet: Tweet = tweets.get(position)

    //set item views base on views and data model

        holder.tvUsername.text = tweet.user?.name
        holder.tvTweetBody.text = tweet.body

        Glide.with(holder.itemView).load(tweet.user?.publicImageUrl).into(holder.ivProflieImage)
    }

    override fun getItemCount(): Int {
        return tweets.size
    }
    fun clear() {
        tweets.clear()
        notifyDataSetChanged()
    }

    // Add a list of items -- change to type used
    fun addAll(tweetList: List<Tweet>) {
        tweets.addAll(tweetList)
        notifyDataSetChanged()
    }
    class viewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val ivProflieImage = itemView.findViewById<ImageView>(R.id.ivProflieImage)
        val tvTweetBody = itemView.findViewById<TextView>(R.id.tvTweetBody)
        val tvUsername = itemView.findViewById<TextView>(R.id.tvUsername)

    }

}