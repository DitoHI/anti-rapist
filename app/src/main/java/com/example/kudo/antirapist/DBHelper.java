package com.example.kudo.antirapist;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Kudo on 5/17/2016.
 */
public class DBHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "AntiRapist.db";
    public static final String CONTACTS_TABLE_NAME="anti_rapist";
    public static final String CONTACTS_COLUMN_ID = "id";
    public static final String CONTACTS_COLUMN_KECAMATAN = "kecamatan";
    public static final String CONTACTS_COLUMN_JUMLAHKEJADIAN = "jumlah_kejadian";
    public static final String CONTACTS_COLUMN_ALAMAT = "alamat";
    private HashMap hp;

    public DBHelper(Context context) {
        super(context, DATABASE_NAME , null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        db.execSQL(
                "create table anti_rapist " + "(id integer primary key, kecamatan text,jumlah_kejadian integer,alamat text)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS anti_rapist");
        onCreate(db);
    }

    public boolean insertKejadian (String kecamatan, String alamat)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("kecamatan", kecamatan);
        contentValues.put("alamat", alamat);
        db.insert("anti_rapist", null, contentValues);
        return true;
    }

    public Cursor getData(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from anti_rapist where id="+id+"", null );
        return res;
    }

    public int numberOfRows(){
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, CONTACTS_TABLE_NAME);
        return numRows;
    }

//    public boolean updateContact (Integer id, String name, String nrp, String address)
//    {
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues contentValues = new ContentValues();
//        contentValues.put("name", name);
//        contentValues.put("nrp", nrp);
//        contentValues.put("address", address);
//        db.update("contacts", contentValues, "id = ? ", new String[] { Integer.toString(id) } );
//        return true;
//    }

//    public Integer deleteContact (Integer id)
//    {
//        SQLiteDatabase db = this.getWritableDatabase();
//        return db.delete("contacts", "id = ? ", new String[] { Integer.toString(id) });
//    }

    public ArrayList<String> getAllKecamatan()
    {
        ArrayList<String> array_list = new ArrayList<String>();

        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from anti_rapist", null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            array_list.add(res.getString(res.getColumnIndex(CONTACTS_COLUMN_KECAMATAN)));
            res.moveToNext();
        }
        return array_list;
    }
    public ArrayList<String> getAllJumlah()
    {
        ArrayList<String> array_list = new ArrayList<String>();

        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from anti_rapist", null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            array_list.add(res.getString(res.getColumnIndex(CONTACTS_COLUMN_JUMLAHKEJADIAN)));
            res.moveToNext();
        }
        return array_list;
    }
    public ArrayList<String> getAllAlamat()
    {
        ArrayList<String> array_list = new ArrayList<String>();

        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from anti_rapist", null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            array_list.add(res.getString(res.getColumnIndex(CONTACTS_COLUMN_ALAMAT)));
            res.moveToNext();
        }
        return array_list;
    }
//    public ArrayList<String> getAllData()
//    {
//        ArrayList<String> array_list = new ArrayList<String>();
//
//        //hp = new HashMap();
//        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor res =  db.rawQuery( "select * from anti_rapist", null );
//        res.moveToFirst();
//
//        while(res.isAfterLast() == false){
//            array_list.add("Kecamatan\t: " + res.getString(res.getColumnIndex(CONTACTS_COLUMN_KECAMATAN)) + "\n\t: " +
//                    res.getString(res.getColumnIndex(CONTACTS_COLUMN_NRP)) + "\nAlamat\t: " +  res.getString(res.getColumnIndex(CONTACTS_COLUMN_ADDRESS)));
//            res.moveToNext();
//        }
//        return array_list;
//    }
}
