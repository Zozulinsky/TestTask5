package zo.den.testtask5

import android.app.Application
import zo.den.testtask5.model.DBProvider
import zo.den.testtask5.model.Db
import zo.den.testtask5.presenters.AddPresenter
import zo.den.testtask5.presenters.CityPresenter
import zo.den.testtask5.presenters.MvpPresenter
import zo.den.testtask5.presenters.PresenterProvider
import zo.den.testtask5.view.MvpView

class App : Application() {

    val appProvider = AppProvider(this)
    val dbProvider = DBProvider(this)
    val presenterProvider = PresenterProvider(dbProvider)

}