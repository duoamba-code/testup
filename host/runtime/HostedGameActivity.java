package com.magicloader.app.host.runtime;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import com.magicloader.app.host.RefreshRate;
import com.mojang.minecraftpe.MainActivity;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class HostedGameActivity extends MainActivity {
    private static final String TAG = "MagicHost";
    private AssetManager gameAssets;

    @Override // com.mojang.minecraftpe.MainActivity, com.google.androidgamesdk.GameActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        if (!GameLibraries.INSTANCE.getLoaded()) {
            restoreOrRestart();
        }
        ModRuntime.start(this);
        super.onCreate(bundle);
        if (RefreshRate.current(this) == RefreshRate.HIGHEST) {
            preferFastestMode();
        }
    }

    private void preferFastestMode() {
        Display display = Build.VERSION.SDK_INT >= 30 ? getDisplay() : getWindowManager().getDefaultDisplay();
        if (display == null) {
            return;
        }
        Display.Mode mode = display.getMode();
        Display.Mode mode2 = mode;
        for (Display.Mode mode3 : display.getSupportedModes()) {
            if (mode3.getPhysicalWidth() == mode.getPhysicalWidth() && mode3.getPhysicalHeight() == mode.getPhysicalHeight() && mode3.getRefreshRate() > mode2.getRefreshRate()) {
                mode2 = mode3;
            }
        }
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.preferredDisplayModeId = mode2.getModeId();
        getWindow().setAttributes(attributes);
        Log.i("MagicHost", "display mode " + mode2.getModeId() + " requested: " + mode2.getRefreshRate() + " Hz (was " + mode.getRefreshRate() + " Hz)");
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        AssetManager assetManager = this.gameAssets;
        if (assetManager != null) {
            return assetManager;
        }
        try {
            AssetManager assetManager2 = (AssetManager) AssetManager.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            Method method = AssetManager.class.getMethod("addAssetPath", String.class);
            Context contextCreatePackageContext = getApplicationContext().createPackageContext("com.mojang.minecraftpe", 3);
            method.invoke(assetManager2, contextCreatePackageContext.getApplicationInfo().sourceDir);
            String[] strArr = contextCreatePackageContext.getApplicationInfo().splitSourceDirs;
            if (strArr != null) {
                for (String str : strArr) {
                    method.invoke(assetManager2, str);
                }
            }
            method.invoke(assetManager2, getApplicationContext().getPackageResourcePath());
            this.gameAssets = assetManager2;
            return assetManager2;
        } catch (Exception e) {
            Log.e("MagicHost", "Could not build the game AssetManager; using MagicLoader's own", e);
            return super.getAssets();
        }
    }

    private void restoreOrRestart() {
        try {
            GameBoot.prepareBlocking(this);
        } catch (Exception | UnsatisfiedLinkError e) {
            Log.e("MagicHost", "Game process restored without its libraries; restarting through the boot screen", e);
            startActivity(new Intent(this, (Class<?>) GameBootActivity.class).addFlags(268435456));
            System.exit(0);
        }
    }
}
