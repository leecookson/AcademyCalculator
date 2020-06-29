package com.CooksonAcademy.mycalculator;

import android.os.Build;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.NumberFormat;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements TextToSpeech.OnInitListener {

    Calculator calc = new Calculator();
    TextView edittext1;
    TextToSpeech textToSpeech;
    Button button_0, button_1, button_2, button_3, button_4, button_5, button_6, button_7, button_8, button_9, button_Add, button_Sub,
            button_Mul, button_Div, button_Equ, button_Del, button_Dot, button_Remainder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button_0 = (Button) findViewById(R.id.b0);
        button_1 = (Button) findViewById(R.id.b1);
        button_2 = (Button) findViewById(R.id.b2);
        button_3 = (Button) findViewById(R.id.b3);
        button_4 = (Button) findViewById(R.id.b4);
        button_5 = (Button) findViewById(R.id.b5);
        button_6 = (Button) findViewById(R.id.b6);
        button_7 = (Button) findViewById(R.id.b7);
        button_8 = (Button) findViewById(R.id.b8);
        button_9 = (Button) findViewById(R.id.b9);
        //button_Dot = (Button) findViewById(R.id.bDot);
        button_Add = (Button) findViewById(R.id.badd);
        button_Sub = (Button) findViewById(R.id.bsub);
        button_Mul = (Button) findViewById(R.id.bmul);
        button_Div = (Button) findViewById(R.id.biv);
        //button_Remainder = (Button) findViewById(R.id.BRemain);
        button_Del = (Button) findViewById(R.id.buttonDel);
        button_Equ = (Button) findViewById(R.id.buttoneql);

        edittext1 = (TextView) findViewById(R.id.display);

        edittext1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                texttoSpeak(edittext1.getText().toString());
            }
        });
        button_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calc.doDigit(1);
                edittext1.setText(setValue(calc.getCurrentOperand()));
                texttoSpeak(setValue(calc.getCurrentOperand()), true);
            }
        });

        button_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calc.doDigit(2);
                edittext1.setText(setValue(calc.getCurrentOperand()));
                texttoSpeak(setValue(calc.getCurrentOperand()), true);
            }
        });

        button_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calc.doDigit(3);
                edittext1.setText(setValue(calc.getCurrentOperand()));
                texttoSpeak(setValue(calc.getCurrentOperand()), true);
            }
        });

        button_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calc.doDigit(4);
                edittext1.setText(setValue(calc.getCurrentOperand()));
                texttoSpeak(setValue(calc.getCurrentOperand()), true);
            }
        });

        button_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calc.doDigit(5);
                edittext1.setText(setValue(calc.getCurrentOperand()));
                texttoSpeak(setValue(calc.getCurrentOperand()), true);
            }
        });

        button_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calc.doDigit(6);
                edittext1.setText(setValue(calc.getCurrentOperand()));
                texttoSpeak(setValue(calc.getCurrentOperand()), true);
            }
        });

        button_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calc.doDigit(7);
                edittext1.setText(setValue(calc.getCurrentOperand()));
                texttoSpeak(setValue(calc.getCurrentOperand()), true);
            }
        });

        button_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calc.doDigit(8);
                edittext1.setText(setValue(calc.getCurrentOperand()));
                texttoSpeak(setValue(calc.getCurrentOperand()), true);
            }
        });

        button_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calc.doDigit(9);
                edittext1.setText(setValue(calc.getCurrentOperand()));
                texttoSpeak(setValue(calc.getCurrentOperand()), true);
            }
        });

        button_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calc.doDigit(0);
                edittext1.setText(setValue(calc.getCurrentOperand()));
                texttoSpeak(setValue(calc.getCurrentOperand()), true);
            }
        });

        button_Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calc.doOperation(Calculator.Operator.CALC_ADD);
                edittext1.setText("+");
                texttoSpeak("plus");
            }
        });

        button_Sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calc.doOperation(Calculator.Operator.CALC_SUB);
                edittext1.setText("-");
                texttoSpeak("minus");
            }
        });

        button_Mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calc.doOperation(Calculator.Operator.CALC_MUL);
                edittext1.setText("x");
                texttoSpeak("times");
            }
        });

        button_Div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calc.doOperation(Calculator.Operator.CALC_DIV);
                edittext1.setText("÷");
                texttoSpeak("divide by");
            }
        });

/*        button_Remainder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentOperator = Operator.CALC_REM;
                edittext1.setText("%");
                texttoSpeak("remainder");
                currentOperand = 0;
            }
        });
*/
        button_Equ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calc.doEquals();
                texttoSpeak("equals");
                double currentValue = calc.getCurrentValue();
                edittext1.setText(setValue(currentValue));
                texttoSpeak(currentValue);
            }
        });

        button_Del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calc.reset();
                edittext1.setText("");
                texttoSpeak("clear");
            }
        });

/*        button_Dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (deci) {
                    //do nothing or you can show the error
                } else {
                    edittext1.setText(edittext1.getText() + ".");
                    deci = true;
                }

            }
        });

 */

        edittext1.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {

                // you can call or do what you want with your EditText here

                // yourEditText...
                //texttoSpeak(edittext1.getText() + "");
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            public void onTextChanged(CharSequence s, int start, int before, int count) {}
        });

        textToSpeech = new TextToSpeech(this, this);

    }
    public String setValue(double n) {
        if (Double.isNaN(n)) {
            return "Not a Number";
        }
        NumberFormat nf = NumberFormat.getInstance(Locale.ENGLISH);
        nf.setMaximumFractionDigits(0);
        return nf.format(n);
    }

    @Override
    public void onInit(int status) {
        if (status == TextToSpeech.SUCCESS) {
            int result = textToSpeech.setLanguage(Locale.US);
            if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.e("error", "This Language is not supported");
            } else {
                texttoSpeak("Welcome");
            }
        } else {
            Log.e("error", "Failed to Initialize");
        }
    }

    @Override
    public void onDestroy() {
        if (textToSpeech != null) {
            textToSpeech.stop();
            textToSpeech.shutdown();
        }
        super.onDestroy();
    }

    private void texttoSpeak(String speakText) {
        texttoSpeak(speakText, false);
    }

    private void texttoSpeak(String speakText, boolean flush) {
        String text = speakText;
        if ("".equals(text)) {
            return;
        }
        if (flush) {
            textToSpeech.speak(text, TextToSpeech.QUEUE_FLUSH, null);
        } else {
            textToSpeech.speak(text, TextToSpeech.QUEUE_ADD, null, null);
        }
    }

    private void texttoSpeak(double number) {
        texttoSpeak(setValue(number));
    }


}
