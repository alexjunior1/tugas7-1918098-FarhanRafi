package com.example.tugas_prak7;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class MyDatabase extends SQLiteOpenHelper {
    private static int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "db_gudang";
    private static final String tb_barang = "tb_barang";
    private static final String tb_barang_id = "id";
    private static final String tb_barang_nama = "nama";
    private static final String tb_barang_warna = "warna";
    private static final String tb_barang_berat = "berat";
    private static final String CREATE_TABLE_BARANG = "CREATE TABLE " +
            tb_barang + "("
            + tb_barang_id + " INTEGER PRIMARY KEY ,"
            + tb_barang_nama + " TEXT,"
            + tb_barang_warna + " TEXT,"
            + tb_barang_berat + " TEXT " + ")";

    public MyDatabase (Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_BARANG);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void CreateBarang (Barang mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_barang_id, mdNotif.get_id());
        values.put(tb_barang_nama, mdNotif.get_nama());
        values.put(tb_barang_warna, mdNotif.get_warna());
        values.put(tb_barang_berat, mdNotif.get_berat());
        db.insert(tb_barang, null, values);
        db.close();
    }

    public List<Barang> ReadBarang() {
        List<Barang> judulModelList = new ArrayList<Barang>();
        String selectQuery = "SELECT * FROM " + tb_barang;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Barang mdKontak = new Barang();
                mdKontak.set_id(cursor.getString(0));
                mdKontak.set_nama(cursor.getString(1));
                mdKontak.set_warna(cursor.getString(2));
                mdKontak.set_berat(cursor.getString(3));
                judulModelList.add(mdKontak);
            } while (cursor.moveToNext());
        }
        db.close();
        return judulModelList;
    }
    public int UpdateBarang (Barang mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_barang_nama, mdNotif.get_nama());
        values.put(tb_barang_warna, mdNotif.get_warna());
        values.put(tb_barang_berat, mdNotif.get_berat());
        return db.update(tb_barang, values, tb_barang_id + " = ?",
                new String[] { String.valueOf(mdNotif.get_id())});
    }
    public void DeleteBarang (Barang mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(tb_barang, tb_barang_id+ " = ?",
                new String[]{String.valueOf(mdNotif.get_id())});
        db.close();
    }
}

