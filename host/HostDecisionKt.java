package com.magicloader.app.host;

import com.magicloader.app.host.HostDecision;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: HostDecision.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\u001a\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"PLAY_STORE_INSTALLER", "", "MOJANG_SIGNER_SHA256", "ARM64", "decideHost", "Lcom/magicloader/app/host/HostDecision;", "install", "Lcom/magicloader/app/host/InstallSnapshot;", "allowUnofficial", "", "app_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class HostDecisionKt {
    private static final String ARM64 = "arm64";
    public static final String MOJANG_SIGNER_SHA256 = "31be40096f931cd7f11d5e262d2b2c437c44385fb4ecbc1013d95a7435816f9c";
    public static final String PLAY_STORE_INSTALLER = "com.android.vending";

    public static /* synthetic */ HostDecision decideHost$default(InstallSnapshot installSnapshot, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return decideHost(installSnapshot, z);
    }

    public static final HostDecision decideHost(InstallSnapshot installSnapshot, boolean z) {
        if (installSnapshot == null) {
            return HostDecision.NotInstalled.INSTANCE;
        }
        List listPlus = CollectionsKt.plus((Collection<? extends String>) CollectionsKt.plus((Collection<? extends String>) installSnapshot.getSplitDirs(), installSnapshot.getNativeLibraryDir()), installSnapshot.getSourceDir());
        if (!(listPlus instanceof Collection) || !listPlus.isEmpty()) {
            Iterator it = listPlus.iterator();
            while (it.hasNext()) {
                if (StringsKt.contains$default((CharSequence) it.next(), (CharSequence) ARM64, false, 2, (Object) null)) {
                    if (z) {
                        return new HostDecision.Ready(installSnapshot);
                    }
                    return !Intrinsics.areEqual(installSnapshot.getSignerDigests(), CollectionsKt.listOf(MOJANG_SIGNER_SHA256)) ? new HostDecision.NotGenuine(installSnapshot.getSignerDigests()) : !Intrinsics.areEqual(installSnapshot.getInstaller(), "com.android.vending") ? new HostDecision.NotFromPlay(installSnapshot.getInstaller()) : new HostDecision.Ready(installSnapshot);
                }
            }
        }
        return new HostDecision.WrongAbi(installSnapshot.getNativeLibraryDir());
    }
}
