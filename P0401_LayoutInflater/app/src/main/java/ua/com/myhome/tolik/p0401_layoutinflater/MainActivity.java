package ua.com.myhome.tolik.p0401_layoutinflater;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MainActivity extends AppCompatActivity {

    final String kMyLogKey = "MyLog";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LayoutInflater inflater = getLayoutInflater();

        View view = inflater.inflate(R.layout.text, null, false);
        assert (view != null);

        ViewGroup.LayoutParams params = view.getLayoutParams();
        assert (params != null);

        Log.d(kMyLogKey, view.getClass().getName());
        for (int i = 0; i < ((ViewGroup)view).getChildCount(); i++) {
            Log.d(kMyLogKey, ((ViewGroup)view).getChildAt(i).getClass().getName());
        }

        ViewGroup linearLayout = (ViewGroup) findViewById(R.id.linearLayout);
        assert (linearLayout != null);

        linearLayout.addView(view);

        ViewGroup relativeLayout = (ViewGroup) findViewById(R.id.relativeLayout);
        assert (relativeLayout != null);

        view = inflater.inflate(R.layout.text, relativeLayout, true);
    }
}
