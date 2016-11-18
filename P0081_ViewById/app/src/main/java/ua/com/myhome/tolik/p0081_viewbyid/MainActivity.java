package ua.com.myhome.tolik.p0081_viewbyid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Button myButton = (Button) findViewById(R.id.myButton);
        assert (myButton != null);
        myButton.setEnabled(true);
        myButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        TextView myTextView = (TextView) findViewById(R.id.myText);
        assert (myTextView != null);
        myTextView.setText("Oops!!!");
    }
}
