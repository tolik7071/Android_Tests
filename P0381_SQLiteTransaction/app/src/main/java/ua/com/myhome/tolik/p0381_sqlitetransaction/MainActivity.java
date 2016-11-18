package ua.com.myhome.tolik.p0381_sqlitetransaction;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private class DBHelper extends SQLiteOpenHelper {

        public DBHelper(Context context) {
            super(context, "MyDB", null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            Log.d(kLogName, "onCreate");

            db.execSQL("create table my_table ("
                    + "id integer primary key autoincrement, "
                    + "val text"
                    + ")"
            );
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }

    static final String kLogName = "MyLog";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DBHelper helper = new DBHelper(this);
        SQLiteDatabase db = helper.getWritableDatabase();
        delete(db, "my_table");

        db.beginTransaction();

        insert(db, "my_table", "val1");
        insert(db, "my_table", "val2");

        db.setTransactionSuccessful();
        db.endTransaction();

        read(db, "my_table");
        db.close();

        helper.close();
    }

    void insert(SQLiteDatabase db, String tableName, String value) {
        Log.d(kLogName, "Insert " + value + " to " + tableName);

        ContentValues values = new ContentValues();
        values.put("val", value);
        db.insert(tableName, null, values);
    }

    void read(SQLiteDatabase db, String tableName) {
        Log.d(kLogName, "Read from " + tableName);

        Cursor cursor = db.query(tableName, null, null, null, null, null, null);
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    Log.d(kLogName, cursor.getString(cursor.getColumnIndex("val")));
                } while (cursor.moveToNext());
            }

            cursor.close();
        }
    }

    void delete(SQLiteDatabase db, String tableName) {
        Log.d(kLogName, "Read all from " + tableName);

        db.delete(tableName, null, null);
    }
}
