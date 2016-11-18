package ua.com.myhome.tolik.p0111_resvalues;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Button button = (Button) findViewById(R.id.buttonClickMe);
        assert (button != null);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Button button = (Button) v;
                RelativeLayout parent = (RelativeLayout) v.getParent();
                assert (parent != null);

                final int kMin = 0x00;
                final int kMax = 0xFF;
                parent.setBackgroundColor(Color.rgb(
                        kMin + (int) (Math.random() * (double) ((kMax - kMin) + 1)),
                        kMin + (int) (Math.random() * (double) ((kMax - kMin) + 1)),
                        kMin + (int) (Math.random() * (double) ((kMax - kMin) + 1))));
            }
        });
    }
}
