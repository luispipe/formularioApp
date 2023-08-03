package com.example.formularioapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
// AppCompatActivity se encarga de adaptar la vista de la APP
// a cualquier versión de android posterior a nuestro min SDK

    //Metodo OnCreate se encarga de contruir la vista(una interfaz)
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //set --> actualizar o modificar
        //get --> obtener
        EditText name = findViewById(R.id.editTextName);
        EditText address= findViewById(R.id.editTextTextPostalAddress);
        EditText phone= findViewById(R.id.editTextPhone);
        EditText email= findViewById(R.id.editTextTextEmailAddress);
        RadioGroup radio= findViewById(R.id.radioGroupPlace);
        RadioButton house= findViewById(R.id.radioButtonHouse);
        RadioButton farm= findViewById(R.id.radioButtonFarm);
        RadioButton apart= findViewById(R.id.radioButtonApart);
        CheckBox panel= findViewById(R.id.checkBoxSolar);
        CheckBox aereo= findViewById(R.id.checkBoxAero);
        CheckBox otro= findViewById(R.id.checkBoxOther);
        Button boton= findViewById(R.id.button);
        TextView resultado= findViewById(R.id.textViewResult);

        // x=20
        // 1=10
        //Cualquier elemento de la interfaz imagenes, botones, textos
        //se les puede asociar una acción o evento

        house.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (house.isChecked()){
                    house.setChecked(false);
                }else{
                    house.setChecked(true);
                    farm.setChecked(false);
                    apart.setChecked(false);
                }
            }
        });

        farm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(farm.isChecked()){
                    farm.setChecked(false);
                }else {
                    farm.setChecked(true);
                    house.setChecked(false);
                    apart.setChecked(false);
                }
            }
        });

        apart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(apart.isChecked()){
                    apart.setChecked(false);
                }else{
                    apart.setChecked(false);
                    house.setChecked(false);
                    farm.setChecked(false);
                }
            }
        });
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Validación de que todos los campos estan diligenciados
                //condicional --> validar si algo se cumple o no
                //es decir si es verdadero o falso
                // Pregunto si el elemento es vacio
                // Pregunto si el elemento no es vacio
                //String = Texto en Java --toString obliga a que un elemnto se vuelva String
                // = es asignación ej: x=20 , y="Hola"
                // == comparación (Igualdad)
                //""--> texto vacio
                //if -> Si Else -> Sino
                //!= diferente
                //Texto tienen una función para saber si esta vacio
                // isEmpty()
                // Conjunción y dinyunsión
                //     || OR  -- && AND

                if(name.getText().toString().isEmpty()  ||
                   address.getText().toString().isEmpty() ||
                   phone.getText().toString().isEmpty() ||
                   email.getText().toString().isEmpty()
                ){


                    //Toast permite crear mensajes emergentes en la pantalla
                    Toast.makeText(getApplicationContext(),"Todos los campos deben diligenciarse",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getApplicationContext(),"Formulario completo",Toast.LENGTH_LONG).show();
                }

            }
        });


    }



}

