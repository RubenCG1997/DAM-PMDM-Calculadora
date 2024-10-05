package com.iescamas.calculadora;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    //Instaciamos los objetos que vamos a utilizar en la app

    EditText txt_primernumero;
    EditText txt_segundonumero;
    TextView lbl_resultado;
    Button btn_suma;
    Button btn_resta;
    Button btn_multiplicacion;
    Button btn_division;
    Button btn_borrar;

    //Mensajes
    final String msgError = "ERROR";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Vinculamos las variables con los elementos de la interfaz por la id
        txt_primernumero = findViewById(R.id.etv_PrimerNumero);
        txt_segundonumero = findViewById(R.id.etv_SegundoNumero);
        lbl_resultado = findViewById(R.id.txt_Resultado);
        btn_suma = findViewById(R.id.btn_Suma);
        btn_resta = findViewById(R.id.btn_Resta);
        btn_multiplicacion = findViewById(R.id.btn_Multiplicacion);
        btn_division = findViewById(R.id.btn_Division);
        btn_borrar = findViewById(R.id.btn_Borrar);

        //Se establecen los listener
        btn_suma.setOnClickListener(view -> Calculadora('+'));
        btn_resta.setOnClickListener(view -> Calculadora('-'));
        btn_multiplicacion.setOnClickListener(view -> Calculadora('x'));
        btn_division.setOnClickListener(view -> Calculadora('/'));
        //Al realizar 3 eventos se pone de esta forma
        btn_borrar.setOnClickListener(view -> {
            lbl_resultado.setText("");
            txt_primernumero.setText("");
            txt_segundonumero.setText("");
        });

    }
    private void Calculadora(char operacion){
        //Obtenemos los textos de los editText y los convertimos en String
        String str_NumeroUno = txt_primernumero.getText().toString();
        String str_NumeroDos = txt_segundonumero.getText().toString();
        //Comprobamos que ninguno de los 2 este vacio
        if(!str_NumeroUno.isEmpty() && !str_NumeroDos.isEmpty()){
            //Convertimos el String en Double
            double numeroUno = Double.parseDouble(str_NumeroUno);
            double numeroDos = Double.parseDouble(str_NumeroDos);
            //Guardamos una variable para el resultado
            double resultado;
            //Realizamos las operaciones
            switch(operacion){

                case '+': resultado = numeroUno + numeroDos;
                    lbl_resultado.setText(String.valueOf(resultado));
                break;
                case '-': resultado = numeroUno - numeroDos;
                    lbl_resultado.setText(String.valueOf(resultado));
                break;
                case 'x': resultado = numeroUno * numeroDos;
                    lbl_resultado.setText(String.valueOf(resultado));
                break;
                case '/': if(numeroDos==0){
                    lbl_resultado.setText(msgError);
                }
                else{
                    resultado = numeroUno / numeroDos;
                    lbl_resultado.setText(String.valueOf(resultado));
                }
                break;
            }
        }
        else {
            lbl_resultado.setText(msgError);
        }
        }

}