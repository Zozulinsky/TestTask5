package zo.den.testtask5.model

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class SQLiteOH constructor(context: Context) : SQLiteOpenHelper(context, "weather.db", null, 1){
    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL("CREATE TABLE cities(city TEXT UNIQUE PRIMARY KEY NOT NULL, type TEXT)")
        db.execSQL("CREATE TABLE logs(month TEXT, temperature INTEGER, city TEXT, FOREIGN KEY(city) REFERENCES cities(city) ON DELETE CASCADE)")
        db.execSQL("PRAGMA foreign_keys = ON")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
    }
}