package zo.den.testtask5.presenters

import android.support.v4.app.FragmentManager
import zo.den.testtask5.model.City
import zo.den.testtask5.model.Db
import zo.den.testtask5.model.Logs
import zo.den.testtask5.view.CityView
import zo.den.testtask5.view.MvpView
import zo.den.testtask5.view.ui.AddDialog

class CityPresenter constructor(private var db: Db) : PresenterBase<CityView>()  {

    fun onCity(city: City) {

    }


    override fun attachView(mvpView: CityView) {
        super.attachView(mvpView)

    }

    override fun viewIsReady() : Boolean {
        super.viewIsReady()
    }

    override fun detachView() {
        super.detachView()
    }

    override fun destroy() {
        super.destroy()
    }

    fun onShowAddDialog(fragmentManager: FragmentManager?) {
        val dialog = AddDialog.getInstance()
        dialog.show(fragmentManager, "TAG_ADD_DIALOG")
    }


     fun addCity(city: String, type: String,
                         jan: String, feb: String, mar: String,
                         apr: String, may: String, jun: String,
                         jul: String, aug: String, sep: String,
                         oct: String, nov: String, dec: String) {
        db.insertCity(City(city, type))
        db.insertLog(Logs(city, "январь", Integer.parseInt(jan)))
        db.insertLog(Logs(city, "февраль", Integer.parseInt(feb)))
        db.insertLog(Logs(city, "март", Integer.parseInt(mar)))
        db.insertLog(Logs(city, "апрель", Integer.parseInt(apr)))
        db.insertLog(Logs(city, "май", Integer.parseInt(may)))
        db.insertLog(Logs(city, "июнь", Integer.parseInt(jun)))
        db.insertLog(Logs(city, "июль", Integer.parseInt(jul)))
        db.insertLog(Logs(city, "август", Integer.parseInt(aug)))
        db.insertLog(Logs(city, "сентябрь", Integer.parseInt(sep)))
        db.insertLog(Logs(city, "октябрь", Integer.parseInt(oct)))
        db.insertLog(Logs(city, "ноябрь", Integer.parseInt(nov)))
        db.insertLog(Logs(city, "декабрь", Integer.parseInt(dec)))
    }
}