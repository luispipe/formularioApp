package com.example.formularioapp;

// Se importan todas las librerias que se requieren
// libreria --> una paquetas de herramientas que necesitamos para que algo funcione

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

    //Override es igual a sobreescribir

    // Siempre que se defina una clase o función
    // Se le asigna un nivel de acceso public, protected, private

    //La función onCreate es la que se encarga de construir la interfaz
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Generar una vista vacia o interfaz vacia
        super.onCreate(savedInstanceState);
        //Cambiamos la interfaz vacia por la que tenemos en nuestro layout
        setContentView(R.layout.activity_main);
        //set --> actualizar o modificar
        //get --> obtener

        /*Siempre que queramos obtener un dato o información
          de un elemento de interfaz (button, edittext, TextView
          Table, RadioButton, etc) se debe definir una variable
          del mismo tipo.
          Ejemplo: para obtener el texto de un TextView -- TextView nombreX;

          findViewById --> es la funcionalidad que nos permite traer
          el elemento desde la interfaz por medio de su ID
        */

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

        /* Para generar una acción u evento se llama a el elemento
        *  y se implementa la funcionalidad setOnClickListener que se encarga
        *  de escuchar o percibir cuando se clickea sobre el elemento y dispara
        *  o ejecuta una acción o evento, donde se construye una nueva vista o interfaz
         * */
        house.setOnClickListener(new View.OnClickListener() {

            //Dentro del onClick es donde se define lo que se quiere
            //mostrar en la nueva vista que sea diferente a la vista actual
            @Override
            public void onClick(View v) {
                farm.setChecked(false);
                apart.setChecked(false);
            }
        });

        farm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                house.setChecked(false);
                apart.setChecked(false);
            }
        });

        apart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    apart.setChecked(true);
                    house.setChecked(false);
                    farm.setChecked(false);

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
                    String nombre= name.getText().toString();
                    String direccion= address.getText().toString();
                    String telefono= phone.getText().toString();
                    String correo= email.getText().toString();
                    String radio="";
                    String checkbox= "";
                    if(house.isChecked()){
                        radio= house.getText().toString();
                    }else if (farm.isChecked()){
                        radio=farm.getText().toString();
                    }else{
                        radio= apart.getText().toString();
                    }
                    if(panel.isChecked()){
                        //Concatenar que es lo mismo que unir
                        //Para unir texto se usa el +
                        checkbox=checkbox+" - "+panel.getText().toString();
                    }
                    if (aereo.isChecked()){
                        checkbox=checkbox+" - "+aereo.getText().toString();
                    }
                    if (otro.isChecked()){
                        checkbox=checkbox+" - "+otro.getText().toString();
                    }

                    resultado.setText(nombre+"-"+direccion+"-"+telefono+"-"
                    +correo+"-"+radio+"-"+checkbox
                    );


                /* Toast es un mensaje emergente que se muestra en l APP para alertar al usuario
                 para ello se llama a Toast.makeText se le envia el contexto de la APP para
                 que el identifique en cual interfaz esta para saber donde despliega el mensaje
                 por esto usamos el getApplicationContext o getBaseContext
                 (los parametro o valores en java se separan por coma , )

                 *El segundo parametro es el mensaje que queremos dar
                 (Los textos en java van dentro de comillas dobles "")
                 *El tercer parametro es el tiempo que se visualizara el mensaje
                 -Solo hay dos opciones Toast.Length_Long tarda 5 seg
                 - Toast.Length_short tarda 2 seg

                 Para finalizar se utiliza la funcionalidad show() que lo que hace
                 es mostrar el mensaje en la interfaz que se detecto
                  * */
                    Toast.makeText(getBaseContext(),"Formulario completo",Toast.LENGTH_LONG).show();
                }

            }
        });


    }



}

