package com.teckja.test12;

import android.content.Context;
import android.content.SharedPreferences;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public final class CommonUtils {
    private static final String FILE_SAVE = "pref_saved";
    private static CommonUtils instance;

    public static CommonUtils getInstance() {
        if (instance == null) {
            instance = new CommonUtils();
        }
        return instance;
    }
    public String getPref(String key, boolean isDelete) {
        SharedPreferences pref = App.getInstance().getSharedPreferences("My pref", Context.MODE_PRIVATE);
        String value = pref.getString(key, null);
        if (value != null && isDelete) {
            pref.edit().remove(key).apply();
        }
        return value;
    }

    public String getPref(String key) {
        return getPref(key,false);
    }

    public void savePref(String key, String data) {
        SharedPreferences pref = App.getInstance().getSharedPreferences("My pref", Context.MODE_PRIVATE);
        pref.edit().putString(key, data).apply();
    }
    private void writeToFile(String fullPath, String data) {
        try {
            File file = new File(fullPath);
            if (file.exists()) {
                return;
            }
            FileOutputStream out = new FileOutputStream(file);
            out.write(data.getBytes());
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private String readFile(String fullPath) {
        try {
            FileInputStream in = new FileInputStream(new File(fullPath));
            byte[] buff = new byte[1024];
            int len = in.read(buff);
            StringBuilder data = new StringBuilder();
            while (len > 0) {
                String txt = new String(buff,0,len);
                data.append(txt);
                len = in.read(buff);
            }
            in.close();
            return data.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}
