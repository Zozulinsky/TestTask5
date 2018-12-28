package zo.den.testtask5.view.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import zo.den.testtask5.presenters.MvpPresenter
import zo.den.testtask5.view.MvpView

abstract class FragmentBase<T: MvpPresenter<out MvpView>> : Fragment(), MvpView {
    abstract val layout: Int

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(layout, container, false)
    }

    protected abstract val presenter : T

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.destroy()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        presenter.detachView()
    }



}