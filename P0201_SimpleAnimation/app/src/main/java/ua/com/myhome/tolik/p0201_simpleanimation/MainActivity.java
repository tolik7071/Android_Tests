package ua.com.myhome.tolik.p0201_simpleanimation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        mTextView = (TextView) findViewById(R.id.myView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        return super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.main, menu);

        return  true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        Animation animation = null;

        switch (item.getItemId()) {

            case R.id.alpha:
                animation = AnimationUtils.loadAnimation(this.getBaseContext(), R.anim.myalpha);
                break;

            case R.id.combo:
                animation = AnimationUtils.loadAnimation(this.getBaseContext(), R.anim.mycombo);
                break;

            case R.id.rotate:
                animation = AnimationUtils.loadAnimation(this.getBaseContext(), R.anim.myrotate);
                break;

            case  R.id.scale:
                animation = AnimationUtils.loadAnimation(this.getBaseContext(), R.anim.myscale);
                break;

            case R.id.transition:
                animation = AnimationUtils.loadAnimation(this.getBaseContext(), R.anim.mytrans);
                break;
        }

        if (animation != null) {
            mTextView.startAnimation(animation);
        }

        return  true;
    }
}
