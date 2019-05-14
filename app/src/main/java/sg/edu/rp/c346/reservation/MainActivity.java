package sg.edu.rp.c346.reservation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etName;
    EditText etNum;
    EditText etPax;
    CheckBox cbSmoke;
    DatePicker dp;
    TimePicker tp;
    Button btnSubmit;
    Button btnReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.editTextName);
        etNum = findViewById(R.id.editTextMobile);
        etPax = findViewById(R.id.editTextPax);
        cbSmoke = findViewById(R.id.checkBoxSmoke);
        dp = findViewById(R.id.datePicker);
        tp = findViewById(R.id.timePicker);
        btnSubmit = findViewById(R.id.buttonSubmit);
        btnReset = findViewById(R.id.buttonReset);

        dp.updateDate(2019, 6-1, 1    );
        tp.setCurrentHour(19);
        tp.setCurrentMinute(30);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button

                String msgSmoke = "";
                if (cbSmoke.isChecked()) {
                    msgSmoke = "Smoking Area";
                }
                else {
                    msgSmoke = "Non-Smoking Area";
                }

                if (etName.getText().toString().isEmpty() && etNum.getText().toString().isEmpty() && etPax.getText().toString().isEmpty()) {

                    Integer duration = Toast.LENGTH_SHORT;
                    Toast.makeText(getApplicationContext(), "Please Fill in all required fields", duration).show();

                }

                else{

                    Integer duration = Toast.LENGTH_LONG;
                    Integer month = dp.getMonth()+1;
                    String date = dp.getDayOfMonth() + "/" + month + "/" + dp.getYear();
                    String time = tp.getCurrentHour() + ":" + tp.getCurrentMinute();

                    String message = "Name: " + etName.getText().toString() + "\n" + "Mobile No.: " + etNum.getText().toString() + "\n" + "Pax: " + etPax.getText().toString() + "\n" + "Date: " + date + "\n" + "Time: " + time + "\n" + "Area: " + msgSmoke;

                    Toast.makeText(getApplicationContext(), message, duration).show();

                }

            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button

                etName.setText("");
                etNum.setText("");
                etPax.setText("");
                cbSmoke.setChecked(false);

                dp.updateDate(2019, 6-1, 1    );
                tp.setCurrentHour(19);
                tp.setCurrentMinute(30);

            }
        });

    }
}
