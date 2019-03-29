package top.qvisa.experimentfive;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.List;

public class DAO {
    private final MyDatabaseHelper mDb;

    public DAO(Context context) {
        mDb = new MyDatabaseHelper(context);
    }

    public void insert(String name, String sex, String department, String salary_string) {
        SQLiteDatabase db = mDb.getWritableDatabase();
        ContentValues values = new ContentValues();
        Float salary = Float.parseFloat(salary_string);

        values.put("name", name);
        values.put("sex", sex);
        values.put("department", department);
        values.put("salary", salary);
        db.insert("staff", null, values);

        values.clear();

    }

    public void update(String name, String sex, String department, String salary_string) {
        SQLiteDatabase db = mDb.getWritableDatabase();
        ContentValues values = new ContentValues();

        if (!sex.equals("")) {
            values.put("sex", sex);
        }
        if (!department.equals("")) {
            values.put("department", department);
        }
        if (!salary_string.equals("")) {
            Float salary = Float.parseFloat(salary_string);
            values.put("salary", salary);
        }
        db.update("staff", values, "name = ?", new String[]{name});

        values.clear();

    }

    public void delete(String name) {
        SQLiteDatabase db = mDb.getWritableDatabase();
        db.delete("staff", "name = ?", new String[]{name});
    }

    public void query(List<Staff> mList_staff) {
        SQLiteDatabase db = mDb.getWritableDatabase();
        Cursor cursor = db.query("staff", null, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                String name = cursor.getString(cursor.getColumnIndex("name"));
                String sex = cursor.getString(cursor.getColumnIndex("sex"));
                String department = cursor.getString(cursor.getColumnIndex("department"));
                float salary = cursor.getFloat(cursor.getColumnIndex("salary"));
                Log.d("query", "name--->>" + name);
                Log.d("query", "sex--->>" + sex);
                Log.d("query", "department--->>" + department);
                Log.d("query", "salary--->>" + salary);
                Staff staff = new Staff(name,sex,department,salary);
                mList_staff.add(staff);
            } while (cursor.moveToNext());
        }
        cursor.close();
    }
}
