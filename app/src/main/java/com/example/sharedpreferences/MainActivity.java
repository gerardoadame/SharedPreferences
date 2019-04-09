package com.example.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText texto;
    Button btn1,btn2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        texto= findViewById(R.id.texto);
        btn1=findViewById(R.id.button);
        btn2=findViewById(R.id.button2);

        final Context context= this;
        final SharedPreferences sharedPreferences= getSharedPreferences("ArchivoSP",context.MODE_PRIVATE);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putString("MiNombre", texto.getText().toString());
                editor.commit();

            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String dato = sharedPreferences.getString("MiNombre","Nacho");
                Toast.makeText(getApplicationContext(),dato,Toast.LENGTH_LONG).show();

            }
        });


    }
}
