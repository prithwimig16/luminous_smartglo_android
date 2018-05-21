package tfl.smartglow.utils;

import android.content.Context;

public class Config {

    public Context applicationContext=null;
    private static Config _instance = null;

    public static Config getSharedInstance()
    {
        if(_instance==null)
        {
            _instance = new Config();
            }
        return _instance;
    }
}
