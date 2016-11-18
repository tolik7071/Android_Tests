package ua.com.myhome.tolik.sqlitetest;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText mName;
    EditText mEmail;
    Button mAdd;
    Button mRead;
    Button mClear;
    DBHelper mDBHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mName = (EditText) findViewById(R.id.editTextName);
        assert (mName != null);

        mEmail = (EditText) findViewById(R.id.editTextEmail);
        assert (mEmail != null);

        mAdd = (Button) findViewById(R.id.buttonAdd);
        assert (mAdd != null);
        mAdd.setOnClickListener(this);

        mRead = (Button) findViewById(R.id.buttonRead);
        assert (mRead != null);
        mRead.setOnClickListener(this);

        mClear = (Button) findViewById(R.id.buttonClear);
        assert (mClear != null);
        mClear.setOnClickListener(this);

        mDBHelper = new DBHelper(this);
    }

    @Override
    public void onClick(View v) {
        SQLiteDatabase db = mDBHelper.getWritableDatabase();
        ContentValues content = new ContentValues();

        switch (v.getId()) {
            case R.id.buttonAdd:
                if (!mName.getText().toString().isEmpty() && !mEmail.getText().toString().isEmpty()) {
                    content.put(DBHelper.KEY_NAME, mName.getText().toString());
                    content.put(DBHelper.KEY_EMAIL, mEmail.getText().toString());
                    db.insert(DBHelper.TABLE_CONTACTS, null, content);
                }else {
                    Toast.makeText(MainActivity.this, "Input error", Toast.LENGTH_SHORT).show();
                }

                break;

            case R.id.buttonRead:
                Cursor cursor = db.query(DBHelper.TABLE_CONTACTS, null, null, null, null, null, null);

                if (cursor.moveToFirst()) {
                    int idIndex = cursor.getColumnIndex(DBHelper.KEY_ID);
                    int nameIndex = cursor.getColumnIndex(DBHelper.KEY_NAME);
                    int emailIndex = cursor.getColumnIndex(DBHelper.KEY_EMAIL);

                    do {
                        Log.d("MyLog"
                                        , "ID = " + cursor.getString(idIndex) + "\n"
                                        + "Name = " + cursor.getString(nameIndex) + "\n"
                                        + "Email = " + cursor.getString(emailIndex)
                        );
                    } while (cursor.moveToNext());
                } else {
                    Toast.makeText(MainActivity.this, "Database is empty", Toast.LENGTH_SHORT).show();
                }

                cursor.close();

                break;

            case R.id.buttonClear:
                db.delete(DBHelper.TABLE_CONTACTS, null, null);
                break;
        }

        db.close();
    }
}
