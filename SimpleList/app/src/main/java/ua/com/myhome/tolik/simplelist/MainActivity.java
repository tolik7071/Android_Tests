package ua.com.myhome.tolik.simplelist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    String people[] = {
            "Илья",
            "Иван",
            "Марьяна",
            "Олег",
            "Юлия"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView list = (ListView) findViewById(R.id.listView);
        assert (list != null);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, people);
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.list_item, people);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Log.d("MyLog", "OnItemClickListener: position " + position + ", id " + id);
            }
        });

        list.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                Log.d("MyLog", "OnItemSelectedListener: position " + position + ", id " + id);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Log.d("MyLog", "NothingSelected");
            }
        });

        list.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView absListView, int i) {
                Log.d("MyLog", "onScrollStateChanged");
            }

            @Override
            public void onScroll(AbsListView absListView, int i, int i1, int i2) {
                Log.d("MyLog", "onScroll");
            }
        });
    }
}
