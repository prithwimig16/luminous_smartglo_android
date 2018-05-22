package tfl.smartglow.views.blueTooth;


import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import tfl.smartglow.R;
import tfl.smartglow.utils.Utils;
import tfl.smartglow.views.device.DeviceActivity;

import static tfl.smartglow.views.welcomeHome.WelcomeHomeActivity.locationServicesEnabled;

public class BlueToothActivity extends AppCompatActivity {
ImageView imgBluetooth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blue_tooth);
        imgBluetooth=(ImageView)findViewById(R.id.img_bluetooth_logo);
        imgBluetooth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callGPSSettingIntent = new Intent(android.provider.Settings.ACTION_SETTINGS);
                startActivityForResult(callGPSSettingIntent, 4);
            }
        });

    }

    public boolean isBluetoothEnabled()
    {
        BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        return mBluetoothAdapter.isEnabled();

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 4) {
            if (isBluetoothEnabled() && locationServicesEnabled(BlueToothActivity.this)) {
                Intent i = new Intent(BlueToothActivity.this, DeviceActivity.class);
                startActivity(i);
            } else {
                Utils.alert("Please Check your GPS and Bluetooth", BlueToothActivity.this);
            }
        } else {

        }
    }

}
