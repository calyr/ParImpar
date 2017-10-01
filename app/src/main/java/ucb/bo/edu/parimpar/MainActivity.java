package ucb.bo.edu.parimpar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

import static java.lang.Integer.parseInt;

public class MainActivity extends AppCompatActivity {

    private TextView mNumber;
    private TextView correctos;
    private TextView incorrectos;
    private int contadorCorrectos;
    private int contadorIncorrectos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.mNumber = (TextView) findViewById(R.id.tvNumber);
        this.correctos = (TextView) findViewById(R.id.contadorCorrectos);
        this.incorrectos = (TextView) findViewById(R.id.contadorIncorrectos);
        this.contadorCorrectos = 0;
        this.contadorIncorrectos = 0;
        setConfig();
    }

    public void setConfig() {

        this.correctos.setText(String.valueOf(this.contadorCorrectos));
        this.incorrectos.setText(String.valueOf(this.contadorIncorrectos));
        this.mNumber.setText( String.valueOf(  (int)(Math.random()*10  + 1) ) );
    }
    public void validate(View view) {
        int numero = parseInt(this.mNumber.getText().toString());
        boolean result = numero % 2 == 0;
        switch (view.getId()) {
            case R.id.btnImpar:
                evaluar(!result);
                break;
            case R.id.btnPar:
                evaluar(result);
                break;
        }

    }
    public void evaluar(boolean result ) {
        if (result) {
            this.contadorCorrectos++;

        } else {
            this.contadorIncorrectos++;
        }
        this.setConfig();
    }


}
