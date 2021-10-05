package com.udaychugh.newapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.udaychugh.newapp.ApiUtilites.apiInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class homefragment : Fragment() {
    var api = "177f87c5e0034517b2b97590859612ab"
    var modelClassArrayList: ArrayList<ModelClass>? = null
    var adapter: Adapter? = null
    var country = "in"
    private var recyclerViewofhome: RecyclerView? = null
    var mainActivity2: MainActivity2? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.homefragment, null)
        recyclerViewofhome = v.findViewById(R.id.recylerviewofhome)
        modelClassArrayList = ArrayList()
        recyclerViewofhome.setLayoutManager(LinearLayoutManager(context))
        adapter = Adapter(context!!, modelClassArrayList!!)
        recyclerViewofhome.setAdapter(adapter)
        mainActivity2 = activity as MainActivity2?
        findNews()
        val state = IntArray(1)
        recyclerViewofhome.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                state[0] = newState
            }

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if (dy > 0 && (state[0] == 0 || state[0] == 2)) {
                    hideToolbar()
                } else if (dy < -10) {
                    showToolbar()
                }
            }
        })
        return v
    }

    private fun findNews() {
        apiInterface.getNews(country, 100, api)!!.enqueue(object : Callback<MainClass> {
            override fun onResponse(call: Call<MainClass>, response: Response<MainClass>) {
                if (response.isSuccessful) {
                    modelClassArrayList!!.addAll(response.body()!!.articles)
                    adapter!!.notifyDataSetChanged()
                }
            }

            override fun onFailure(call: Call<MainClass>, t: Throwable) {}
        })
    }

    private fun hideToolbar() {
        mainActivity2!!.mMaintoolbarLayout.visibility = View.GONE
    }

    private fun showToolbar() {
        mainActivity2!!.mMaintoolbarLayout.visibility = View.VISIBLE
    }
}