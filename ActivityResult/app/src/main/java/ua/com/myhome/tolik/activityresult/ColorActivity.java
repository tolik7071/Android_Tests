package ua.com.myhome.tolik.activityresult;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.*;

public class ColorActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);

        ViewGroup rootLayout = (ViewGroup) findViewById(R.id.rootLayout);
        assert (rootLayout != null);

        for (int i = 0; i < rootLayout.getChildCount(); ++i) {
            View view = rootLayout.getChildAt(i);
            view.setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();

        switch (v.getId()) {
            case R.id.buttonRed:
                intent.putExtra("color", Color.RED);
                break;

            case R.id.buttonGreen:
                intent.putExtra("color", Color.GREEN);
                break;

            case  R.id.buttonBlue:
                intent.putExtra("color", Color.BLUE);
                break;
        }

        setResult(RESULT_OK, intent);
        finish();
    }
}
