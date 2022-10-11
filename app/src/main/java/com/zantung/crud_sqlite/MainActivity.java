package com.zantung.crud_sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;

import com.zantung.crud_sqlite.sqlite.DBhelper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DBhelper dBhelper = new DBhelper(this);
        SQLiteDatabase database = dBhelper.getReadableDatabase();
        database.close();
    }
}