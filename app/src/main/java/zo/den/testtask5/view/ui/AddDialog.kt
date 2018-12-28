package zo.den.testtask5.view.ui

import android.app.Activity
import android.app.Dialog
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.dialog_add.*
import zo.den.testtask5.R
import zo.den.testtask5.view.AddView

class AddDialog : DialogFragment(), AddView {

    companion object {
        fun getInstance(): AddDialog = AddDialog()
    }

    lateinit var context : Activity

    override fun onAttach(activity: Activity) {

        super.onAttach(activity)
        context = activity
    }



    var listener: OnAddListener? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn_add.setOnClickListener {
            if(input_city.text.toString().isNotEmpty() &&
                    input_type.toString().isNotEmpty() &&
                    input_jan.text.toString().isNotEmpty() && input_feb.text.toString().isNotEmpty() &&
                    input_mar.text.toString().isNotEmpty() && input_apr.text.toString().isNotEmpty() &&
                    input_may.text.toString().isNotEmpty() && input_jun.text.toString().isNotEmpty() &&
                    input_jul.text.toString().isNotEmpty() && input_aug.text.toString().isNotEmpty() &&
                    input_sep.text.toString().isNotEmpty() && input_oct.text.toString().isNotEmpty() &&
                    input_nov.text.toString().isNotEmpty() && input_dec.text.toString().isNotEmpty()){

                addCity(input_city.text.toString(),input_type.text.toString(),
                        input_jan.text.toString(), input_feb.text.toString(),
                        input_mar.text.toString(), input_apr.text.toString(),
                        input_may.text.toString(), input_jun.text.toString(),
                        input_jul.text.toString(), input_aug.text.toString(),
                        input_sep.text.toString(), input_oct.text.toString(),
                        input_nov.text.toString(), input_dec.text.toString()
                )
                dismiss()
            } else if (input_city.text.toString().length == 0){
                //TODO добавить отображение "Введите город"
            }else if (input_type.text.toString().length == 0){
                //TODO добавить отображение "Введите тип"
            } else {
                //TODO добавить отображение "Введите температуру"
            }
        }
        btn_cancel.setOnClickListener {
            dismiss()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.dialog_add, container, false)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState)
        return dialog
    }

    override fun addCity(city: String, type: String,
                         jan: String, feb: String, mar: String,
                         apr: String, may: String, jun: String,
                         jul: String, aug: String, sep: String,
                         oct: String, nov: String, dec: String) {

    }



    interface OnAddListener {
        fun onAddRss(city: String, type: String,
                     jan: String, feb: String, mar: String,
                     apr: String, may: String, jun: String,
                     jul: String, aug: String, sep: String,
                     oct: String, nov: String, dec: String
        )

    }
}
