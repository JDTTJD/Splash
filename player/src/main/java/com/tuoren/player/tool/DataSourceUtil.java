package com.tuoren.player.tool;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;

/**
 * Create by JDT on 2019/12/13.
 */
public class DataSourceUtil {
    public static int getMetaDataFromApp(Context context) {
        int value = 0;
        try {
            ApplicationInfo appInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), PackageManager.GET_META_DATA);
            value = appInfo.metaData.getInt("playertype");
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return value;
    }
}
