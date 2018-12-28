package zo.den.testtask5.model

import android.content.Context

class DBProvider (private val context: Context) {

    val db : Db by lazy { Db(context) }

}