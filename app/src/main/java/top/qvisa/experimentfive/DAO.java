package top.qvisa.experimentfive;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class DAO {
    private final MyDatabaseHelper mDb;

    public DAO(Context context ) {
        mDb = new MyDatabaseHelper(context);
    }

    public void insert(String title,String Content) {
        SQLiteDatabase db = mDb.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("title", title);
        values.put("content", Content);
        db.insert("Note", null, values);
        values.clear();

    }
}
