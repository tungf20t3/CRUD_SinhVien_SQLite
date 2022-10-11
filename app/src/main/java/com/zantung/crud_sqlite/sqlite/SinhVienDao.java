package com.zantung.crud_sqlite.sqlite;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.zantung.crud_sqlite.model.SinhVien;

import java.util.ArrayList;
import java.util.List;

public class SinhVienDao {
    private SQLiteDatabase db;

    public SinhVienDao(Context context) {
        DBhelper helper = new DBhelper(context);
        db = helper.getWritableDatabase();
    }
    @SuppressLint("Range")
    public List<SinhVien> get(String sql, String ...selectArgs){
        List<SinhVien> list = new ArrayList<>();
        Cursor cursor = db.rawQuery(sql, selectArgs);
        while (cursor.moveToNext()){
            SinhVien sinhVien = new SinhVien();
            sinhVien.setId(cursor.getString(cursor.getColumnIndex("id")));
            sinhVien.setName(cursor.getString(cursor.getColumnIndex("name")));
            sinhVien.setAge(cursor.getInt(cursor.getColumnIndex("age")));

            list.add(sinhVien);
        }
        return list;
    }
    public List<SinhVien> getAll(){
        String sql = "select * from SinhVien";
        return get(sql);
    }
    public SinhVien getById(String id){
        String sql = "select * from SinhVien where id = ?";
        List<SinhVien> list = get(sql, id);
        return list.get(0);
    }
    public long insert(SinhVien sv){
        ContentValues values = new ContentValues();
        values.put("id", sv.getId());
        values.put("name", sv.getName());
        values.put("age", sv.getAge());

        return db.insert("Sinhvien", null, values);
    }
    public long update(SinhVien sv){
        ContentValues values = new ContentValues();
        values.put("name", sv.getName());
        values.put("age", sv.getAge());

        return db.update("Sinhvien", values, "id = ?", new String[]{sv.getId()});
    }
    public long delete(String id){

        return db.delete("Sinhvien", "id = ?", new String[]{id});
    }
}
