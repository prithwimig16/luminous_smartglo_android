package tfl.smartglow.model;

import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.util.List;

public class DeviceTable {
    public static Device findByMac(String mac) {
        return SQLite.select().from(Device.class).where(Device_Table.macAddress.eq(mac)).querySingle();
    }
    public static List<Device> getAll() { return SQLite.select().from(Device.class).queryList();
    }
}
