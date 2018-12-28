package zo.den.testtask5.presenters

import zo.den.testtask5.model.DBProvider

class PresenterProvider(private var dbProvider: DBProvider) {
    fun getCityPresenter() : CityPresenter{
        return CityPresenter(dbProvider.db)
    }
}