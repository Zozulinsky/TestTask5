package zo.den.testtask5.presenters

import zo.den.testtask5.view.MvpView



interface MvpPresenter<V: MvpView> {
    fun attachView(mvpView: V)

    fun viewIsReady() : Boolean

    fun detachView()

    fun destroy()
}