package leyva.josef.xizuth.pip;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import leyva.josef.xizuth.pip.about.About;
import leyva.josef.xizuth.pip.lib.PerdidaInsensible;
import leyva.josef.xizuth.pip.lib.SuperficieCorporal;

public class MainActivity extends AppCompatActivity {

    private Button calculate;
    private EditText weight, timeFever, other;
    private TextView result;
    private boolean timeExt = false;
    private double time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isEmpty())
                    calculateResult();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.menu_about:
                startActivity(new Intent(MainActivity.this, About.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void init() {
        String[] ts = getResources().getStringArray(R.array.turns);
        calculate = (Button) findViewById(R.id.calculate);
        weight = (EditText) findViewById(R.id.weight);
        timeFever = (EditText) findViewById(R.id.time_fever);
        other = (EditText) findViewById(R.id.other);
        Spinner turns = (Spinner) findViewById(R.id.turns);
        result = (TextView) findViewById(R.id.result);

        ArrayAdapter adapter = new ArrayAdapter<>(
                MainActivity.this,
                android.R.layout.simple_spinner_dropdown_item,
                ts
        );

        turns.setAdapter(adapter);
        turns.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                switch (position) {
                    case 0:
                        other.setVisibility(View.GONE);
                        timeExt = false;
                        time = 8;
                        break;
                    case 1:
                        timeExt = false;
                        other.setVisibility(View.GONE);
                        time = 12;
                        break;
                    case 2:
                        timeExt = true;
                        other.setVisibility(View.VISIBLE);
                        other.setFocusable(true);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    private void calculateResult() {
        double w = Double.parseDouble(weight.getText().toString());
        double tF = Double.parseDouble(timeFever.getText().toString());
        double sc = superficieCorporal(w);
        Log.e("MainA", "calculateResult: SC" + sc);

        if (timeExt)
            time = Double.parseDouble(other.getText().toString());

        PerdidaInsensible perdidaInsensible = new PerdidaInsensible(sc, tF, time);

        result.setText(String.format("%.2f ml", perdidaInsensible.getPITotal()));
    }

    private double superficieCorporal(double w) {
        double r;
        if (w <= SuperficieCorporal.K_SC_10) {
            r = SuperficieCorporal.scLess10(w);
        } else {
            r = SuperficieCorporal.scMore10(w);
        }
        return r;
    }

    private boolean isEmpty() {
        EditText[] e = {weight, timeFever};

        boolean empty = false;

        for (EditText ed : e) {
            if (ed.getText().toString().isEmpty())
                empty = true;
        }

        if (timeExt)
            if (other.getText().toString().isEmpty())
                empty = true;

        if (empty) {
            Toast.makeText(this, "Faltan datos", Toast.LENGTH_SHORT).show();
        }

        return empty;
    }

}
