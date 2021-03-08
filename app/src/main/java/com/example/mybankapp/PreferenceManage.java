package com.example.mybankapp;
import android.content.Context;
import android.content.SharedPreferences;

public class PreferenceManage {
    Context context;

    PreferenceManage(Context context) {
        this.context = context;
    }

    public void saveLoginDetails(String id_connection) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("LoginDetails", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("Id", id_connection);
        editor.commit();
    }

    public String getId() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("LoginDetails", Context.MODE_PRIVATE);
        return sharedPreferences.getString("Id", "");
    }
    public boolean isUserLogedOut() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("LoginDetails", Context.MODE_PRIVATE);
        boolean isEmailEmpty = sharedPreferences.getString("Id", "").isEmpty();
        return isEmailEmpty;
    }
}
