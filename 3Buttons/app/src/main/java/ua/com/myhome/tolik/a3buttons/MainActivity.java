package ua.com.myhome.tolik.a3buttons;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView mTextView;
    Button mButton1;
    Button mButton2;
    Button mButton3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        mTextView = (TextView) findViewById(R.id.textView);
        assert (mTextView != null);

        mButton1 = (Button) findViewById(R.id.button1);
        assert (mButton1 != null);
        mButton2 = (Button) findViewById(R.id.button2);
        assert (mButton2 != null);
        mButton3 = (Button) findViewById(R.id.button3);
        assert (mButton3 != null);

        mButton1.setOnClickListener(this);

        mButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTextView.setText(((Button)v).getText());
            }
        });
    }

    @Override
    public void onClick(View v) {
        mTextView.setText(((Button)v).getText());
    }
}
