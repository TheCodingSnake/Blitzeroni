package ch.hauseralwin.blitzeroni;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
// import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Switch;

public class SettingActivity extends AppCompatActivity {
    public Boolean imperialUnit;


    // tested Uri. It works, but the App doesn't need it.
   // Uri gmmIntentUri = Uri.parse("google.streetview:cbll=46.414382,10.013988");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        ImageButton backToMain = findViewById(R.id.imageButton_backToMain);
        backToMain.setOnClickListener(v -> openMainActivity());

        Button openGoogleMaps = findViewById(R.id.button_openGoogleMaps);
        openGoogleMaps.setOnClickListener(v -> launchGoogleMaps());

        @SuppressLint("UseSwitchCompatOrMaterialCode")
        Switch switchSpeedUnits = findViewById(R.id.switch_Imperial_Units);
        switchSpeedUnits.setOnClickListener(v -> switchToImperial());
    }

    public void switchToImperial() {
        imperialUnit = true;
    }

    public void openMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("imperialUnit", imperialUnit);
        startActivity(intent);
    }

    public void launchGoogleMaps() {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setPackage("com.google.android.apps.maps"); // Uri as second parameter to launch Streetview.
        startActivity(intent);
    }

}