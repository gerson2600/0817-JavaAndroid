package com.example.calculadoraimc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editPeso;
    private EditText editAltura;
    private TextView txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editAltura = findViewById(R.id.ctxaltura);
        editPeso = findViewById(R.id.ctxpeso);
        txtResultado = findViewById(R.id.txtimc);



    }
    public void calculaIMC(View view){
        double altura = Double.parseDouble(editAltura.getText().toString());
        double peso = Double.parseDouble(editPeso.getText().toString());
        double imc = peso/(altura*altura);
        if(imc<18.5)
            txtResultado.setText("IMC: "+imc+". Abaixo do peso Normal!");
        else if(imc<25)
            txtResultado.setText("IMC: "+imc+". Está no peso Normal!");
        else if(imc<30)
            txtResultado.setText("IMC: "+imc+". Está acima do peso Normal!");
        else if(imc<35)
            txtResultado.setText("IMC: "+imc+". Obesidade Grau I!");
        else if(imc<40)
            txtResultado.setText("IMC: "+imc+". Obesidade Grau II!");
        else
            txtResultado.setText("IMC: "+imc+". Obesidade Grau III!");

    }
}