package com.magicloader.app.host.runtime;

import android.content.Context;
import java.io.File;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class HostRuntime {
    private static final String LIBRARY = "magicloader_host";
    private static boolean started;

    private static native boolean nativeStart(String str, String[] strArr);

    private HostRuntime() {
    }

    public static synchronized void start(Context context, List<String> list) {
        if (started) {
            return;
        }
        System.loadLibrary(LIBRARY);
        if (!nativeStart(new File(context.getFilesDir(), GameInstall.MAGIC_DIR).getAbsolutePath(), (String[]) list.toArray(new String[0]))) {
            throw new IllegalStateException("MagicLoader renderer did not start");
        }
        started = true;
    }
}
