package zo.den.testtask5.view

interface AddView : MvpView {

    fun addCity(city: String, type: String,
                jan: String, feb: String, mar: String,
                apr: String, may: String, jun: String,
                jul: String, aug: String, sep: String,
                oct: String, nov: String, dec: String)

}