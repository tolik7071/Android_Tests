package ua.com.myhome.tolik.simpleactivityresult;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ActivityName extends AppCompatActivity implements View.OnClickListener {

    EditText mEditTextName;
    Button mButtonSubmitName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);

        mEditTextName = (EditText) findViewById(R.id.editTextName);
        assert (mEditTextName != null);

        mButtonSubmitName = (Button) findViewById(R.id.buttonSubmitName);
        assert (mButtonSubmitName != null);
        mButtonSubmitName.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        intent.putExtra("name", mEditTextName.getText().toString());
        setResult(RESULT_OK, intent);
        finish();
    }
}
