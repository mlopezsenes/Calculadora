package ar.edu.utn.fra.lab5.calculadora;

import android.view.View;

/**
 * Created by lkdml on 30/08/2017.
 */

public class MyListener implements View.OnClickListener {


    private MainActivity miActivity;

    public MyListener(MainActivity miActivity) {
        this.miActivity =  miActivity;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn0:
               this.miActivity.agregarNumero("0");
                break;
            case R.id.btn1:
                this.miActivity.agregarNumero("1");
                break;
            case R.id.btn2:
                this.miActivity.agregarNumero("2");
                break;
            case R.id.btn3:
                this.miActivity.agregarNumero("3");
                break;
            case R.id.btn4:
                this.miActivity.agregarNumero("4");
                break;
            case R.id.btn5:
                this.miActivity.agregarNumero("5");
                break;
            case R.id.btn6:
                this.miActivity.agregarNumero("6");
                break;
            case R.id.btn7:
                this.miActivity.agregarNumero("7");
                break;
            case R.id.btn8:
                this.miActivity.agregarNumero("8");
                break;
            case R.id.btn9:
                this.miActivity.agregarNumero("9");
                break;
            case R.id.btnComa:
                //this.miActivity.agregarNumero(".");
                break;
            case R.id.btnMas:
                this.miActivity.agregarOperacion("+");

                break;
            case R.id.btnMenos:
                this.miActivity.agregarOperacion("-");

                break;
            case R.id.btnMultiplicar:
                this.miActivity.agregarOperacion("*");

                break;
            case R.id.btnIgual:
                this.miActivity.procesar();
                break;
            case R.id.btnCE:
                this.miActivity.limpiar();
                break;
        }
    }
}
