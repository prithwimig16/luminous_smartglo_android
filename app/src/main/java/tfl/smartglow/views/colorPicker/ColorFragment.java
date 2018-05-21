package tfl.smartglow.views.colorPicker;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.jingxun.meshlibtelink.TelinkLightService;
import com.skydoves.colorpickerpreference.ColorEnvelope;
import com.skydoves.colorpickerpreference.ColorListener;
import com.skydoves.colorpickerpreference.ColorPickerPreference;
import com.skydoves.colorpickerpreference.ColorPickerView;
import com.skydoves.colorpickerpreference.FlagMode;
import com.telink.bluetooth.light.Opcode;

import tfl.smartglow.R;
import tfl.smartglow.model.Device;
import tfl.smartglow.model.DeviceOp;
import tfl.smartglow.model.DeviceTable;

/**
 * A simple {@link Fragment} subclass.
 */
public class ColorFragment extends Fragment {
ColorPickerView colorPickerView;
    int p;
    int []q;
    private String macAddress;
    private Device device;

    public ColorFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_color, container, false);


        return v;
    }

    @Override
    public void onViewCreated(final View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
// add your code here which executes after the execution of onCreateView() method.
        colorPickerView=(ColorPickerView)view.findViewById(R.id.colorPickerView);
        Button btDone=(Button)view.findViewById(R.id.bt_done);
        colorPickerView.setFlagMode(FlagMode.ALWAYS);

        colorPickerView.setColorListener(new ColorListener() {
            @Override
            public void onColorSelected(ColorEnvelope colorEnvelope) {
                p=colorEnvelope.getColor();
                 q=colorEnvelope.getColorRGB();
                String hexColor = String.format("#%06X", (0xFFFFFF & p));
                String s1 = hexColor.substring(1, 3);
                String s2 = hexColor.substring(3, 5);
                String s3 = hexColor.substring(5, 7);
                TelinkLightService.Instance().getAdapter().sendCommand(Opcode.BLE_GATT_OP_CTRL_E2.getValue(), 0x01, new byte[]{0x04, (byte) hexStringToByte(s1), (byte) hexStringToByte(s2), (byte) hexStringToByte(s3)});
                DeviceOp deviceOp = new DeviceOp();
                deviceOp.color = hexColor;
                deviceOp.deviceName = device.deviceName;
                deviceOp.macAddress = device.macAddress;
                deviceOp.meshName = device.meshName;
                device.color = p;
                device.update();

            }

        });

        btDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent=new Intent();
                intent.putExtra("COLOR_CODE",p);
//                intent.putExtra("COLOR_CODE",q);
                getActivity(). setResult(2,intent);
                getActivity(). finish();//finishing activity
            }
        });

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        device = DeviceTable.findByMac(macAddress);
    }

    @Override
    public void onResume() {
        super.onResume();

    }

    private void pickColor(){
        colorPickerView.setColorListener(new ColorListener() {
            @Override
            public void onColorSelected(ColorEnvelope colorEnvelope) {
//                LinearLayout linearLayout = v.findViewById(R.id.colorPickerView);
//                linearLayout.setBackgroundColor(colorEnvelope.getColor());
                int c=colorEnvelope.getColor();
                int k=c;
            }
        });
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    private static byte hexStringToByte(String data) {
        return (byte) ((Character.digit(data.charAt(0), 16) << 4)
                | Character.digit(data.charAt(1), 16));
    }
}
