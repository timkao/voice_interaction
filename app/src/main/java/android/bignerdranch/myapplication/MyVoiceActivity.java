package android.bignerdranch.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.VoiceInteractor;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MyVoiceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_voice);
        Log.i("@tim", "testing voice");
    }

    class Confirm extends VoiceInteractor.ConfirmationRequest {
        public Confirm(String ttsPrompt, String visualPrompt) {
            super(new VoiceInteractor.Prompt(
                    new String[] {ttsPrompt}, visualPrompt), null);
        }

        @Override
        public void onConfirmationResult(boolean confirmed, Bundle result) {
            super.onConfirmationResult(confirmed, result);
            if (confirmed) {
                Toast.makeText(getApplicationContext(), "Voice Confirmed", Toast.LENGTH_SHORT).show();
            }
            finish();
        }
    };

    @Override
    public void onResume() {
        super.onResume();
        if (isVoiceInteraction()) {
            Log.i("@tim", "inside voice interaction");
            String ttsPrompt = "are you sure?";
            String visualPrompt = "are you sure?";
            getVoiceInteractor().submitRequest(new Confirm(ttsPrompt, visualPrompt));
        } else {
            finish();
        }
    }

}
