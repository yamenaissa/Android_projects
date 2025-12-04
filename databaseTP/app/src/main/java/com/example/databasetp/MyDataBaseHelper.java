package com.example.databasetp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDataBaseHelper extends SQLiteOpenHelper {
    public MyDataBaseHelper(Context context){super(context, "offres.db",null,1);}

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL("CREATE TABLE offres(id INTEGER PRIMARY KEY AUTOINCREMENT,poste TEXT, description TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1){
        db.execSQL("DROP TABLE IF EXISTS offres");
        onCreate(db);
    }

}
