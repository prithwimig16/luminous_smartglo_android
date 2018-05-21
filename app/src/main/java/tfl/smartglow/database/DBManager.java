package tfl.smartglow.database;

import com.raizlabs.android.dbflow.annotation.Database;

@Database(name = DBManager.NAME, version = DBManager.VERSION)
public class DBManager {
    public static final String NAME = "luminous_consumer";
    public static final int VERSION = 1;
}