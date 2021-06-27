package com.example.savingandretrievingdata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btSave, btRetrive;
    String myFirstName;
    TextView txFirstName;
    EditText etFirstName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txFirstName = findViewById(R.id.txFirstName);
        etFirstName =findViewById(R.id.etFirstName);
        btSave = findViewById(R.id.btSave);
        btRetrive=findViewById(R.id.btRetrive);
        final SharedPreferences myPref = getSharedPreferences("MySharedPreference", MODE_PRIVATE);

        btSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stringMyValue = etFirstName.getText().toString();
                SharedPreferences.Editor myEditor = myPref.edit();

                myEditor.putString("myNameFirst", stringMyValue);
                myEditor.apply();
                Toast.makeText(MainActivity.this, "data saved", Toast.LENGTH_SHORT).show();
            }

        });

        btRetrive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myFirstName= myPref.getString("myNameFirst", "no_value");

                txFirstName.setText(myFirstName);
            }
        });







    }
}