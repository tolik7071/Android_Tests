package ua.com.myhome.tolik.activitytest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

//final StackTraceElement aTop = Thread.currentThread ().getStackTrace ()[1];
//System.out.println (aTop.getMethodName ());

public class MainActivity extends AppCompatActivity {

    final String mTagDebug = "MyLog";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

//        Log.d(mTagDebug, this.getClass().getName() + ":onCreate()");

        RelativeLayout layout = (RelativeLayout) findViewById(R.id.rootLayout);
        assert (layout != null);

        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Clicked...", Toast.LENGTH_SHORT).show();
            }
        });

        final StackTraceElement[] trace = Thread.currentThread().getStackTrace();
        Log.d(mTagDebug, trace[2].toString());
    }

    @Override
    protected void onStart() {
        super.onStart();

        final StackTraceElement[] trace = Thread.currentThread().getStackTrace();
        Log.d(mTagDebug, trace[2].toString());
    }

    @Override
    protected void onResume() {
        super.onResume();

        final StackTraceElement[] trace = Thread.currentThread().getStackTrace();
        Log.d(mTagDebug, trace[2].toString());
    }

    @Override
    protected void onPause() {
        super.onPause();

        final StackTraceElement[] trace = Thread.currentThread().getStackTrace();
        Log.d(mTagDebug, trace[2].toString());
    }

    @Override
    protected void onStop() {
        super.onStop();

        final StackTraceElement[] trace = Thread.currentThread().getStackTrace();
        Log.d(mTagDebug, trace[2].toString());
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        final StackTraceElement[] trace = Thread.currentThread().getStackTrace();
        Log.d(mTagDebug, trace[2].toString());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        final StackTraceElement[] trace = Thread.currentThread().getStackTrace();
        Log.d(mTagDebug, trace[2].toString());
    }
}
