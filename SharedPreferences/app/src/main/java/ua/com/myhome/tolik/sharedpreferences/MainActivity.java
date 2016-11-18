package ua.com.myhome.tolik.sharedpreferences;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.*;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText mTextField;
    CheckBox mUseGlobalLocation;
    final String SAVED_STRING_KEY = "SAVED_STRING";
    final String SHARED_SETTINGS_FILE_NAME = "MY_SETTINGS";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button;

        button = (Button) findViewById(R.id.buttonSave);
        button.setOnClickListener(this);

        button = (Button) findViewById(R.id.buttonLoad);
        button.setOnClickListener(this);

        mTextField = (EditText) findViewById(R.id.editText);
        assert (mTextField != null);

        mUseGlobalLocation =(CheckBox) findViewById(R.id.checkBoxGlobalLocation);
        assert (mUseGlobalLocation != null);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonSave:
                saveSettings();
                Toast.makeText(MainActivity.this, "Data has been saved", Toast.LENGTH_SHORT).show();
                break;

            case R.id.buttonLoad:
                loadSettings();
                Toast.makeText(MainActivity.this, "Data has been read", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    private void saveSettings() {
        SharedPreferences preferences;

        if (!mUseGlobalLocation.isChecked()) {
            preferences = getPreferences(MODE_PRIVATE);
        }
        else {
            preferences = getSharedPreferences(SHARED_SETTINGS_FILE_NAME, MODE_PRIVATE);
        }

        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(SAVED_STRING_KEY, mTextField.getText().toString());
        editor.commit();
    }

    private void loadSettings() {
        SharedPreferences preferences;

        if (!mUseGlobalLocation.isChecked()) {
            preferences = getPreferences(MODE_PRIVATE);
        }
        else {
            preferences = getSharedPreferences(SHARED_SETTINGS_FILE_NAME, MODE_PRIVATE);
        }

        mTextField.setText(preferences.getString(SAVED_STRING_KEY, ""));
    }

    @Override
    protected void onStart() {
        super.onStart();

        loadSettings();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        saveSettings();
    }
}
