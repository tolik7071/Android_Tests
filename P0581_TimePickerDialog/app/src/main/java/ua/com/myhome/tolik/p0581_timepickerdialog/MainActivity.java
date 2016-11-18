package ua.com.myhome.tolik.p0581_timepickerdialog;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import static ua.com.myhome.tolik.p0581_timepickerdialog.R.id.tvTime;

public class MainActivity extends Activity {

    int DIALOG_TIME = 1;
    int DIALOG_DATE = 2;

    int myHour = 14;
    int myMinute = 35;

    int myYear = 2016;
    int myMonth = 1;
    int myDay = 2;

    TextView textView;
    boolean useDate = true;

    /** Called when the activity is first created. */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(tvTime);
    }

    public void onclick(View view) {
        showDialog(useDate ? DIALOG_DATE : DIALOG_TIME);
    }

    protected Dialog onCreateDialog(int id) {
        if (id == DIALOG_TIME) {
            TimePickerDialog tpd = new TimePickerDialog(this, myTimeCallBack, myHour, myMinute, true);
            return tpd;
        }
        else if (id == DIALOG_DATE) {
            DatePickerDialog dpd = new DatePickerDialog(this, myDateCallBack, 2016, 3, 1);
            return dpd;
        }

        return super.onCreateDialog(id);
    }

    OnTimeSetListener myTimeCallBack = new OnTimeSetListener() {
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            myHour = hourOfDay;
            myMinute = minute;
            textView.setText("Time is " + myHour + " hours " + myMinute + " minutes");
        }
    };

    DatePickerDialog.OnDateSetListener myDateCallBack = new OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
            myYear = i;
            myMonth = i1;
            myDay = i2;
            textView.setText("Today is " + myDay + "/" + myMonth + "/" + myYear);
        }
    };
}
