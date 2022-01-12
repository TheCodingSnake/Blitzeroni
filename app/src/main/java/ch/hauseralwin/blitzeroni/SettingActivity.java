package ch.hauseralwin.blitzeroni;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

public class SettingActivity extends AppCompatActivity {
    private ImageButton backToMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        backToMain = (ImageButton) findViewById(R.id.imageButton_backToMain);
        backToMain.setOnClickListener(v -> openMainActivity());

    }

    public void openMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}