package com.mateollugcha.myfirstlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

import kotlin.text.UStringsKt;

public class MainActivity extends AppCompatActivity {

    private Button button7, button8, button6, button9, button5, button4, button3, button2, button1,button0, buttondividir, buttonmultip, buttonresta, buttonsuma, buttonigual, buttonpunto, buttonborrar,buttonelminar;
    private EditText display;
    private double currentValue = 0;
    private String operation = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View.OnClickListener numberClickListener= new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button clickedbutton = (Button) view;
                String number = clickedbutton.getText().toString();
                addToDisplay(number);
            }
        };

        /**
         * le damos un id a todo
         */
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);

        button6 = findViewById(R.id.button6);
        button5 = findViewById(R.id.button5);
        button4 = findViewById(R.id.button4);

        button3 = findViewById(R.id.button3);
        button2 = findViewById(R.id.button2);
        button1 = findViewById(R.id.button1);
        button0 = findViewById(R.id.button0);

        buttondividir = findViewById(R.id.buttondividir);
        buttonmultip = findViewById(R.id.buttonmultip);
        buttonresta = findViewById(R.id.buttonresta);
        buttonsuma = findViewById(R.id.buttonsuma);

        buttonigual = findViewById(R.id.buttonigual);
        buttonpunto = findViewById(R.id.buttonpunto);
        buttonborrar = findViewById(R.id.buttonborrar);
        buttonelminar = findViewById(R.id.buttoneliminar);

        display = findViewById(R.id.display);

        /**
         * le damos un listener a todos los id
         */

        button7.setOnClickListener(numberClickListener);
        button8.setOnClickListener(numberClickListener);
        button9.setOnClickListener(numberClickListener);

        button6.setOnClickListener(numberClickListener);
        button5.setOnClickListener(numberClickListener);
        button4.setOnClickListener(numberClickListener);

        button3.setOnClickListener(numberClickListener);
        button2.setOnClickListener(numberClickListener);
        button1.setOnClickListener(numberClickListener);
        button0.setOnClickListener(numberClickListener);

        buttonpunto.setOnClickListener(numberClickListener);

        buttondividir.setOnClickListener(view -> setOperation("/"));
        buttonsuma.setOnClickListener(view -> setOperation("+"));
        buttonresta.setOnClickListener(view -> setOperation("-"));
        buttonmultip.setOnClickListener(view -> setOperation("*"));
        buttonigual.setOnClickListener(view -> calculate());
/**
 * boton para borrar y eliminar
 */
        buttonborrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteLastCharacter();
            }
        });

        buttonelminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearDisplay();
            }
        });


    }

    /**
     * añade al display el numero que se presione
     * @param number
     */
    public void addToDisplay(String number){

        String currentVal = this.display.getText().toString();
        if (currentVal.equals("0")) {
            this.display.setText(number);
            return;
        }

        if( currentVal.contains(".") && number.equals("."))
            return;

        this.display.setText(currentVal + number);
    }

    /**
     * GUARDAR OPERACION
     * @param op
     */
    private void setOperation(String op){
        this.currentValue = Double.parseDouble(this.display.getText().toString());
        this.display.setText("0");
        this.operation = op;

    }

    private void calculate(){
        double secondValue = Double.parseDouble(this.display.getText().toString());
        double result = 0;

        switch (this.operation){
            case "+":
                result = this.currentValue + secondValue;
                break;
            case "-":
                result = this.currentValue - secondValue;
                break;
            case "/":
                result = this.currentValue / secondValue;
                break;
            case "*":
                result = this.currentValue * secondValue;
                break;
        }

        display.setText(String.valueOf(result));
        this.currentValue = result;
    }
/**
 * eliminar y limpipar
 */
    private void deleteLastCharacter(){

        String currentText = display.getText().toString();
        if(!currentText.isEmpty()){
            currentText = currentText.substring(0,currentText.length() - 1);
            display.setText(currentText);
        }
    }

    private void clearDisplay(){
        display.setText("0");
    }

}