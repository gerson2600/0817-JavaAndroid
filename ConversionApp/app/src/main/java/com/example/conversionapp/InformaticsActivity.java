package com.example.conversionapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class InformaticsActivity extends AppCompatActivity {

    EditText InformaticsMB;
    TextView InformaticsB;
    TextView InformaticsKB;
    TextView InformaticsGB;
    TextView InformaticsTB;

    Button ConvertInformatics;
    Button ReturnInformatics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informatics);

        ConvertInformatics = findViewById(R.id.BtnConvertInformatics);
        ReturnInformatics = findViewById(R.id.BtnReturnInformatics);

    }

    public void InformaticsConvert(View v)
    {
        InformaticsMB = findViewById(R.id.TxtInformaticsMB);
        InformaticsB = findViewById(R.id.TxtInformaticsB);
        InformaticsKB = findViewById(R.id.TxtInformaticsKB);
        InformaticsGB = findViewById(R.id.TxtInformaticsGB);
        InformaticsTB = findViewById(R.id.TxtInformaticsTB);

        Double ResultInformatics = Double.parseDouble(InformaticsMB.getText().toString());
        InformaticsB.setText(ResultInformatics + "MB equals: " + ResultInformatics*1000000 + "Bytes.");
        InformaticsKB.setText(ResultInformatics + "MB equals: " + ResultInformatics*1000 + "KiloBytes.");
        InformaticsGB.setText(ResultInformatics + "MB equals: " + ResultInformatics*0.001 + "GigaBytes.");
        InformaticsTB.setText(ResultInformatics + "MB equals: " + ResultInformatics*0.000001 + "TerraBytes.");

    }

    public void InformaticsReturn(View v)
    {
        Intent i = new Intent(InformaticsActivity.this, MenuActivity.class);
        startActivity(i);
    }


}