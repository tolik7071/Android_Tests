package ua.com.myhome.tolik.activityresult;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;

public class AligmentActivity extends AppCompatActivity implements  View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aligment);

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
            case R.id.buttonLeft:
                intent.putExtra("aligment", Gravity.LEFT);
                break;

            case R.id.buttonCenter:
                intent.putExtra("aligment", Gravity.CENTER);
                break;

            case  R.id.buttonRight:
                intent.putExtra("aligment", Gravity.RIGHT);
                break;
        }

        setResult(RESULT_OK, intent);
        finish();
    }
}
