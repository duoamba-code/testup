package com.magicloader.app.host;

import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HostDecision.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BU\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\t\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\t¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00030\tHÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00030\tHÆ\u0003Jg\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\tHÆ\u0001J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010(\u001a\u00020)HÖ\u0001J\t\u0010*\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\t¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00030\t8F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0016¨\u0006+"}, d2 = {"Lcom/magicloader/app/host/InstallSnapshot;", "", "versionName", "", "versionCode", "", "lastUpdateTime", "sourceDir", "splitDirs", "", "nativeLibraryDir", "installer", "signerDigests", "<init>", "(Ljava/lang/String;JJLjava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getVersionName", "()Ljava/lang/String;", "getVersionCode", "()J", "getLastUpdateTime", "getSourceDir", "getSplitDirs", "()Ljava/util/List;", "getNativeLibraryDir", "getInstaller", "getSignerDigests", "apks", "getApks", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class InstallSnapshot {
    private final String installer;
    private final long lastUpdateTime;
    private final String nativeLibraryDir;
    private final List<String> signerDigests;
    private final String sourceDir;
    private final List<String> splitDirs;
    private final long versionCode;
    private final String versionName;

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getVersionName() {
        return this.versionName;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getVersionCode() {
        return this.versionCode;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final long getLastUpdateTime() {
        return this.lastUpdateTime;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getSourceDir() {
        return this.sourceDir;
    }

    public final List<String> component5() {
        return this.splitDirs;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getNativeLibraryDir() {
        return this.nativeLibraryDir;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getInstaller() {
        return this.installer;
    }

    public final List<String> component8() {
        return this.signerDigests;
    }

    public final InstallSnapshot copy(String versionName, long versionCode, long lastUpdateTime, String sourceDir, List<String> splitDirs, String nativeLibraryDir, String installer, List<String> signerDigests) {
        Intrinsics.checkNotNullParameter(versionName, "versionName");
        Intrinsics.checkNotNullParameter(sourceDir, "sourceDir");
        Intrinsics.checkNotNullParameter(splitDirs, "splitDirs");
        Intrinsics.checkNotNullParameter(nativeLibraryDir, "nativeLibraryDir");
        Intrinsics.checkNotNullParameter(signerDigests, "signerDigests");
        return new InstallSnapshot(versionName, versionCode, lastUpdateTime, sourceDir, splitDirs, nativeLibraryDir, installer, signerDigests);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InstallSnapshot)) {
            return false;
        }
        InstallSnapshot installSnapshot = (InstallSnapshot) other;
        return Intrinsics.areEqual(this.versionName, installSnapshot.versionName) && this.versionCode == installSnapshot.versionCode && this.lastUpdateTime == installSnapshot.lastUpdateTime && Intrinsics.areEqual(this.sourceDir, installSnapshot.sourceDir) && Intrinsics.areEqual(this.splitDirs, installSnapshot.splitDirs) && Intrinsics.areEqual(this.nativeLibraryDir, installSnapshot.nativeLibraryDir) && Intrinsics.areEqual(this.installer, installSnapshot.installer) && Intrinsics.areEqual(this.signerDigests, installSnapshot.signerDigests);
    }

    public int hashCode() {
        int iHashCode = ((((((((((this.versionName.hashCode() * 31) + Long.hashCode(this.versionCode)) * 31) + Long.hashCode(this.lastUpdateTime)) * 31) + this.sourceDir.hashCode()) * 31) + this.splitDirs.hashCode()) * 31) + this.nativeLibraryDir.hashCode()) * 31;
        String str = this.installer;
        return ((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.signerDigests.hashCode();
    }

    public String toString() {
        return "InstallSnapshot(versionName=" + this.versionName + ", versionCode=" + this.versionCode + ", lastUpdateTime=" + this.lastUpdateTime + ", sourceDir=" + this.sourceDir + ", splitDirs=" + this.splitDirs + ", nativeLibraryDir=" + this.nativeLibraryDir + ", installer=" + this.installer + ", signerDigests=" + this.signerDigests + ")";
    }

    public InstallSnapshot(String versionName, long j, long j2, String sourceDir, List<String> splitDirs, String nativeLibraryDir, String str, List<String> signerDigests) {
        Intrinsics.checkNotNullParameter(versionName, "versionName");
        Intrinsics.checkNotNullParameter(sourceDir, "sourceDir");
        Intrinsics.checkNotNullParameter(splitDirs, "splitDirs");
        Intrinsics.checkNotNullParameter(nativeLibraryDir, "nativeLibraryDir");
        Intrinsics.checkNotNullParameter(signerDigests, "signerDigests");
        this.versionName = versionName;
        this.versionCode = j;
        this.lastUpdateTime = j2;
        this.sourceDir = sourceDir;
        this.splitDirs = splitDirs;
        this.nativeLibraryDir = nativeLibraryDir;
        this.installer = str;
        this.signerDigests = signerDigests;
    }

    public final String getVersionName() {
        return this.versionName;
    }

    public final long getVersionCode() {
        return this.versionCode;
    }

    public final long getLastUpdateTime() {
        return this.lastUpdateTime;
    }

    public final String getSourceDir() {
        return this.sourceDir;
    }

    public final List<String> getSplitDirs() {
        return this.splitDirs;
    }

    public final String getNativeLibraryDir() {
        return this.nativeLibraryDir;
    }

    public final String getInstaller() {
        return this.installer;
    }

    public final List<String> getSignerDigests() {
        return this.signerDigests;
    }

    public final List<String> getApks() {
        return CollectionsKt.plus((Collection) CollectionsKt.listOf(this.sourceDir), (Iterable) this.splitDirs);
    }
}
