package ar.edu.utn.fra.lab5.calculadora;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Double ValorA;
    private Double ValorB;
    public double subTotal;
    private MyListener listener;
    private TextView txtSubTotal;
    private TextView txtNumero;
    private TextView txtOperador;
    private String operacion;
    private boolean esSubTotal;
    private boolean esValorA;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.listener = new MyListener(this);

        this.txtNumero = (TextView) findViewById(R.id.txtNumero);
        this.txtSubTotal = (TextView) findViewById(R.id.txtSubTotal);
        this.txtOperador = (TextView) findViewById(R.id.txtOperador);
        this.limpiar();
        // ConstraintLayout es un ViewGroup
        ConstraintLayout mainLayout = (ConstraintLayout) findViewById(R.id.layout);
        for (int i = 0; i < mainLayout.getChildCount(); i++) {
            View view = mainLayout.getChildAt(i);
            if (view instanceof Button) {
                view.setOnClickListener(listener);
            }

        }

    }

    public void limpiar(){
        this.operacion="";
        this.ValorA =0.0;
        this.ValorB =0.0;
        this.subTotal = 0;
        this.txtNumero.setText("0");
        this.txtSubTotal.setText("");
        this.txtOperador.setText("");
        this.esSubTotal=true;
        this.esValorA=true;
    }
    public void agregarNumero(String texto){
        if (!this.esSubTotal) {
            String textoprevio = this.txtNumero.getText().toString();
            if (textoprevio == "0") {
                this.txtNumero.setText(texto);
            } else {
                this.txtNumero.setText(textoprevio + texto);
            }
        } else {
            this.txtNumero.setText(texto);
            this.esSubTotal=false;
        }
    }

    public void agregarOperacion(String texto){
        this.operacion=texto;
        this.txtOperador.setText(this.operacion.toString());
        this.txtSubTotal.setText(this.txtNumero.getText().toString());
        this.esSubTotal=true;
    }


    public String calcular(Double ValorA, Double ValorB, String operacion){
        String resultado = "0";
            switch (this.operacion){
                case "+":
                    resultado = this.sumar(ValorA,ValorB);
                    break;
                case "-":
                    resultado = this.restar(ValorA,ValorB);
                    break;
                case "*":
                    resultado = this.multiplicar(ValorA,ValorB);
                    break;
                case "/":
                    resultado = this.dividir(ValorA,ValorB);
                    break;
            }
        return resultado;
    }

    public void procesar(){
        this.txtNumero.setText(calcular(Double.valueOf(this.txtSubTotal.getText().toString()),Double.valueOf(this.txtNumero.getText().toString()),this.txtOperador.getText().toString()));
       this.txtSubTotal.setText("");
        this.txtOperador.setText("");
    }
    //Funciones matematicas
    private String sumar(Double a, Double b){
        return String.valueOf(a+b);
    }
    private String restar(Double a, Double b){
        return String.valueOf(a-b);
    }
    private String dividir(Double a, Double b){
        if (b>0){
            return String.valueOf(a/b);
        } else {
            return "Error";
        }
    }
    private String multiplicar(Double a, Double b){
        return String.valueOf(a*b);
    }



}
