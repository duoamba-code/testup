package com.magicloader.app.host;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import com.magicloader.app.host.runtime.GameBootActivity;
import java.io.File;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: HostLauncher.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¨\u0006\u0004"}, d2 = {"launchHostedGame", "", "activity", "Landroid/app/Activity;", "app_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class HostLauncherKt {
    public static final void launchHostedGame(Activity activity) {
        Object objM325constructorimpl;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intent intentAddFlags = new Intent(activity, (Class<?>) GameBootActivity.class).addFlags(268435456);
        Intrinsics.checkNotNullExpressionValue(intentAddFlags, "addFlags(...)");
        try {
            Result.Companion companion = Result.INSTANCE;
            objM325constructorimpl = Result.m325constructorimpl(StringsKt.trim((CharSequence) FilesKt.readText$default(new File(activity.getFilesDir(), "launch_deeplink"), null, 1, null)).toString());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM325constructorimpl = Result.m325constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m331isFailureimpl(objM325constructorimpl)) {
            objM325constructorimpl = null;
        }
        String str = (String) objM325constructorimpl;
        if (str != null) {
            String str2 = str.length() > 0 ? str : null;
            if (str2 != null) {
                intentAddFlags.setAction("android.intent.action.VIEW");
                intentAddFlags.setData(Uri.parse(str2));
            }
        }
        activity.startActivity(intentAddFlags);
    }
}
