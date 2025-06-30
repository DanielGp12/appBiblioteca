package com.example.proyectobiblioteca;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "Usuarios.db";
    public static final int DB_VERSION = 1;

    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE Login (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "usuario TEXT, " +
                "contraseña TEXT)");

        // Usuario por defecto
        db.execSQL("INSERT INTO Login (usuario, contraseña) VALUES ('admin', '1234')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Login");
        onCreate(db);
    }

    public boolean validarUsuario(String usuario, String contraseña) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM Login WHERE usuario = ? AND contraseña = ?",
                new String[]{usuario, contraseña});
        boolean existe = cursor.getCount() > 0;
        cursor.close();
        return existe;
    }
}
