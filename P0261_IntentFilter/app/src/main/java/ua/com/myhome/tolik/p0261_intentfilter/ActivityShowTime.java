package ua.com.myhome.tolik.p0261_intentfilter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ActivityShowTime extends AppCompatActivity {

    TextView mTextViewShowTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_time);

        mTextViewShowTime = (TextView) findViewById(R.id.textViewTime);
        assert (mTextViewShowTime != null);
    }

    @Override
    protected void onStart() {
        super.onStart();

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

        mTextViewShowTime.setText(dateFormat.format(calendar.getTime()));
    }
}
