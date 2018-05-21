package tfl.smartglow.views.splashScreen;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import tfl.smartglow.R;
import tfl.smartglow.utils.Config;
import tfl.smartglow.views.SliderPage.SliderActivity;
import tfl.smartglow.views.welcomeHome.WelcomeHomeActivity;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        Config.getSharedInstance().applicationContext = this.getApplicationContext();
        int secondsDelayed = 3;
        new Handler().postDelayed(new Runnable() {
            public void run() {

                if(isBluetoothEnabled()){

                startActivity(new Intent(SplashScreenActivity.this, SliderActivity.class));
                finish();
                }
                else{
                    startActivity(new Intent(SplashScreenActivity.this,  SliderActivity.class));
                    finish();
                }
            }
        }, secondsDelayed * 1000);
    }

    public boolean isBluetoothEnabled()
    {
        BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        return mBluetoothAdapter.isEnabled();

    }
}
