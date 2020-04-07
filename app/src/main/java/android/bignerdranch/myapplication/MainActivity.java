package android.bignerdranch.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnVoice).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Start Voice Interaction", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), MyVoiceActivity.class);
                intent.addCategory("android.intent.category.VOICE");
                startActivity(intent);
            }
        });
    }
}
