package com.magicloader.app.host.runtime;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import com.magicloader.app.host.InstallSnapshot;
import com.microsoft.applications.events.Constants;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: LibraryStage.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\b\u001a\u00020\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/magicloader/app/host/runtime/LibraryStage;", "", "context", "Landroid/content/Context;", "install", "Lcom/magicloader/app/host/InstallSnapshot;", "<init>", "(Landroid/content/Context;Lcom/magicloader/app/host/InstallSnapshot;)V", "directory", "Ljava/io/File;", NotificationCompat.CATEGORY_PROGRESS, "Lkotlin/Function1;", "", "", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class LibraryStage {

    @Deprecated
    public static final String CACHE_ROOT = "game-libs";
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final String PARTIAL = ".partial";

    @Deprecated
    public static final String SO_SUFFIX = ".so";

    @Deprecated
    public static final String STAMP = ".complete";
    private final Context context;
    private final InstallSnapshot install;

    public LibraryStage(Context context, InstallSnapshot install) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(install, "install");
        this.context = context;
        this.install = install;
    }

    public final File directory(Function1<? super String, Unit> progress) throws IOException {
        final String str;
        Object next;
        FileOutputStream zipFile;
        Intrinsics.checkNotNullParameter(progress, "progress");
        File file = new File(this.install.getNativeLibraryDir());
        if (new File(file, GameLibraries.MAIN).isFile()) {
            return file;
        }
        File file2 = new File(this.context.getCodeCacheDir(), CACHE_ROOT);
        File file3 = new File(file2, this.install.getVersionCode() + Constants.CONTEXT_SCOPE_NONE + this.install.getLastUpdateTime());
        if (new File(file3, STAMP).isFile()) {
            return file3;
        }
        FilesKt.deleteRecursively(file2);
        file3.mkdirs();
        Iterator<T> it = this.install.getApks().iterator();
        while (true) {
            str = "lib/arm64-v8a/";
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            zipFile = new ZipFile((String) next);
            try {
                boolean z = zipFile.getEntry(new StringBuilder().append("lib/arm64-v8a/").append(GameLibraries.MAIN).toString()) != null;
                CloseableKt.closeFinally(zipFile, null);
                if (z) {
                    break;
                }
            } finally {
            }
        }
        String str2 = (String) next;
        if (str2 == null) {
            throw new IOException("libminecraftpe.so is not in the installed Minecraft APKs");
        }
        zipFile = new ZipFile(str2);
        try {
            ZipFile zipFile2 = zipFile;
            Enumeration<? extends ZipEntry> enumerationEntries = zipFile2.entries();
            Intrinsics.checkNotNullExpressionValue(enumerationEntries, "entries(...)");
            for (ZipEntry zipEntry : SequencesKt.filter(SequencesKt.asSequence(CollectionsKt.iterator(enumerationEntries)), new Function1() { // from class: com.magicloader.app.host.runtime.LibraryStage$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return Boolean.valueOf(LibraryStage.directory$lambda$6$lambda$2(str, (ZipEntry) obj));
                }
            })) {
                String name = zipEntry.getName();
                Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                String strRemovePrefix = StringsKt.removePrefix(name, (CharSequence) "lib/arm64-v8a/");
                progress.invoke("Copying " + strRemovePrefix);
                File file4 = new File(file3, strRemovePrefix + PARTIAL);
                zipFile = zipFile2.getInputStream(zipEntry);
                try {
                    InputStream inputStream = zipFile;
                    zipFile = new FileOutputStream(file4);
                    try {
                        Intrinsics.checkNotNull(inputStream);
                        ZipFile zipFile3 = zipFile2;
                        ByteStreamsKt.copyTo$default(inputStream, zipFile, 0, 2, null);
                        CloseableKt.closeFinally(zipFile, null);
                        CloseableKt.closeFinally(zipFile, null);
                        if (!file4.renameTo(new File(file3, strRemovePrefix))) {
                            throw new IOException("Cannot stage " + strRemovePrefix);
                        }
                        zipFile2 = zipFile3;
                    } finally {
                    }
                } finally {
                }
            }
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(zipFile, null);
            FilesKt.writeText$default(new File(file3, STAMP), str2, null, 2, null);
            return file3;
        } finally {
            try {
                throw th;
            } finally {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean directory$lambda$6$lambda$2(String str, ZipEntry zipEntry) {
        if (zipEntry.isDirectory()) {
            return false;
        }
        String name = zipEntry.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        if (!StringsKt.startsWith$default(name, str, false, 2, (Object) null)) {
            return false;
        }
        String name2 = zipEntry.getName();
        Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
        return StringsKt.endsWith$default(name2, SO_SUFFIX, false, 2, (Object) null);
    }

    /* JADX INFO: compiled from: LibraryStage.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/magicloader/app/host/runtime/LibraryStage$Companion;", "", "<init>", "()V", "CACHE_ROOT", "", "STAMP", "PARTIAL", "SO_SUFFIX", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
