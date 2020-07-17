package com.CooksonAcademy.mycalculator;

import android.app.Application;
import android.speech.tts.TextToSpeech;
import android.util.Log;

public class MyApplication extends Application {

    private TextToSpeech textToSpeech;

    public TextToSpeech getTextToSpeech() {
        return textToSpeech;
    }

    public void setTextToSpeech(TextToSpeech textToSpeech) {
        this.textToSpeech = textToSpeech;
    }

    @Override
    public void onCreate() {
        Log.i("APP", "CREATE");
        super.onCreate();
    }

    @Override
    public void onTerminate() {
        Log.i("APP", "TERMINATE");
        super.onTerminate();

        if (textToSpeech != null) {
            textToSpeech.stop();
            textToSpeech.shutdown();
        }
    }

    @Override
    public void registerActivityLifecycleCallbacks (Application.ActivityLifecycleCallbacks callback) {


    }

}
