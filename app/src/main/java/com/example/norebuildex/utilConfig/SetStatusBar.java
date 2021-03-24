package com.example.norebuildex.utilConfig;

import android.app.Activity;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.example.norebuildex.R;

public class SetStatusBar {

    /**
     * 更改状态栏
     */
    /**
     * 是否设置成透明状态栏，即就是全屏模式
     */
    public static boolean isUseFullScreenMode;
    /**
     * 更改状态栏颜色，只有非全屏模式下有效
     */
    public static int getStatusBarColor = R.color.colorWhite;
    /**
     * 是否改变状态栏文字颜色为黑色，默认为黑色
     */
    public static boolean isUseBlackFontWithStatusBar = false;

    public static void setStatusBar(@NonNull Activity activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (isUseFullScreenMode) {
                StatusBarUtil.transparencyBar(activity);
            } else {
                StatusBarUtil.setStatusBarColor(activity, getStatusBarColor);
            }

            if (isUseBlackFontWithStatusBar) {
                StatusBarUtil.setLightStatusBar(activity, true, isUseFullScreenMode);
            }
        }
    }

    public static void closeStatusBar(@NonNull Activity activity){
        isUseFullScreenMode = true;
        setStatusBar(activity);
    }

    /**
     * 是否设置成透明状态栏，即就是全屏模式
     */
  /* public static  boolean isUseFullScreenMode() {
       return true;
   }*/

    /**
     * 更改状态栏颜色，只有非全屏模式下有效
     */
  /*  public static int getStatusBarColor() {
        return R.color.colorWhite;
    }*/

    /**
     * 是否改变状态栏文字颜色为黑色，默认为黑色
     */
   /* public static boolean isUseBlackFontWithStatusBar() {
        return true;
    }*/


}
