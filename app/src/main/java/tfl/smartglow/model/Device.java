package tfl.smartglow.model;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

import tfl.smartglow.database.DBManager;

@Table(database = DBManager.class)
public class Device extends BaseModel {

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
    public int meshAddress;

    @Column
    public int meshUUID;

    @Column
    public int productUUID;

    @Column
    public int manufactureID;

    @Column
    public int status;

    @Column
    public  int color;

    @Column
    public byte[] longTermKey = new byte[16];

    @Column
    public String firmwareRevision;
}
