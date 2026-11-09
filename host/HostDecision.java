package com.magicloader.app.host;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HostDecision.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005\u0004\u0005\u0006\u0007\bB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0005\t\n\u000b\f\r¨\u0006\u000e"}, d2 = {"Lcom/magicloader/app/host/HostDecision;", "", "<init>", "()V", "NotInstalled", "WrongAbi", "NotGenuine", "NotFromPlay", "Ready", "Lcom/magicloader/app/host/HostDecision$NotFromPlay;", "Lcom/magicloader/app/host/HostDecision$NotGenuine;", "Lcom/magicloader/app/host/HostDecision$NotInstalled;", "Lcom/magicloader/app/host/HostDecision$Ready;", "Lcom/magicloader/app/host/HostDecision$WrongAbi;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class HostDecision {
    public /* synthetic */ HostDecision(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX INFO: compiled from: HostDecision.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/magicloader/app/host/HostDecision$NotInstalled;", "Lcom/magicloader/app/host/HostDecision;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class NotInstalled extends HostDecision {
        public static final NotInstalled INSTANCE = new NotInstalled();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof NotInstalled)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -1427098797;
        }

        public String toString() {
            return "NotInstalled";
        }

        private NotInstalled() {
            super(null);
        }
    }

    private HostDecision() {
    }

    /* JADX INFO: compiled from: HostDecision.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/magicloader/app/host/HostDecision$WrongAbi;", "Lcom/magicloader/app/host/HostDecision;", "nativeLibraryDir", "", "<init>", "(Ljava/lang/String;)V", "getNativeLibraryDir", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class WrongAbi extends HostDecision {
        private final String nativeLibraryDir;

        public static /* synthetic */ WrongAbi copy$default(WrongAbi wrongAbi, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = wrongAbi.nativeLibraryDir;
            }
            return wrongAbi.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getNativeLibraryDir() {
            return this.nativeLibraryDir;
        }

        public final WrongAbi copy(String nativeLibraryDir) {
            Intrinsics.checkNotNullParameter(nativeLibraryDir, "nativeLibraryDir");
            return new WrongAbi(nativeLibraryDir);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof WrongAbi) && Intrinsics.areEqual(this.nativeLibraryDir, ((WrongAbi) other).nativeLibraryDir);
        }

        public int hashCode() {
            return this.nativeLibraryDir.hashCode();
        }

        public String toString() {
            return "WrongAbi(nativeLibraryDir=" + this.nativeLibraryDir + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public WrongAbi(String nativeLibraryDir) {
            super(null);
            Intrinsics.checkNotNullParameter(nativeLibraryDir, "nativeLibraryDir");
            this.nativeLibraryDir = nativeLibraryDir;
        }

        public final String getNativeLibraryDir() {
            return this.nativeLibraryDir;
        }
    }

    /* JADX INFO: compiled from: HostDecision.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0004HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/magicloader/app/host/HostDecision$NotGenuine;", "Lcom/magicloader/app/host/HostDecision;", "signerDigests", "", "", "<init>", "(Ljava/util/List;)V", "getSignerDigests", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class NotGenuine extends HostDecision {
        private final List<String> signerDigests;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ NotGenuine copy$default(NotGenuine notGenuine, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = notGenuine.signerDigests;
            }
            return notGenuine.copy(list);
        }

        public final List<String> component1() {
            return this.signerDigests;
        }

        public final NotGenuine copy(List<String> signerDigests) {
            Intrinsics.checkNotNullParameter(signerDigests, "signerDigests");
            return new NotGenuine(signerDigests);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof NotGenuine) && Intrinsics.areEqual(this.signerDigests, ((NotGenuine) other).signerDigests);
        }

        public int hashCode() {
            return this.signerDigests.hashCode();
        }

        public String toString() {
            return "NotGenuine(signerDigests=" + this.signerDigests + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NotGenuine(List<String> signerDigests) {
            super(null);
            Intrinsics.checkNotNullParameter(signerDigests, "signerDigests");
            this.signerDigests = signerDigests;
        }

        public final List<String> getSignerDigests() {
            return this.signerDigests;
        }
    }

    /* JADX INFO: compiled from: HostDecision.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/magicloader/app/host/HostDecision$NotFromPlay;", "Lcom/magicloader/app/host/HostDecision;", "installer", "", "<init>", "(Ljava/lang/String;)V", "getInstaller", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class NotFromPlay extends HostDecision {
        private final String installer;

        public static /* synthetic */ NotFromPlay copy$default(NotFromPlay notFromPlay, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = notFromPlay.installer;
            }
            return notFromPlay.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getInstaller() {
            return this.installer;
        }

        public final NotFromPlay copy(String installer) {
            return new NotFromPlay(installer);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof NotFromPlay) && Intrinsics.areEqual(this.installer, ((NotFromPlay) other).installer);
        }

        public int hashCode() {
            String str = this.installer;
            if (str == null) {
                return 0;
            }
            return str.hashCode();
        }

        public String toString() {
            return "NotFromPlay(installer=" + this.installer + ")";
        }

        public NotFromPlay(String str) {
            super(null);
            this.installer = str;
        }

        public final String getInstaller() {
            return this.installer;
        }
    }

    /* JADX INFO: compiled from: HostDecision.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/magicloader/app/host/HostDecision$Ready;", "Lcom/magicloader/app/host/HostDecision;", "install", "Lcom/magicloader/app/host/InstallSnapshot;", "<init>", "(Lcom/magicloader/app/host/InstallSnapshot;)V", "getInstall", "()Lcom/magicloader/app/host/InstallSnapshot;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Ready extends HostDecision {
        private final InstallSnapshot install;

        public static /* synthetic */ Ready copy$default(Ready ready, InstallSnapshot installSnapshot, int i, Object obj) {
            if ((i & 1) != 0) {
                installSnapshot = ready.install;
            }
            return ready.copy(installSnapshot);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final InstallSnapshot getInstall() {
            return this.install;
        }

        public final Ready copy(InstallSnapshot install) {
            Intrinsics.checkNotNullParameter(install, "install");
            return new Ready(install);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Ready) && Intrinsics.areEqual(this.install, ((Ready) other).install);
        }

        public int hashCode() {
            return this.install.hashCode();
        }

        public String toString() {
            return "Ready(install=" + this.install + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Ready(InstallSnapshot install) {
            super(null);
            Intrinsics.checkNotNullParameter(install, "install");
            this.install = install;
        }

        public final InstallSnapshot getInstall() {
            return this.install;
        }
    }
}
