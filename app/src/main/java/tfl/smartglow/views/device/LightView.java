package tfl.smartglow.views.device;

import com.telink.bluetooth.light.DeviceInfo;

public interface LightView {
    void doOperation(DeviceInfo deviceInfo);
}
