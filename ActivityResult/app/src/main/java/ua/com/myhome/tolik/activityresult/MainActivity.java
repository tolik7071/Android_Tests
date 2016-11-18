package ua.com.myhome.tolik.activityresult;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener {

    final int REQUEST_CODE_COLOR = 1;
    final int REQUEST_CODE_ALIGMENT = 2;

    TextView mTextView;
    Button mButtonColor;
    Button mButtonAligment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = (TextView) findViewById(R.id.textView);
        assert (mTextView != null);

        mButtonColor = (Button) findViewById(R.id.buttonColor);
        assert (mButtonColor != null);
        mButtonColor.setOnClickListener(this);

        mButtonAligment = (Button) findViewById(R.id.buttonAligment);
        assert (mButtonAligment != null);
        mButtonAligment.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;

        switch (v.getId()) {
            case R.id.buttonColor:
                intent = new Intent(this, ColorActivity.class);
                startActivityForResult(intent, REQUEST_CODE_COLOR);
                break;

            case R.id.buttonAligment:
                intent = new Intent(this, AligmentActivity.class);
                startActivityForResult(intent, REQUEST_CODE_ALIGMENT);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case REQUEST_CODE_COLOR:
                    mTextView.setTextColor(data.getIntExtra("color", Color.CYAN));
                    break;

                case REQUEST_CODE_ALIGMENT:
                    mTextView.setGravity(data.getIntExtra("aligment", Gravity.LEFT));
                    break;
            }
        }
    }
}
