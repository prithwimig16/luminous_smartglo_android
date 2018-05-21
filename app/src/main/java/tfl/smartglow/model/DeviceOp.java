package tfl.smartglow.model;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

import tfl.smartglow.database.DBManager;

@Table(database = DBManager.class)
public class DeviceOp  extends BaseModel {

    @PrimaryKey(autoincrement = true)
    @Column
    public int id;

    @Column
    public String macAddress;

    @Column
    public String deviceName;

    @Column
    public String meshName;

    @Column
    public String color;


}
