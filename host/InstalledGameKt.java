package com.magicloader.app.host;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.os.Build;
import androidx.core.os.EnvironmentCompat;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InstalledGame.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\u001a\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002\u001a\u0012\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0006\u001a\u00020\u0007H\u0002\u001a\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000b2\u0006\u0010\f\u001a\u00020\u0005H\u0002¨\u0006\r"}, d2 = {"readInstalledGame", "Lcom/magicloader/app/host/InstallSnapshot;", "context", "Landroid/content/Context;", "packageInfo", "Landroid/content/pm/PackageInfo;", "manager", "Landroid/content/pm/PackageManager;", "installerOf", "", "signerDigests", "", "info", "app_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class InstalledGameKt {
    public static final InstallSnapshot readInstalledGame(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            PackageManager packageManager = context.getPackageManager();
            Intrinsics.checkNotNullExpressionValue(packageManager, "getPackageManager(...)");
            PackageInfo packageInfo = packageInfo(packageManager);
            ApplicationInfo applicationInfo = packageInfo.applicationInfo;
            if (applicationInfo == null) {
                return null;
            }
            String str = packageInfo.versionName;
            if (str == null) {
                str = EnvironmentCompat.MEDIA_UNKNOWN;
            }
            String str2 = str;
            long longVersionCode = packageInfo.getLongVersionCode();
            long j = packageInfo.lastUpdateTime;
            String sourceDir = applicationInfo.sourceDir;
            Intrinsics.checkNotNullExpressionValue(sourceDir, "sourceDir");
            String[] strArr = applicationInfo.splitSourceDirs;
            List list = strArr != null ? ArraysKt.toList(strArr) : null;
            if (list == null) {
                list = CollectionsKt.emptyList();
            }
            List list2 = list;
            String nativeLibraryDir = applicationInfo.nativeLibraryDir;
            Intrinsics.checkNotNullExpressionValue(nativeLibraryDir, "nativeLibraryDir");
            PackageManager packageManager2 = context.getPackageManager();
            Intrinsics.checkNotNullExpressionValue(packageManager2, "getPackageManager(...)");
            return new InstallSnapshot(str2, longVersionCode, j, sourceDir, list2, nativeLibraryDir, installerOf(packageManager2), signerDigests(packageInfo));
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    private static final PackageInfo packageInfo(PackageManager packageManager) throws PackageManager.NameNotFoundException {
        if (Build.VERSION.SDK_INT >= 33) {
            PackageInfo packageInfo = packageManager.getPackageInfo("com.mojang.minecraftpe", PackageManager.PackageInfoFlags.of(134217728L));
            Intrinsics.checkNotNull(packageInfo);
            return packageInfo;
        }
        PackageInfo packageInfo2 = packageManager.getPackageInfo("com.mojang.minecraftpe", 134217728);
        Intrinsics.checkNotNull(packageInfo2);
        return packageInfo2;
    }

    private static final String installerOf(PackageManager packageManager) {
        String installerPackageName;
        try {
            if (Build.VERSION.SDK_INT >= 30) {
                installerPackageName = packageManager.getInstallSourceInfo("com.mojang.minecraftpe").getInstallingPackageName();
            } else {
                installerPackageName = packageManager.getInstallerPackageName("com.mojang.minecraftpe");
            }
            return installerPackageName;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    private static final List<String> signerDigests(PackageInfo packageInfo) {
        SigningInfo signingInfo = packageInfo.signingInfo;
        Signature[] apkContentsSigners = signingInfo != null ? signingInfo.getApkContentsSigners() : null;
        if (apkContentsSigners == null) {
            apkContentsSigners = new Signature[0];
        }
        ArrayList arrayList = new ArrayList(apkContentsSigners.length);
        for (Signature signature : apkContentsSigners) {
            byte[] bArrDigest = MessageDigest.getInstance("SHA-256").digest(signature.toByteArray());
            Intrinsics.checkNotNullExpressionValue(bArrDigest, "digest(...)");
            arrayList.add(ArraysKt.joinToString$default(bArrDigest, (CharSequence) "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: com.magicloader.app.host.InstalledGameKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return InstalledGameKt.signerDigests$lambda$1$lambda$0(((Byte) obj).byteValue());
                }
            }, 30, (Object) null));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence signerDigests$lambda$1$lambda$0(byte b) {
        String str = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(b)}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }
}
