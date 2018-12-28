package zo.den.testtask5.view.ui

import android.content.Context
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_city.*
import zo.den.testtask5.App
import zo.den.testtask5.R
import zo.den.testtask5.R.id.city_rv
import zo.den.testtask5.model.City
import zo.den.testtask5.presenters.CityPresenter
import zo.den.testtask5.view.CityView
import zo.den.testtask5.view.adapter.CityAdapter

class CityFragment : FragmentBase<CityPresenter>(), CityView {

    override var presenter = (context?.applicationContext as App).presenterProvider.getCityPresenter()

    override val layout: Int = R.layout.fragment_city

    private val cityAdapter = CityAdapter()



    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        presenter.attachView(this)
        val context: Context? = this.context
        val fab = view!!.findViewById(R.id.fab) as? FloatingActionButton
        fab?.setOnClickListener{
        }

        city_rv.adapter = cityAdapter
        city_rv.layoutManager = LinearLayoutManager(context)
        cityAdapter.listener = object : CityAdapter.OnItemClickListener {
            override fun onItemClick(city: City) {
            }

            override fun onItemLongClick(city: City) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        }
    }

    override fun showCityList(list: List<City>){
        cityAdapter.list = list
    }

}