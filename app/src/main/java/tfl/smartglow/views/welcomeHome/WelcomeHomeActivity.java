package tfl.smartglow.views.welcomeHome;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import android.support.design.internal.BottomNavigationItemView;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.jingxun.meshlibtelink.TelinkLightService;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.telink.TelinkApplication;
import com.telink.bluetooth.light.LeAutoConnectParameters;
import com.telink.bluetooth.light.LeRefreshNotifyParameters;
import com.telink.bluetooth.light.Opcode;
import com.telink.bluetooth.light.Parameters;
import com.telink.util.Event;
import com.telink.util.EventListener;
import com.telink.util.Strings;

import java.util.ArrayList;
import java.util.List;

import tfl.smartglow.Constants;
import tfl.smartglow.R;
import tfl.smartglow.model.Device;
import tfl.smartglow.model.DeviceOp;
import tfl.smartglow.model.DeviceTable;
import tfl.smartglow.utils.Config;
import tfl.smartglow.utils.Utils;
import tfl.smartglow.views.blueTooth.BlueToothActivity;
import tfl.smartglow.views.colorPicker.ColorPickerActivity;
import tfl.smartglow.views.device.DeviceActivity;

public class WelcomeHomeActivity extends AppCompatActivity implements EventListener<String>, ItemListener {
    private ListView listView;
    String newMeshName = "";
    String newMeshPassword = "";
    TextView mtextView;//tvNoOfBulb;
    private ArrayList<Device> devices=new ArrayList<>();
    // BottomNavigationItemView bottomNavigationView;
    //  BulbListAdapter adapter;
    HomeAdapter adapter;

    String colorCode;
    ImageView imgAddDevice;
    int RED = 0, GREEN = 0, BLUE = 0;
    private int selectedPosition;
    private Object selectedObj;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TelinkApplication.getInstance().doInit(getApplicationContext(), TelinkLightService.class);
        setContentView(R.layout.activity_welcome_home);
//       bottomNavigationView=(BottomNavigationItemView)findViewById(R.id.bottom_navigation);


        BottomNavigationView bottomNavigationView = (BottomNavigationView)
                findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.action_home:
                                break;

                            case R.id.action_schedule:
                                break;

                            case R.id.action_menu:
                                break;

                        }
                        return true;
                    }
                });


        Config.getSharedInstance().applicationContext = this.getApplicationContext();
        FlowManager.init(this);
        String email = Utils.getValueFromPref(Constants.EMAIL);
        String password = Utils.getValueFromPref(Constants.PASSWORD);
        newMeshName = email;//"abc123";//random(10);
        newMeshPassword = password; //"123";//random(4);
        mtextView = findViewById(R.id.tv_connected_bulb_number);
        recyclerView = findViewById(R.id.rcv);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(WelcomeHomeActivity.this);
        recyclerView.setLayoutManager(linearLayoutManager);
        this.adapter = new HomeAdapter(this, this);
        recyclerView.setAdapter(adapter);
        //adapter.setDevices(DeviceTable.getAll());
        adapter.setDevices(testBulb());
        TelinkApplication.getInstance().addEventListener("com.telink.bluetooth.light.EVENT_SERVICE_CONNECTED", this);

        this.imgAddDevice = (ImageView) findViewById(R.id.img_add);
        this.imgAddDevice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //check whether ble on or not
                if (isBluetoothEnabled() && locationServicesEnabled(WelcomeHomeActivity.this)) {
                    Intent i = new Intent(WelcomeHomeActivity.this, DeviceActivity.class);
                    startActivity(i);
                } else {
                    //Utils.alert("Please Check your GPS and Bluetooth",WelcomeHomeActivity.this);
                    Intent i = new Intent(WelcomeHomeActivity.this, BlueToothActivity.class);
                    startActivity(i);
                }
            }
        });
    }

    private List<Device> testBulb(){
        Device device=new Device();
        device.deviceName="SmartG1";
        device.macAddress="1";
        Device device1=new Device();
        device1.deviceName="SmartG2";
        device1.macAddress="2";
        devices.add(device1);
        devices.add(device);
        return devices;
    }


    protected void onResume() {
        super.onResume();

        if (adapter.devices.size() <= 0) {
            List<Device> all = DeviceTable.getAll();
            adapter.setDevices(all);
        }
    }


    @Override
    public void performed(Event<String> event) {
        List<Device> all = DeviceTable.getAll();
        String email = Utils.getValueFromPref(Constants.EMAIL);
        String password = Utils.getValueFromPref(Constants.PASSWORD);
        for (Device device : all) {
            autoConnect(device.meshName, password, device.macAddress);
        }
    }

    public void autoConnect(String meshName, String meshPassword, String macAddress) {
        LeAutoConnectParameters parameters = Parameters.createAutoConnectParameters();
        parameters.setMeshName(meshName);
        parameters.setPassword(meshPassword);
        parameters.setConnectMac(macAddress);
        parameters.setTimeoutSeconds(10);
        parameters.autoEnableNotification(true);
        TelinkLightService.Instance().autoConnect(parameters);
        enableAutoRefreshNotify();
    }


    public void enableAutoRefreshNotify() {
        LeRefreshNotifyParameters parameters = Parameters.createRefreshNotifyParameters();
        parameters.setRefreshRepeatCount(10);
        parameters.setRefreshInterval(2000);
        TelinkLightService.Instance().autoRefreshNotify(parameters);
    }


    @Override
    public void onItemClick(Object o) {
        int i = 0;
    }

    @Override
    public void onItemLongClick(Object o) {
        TelinkLightService.Instance().login(Strings.stringToBytes(newMeshName, 16), Strings.stringToBytes(newMeshPassword, 16));
        Toast.makeText(this, "item Long clicked ", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemClick(Object o, int position) {
        selectedPosition = position;
        selectedObj = o;
        Intent i = new Intent(WelcomeHomeActivity.this, ColorPickerActivity.class);
        if (selectedObj instanceof Device) {
            i.putExtra(Constants.MAC_ADDRESS, ((Device) selectedObj).macAddress);
        }

        startActivityForResult(i, 2);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // check if the request code is same as what is passed  here it is 2
        if (requestCode == 2 && data != null) {
            int selectedColor = data.getIntExtra("COLOR_CODE", -1);
            if (selectedObj instanceof Device) {
                String hexColor = String.format("#%06X", (0xFFFFFF & selectedColor));
                String s1 = hexColor.substring(1, 3);
                String s2 = hexColor.substring(3, 5);
                String s3 = hexColor.substring(5, 7);
                TelinkLightService.Instance().getAdapter().sendCommand(Opcode.BLE_GATT_OP_CTRL_E2.getValue(), 0x01, new byte[]{0x04, (byte) hexStringToByte(s1), (byte) hexStringToByte(s2), (byte) hexStringToByte(s3)});
                DeviceOp deviceOp = new DeviceOp();
                deviceOp.color = hexColor;
                Device device = (Device) selectedObj;
                deviceOp.deviceName = device.deviceName;
                deviceOp.macAddress = device.macAddress;
                deviceOp.meshName = device.meshName;
            }

            int color = data.getIntExtra("COLOR_CODE", -1);
            if (selectedObj instanceof Device) {
                Device device = (Device) selectedObj;
                device.color = color;
                this.adapter.notifyItemChanged(selectedPosition, device);
            }

        }
        if (requestCode == 4) {
            if (isBluetoothEnabled() && locationServicesEnabled(WelcomeHomeActivity.this)) {
                Intent i = new Intent(WelcomeHomeActivity.this, DeviceActivity.class);
                startActivity(i);
            } else {
                Utils.alert("Please Check your GPS and Bluetooth", WelcomeHomeActivity.this);
            }
        } else {
            adapter.notifyDataSetChanged();
        }
    }

    private static byte hexStringToByte(String data) {
        return (byte) ((Character.digit(data.charAt(0), 16) << 4)
                | Character.digit(data.charAt(1), 16));
    }

    public boolean isBluetoothEnabled() {
        BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        return mBluetoothAdapter.isEnabled();

    }

    public static boolean locationServicesEnabled(Context context) {
        LocationManager lm = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        boolean gps_enabled = false;
        boolean net_enabled = false;

        try {
            gps_enabled = lm.isProviderEnabled(LocationManager.GPS_PROVIDER);
        } catch (Exception ex) {
            Log.e("TAG", "Exception gps_enabled");
        }

        try {
            net_enabled = lm.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
        } catch (Exception ex) {
            Log.e("TAG", "Exception network_enabled");
        }
        return gps_enabled || net_enabled;
    }
}
