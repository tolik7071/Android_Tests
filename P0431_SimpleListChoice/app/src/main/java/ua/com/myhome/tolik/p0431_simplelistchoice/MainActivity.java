package ua.com.myhome.tolik.p0431_simplelistchoice;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    final String LOG_TAG = "MyLog";

    ListView lvMain;
    String names[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvMain = (ListView) findViewById(R.id.lvMain);
        assert (lvMain != null);

        lvMain.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.names, android.R.layout.simple_list_item_multiple_choice);
        lvMain.setAdapter(adapter);

        names = getResources().getStringArray(R.array.names);

        Button button = (Button)findViewById(R.id.btnChecked);
        assert (button != null);

        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnChecked) {
            Log.d(LOG_TAG, "checked: ");
            SparseBooleanArray array = lvMain.getCheckedItemPositions();
            for (int i = 0; i < array.size(); i++) {
                int key = array.keyAt(i);
                if (array.get(key)) {
                    Log.d(LOG_TAG, names[key]);
                }
            }
        }
    }
}
