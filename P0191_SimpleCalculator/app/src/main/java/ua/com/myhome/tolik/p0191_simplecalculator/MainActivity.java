package ua.com.myhome.tolik.p0191_simplecalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText mLeft;
    EditText mRight;

    Button mAdd;
    Button mMinus;
    Button mMult;
    Button mDiv;

    TextView mResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        mLeft = (EditText) findViewById(R.id.editTextLeft);
        assert (mLeft != null);
        mRight = (EditText) findViewById(R.id.editTextRigth);
        assert (mRight != null);

        mAdd = (Button) findViewById(R.id.buttonAdd);
        assert (mAdd != null);
        mMinus = (Button) findViewById(R.id.buttonMinus);
        assert (mMinus != null);
        mMult = (Button) findViewById(R.id.buttonMult);
        assert (mMult != null);
        mDiv = (Button) findViewById(R.id.buttonDiv);
        assert (mDiv != null);

        mResult = (TextView) findViewById(R.id.textViewResult);
        assert (mResult != null);

        mAdd.setOnClickListener(this);
        mMinus.setOnClickListener(this);
        mMult.setOnClickListener(this);
        mDiv.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (mLeft.getText().toString().isEmpty() || mRight.getText().toString().isEmpty()) {
            Toast.makeText(this.getBaseContext(), "No imput data.", Toast.LENGTH_SHORT).show();
            return;
        }

        Integer result = null;

        try {
            switch (view.getId()) {
                case R.id.buttonAdd: {
                    result = Integer.parseInt(mLeft.getText().toString()) + Integer.parseInt(mRight.getText().toString());
                    break;
                }

                case R.id.buttonMinus: {
                    result = Integer.parseInt(mLeft.getText().toString()) - Integer.parseInt(mRight.getText().toString());
                    break;
                }

                case R.id.buttonMult: {
                    result = Integer.parseInt(mLeft.getText().toString()) * Integer.parseInt(mRight.getText().toString());
                    break;
                }

                case R.id.buttonDiv: {
                    result = Integer.parseInt(mLeft.getText().toString()) / Integer.parseInt(mRight.getText().toString());
                    break;
                }
            }

            mResult.setText(result.toString());
        }
        catch (java.lang.ArithmeticException exception) {
            Toast.makeText(this.getBaseContext(), exception.toString(), Toast.LENGTH_SHORT).show();
            mResult.setText("");
        }
    }
}
