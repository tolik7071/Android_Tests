package ua.com.myhome.tolik.p0121_logandmessages;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Button buttonClickMe = (Button) findViewById(R.id.buttonClickMe);
        assert (buttonClickMe != null);

        buttonClickMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("MY_OUTPUT", v.toString());
                Toast.makeText(v.getContext(), "Click me pressed", Toast.LENGTH_LONG).show();
            }
        });
    }
}
