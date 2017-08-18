package com.allen.code.analyze;

import android.app.Application;

import com.github.moduth.blockcanary.BlockCanary;
import com.squareup.leakcanary.LeakCanary;

/**
 * 作者：husongzhen on 17/8/18 10:47
 * 邮箱：husongzhen@musikid.com
 */

public class AnalyzeManager {

    public static final void init(Application context) {
        if (LeakCanary.isInAnalyzerProcess(context)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(context);

        BlockCanary.install(context, new AppBlockCanaryContext()).start();
    }

}
