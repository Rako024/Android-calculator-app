package com.rashid.kalkuyator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    TextView solutionTv,resultTv;
    Button btnAC,btnLeft,btnRight,btnBolme,btn7,btn8,btn9,btnVurma,btn4,btn5,btn6,btnCixma,btn1,btn2,btn3,btnToplama,btn0,btnVergul,btnBeraber;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        solutionTv = findViewById(R.id.solution_tv);
        resultTv = findViewById(R.id.result_tv);
        assingId(btnAC,R.id.btn_AC);
        assingId(btnLeft,R.id.btn_left);
        assingId(btnRight,R.id.btn_right);
        assingId(btnBolme,R.id.btn_bolme);
        assingId(btn7,R.id.btn_7);
        assingId(btn8,R.id.btn_8);
        assingId(btn9,R.id.btn_9);
        assingId(btnVurma,R.id.btn_vurma);
        assingId(btn4,R.id.btn_4);
        assingId(btn5,R.id.btn_5);
        assingId(btn6,R.id.btn_6);
        assingId(btnCixma,R.id.btn_cixma);
        assingId(btn1,R.id.btn_1);
        assingId(btn2,R.id.btn_2);
        assingId(btn3,R.id.btn_3);
        assingId(btnToplama,R.id.btn_toplama);
        assingId(btn0,R.id.btn_0);
        assingId(btnVergul,R.id.btn_vergul);
        assingId(btnBeraber,R.id.btn_beraber);

    }
    void assingId(Button btn,int id){
        btn = findViewById(id);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Button button = (Button) view;
        String buttonText = button.getText().toString();

        if(buttonText.equals("AC")){
            solutionTv.setText("");
            resultTv.setText("0");
            return;
        }
        if(buttonText.equals("=")){
            solutionTv.setText(resultTv.getText());
            return;
        }

        String dataToCalculate = solutionTv.getText().toString();
        dataToCalculate +=buttonText;
        solutionTv.setText(dataToCalculate);
        String finalResult = getResult(dataToCalculate);
        if(!finalResult.equals("Err")){
            resultTv.setText(finalResult);
        }

    }
    String getResult(String data){
        try {
            Context context = Context.enter();
            context.setOptimizationLevel(-1);
            Scriptable scriptable = context.initSafeStandardObjects();
            String finalResult =  context.evaluateString(scriptable,data,"Javascript",1,null).toString();
            return finalResult;
        }catch (Exception e){
            return "Err";

        }
    }
}