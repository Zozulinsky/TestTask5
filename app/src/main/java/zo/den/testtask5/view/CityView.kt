package zo.den.testtask5.view

import zo.den.testtask5.model.City

interface CityView : MvpView {
    fun showCityList(list: List<City>)
}