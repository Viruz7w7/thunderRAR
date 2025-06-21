package com.example.thunder;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class BaseDeDatosUsers extends SQLiteOpenHelper {

    public BaseDeDatosUsers(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase BaseDeDatos) {
        BaseDeDatos.execSQL("create table users (usuario text primary key, password text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase BaseDeDatos, int oldVersion, int newVersion) {

    }
}
