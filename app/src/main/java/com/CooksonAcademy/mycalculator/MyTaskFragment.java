package com.CooksonAcademy.mycalculator;

/**
 * This Fragment manages a single background task and retains 
 * itself across configuration changes.
 */

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;

import androidx.fragment.app.Fragment;

import java.util.Locale;

public class MyTaskFragment extends Fragment implements TextToSpeech.OnInitListener {

    private TextToSpeech textToSpeech;

    public TextToSpeech getTextToSpeech() {
        return textToSpeech;
    }

    public void setTextToSpeech(TextToSpeech textToSpeech) {
        this.textToSpeech = textToSpeech;
    }

    // this method is only called once for this fragment
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // retain this fragment
        setRetainInstance(true);

        this.textToSpeech = new TextToSpeech(getActivity(), this);

        Log.i("FRAGMENT", "CREATE");
    }

    @Override
    public void onInit(int status) {
        Log.i("FRAGMENT", "INIT");

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
    public void onResume() {
        Log.i("FRAGMENT", "RESUME");
        super.onResume();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    public void destroySpeech() {
        if (textToSpeech != null) {
            textToSpeech.stop();
            textToSpeech.shutdown();
        }
    }

    public void texttoSpeak(String speakText) {
        texttoSpeak(speakText, false);
    }

    public void texttoSpeak(String speakText, boolean flush) {
        Log.i("textToSpeak", "speaking " + speakText);
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

}