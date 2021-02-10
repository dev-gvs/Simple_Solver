package kz.gvsx.simplesolver;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    TextView textViewY;
    EditText numberX;
    EditText numberA;
    EditText numberB;
    EditText numberC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewY = findViewById(R.id.textViewY);
        numberX = findViewById(R.id.editTextNumberX);
        numberA = findViewById(R.id.editTextNumberA);
        numberB = findViewById(R.id.editTextNumberB);
        numberC = findViewById(R.id.editTextNumberC);

        if (savedInstanceState != null) {
            textViewY.setText(savedInstanceState.getString("y"));
        }
    }

    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("y", textViewY.getText().toString());
    }

    public void onButtonSolveClick(View view) {
        double x, a, b, c, y;

        try {
            x = Double.parseDouble(numberX.getText().toString().trim());
            a = Double.parseDouble(numberA.getText().toString().trim());
            b = Double.parseDouble(numberB.getText().toString().trim());

            if (x < 4) {
                c = Double.parseDouble(numberC.getText().toString().trim());
                y = ((x * x + a * a) * c) / (2 * b);
            } else {
                y = (x * x * x) * (a - b);
            }

            DecimalFormat df = new DecimalFormat("#.##");
            textViewY.setText("y = " + df.format(y));
        } catch (Exception e) {
            Toast.makeText(this, "Неверные данные", Toast.LENGTH_LONG).show();
        }

        clearFocuses();
    }

    public void onButtonClearClick(View view) {
        textViewY.setText("y = ");
        numberX.setText("");
        numberA.setText("");
        numberB.setText("");
        numberC.setText("");
        clearFocuses();
    }

    private void clearFocuses() {
        numberX.clearFocus();
        numberA.clearFocus();
        numberB.clearFocus();
        numberC.clearFocus();
    }
}