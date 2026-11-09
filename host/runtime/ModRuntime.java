package com.magicloader.app.host.runtime;

import android.app.Activity;
import com.magicloader.app.injected.InjectedEntry;

/* JADX INFO: loaded from: classes.dex */
final class ModRuntime {
    private static boolean started;

    private ModRuntime() {
    }

    static void start(Activity activity) {
        if (started) {
            return;
        }
        started = true;
        InjectedEntry.install(activity.getApplication());
    }
}
