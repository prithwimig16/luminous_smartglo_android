package tfl.smartglow.deviceInfo;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Arrays;

public class DeviceInfo implements Parcelable {
    public String macAddress;
    public String deviceName;
    public String meshName;
    public int meshAddress;
    public int meshUUID;
    public int productUUID;
    public int manufactureID;
    public int status;
    public byte[] longTermKey = new byte[16];
    public String firmwareRevision;
    public static final Creator<DeviceInfo> CREATOR = new Creator<DeviceInfo>() {
        public DeviceInfo createFromParcel(Parcel source) {
            return new DeviceInfo(source);
        }

        public DeviceInfo[] newArray(int size) {
            return new DeviceInfo[size];
        }
    };

    public DeviceInfo() {
    }

    public String toString() {
        return "DeviceInfo{macAddress='" + this.macAddress + '\'' + ", deviceName='" + this.deviceName + '\'' + ", meshName='" + this.meshName + '\'' + ", meshAddress=" + this.meshAddress + ", meshUUID=" + this.meshUUID + ", productUUID=" + this.productUUID + ", manufactureID=" + this.manufactureID + ", status=" + this.status + ", longTermKey=" + Arrays.toString(this.longTermKey) + ", firmwareRevision='" + this.firmwareRevision + '\'' + '}';
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.macAddress);
        dest.writeString(this.deviceName);
        dest.writeString(this.meshName);
        dest.writeInt(this.meshAddress);
        dest.writeInt(this.meshUUID);
        dest.writeInt(this.productUUID);
        dest.writeInt(this.manufactureID);
        dest.writeInt(this.status);
        dest.writeByteArray(this.longTermKey);
        dest.writeString(this.firmwareRevision);
    }

    protected DeviceInfo(Parcel in) {
        this.macAddress = in.readString();
        this.deviceName = in.readString();
        this.meshName = in.readString();
        this.meshAddress = in.readInt();
        this.meshUUID = in.readInt();
        this.productUUID = in.readInt();
        this.manufactureID = in.readInt();
        this.status = in.readInt();
        this.longTermKey = in.createByteArray();
        this.firmwareRevision = in.readString();
    }
}
