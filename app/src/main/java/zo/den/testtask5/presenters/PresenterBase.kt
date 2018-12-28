package zo.den.testtask5.presenters

import zo.den.testtask5.view.MvpView

abstract class PresenterBase<T : MvpView> : MvpPresenter<T> {

    protected var view : T? = null

    override fun attachView(mvpView: T) {
            view = mvpView
    }

    override fun viewIsReady() : Boolean {
        return view != null
    }

    override fun detachView() {
        view = null
    }

    override fun destroy() {

    }
}