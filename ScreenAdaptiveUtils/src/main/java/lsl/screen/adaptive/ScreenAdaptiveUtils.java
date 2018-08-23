package lsl.screen.adaptive;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.util.DisplayMetrics;

/**
 * 根据 今日头条技术团队 分享的android适配方案封装
 *
 * @author lishuanglong 2018/8/23
 */
public class ScreenAdaptiveUtils {

    private static float sNoncompatDensity = 0.0F;
    private static float sNoncompatScaledDensity = 0.0F;

    /**
     * 根据设备的高适配
     */
    public static void screenAdaptiveHeight(@NonNull Context activity, @NonNull Context application, int designSizeDP) {
        setCustomDensity(activity, application, true, designSizeDP);
    }

    /**
     * 根据设备的宽适配
     */
    public static void screenAdaptiveWidth(@NonNull Context activity, @NonNull Context application, int designSizeDP) {
        setCustomDensity(activity, application, false, designSizeDP);
    }

    /**
     * 关闭，取消屏幕适配
     */
    public static void cancelAdaptive(@NonNull Context activity, @NonNull Context application) {
        closeAdaptive(activity, application);
    }

    /**
     * @param activity      activity 上下文
     * @param application   application 上下文
     * @param isOrientation 为 true 是以高适配，为false以宽适配
     * @param designSizeDP  以设计图宽(dp)，高(dp)为基准,修改系统的 Density（密度、比例）、dpi、scaledDensity
     */
    private static void setCustomDensity(@NonNull Context activity, @NonNull final Context application, boolean isOrientation,
                                         int designSizeDP) {
        DisplayMetrics applicationDisplayMetrics = application.getResources().getDisplayMetrics();

        if (sNoncompatDensity == 0) {
            sNoncompatDensity = applicationDisplayMetrics.density;
            sNoncompatScaledDensity = applicationDisplayMetrics.scaledDensity;
            application.registerComponentCallbacks(new ComponentCallbacks() {
                @Override
                public void onConfigurationChanged(Configuration newConfig) {
                    if (newConfig != null && newConfig.fontScale > 0) {
                        sNoncompatScaledDensity = application.getResources().getDisplayMetrics().scaledDensity;
                    }
                }

                @Override
                public void onLowMemory() {
                }
            });
        }
        float targetDensity = 0.0F;
        if (isOrientation) {
            targetDensity = (float) applicationDisplayMetrics.heightPixels / designSizeDP;
        } else {
            targetDensity = (float) applicationDisplayMetrics.widthPixels / designSizeDP;
        }
        float targetScaledDensity = targetDensity * (sNoncompatScaledDensity / sNoncompatDensity);
        int targetDensityDpi = (int) (targetDensity * 160);

        applicationDisplayMetrics.scaledDensity = targetScaledDensity;
        applicationDisplayMetrics.density = targetDensity;
        applicationDisplayMetrics.densityDpi = targetDensityDpi;

        DisplayMetrics activityDisplayMetrics = activity.getResources().getDisplayMetrics();
        activityDisplayMetrics.scaledDensity = targetScaledDensity;
        activityDisplayMetrics.density = targetDensity;
        activityDisplayMetrics.densityDpi = targetDensityDpi;
    }

    /**
     * 关闭适配，恢复之前的 dpi、Density、scaledDensity
     */
    private static void closeAdaptive(@NonNull Context activity, @NonNull Context application) {
        DisplayMetrics ResourcesDisplayMetrics = Resources.getSystem().getDisplayMetrics();
        DisplayMetrics applicationDisplayMetrics = application.getResources().getDisplayMetrics();
        DisplayMetrics activityDisplayMetrics = activity.getResources().getDisplayMetrics();

        applicationDisplayMetrics.scaledDensity = ResourcesDisplayMetrics.scaledDensity;
        applicationDisplayMetrics.density = ResourcesDisplayMetrics.density;
        applicationDisplayMetrics.densityDpi = ResourcesDisplayMetrics.densityDpi;

        activityDisplayMetrics.scaledDensity = ResourcesDisplayMetrics.scaledDensity;
        activityDisplayMetrics.density = ResourcesDisplayMetrics.density;
        activityDisplayMetrics.densityDpi = ResourcesDisplayMetrics.densityDpi;
    }
}
