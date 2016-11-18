package ua.com.myhome.tolik.simpleintents;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewGroup rootView = (ViewGroup) findViewById(R.id.rootView);
        assert (rootView != null);

        for (int i = 0; i < rootView.getChildCount(); ++i) {
            View view = rootView.getChildAt(i);
            if (view instanceof Button ) {
                ((Button)view).setOnClickListener(this);
            }

        }
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;

        switch (v.getId()) {
            case R.id.buttonWeb:
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://developer.android.com"));
                break;

            case R.id.buttonMap:
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:-0.45609946,-90.26607513"));
                break;

            case R.id.buttonCall:
                intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:+380634428349"));
                break;
        }

        if (intent != null) {
            startActivity(intent);
        }
    }
}
