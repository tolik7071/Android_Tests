package ua.com.myhome.tolik.p0151_contextmenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.style.RelativeSizeSpan;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AnalogClock;
import android.widget.Toast;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    AnalogClock analogClock;
    RelativeLayout layout;

    final int kRedId = 0;
    final int kGreenId = 1;
    final int kBlueId = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        analogClock = (AnalogClock) findViewById(R.id.analogClock);
        assert (analogClock != null);

        layout = (RelativeLayout) findViewById(R.id.layout);
        assert (layout != null);

        registerForContextMenu(analogClock);

//        analogClock.setBackgroundColor(0x55112200);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        if (v.getId() == R.id.analogClock) {
            menu.add(0, kRedId, 0, "Red color");
            menu.add(0, kGreenId, 0, "Green color");
            menu.add(0, kBlueId, 0, "Blue color");
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

//        Toast.makeText(this.getBaseContext(), item.toString(), Toast.LENGTH_SHORT).show();
        switch (item.getItemId()) {
            case kRedId:
                layout.setBackgroundColor(0xFFFF0000);
                break;

            case kGreenId:
                layout.setBackgroundColor(0xFF00FF00);
                break;

            case kBlueId:
                layout.setBackgroundColor(0xFF0000FF);
        }

        return super.onContextItemSelected(item);
    }
}
