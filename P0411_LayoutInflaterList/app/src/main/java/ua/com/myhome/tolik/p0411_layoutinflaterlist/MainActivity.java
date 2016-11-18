package ua.com.myhome.tolik.p0411_layoutinflaterlist;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    class PersonData {
        String name;
        String position;
        int salary;

        PersonData(String name, String position, int salary) {
            this.name = name;
            this.position = position;
            this.salary = salary;
        }
    }

    PersonData people[] = {
            new PersonData("Иван", "Программистр", 2500),
            new PersonData("Мария", "Уборщица", 250),
            new PersonData("Геннадий", "Программистр", 2000),
            new PersonData("Владимир", "Программистр", 3000),
            new PersonData("Константин", "Программистр", 3500),
            new PersonData("Егор", "Директор", 5000),
            new PersonData("Наталья", "Бухгалтер", 2500)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout root = (LinearLayout) findViewById(R.id.linLayout);
        assert (root != null);

        int colors[] = {
                Color.parseColor("#559966CC"),
                Color.parseColor("#553366CC")
        };

        LayoutInflater inflater = getLayoutInflater();

        for (int i = 0; i < people.length; i++) {
            View item = inflater.inflate(R.layout.item, root, false);

            TextView tv;

            tv = (TextView) item.findViewById(R.id.tvName);
            tv.setText(people[i].name);

            tv = (TextView) item.findViewById(R.id.tvPosition);
            tv.setText(people[i].position);

            tv = (TextView) item.findViewById(R.id.tvSalary);
            tv.setText(String.valueOf(people[i].salary));

            item.getLayoutParams().width = ViewGroup.LayoutParams.MATCH_PARENT;
            item.setBackgroundColor(colors[i % 2]);
            root.addView(item);
        }
    }
}
