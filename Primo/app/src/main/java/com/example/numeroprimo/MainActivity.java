package com.example.numeroprimo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.numeroprimo.modelo.Controle;

public class MainActivity extends AppCompatActivity
{
    EditText edtNumero;
    Button btnVerificar;
    TextView txvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        configuracao();
        eventos();
    }

    private void configuracao()
    {
        edtNumero = findViewById(R.id.edtNumero);
        btnVerificar = findViewById(R.id.btnVerificar);
        txvResultado = findViewById(R.id.txvResultado);
    }

    private void eventos()
    {
        btnVerificar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Controle controle = new Controle(edtNumero.getText().toString());
                txvResultado.setText(controle.getMensagem());
            }
        });
    }
}