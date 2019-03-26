package top.qvisa.experimentfive;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class MyDatabaseHelper extends SQLiteOpenHelper {

    private static final String CREATE_Table_staff = "create table staff ("
            + "_id integer primary key autoincrement,"
            + "name text,"
            + "sex text,"
            + "department text,"
            + "salary float)";


    public MyDatabaseHelper(Context context) {
        super(context, "test.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_Table_staff);
        Log.d("MyDatabaseHelper","CREATE Table");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists staff");
        onCreate(db);
        Log.d("MyDatabaseHelper","Update Table");
    }
}
