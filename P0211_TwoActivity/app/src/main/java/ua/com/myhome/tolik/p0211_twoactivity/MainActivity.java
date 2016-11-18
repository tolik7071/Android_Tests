package ua.com.myhome.tolik.p0211_twoactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button mButtonGotoLayout2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButtonGotoLayout2 = (Button) findViewById(R.id.buttonGotoLayout2);
        assert (mButtonGotoLayout2 != null);

        mButtonGotoLayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (v.getId() == R.id.buttonGotoLayout2) {
                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    startActivity(intent);
                }
//                Toast.makeText(MainActivity.this, "WOW!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
