package com.example.narupak.myapplication.viewholder

import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.view.View.Y
import android.widget.ImageView
import android.widget.TextView
import com.example.narupak.myapplication.R
import com.example.narupak.myapplication.R.id.finalPrice
import com.example.narupak.myapplication.model.Auction
import com.example.narupak.myapplication.model.AuctionRealtimeDatabase
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by Narupak on 5/9/2561.
 */
class AuctionRealtimeViewholder : RecyclerView.ViewHolder{

    var cardview_auction : CardView
    var bidder : TextView
    var bidTime : TextView
    var Price : TextView

        constructor(itemView: View?) : super(itemView) {
            this.bidder = itemView!!.findViewById(R.id.name_auction)
            this.bidTime = itemView.findViewById(R.id.date_auction)
            this.Price = itemView.findViewById(R.id.amount_auction)
            this.cardview_auction = itemView.findViewById(R.id.cardview_auction)

        }
        fun updateUI(auctionRealtimeList : AuctionRealtimeDatabase){
            bidder.text = auctionRealtimeList.bidder.toString()
            var date : Long? = auctionRealtimeList.bidtime
            if(date == null){
                date = Date().time
                bidTime.text = date.toString()
            }else{
                val fmt = SimpleDateFormat("dd-MMMM-yyyy HH:mm:ss", Locale("th", "THAILAND"))
                bidTime.text = fmt.format(date)
            }
            Price.text = auctionRealtimeList.price.toString()
        }
}