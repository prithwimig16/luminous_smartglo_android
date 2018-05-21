package tfl.smartglow.dbQuerys;

import java.util.ArrayList;
import java.util.List;

import tfl.smartglow.deviceInfo.DeviceInfo;

public class DeviceList {
    static List<DeviceInfo> list = new ArrayList<DeviceInfo>();


    public static void add(DeviceInfo deviceInfo){
        list.add(deviceInfo);
    }

    public static List<DeviceInfo> getList() {
        return list;
    }
}
