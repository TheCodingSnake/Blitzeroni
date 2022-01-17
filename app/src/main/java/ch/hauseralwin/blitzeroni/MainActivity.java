package ch.hauseralwin.blitzeroni;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements LocationListener {

    public boolean imperialUnit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton openSettings = findViewById(R.id.imageButton_openSettings);
        openSettings.setOnClickListener(v -> openSettingsActivity());


        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},1);
        if(ActivityCompat.checkSelfPermission(this,Manifest.permission.ACCESS_FINE_LOCATION)!=PackageManager.PERMISSION_GRANTED &&ActivityCompat.checkSelfPermission(this,Manifest.permission.ACCESS_COARSE_LOCATION)!=PackageManager.PERMISSION_GRANTED)
    {
        return;
    }
        LocationManager lm = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
        lm.requestLocationUpdates(LocationManager.GPS_PROVIDER,0,0,this);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            imperialUnit = extras.getBoolean("imperialUnit");
            //The key argument here must match that used in the other activity
        }


}

    @SuppressLint("SetTextI18n")
    @Override
    public void onLocationChanged(Location location) {


        TextView txt = this.findViewById(R.id.textView_CurrentSpeed);

        if (location==null) {
            txt.setText("### KMH");
        } else {
            double nCurrentSpeed = location.getSpeed();
            nCurrentSpeed = nCurrentSpeed * 3.6; // change M/S to KMH
            txt.setText(nCurrentSpeed + " KMH");
            if (imperialUnit) {
                nCurrentSpeed = nCurrentSpeed / 1.6;
                txt.setText(nCurrentSpeed + " MPH");
            }
        }

    }
    public void openSettingsActivity() {
        Intent intent = new Intent(this, SettingActivity.class);
        startActivity(intent);
    }
}