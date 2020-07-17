package com.CooksonAcademy.mycalculator;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.NumberFormat;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements TextToSpeech.OnInitListener {

    private static Calculator calc;
    private TextToSpeech textToSpeech;

    TextView edittext1;
    Button button_0, button_1, button_2, button_3, button_4, button_5, button_6, button_7, button_8, button_9, button_Add, button_Sub,
            button_Mul, button_Div, button_Equ, button_Del, button_Dot, button_Remainder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.i("ACTIVITY", "CREATE");

        if (calc == null) {
            calc = new Calculator();
        }

        if (textToSpeech == null) {
            MyApplication app = (MyApplication) getApplication();
            TextToSpeech appTextToSpeech = app.getTextToSpeech();
            if (appTextToSpeech == null) {
                app.setTextToSpeech(new TextToSpeech(getApplicationContext(), this));
            }
            textToSpeech = app.getTextToSpeech();
        }

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

        Log.i("ACTIVITY", "INIT TEXTVIEW");
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
                texttoSpeak("clear", true);
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
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);

        savedInstanceState.putString("currentValue", edittext1.getText().toString());

    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        {

            edittext1.setText("" + savedInstanceState.getString("currentValue"));

        }
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
        Log.i("MAIN", "INIT");
        if (status == TextToSpeech.SUCCESS && textToSpeech != null) {
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
        Log.i("MAIN", "DESTROY");

        super.onDestroy();
    }

    @Override
    protected void onResume() {
        Log.i("MAIN", "RESUME");
        super.onResume();

        edittext1 = (TextView) findViewById(R.id.display);

        double currentValue = calc.getCurrentValue();
        double currentOperand = calc.getCurrentOperand();
        Log.i("MAIN", "CURRENT " + currentValue + ", " + currentOperand);
        if (!Double.isNaN(currentValue)) {
            Log.i("MAIN", "RELOAD TEXT VALUE " + currentValue);
            //edittext1.setText((int) currentValue);
        } else if (!Double.isNaN(currentOperand)) {
            Log.i("MAIN", "RELOAD TEXT OPERAND " + currentOperand);
            // WHY is resource not found here?
            //edittext1.setText((int) currentOperand);
        }
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