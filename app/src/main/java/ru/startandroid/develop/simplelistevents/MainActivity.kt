package ru.startandroid.develop.simplelistevents

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AbsListView
import android.widget.AbsListView.OnScrollListener
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.ListView

const val LOG_TAG = "myLogs"

class MainActivity : AppCompatActivity() {

    private var lvMain:ListView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lvMain = findViewById(R.id.lvMain)

        val adapter:ArrayAdapter<CharSequence> = ArrayAdapter.createFromResource(
            this, R.array.names, android.R.layout.simple_list_item_1)
        lvMain!!.adapter = adapter

        lvMain!!.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            Log.d(LOG_TAG, "itemClick: position = $position, id = $id")
        }
        lvMain!!.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?,
                                        view: View?,
                                        position: Int,
                                        id: Long) {
                Log.d(LOG_TAG, "itemSelected: position = $position, id = $id")
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                Log.d(LOG_TAG, "itemSelected: nothing")
            }
        }
        lvMain!!.setOnScrollListener(object : OnScrollListener {
            override fun onScrollStateChanged(view: AbsListView?, scrollState: Int) {
                Log.d(LOG_TAG, "scrollState = $scrollState")
            }

            override fun onScroll(view: AbsListView?,
                                  firstVisibleItem: Int,
                                  visibleItemCount: Int,
                                  totalItemCount: Int) {
                Log.d(LOG_TAG, "scroll: firstVisibleItem = $firstVisibleItem," +
                        "visibleItemCount = $visibleItemCount," +
                        "totalItemCount = $totalItemCount")
            }
        } )
    }
}