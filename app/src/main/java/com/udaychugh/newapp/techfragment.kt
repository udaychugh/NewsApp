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

class techfragment : Fragment() {
    var api = "177f87c5e0034517b2b97590859612ab"
    var modelClassArrayList: ArrayList<ModelClass>? = null
    var adapter: Adapter? = null
    var country = "in"
    private var recyclerViewoftech: RecyclerView? = null
    private val category = "technology"
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.technologyfragment, null)
        recyclerViewoftech = v.findViewById(R.id.recylerviewoftech)
        modelClassArrayList = ArrayList()
        recyclerViewoftech.setLayoutManager(LinearLayoutManager(context))
        adapter = Adapter(context!!, modelClassArrayList!!)
        recyclerViewoftech.setAdapter(adapter)
        findNews()
        return v
    }

    private fun findNews() {
        apiInterface.getCategoryNews(country, category, 100, api)!!.enqueue(object : Callback<MainClass> {
            override fun onResponse(call: Call<MainClass>, response: Response<MainClass>) {
                if (response.isSuccessful) {
                    modelClassArrayList!!.addAll(response.body()!!.articles)
                    adapter!!.notifyDataSetChanged()
                }
            }

            override fun onFailure(call: Call<MainClass>, t: Throwable) {}
        })
    }
}