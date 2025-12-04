package com.example.databasetp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class DAO {
    SQLiteDatabase db;

    public DAO(Context context){
        db=new MyDataBaseHelper(context).getWritableDatabase();
    }

    public void addOffre(Offre offre){
        ContentValues cv= new ContentValues();
        cv.put("poste", offre.poste);
        cv.put("description",offre.description);
        db.insert("offres",null,cv);
    }

    public List<Offre> getAllOffres(){
        List<Offre> l=new ArrayList<>();
        Cursor c=db.rawQuery("select * from offres", null);
        while(c.moveToNext()){
            l.add(new Offre(c.getInt(0), c.getString(1), c.getString(2)));
        }
        c.close();
        return l;
    }

    public void updateOffre(int id, String poste, String desc){
        ContentValues cv=new ContentValues();
        cv.put("poste",poste);
        cv.put("description",desc);
        db.update("offres", cv, "id=?", new String[]{String.valueOf(id)});
    }

    public void deleteOffre(int id){
        db.delete("offres", "id=?", new String[]{String.valueOf(id)});
    }
}
