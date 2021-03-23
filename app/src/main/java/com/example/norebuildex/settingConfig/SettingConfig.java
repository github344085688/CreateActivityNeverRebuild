package com.example.norebuildex.settingConfig;

import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;

public class SettingConfig {
    /**
     * 全透状态栏
     */
    public static void setStatusBarFullTransparent(@NonNull Activity activity) {
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT) {
            int flagTranslucentStatus = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
            int flagTranslucentNavigation = WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                Window window = activity.getWindow();
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.flags |= flagTranslucentNavigation;
                window.setAttributes(attributes);
                activity.getWindow().setStatusBarColor(Color.TRANSPARENT);
            } else {
                Window window = activity.getWindow();
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.flags |= flagTranslucentStatus | flagTranslucentNavigation;
                window.setAttributes(attributes);
            }
        }
    }

    /**
     * 计算状态栏颜色
     */
    //Get alpha color
    static int calculateStatusBarColor(int color, int alpha) {
        float a = 1 - alpha / 255f;
        int red = color >> 16 & 0xff;
        int green = color >> 8 & 0xff;
        int blue = color & 0xff;
        red = (int) (red * a + 0.5);
        green = (int) (green * a + 0.5);
        blue = (int) (blue * a + 0.5);
        return 0xff << 24 | red << 16 | green << 8 | blue;
    }

    /**
     * set statusBarColor
     *
     * @param statusColor color
     * @param
     */
    public static void setStatusBarColor(@NonNull Activity activity, @ColorInt int statusColor, int alpha) {
        setStatusBarColor(activity, calculateStatusBarColor(statusColor, alpha));
    }

    static void setStatusBarColor(@NonNull Activity activity, @ColorInt int statusColor) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            SettingConfig.setStatusBarColor(activity, statusColor);
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            SettingConfig.setStatusBarColor(activity, statusColor);
        }
    }

    public static void translucentStatusBar(@NonNull Activity activity) {
        translucentStatusBar(activity, false);
    }

    /**
     * change to full screen mode
     *
     * @param hideStatusBarBackground hide status bar alpha Background when SDK > 21, true if hide it
     */
    public static void translucentStatusBar(@NonNull Activity activity, boolean hideStatusBarBackground) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            SettingConfig.translucentStatusBar(activity, hideStatusBarBackground);
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            SettingConfig.translucentStatusBar(activity);
        }
    }

   /* public static void setStatusBarColorForCollapsingToolbar(@NonNull Activity activity, AppBarLayout AppBarLayout appBarLayout, CollapsingToolbarLayout collapsingToolbarLayout,
                                                             Toolbar toolbar, @ColorInt int statusColor) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            StatusBarCompat.setStatusBarColorForCollapsingToolbar(activity, appBarLayout, collapsingToolbarLayout, toolbar, statusColor);
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            StatusBarCompat.setStatusBarColorForCollapsingToolbar(activity, appBarLayout, collapsingToolbarLayout, toolbar, statusColor);
        }
    }*/


    /**
     * 设置状态栏字体颜色是否加深
     *
     * @param activity
     * @param isDark   true为加深
     */
   /* public static void setStatusBarTextColor(Activity activity, boolean isDark) {
        if (isDark == true) {
            if (OisSample.isMIUI()) {
                setMiuiStatusBarDarkMode(activity, true);
            } else if (OsInfoUtil.isFlyme()) {
                setMeizuStatusBarDarkIcon(activity, true);
            } else {
                setStatusBarLightMode(activity, true);
            }
        } else {
            if (OsInfoUtil.isMIUI()) {
                setMiuiStatusBarDarkMode(activity, false);
            } else if (OsInfoUtil.isFlyme()) {
                setMeizuStatusBarDarkIcon(activity, false);
            } else {
                setStatusBarLightMode(activity, false);
            }
        }
    }*/

    /**
     * MIUI 状态栏字体颜色
     *
     * @param activity
     * @param darkmode
     * @return
     */
  /*  private static boolean setMiuiStatusBarDarkMode(Activity activity,
                                                    boolean darkmode) {
        Class<? extends Window> clazz = activity.getWindow().getClass();
        try {
            int darkModeFlag = 0;
            Class<?> layoutParams = Class
                    .forName("android.view.MiuiWindowManager$LayoutParams");
            Field field = layoutParams
                    .getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE");
            darkModeFlag = field.getInt(layoutParams);
            Method extraFlagField = clazz.getMethod("setExtraFlags", int.class,
                    int.class);
            extraFlagField.invoke(activity.getWindow(), darkmode ? darkModeFlag
                    : 0, darkModeFlag);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }*/

    /**
     * flyme状态栏字体颜色
     *
     * @param activity
     * @param dark
     * @return
     */
   /* private static boolean setMeizuStatusBarDarkIcon(Activity activity,
                                                     boolean dark) {
        boolean result = false;
        if (activity != null) {
            try {
                WindowManager.LayoutParams lp = activity.getWindow()
                        .getAttributes();
                Field darkFlag = WindowManager.LayoutParams.class
                        .getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");
                Field meizuFlags = WindowManager.LayoutParams.class
                        .getDeclaredField("meizuFlags");
                darkFlag.setAccessible(true);
                meizuFlags.setAccessible(true);
                int bit = darkFlag.getInt(null);
                int value = meizuFlags.getInt(lp);
                if (dark) {
                    value |= bit;
                } else {
                    value &= ~bit;
                }
                meizuFlags.setInt(lp, value);
                activity.getWindow().setAttributes(lp);
                result = true;
            } catch (Exception e) {
            }
        }
        return result;
    }*/

    /**
     * 设置6.0+状态栏字体颜色
     *
     * @param activity
     * @param isFontColorDark
     */
    public static void setStatusBarLightMode(Activity activity, boolean isFontColorDark) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (isFontColorDark) {
                // 沉浸式
                //                activity.getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
                //非沉浸式
                activity.getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            } else {
                //非沉浸式
                activity.getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_VISIBLE);
            }
        }
    }
}
