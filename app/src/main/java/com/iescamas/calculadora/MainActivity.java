package com.iescamas.calculadora;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    //Instaciamos los objetos que vamos a utilizar en la app

    EditText txt_primernumero;
    EditText txt_segundonumero;
    TextView lbl_resultado;
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

        //Se establecen los listener
        findViewById(R.id.btn_Suma).setOnClickListener(view -> Calculadora(1));
        findViewById(R.id.btn_Resta).setOnClickListener(view -> Calculadora(2));
        findViewById(R.id.btn_Multiplicacion).setOnClickListener(view -> Calculadora(3));
        findViewById(R.id.btn_Division).setOnClickListener(view -> Calculadora(4));
        //Al realizar 3 eventos se pone de esta forma
        findViewById(R.id.btn_Borrar).setOnClickListener(view -> {
            lbl_resultado.setText("");
            txt_primernumero.setText("");
            txt_segundonumero.setText("");
        });

    }
    private int suma(int numero1,int numero2){

        return numero1 + numero2;
    }
    private int resta (int numero1,int numero2){

        return numero1 - numero2;
    }
    private int multiplicacion (int numero1,int numero2){

        return numero1 * numero2;
    }
    private double division(double numero1,int numero2){

        return (numero1/numero2);
    }
    @SuppressLint("DefaultLocale")
    private void Calculadora(int operacion){
        //Obtenemos los textos de los editText y los convertimos en String
        String str_NumeroUno = txt_primernumero.getText().toString();
        String str_NumeroDos = txt_segundonumero.getText().toString();

        //Comprobamos que ninguno de los 2 este vacio
        if(!str_NumeroUno.isEmpty() && !str_NumeroDos.isEmpty()){

            int numero1 = Integer.parseInt(str_NumeroUno);
            int numero2 = Integer.parseInt(str_NumeroDos);
            //Realizamos las operaciones
            switch(operacion){
                case 1:lbl_resultado.setText(String.valueOf(suma(numero1,numero2)));break;
                case 2:lbl_resultado.setText(String.valueOf(resta(numero1,numero2)));break;
                case 3:lbl_resultado.setText(String.valueOf(multiplicacion(numero1,numero2)));break;
                case 4: if(str_NumeroDos.equals("0")){
                    lbl_resultado.setText(msgError);
                }
                else{
                    lbl_resultado.setText(String.format("%.2f",division(numero1,numero2)));
                }
                break;
            }
        }
        else {
            lbl_resultado.setText(msgError);
        }
        }
}