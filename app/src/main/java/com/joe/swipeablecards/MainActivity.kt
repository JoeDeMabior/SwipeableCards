package com.joe.swipeablecards

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import swipeable.com.layoutmanager.OnItemSwiped
import swipeable.com.layoutmanager.SwipeableLayoutManager
import swipeable.com.layoutmanager.SwipeableTouchHelperCallback
import swipeable.com.layoutmanager.touchelper.ItemTouchHelper

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: ListItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = ListItemAdapter()

        val callback = object : SwipeableTouchHelperCallback(object : OnItemSwiped {
            override fun onItemSwiped() {
                adapter.removeTopItem()
            }

            override fun onItemSwipedRight() {
                Log.i("SWIPE", "RIGHT")
            }

            override fun onItemSwipedLeft() {
                Log.i("SWIPE", "LEFT")
            }
        }) {
        }

        val helper = ItemTouchHelper(callback)
        helper.attachToRecyclerView(recycler_view)

        recycler_view.layoutManager = SwipeableLayoutManager().setAngle(10)
            .setAnimationDuratuion(450)
            .setMaxShowCount(3)
            .setScaleGap(0.1f)
            .setTransYGap(0)
        recycler_view.adapter = adapter

        swipe.setOnClickListener {
            helper.startSwipe(recycler_view.findViewHolderForAdapterPosition(0))
        }
    }

}
