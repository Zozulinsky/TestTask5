package zo.den.testtask5.model

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context

class Db constructor(private val context: Context) {
    companion object {
        private const val TABLE_NAME_CITIES = "cities"
        private const val TABLE_NAME_LOGS = "logs"
        private const val COLUMN_CITY = "city"
        private const val COLUMN_TYPE = "type"
        private const val COLUMN_MONTH = "month"
        private const val COLUMN_TEMP = "temperature"

        @SuppressLint("StaticFieldLeak")
        private var db: Db? = null
        fun getInstance(context: Context) {
            return synchronized(Db::class) {
                db.let {
                    if (it == null) {
                        val dbLocal = Db(context.applicationContext)
                        dbLocal
                    } else
                        it
                }.also {
                    db = it
                }
            }
        }

    }

    var sqLiteOH: SQLiteOH = SQLiteOH(context)

     fun getAllCity(): List<City> {
        return synchronized(this) {
            sqLiteOH.writableDatabase.use {
                it.query(TABLE_NAME_CITIES, null, null, null,
                        null, null, COLUMN_CITY)
                        .use { cursor ->
                            val list = arrayListOf<City>()
                            while (cursor.moveToNext()) {
                                val city = City(
                                        cursor.getString(cursor.getColumnIndex("city")),
                                        cursor.getString(cursor.getColumnIndex("type"))
                                )
                                list.add(city)
                            }
                            list
                        }
            }
        }
    }

     fun getLogs(city: City): HashMap<String, Int> {
        return synchronized(this) {
            sqLiteOH.writableDatabase.use {
                it.query(TABLE_NAME_LOGS, null, COLUMN_CITY + "LIKE ? ", arrayOf(city.city), null, null, null)
                        .use { cursor ->
                            val map = HashMap<String, Int>()
                            while (cursor.moveToNext()) {
                                val logs = Logs(
                                        city.city,
                                        cursor.getString(cursor.getColumnIndex("month")),
                                        cursor.getInt(cursor.getColumnIndex("temperature"))
                                )
                                map.put(logs.month, logs.temperature)
                            }
                            map
                        }
            }
        }
    }

     fun deleteCity(city: City) {
        synchronized(this) {
            sqLiteOH.writableDatabase.use {
                it.delete(TABLE_NAME_CITIES, "city=?", arrayOf(city.city))
            }
        }
    }

     fun insertCity(city: City) {
        synchronized(this) {
            sqLiteOH.writableDatabase.use {
                it.insert(TABLE_NAME_CITIES, null, ContentValues().apply {
                    put(COLUMN_CITY, city.city)
                    put(COLUMN_TYPE, city.type)
                })
            }
        }
    }

     fun insertLog(logs: Logs) {
        synchronized(this) {
            sqLiteOH.writableDatabase.use {
                it.insert(TABLE_NAME_LOGS, null, ContentValues().apply {
                    put(COLUMN_CITY, logs.city)
                    put(COLUMN_MONTH, logs.month)
                    put(COLUMN_TEMP, logs.temperature)
                })
            }
        }
    }

     fun updateCity(city: City) {
        synchronized(this) {
            sqLiteOH.writableDatabase.use {
                it.update(TABLE_NAME_CITIES, ContentValues().apply {
                    put(COLUMN_CITY, city.city)
                    put(COLUMN_TYPE, city.type)
                }, "city=?", arrayOf(city.city))
            }
        }
    }

     fun updateLog(logs: Logs) {
        synchronized(this) {
            sqLiteOH.writableDatabase.use {
                it.update(TABLE_NAME_LOGS, ContentValues().apply {
                    put(COLUMN_CITY, logs.city)
                    put(COLUMN_MONTH, logs.month)
                    put(COLUMN_TEMP, logs.temperature)
                }, "city=?", arrayOf(logs.city))
            }
        }
    }


}