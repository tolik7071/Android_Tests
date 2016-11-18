package ua.com.myhome.tolik.simpleactivityresult;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    final int kRequestName = 99;

    TextView mTextViewName;
    Button mButtonInputName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextViewName = (TextView) findViewById(R.id.textViewYourName);
        assert (mTextViewName != null);

        mButtonInputName = (Button) findViewById(R.id.buttonInputName);
        assert (mButtonInputName != null);
        mButtonInputName.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, ActivityName.class);
        startActivityForResult(intent, kRequestName);
    }

    @Override
        protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (data == null) {
            return;
        }

        String returnedName = data.getStringExtra("name");
        mTextViewName.setText("Your name is " + returnedName);
    }
}
